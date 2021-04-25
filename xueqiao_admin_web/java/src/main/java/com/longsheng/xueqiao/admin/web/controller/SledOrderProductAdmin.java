package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.admin.bean.LocalOrderProduct;
import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenterPayment;
import com.longsheng.xueqiao.payment.product.thriftapi.CurrencyType;
import com.longsheng.xueqiao.payment.product.thriftapi.Operation;
import com.longsheng.xueqiao.payment.product.thriftapi.Product;
import com.longsheng.xueqiao.payment.product.thriftapi.ProductPage;
import com.longsheng.xueqiao.payment.product.thriftapi.ProductPurpose;
import com.longsheng.xueqiao.payment.product.thriftapi.ProductStatus;
import com.longsheng.xueqiao.payment.product.thriftapi.ProductType;

public class SledOrderProductAdmin extends OaAuthController {

	public void show() throws Exception {
		render("sled_order_product_admin.html");
	}
	
	public void queryOrderProductList() throws IOException {
		ErrorResult result = new ErrorResult();

		String productType = parameter("productType", "");
		String currencyTypeStr = parameter("currencyType", "");
		String productStatus = parameter("productStatus", "");

		ProductType type = null;
		ProductStatus status = null;
		CurrencyType currencyType = null;
		try {
			type = ProductType.valueOf(productType);
		} catch (Throwable t) {}
		try {
			status = ProductStatus.valueOf(productStatus);
		} catch (Throwable t) {}
		try {
			currencyType = CurrencyType.valueOf(currencyTypeStr);
		} catch (Throwable t) {}

		ProductPage productPage = null;
		try {
			productPage = MXueqiaoUserCenterPayment.getInstance().queryOrderProductList(type, status, currencyType);
			
			if (productPage != null) {
				AppLog.i("SledOrderProductAdmin ---- queryOrderProductList ---- productPage size : " + productPage.getPageSize());

				List<LocalOrderProduct> localOrderProductList = new ArrayList<LocalOrderProduct>();
				for (Product product : productPage.getPage()) {
					LocalOrderProduct localOrderProduct = new LocalOrderProduct();

					localOrderProduct.setProductId(product.getProductId());
					localOrderProduct.setType(product.getType());
					localOrderProduct.setName(product.getName());
					localOrderProduct.setDescription(product.getDescription());
					localOrderProduct.setInventoryQuantity(product.getInventoryQuantity());
					localOrderProduct.setPrice(product.getPrice());
					localOrderProduct.setCurrencyType(product.getCurrencyType().name());
					localOrderProduct.setImageCodes(product.getImageCodes());
					localOrderProduct.setStatus(product.getStatus());
					localOrderProduct.setNeedOperator(String.valueOf(product.isNeedOperator()));
					localOrderProduct.setOperation(product.getOperation().name());
					localOrderProduct.setPurpose(product.getPurpose());
					localOrderProduct.setPurposeType(product.getPurposeType());
					localOrderProduct.setxCoinIncrement(product.getXCoinIncrement());
					localOrderProduct.setTimeIncrement(product.getTimeIncrement());

					localOrderProductList.add(localOrderProduct);
				}

				echoJson(localOrderProductList);
			} else {
				result.setErrorCode(5);
				result.setErrorMsg("查找商品失败");
				echoJson(result);
			}
		} catch(ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
		}
	}
	
	public void addNewOrderProduct() throws IOException {
		ErrorResult result = new ErrorResult();
		try {
			String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));

			AppLog.i("SledOrderProductAdmin ---- addNewOrderProduct ---- content : " + content);

			LocalOrderProduct localOrderProduct = GsonFactory.getGson().fromJson(content, LocalOrderProduct.class);

//			AppLog.i("SledOrderProductAdmin ---- addNewOrderProduct ---- localOrderProduct : " + localOrderProduct.toString());

			if (localOrderProduct == null) {
				result.setErrorCode(6);
				result.setErrorMsg("商品信息为空，请检查是否填写错误");
				echoJson(result);
				return;
			}

			ProductPurpose newProductPurpose = null;
			if (StringUtils.isNotBlank(localOrderProduct.getPurpose())) {
				try {
					newProductPurpose = ProductPurpose.valueOf(localOrderProduct.getPurpose());
				} catch (Throwable throwable) {
					AppLog.e("SledOrderProductAdmin ---- get ProductPurpose error", throwable);
				}
			}
			if (newProductPurpose == null) {
				result.setErrorCode(7);
				result.setErrorMsg("商品目的不正确，请检查是否填写错误");
				echoJson(result);
				return;
			}
			Product newProduct = new Product();
			newProduct.setPurpose(newProductPurpose);
			newProduct.setName(localOrderProduct.getName());
			newProduct.setDescription(localOrderProduct.getDescription());
			newProduct.setPrice(localOrderProduct.getPrice());
			newProduct.setCurrencyType(CurrencyType.RMB);
			newProduct.setStatus(ProductStatus.VALID);
			newProduct.setInventoryQuantity(Integer.MAX_VALUE);

			if (newProductPurpose == ProductPurpose.NEW) {
				// check parameters type
				ProductType newProductType = checkProductType(localOrderProduct.getType());
				if (checkParamError(newProductType, result, "商品类型")) return;

				newProduct.setType(newProductType);
				newProduct.setTimeIncrement(localOrderProduct.getTimeIncrement());
				newProduct.setPurposeType(newProductType);
				newProduct.setXCoinIncrement(0);
				newProduct.setNeedOperator(true);
				newProduct.setOperation(Operation.ALLOCATE_SPEC);

			} else if (newProductPurpose == ProductPurpose.UPGRADE) {
				// check parameters type
				ProductType newProductType = checkProductType(localOrderProduct.getType());
				if (checkParamError(newProductType, result, "商品类型")) return;
				// check parameters purpose type
				ProductType newProductPurposeType = checkProductType(localOrderProduct.getPurposeType());
				if (checkParamError(newProductPurposeType, result, "商品目标规格")) return;

				newProduct.setType(newProductType);
				newProduct.setTimeIncrement(LocalOrderProduct.convertDayToSeconds(1));
				newProduct.setPurposeType(newProductPurposeType);
				newProduct.setXCoinIncrement(0);
				newProduct.setNeedOperator(true);
				newProduct.setOperation(Operation.UPGRADE_SPEC);

			} else if (newProductPurpose == ProductPurpose.RECHARGE_XCOIN) {
				newProduct.setType(ProductType.XCOIN);
				newProduct.setTimeIncrement(0);
				newProduct.setPurposeType(ProductType.XCOIN);
				newProduct.setXCoinIncrement(localOrderProduct.getxCoinIncrement());
				newProduct.setNeedOperator(false);
				newProduct.setOperation(Operation.NONE);

			} else if (newProductPurpose == ProductPurpose.RECHARGE_TIME) {
				// check parameters type
				ProductType newProductType = checkProductType(localOrderProduct.getType());
				if (checkParamError(newProductType, result, "商品类型")) return;

				newProduct.setType(newProductType);
				newProduct.setTimeIncrement(localOrderProduct.getTimeIncrement());
				newProduct.setPurposeType(newProductType);
				newProduct.setXCoinIncrement(0);
				newProduct.setNeedOperator(false);
				newProduct.setOperation(Operation.NONE);
			} else if (newProductPurpose == ProductPurpose.PERSONAL_NEW) {
				newProduct.setType(ProductType.BASIC_SPEC);
				newProduct.setTimeIncrement(localOrderProduct.getTimeIncrement());
				newProduct.setPurposeType(ProductType.BASIC_SPEC);
				newProduct.setXCoinIncrement(0);
				newProduct.setNeedOperator(true);
				newProduct.setOperation(Operation.ALLOCATE_PERSONAL_USER_HOSTING_SERVICE);
			} else if (newProductPurpose == ProductPurpose.PERSONAL_RECHARGE_TIME) {
				newProduct.setType(ProductType.BASIC_SPEC);
				newProduct.setTimeIncrement(localOrderProduct.getTimeIncrement());
				newProduct.setPurposeType(ProductType.BASIC_SPEC);
				newProduct.setXCoinIncrement(0);
				newProduct.setNeedOperator(false);
				newProduct.setOperation(Operation.NONE);
			}
			MXueqiaoUserCenterPayment.getInstance().addOrderProduct(newProduct);
		} catch(ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
			return;
		}
		result.setErrorCode(0);
		result.setErrorMsg("添加成功");
		echoJson(result);
	}
	
	public void updateOrderProduct() throws IOException {
		ErrorResult result = new ErrorResult();
		try {
			String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));

			AppLog.i("SledOrderProductAdmin ---- updateOrderProduct ---- content : " + content);

			Product product = GsonFactory.getGson().fromJson(content, Product.class);
			
			if (product != null) {
				MXueqiaoUserCenterPayment.getInstance().updateOrderProduct(product.getProductId(), product.getInventoryQuantity(), product.getStatus(), product.getName(), product.getDescription());
			} else {
				result.setErrorCode(6);
				result.setErrorMsg("商品信息为空，请检查是否填写错误");
				echoJson(result);
				return;
			}
		} catch(ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
			return;
		}
		result.setErrorCode(0);
		result.setErrorMsg("修改成功");
		echoJson(result);
	}

	private ProductType checkProductType(String type) {
		ProductType newProductType = null;
		if (StringUtils.isNotBlank(type)) {
			try {
				newProductType = ProductType.valueOf(type);
			} catch (Throwable throwable) {
				AppLog.e("SledOrderProductAdmin ---- get ProductType error", throwable);
			}
		}
		return newProductType;
	}

	private boolean checkParamError(Object object, ErrorResult result, String paramName) throws IOException {
		if (object == null) {
			result.setErrorCode(8);
			result.setErrorMsg(paramName + "不正确，请检查是否填写错误");
			echoJson(result);
			return true;
		}
		return false;
	}

//	private Product getProductFromLocalOrderProduct(LocalOrderProduct localOrderProduct) {
//		Product product = new Product();
//		product.setProductId(localOrderProduct.getProductId());
//		product.setType(ProductType.valueOf(localOrderProduct.getType()));
//		product.setName(localOrderProduct.getName());
//		product.setDescription(localOrderProduct.getDescription());
//		product.setInventoryQuantity(localOrderProduct.getInventoryQuantity());
//		product.setPrice(localOrderProduct.getPrice());
//		product.setCurrencyType(CurrencyType.valueOf(localOrderProduct.getCurrencyType()));
//		if (localOrderProduct.getStatus() != null && !localOrderProduct.getStatus().isEmpty()) {
//			product.setStatus(ProductStatus.valueOf(localOrderProduct.getStatus()));
//		}
//		product.setNeedOperator("true".equals(localOrderProduct.getNeedOperator()));
//		product.setOperation(Operation.valueOf(localOrderProduct.getOperation()));
//		product.setPurpose(ProductPurpose.valueOf(localOrderProduct.getPurpose()));
//		product.setPurposeType(ProductType.valueOf(localOrderProduct.getPurposeType()));
//		product.setXCoinIncrement(localOrderProduct.getxCoinIncrement());
//		product.setTimeIncrement(localOrderProduct.getTimeIncrement());
//
//		return product;
//	}
}
