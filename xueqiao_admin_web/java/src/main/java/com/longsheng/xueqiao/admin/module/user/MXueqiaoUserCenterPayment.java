package com.longsheng.xueqiao.admin.module.user;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.longsheng.xueqiao.payment.balance.alteration.BalanceAlteration;
import com.longsheng.xueqiao.payment.balance.alteration.BalanceAlterationPage;
import com.longsheng.xueqiao.payment.balance.alteration.ReqBalanceAlterationOption;
import com.longsheng.xueqiao.payment.product.thriftapi.*;
import com.longsheng.xueqiao.payment.thriftapi.*;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.admin.module.user.bean.LocalOrder;
import com.longsheng.xueqiao.payment.dao.thriftapi.client.PaymentDaoStub;

public class MXueqiaoUserCenterPayment {
    private static Map<String, String> BALANCE_ALTERATION_OPERATION_TYPE = new HashMap<>();
    private static Map<String, String> BALANCE_ALTERATION_CHANNEL = new HashMap<>();
    static {
        BALANCE_ALTERATION_OPERATION_TYPE.put("ADD_XCOIN", "增加");
        BALANCE_ALTERATION_OPERATION_TYPE.put("REDUCE_XCOIN", "扣减");

        BALANCE_ALTERATION_CHANNEL.put("NONE", "无");
        BALANCE_ALTERATION_CHANNEL.put("ALIPAY", "支付宝");
        BALANCE_ALTERATION_CHANNEL.put("WXPAY", "微信支付");
        BALANCE_ALTERATION_CHANNEL.put("BANK_TRANSFER", "银行转账");
        BALANCE_ALTERATION_CHANNEL.put("OTHERS", "其他");
    }

    public static final int PAGE_SIZE = 10;
    private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
    private PaymentDaoStub mPaymentDaoStub;

    private static MXueqiaoUserCenterPayment mInstance;

    public static MXueqiaoUserCenterPayment getInstance() {
        if (mInstance == null) {
            mInstance = new MXueqiaoUserCenterPayment();
        }
        return mInstance;
    }

    public MXueqiaoUserCenterPayment() {
        mPaymentDaoStub = new PaymentDaoStub();
    }

    public static Map<String, String> getBalanceAlterationOperationType() {
        return BALANCE_ALTERATION_OPERATION_TYPE;
    }

    public static Map<String, String> getBalanceAlterationChannel() {
        return BALANCE_ALTERATION_CHANNEL;
    }

    public OrderPage queryOrderList(int pageIndex, int orderId, int companyId, int productId, String status) throws ErrorInfo, TException {
        ReqOrderOption option = new ReqOrderOption();

        IndexedPageOption indexedPageOption = new IndexedPageOption();
        indexedPageOption.setNeedTotalCount(true);
        indexedPageOption.setPageIndex(pageIndex);
        indexedPageOption.setPageSize(PAGE_SIZE);
        option.setPageOption(indexedPageOption);

        if (orderId > 0) {
            Set<Integer> orderIds = new HashSet<Integer>();
            orderIds.add(orderId);
            option.setOrderIds(orderIds);
        }
        if (companyId > 0) {
            Set<Integer> companyIds = new HashSet<Integer>();
            companyIds.add(companyId);
            option.setCompanyIds(companyIds);
        }
        if (productId > 0) {
            Set<Integer> productIds = new HashSet<Integer>();
            productIds.add(productId);
            option.setProductIds(productIds);
        }
        if (status != null && !status.isEmpty()) {
            try {
                option.setStatus(OrderStatus.valueOf(status));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return mPaymentDaoStub.reqOrder(option);
    }

    public OrderPage queryOrderList(int companyId) throws ErrorInfo, TException {
        ReqOrderOption option = new ReqOrderOption();

        IndexedPageOption indexedPageOption = new IndexedPageOption();
        indexedPageOption.setPageIndex(0);
        indexedPageOption.setPageSize(PAGE_SIZE_MAX);
        option.setPageOption(indexedPageOption);

        Set<Integer> companyIds = new HashSet<Integer>();
        companyIds.add(companyId);
        option.setCompanyIds(companyIds);

        return mPaymentDaoStub.reqOrder(option);
    }

    public CheckPrePayResp checkOrderPrePay(int orderId) throws ErrorInfo, TException {
        PayOrderInfo payOrderInfo = new PayOrderInfo();
        payOrderInfo.setOrderId(orderId);
        return mPaymentDaoStub.checkOrderPrePay(payOrderInfo);
    }

    public Order queryOrderById(int orderId) throws ErrorInfo, TException {
        IndexedPageOption indexedPageOption = new IndexedPageOption();
        indexedPageOption.setPageIndex(0);
        indexedPageOption.setPageSize(PAGE_SIZE);

        Set<Integer> orderIds = new HashSet<Integer>();
        orderIds.add(orderId);

        ReqOrderOption option = new ReqOrderOption();
        option.setOrderIds(orderIds);
        option.setPageOption(indexedPageOption);

        OrderPage orderPage = mPaymentDaoStub.reqOrder(option);

        if (orderPage.getPageSize() > 0) {
            return orderPage.getPage().get(0);
        }

        return null;
    }

    public Order placeOrder(LocalOrder localOrder) throws ErrorInfo, TException {
        Order order = new Order();
        if (localOrder.getSource() != null && localOrder.getSource().isEmpty()) {
            order.setSource(OrderSource.valueOf(localOrder.getSource()));
        }
        order.setProductId(localOrder.getProductId());
        order.setCompanyId(localOrder.getCompanyId());
        order.setCompanyGroupId(localOrder.getCompanyGroupId());
        order.setProductName(localOrder.getProductName());
        order.setProductDescription(localOrder.getProductDescription());
        order.setProductQuantity(localOrder.getProductQuantity());
        if (localOrder.getPrice() != null && !localOrder.getPrice().isEmpty()) {
            order.setPrice(Double.valueOf(localOrder.getPrice()));
        }
        if (localOrder.getCurrencyType() != null && !localOrder.getCurrencyType().isEmpty()) {
            order.setCurrencyType(CurrencyType.valueOf(localOrder.getCurrencyType()));
        }
        if (localOrder.getTotalAmount() != null && !localOrder.getTotalAmount().isEmpty()) {
            order.setTotalAmount(Double.valueOf(localOrder.getTotalAmount()));
        }
        if (localOrder.getPayType() != null && !localOrder.getPayType().isEmpty()) {
            order.setPayType(PayType.valueOf(localOrder.getPayType()));
        }
        order.setThirdPartyOrderNo(localOrder.getThirdPartyOrderNo());
        order.setTradeInfo(localOrder.getTradeInfo());
        if (localOrder.getNeedOperator() != null && !localOrder.getNeedOperator().isEmpty()) {
            order.setNeedOperator(localOrder.getNeedOperator().equals("1") ? true : false);
        }
        order.setOperator(localOrder.getOperator());
        if (localOrder.getOperation() != null && !localOrder.getOperation().isEmpty()) {
            order.setOperation(Operation.valueOf(localOrder.getOperation()));
        }

        return mPaymentDaoStub.buyProduct(order);
    }

    public void payOrder(/*int orderId*/PayOrderInfo payOrderInfo) throws ErrorInfo, TException {
//		PayOrderInfo payOrderInfo = new PayOrderInfo();
//		payOrderInfo.setOrderId(orderId);
        mPaymentDaoStub.payOrder(payOrderInfo);
    }

    public ProductPage queryOrderProductList(ProductType type, ProductStatus status, CurrencyType currencyType) throws ErrorInfo, TException {
        ReqProductOption option = new ReqProductOption();
        if (type != null) {
            option.setType(type);
        }
        if (status != null) {
            option.setStatus(status);
        }
        if (currencyType != null) {
            option.setCurrencyType(currencyType);
        }

        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(PAGE_SIZE_MAX);
        option.setPageOption(pageOption);
        return mPaymentDaoStub.reqProduct(option);
    }

    public Product queryOrderProductById(int productId) throws ErrorInfo, TException {
        ReqProductOption option = new ReqProductOption();
        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(1);
        option.setPageOption(pageOption);

        if (productId > 0) {
            Set<Integer> productIds = new HashSet<Integer>();
            productIds.add(productId);
            option.setProductIds(productIds);

            ProductPage productPage = mPaymentDaoStub.reqProduct(option);
            if (productPage != null && productPage.getPageSize() > 0) {
                return productPage.getPage().get(0);
            }
        }
        return null;
    }

    public void addOrderProduct(Product product) throws ErrorInfo, TException {
        mPaymentDaoStub.addProduct(product);
    }

    public void updateOrderProduct(int productId, int inventoryQuantity, ProductStatus status, String name, String description) throws ErrorInfo, TException {
        Product product = new Product();
        product.setProductId(productId);
        product.setInventoryQuantity(inventoryQuantity);
        product.setStatus(status);
        product.setName(name);
        product.setDescription(description);
        mPaymentDaoStub.updateProduct(product);
    }

    public OrderFlowPage queryOrderFlow(int orderId) throws ErrorInfo, TException {
        ReqOrderFlowOption option = new ReqOrderFlowOption();
        option.setOrderId(orderId);
        return mPaymentDaoStub.reqOrderFlow(option);
    }

    public Order modifyOrder(int orderId, String operator, OrderStatus orderStatus) throws ErrorInfo, TException {
        AppLog.i("MXueqiaoUserCenterPayment ---- modifyOrder ---- orderId : " + orderId + ", operator : " + operator + ", orderStatus : " + orderStatus);
        OperateOrderInfo info = new OperateOrderInfo();
        info.setOrderId(orderId);
        if (operator != null && !operator.isEmpty()) {
            info.setOperator(operator);
        }
        if (orderStatus != null) {
            info.setStatus(orderStatus);
        }
        return mPaymentDaoStub.operateOrder(info);
    }

    public long queryCompanyGroupExpiredTimestamp(int companyId, int groupId) throws ErrorInfo, TException {
        long expiredTimestamp = -1;

        CompanyGroupSpec companyGroupSpec = queryCompanyGroupSpecFromPaymentDao(companyId, groupId);
        if (companyGroupSpec != null) {
            expiredTimestamp = companyGroupSpec.getExpiredTimestamp();
        }
        AppLog.i("MXueqiaoUserCenterPayment ---- queryCompanyGroupExpiredTimestamp ---- companyId : " + companyId + ", groupId : " + groupId + ", expiredTimestamp : " + expiredTimestamp);
        return expiredTimestamp;
    }

    public CompanyGroupSpec queryCompanyGroupSpecFromPaymentDao(int companyId, int groupId) throws TException {
        ReqCompanyGroupSpecOption option = new ReqCompanyGroupSpecOption();
        option.addToCompanyIds(companyId);
        option.setGroupId(groupId);

        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0).setPageSize(1).setNeedTotalCount(false);
        option.setPageOption(pageOption);

        CompanyGroupSpecPage companyGroupSpecPage = mPaymentDaoStub.reqCompanyGroupSpec(option);
        if (companyGroupSpecPage != null && companyGroupSpecPage.getPageSize() > 0) {
            return companyGroupSpecPage.getPage().get(0);
        }
        return null;
    }

    public CompanyBalance queryCompanyBalance(int companyId) throws TException {
        ReqCompanyBalanceOption option = new ReqCompanyBalanceOption();
        option.addToCompanyIds(companyId);

        IndexedPageOption indexedPageOption = new IndexedPageOption();
        indexedPageOption.setPageIndex(0);
        indexedPageOption.setPageSize(1);
        option.setPageOption(indexedPageOption);
        CompanyBalancePage companyBalancePage = mPaymentDaoStub.reqCompanyBalance(option);
        if (companyBalancePage != null && companyBalancePage.getPageSize() > 0) {
            return companyBalancePage.getPage().get(0);
        }
        return null;
    }

    public BalanceAlterationPage queryBalanceAlterationList(int companyId, int pageIndex, int pageSize) throws TException {
        ReqBalanceAlterationOption reqOption = new ReqBalanceAlterationOption();
        reqOption.setCompanyId(companyId);

        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(pageIndex).setPageSize(pageSize).setNeedTotalCount(true);
        return mPaymentDaoStub.reqCompanyBalanceAlteration(reqOption, pageOption);
    }

    public void alterBalance(BalanceAlteration balanceAlteration) throws TException {
        mPaymentDaoStub.alterCompanyBalance(balanceAlteration);
    }

    public void modifyAlterBalanceRecord(long alterationId, String description) throws TException {
        BalanceAlteration balanceAlteration = new BalanceAlteration();
        balanceAlteration.setAlterationId(alterationId);
        balanceAlteration.setDescription(description);
        mPaymentDaoStub.updateCompanyBalanceAlteration(balanceAlteration);
    }
}
