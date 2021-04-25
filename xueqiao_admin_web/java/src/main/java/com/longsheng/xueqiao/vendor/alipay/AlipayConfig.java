package com.longsheng.xueqiao.vendor.alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016091500517549";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCHO09FsaEdW9sOuaS2kGfgOa2brA6+Qz0JLRUJxr+nciKaWZwaXVOmt3aHgBrnghJmfGekvSSbdApLkYXwp7ty6PW6qmTSAK0fJIuarMEC+T56kuRomWXw0UojFpSNy+eMRLWJJe3h2DUG724CRVxNoxhi9OP6Cl6iCPjXeS6zVRvblvgjB1oiDiIK0e8qtGZ4RKnlxPBf0S9HBqEAVBYnHn13z/xqtYdNWnn9tuMEI1zQKhaQx0XNBfUh1+zN2+floGlf7MybTpjsNmQUsU4Qr/uBbaxrHAa2wpS9kK/1sOyBhzKSTda+UxIZSOW1GCY7YCdnBJWjD2HLrPsGJwQXAgMBAAECggEAKrWGkcJJ2hXal0n2RVpSFDTjKZkrhteBfVZpoI7OlLmtSAYpEQKMmsiyfJTu6lLgMNH1gcfiud3qKnepT5oJz37XrL6H3PMtufo2xQDubFv/aYLe9FIOKgJPYcmN3UKavGgu1UPPX1aDWM9hdQIm5rYty4MARUXlIVOoE5VINIalB7VVyTC8ub//DJ76waC+H/4B7Hak8E1YnZEKednn4B9IK57bEoUU9T6EaSASbE3ziCcSBJuzaL4WVkJc3KH5Ecn3YRwNliSQ4QxD2gWHXvQA4DX9807cLmoz4tcI1S56k9/jHFaq9kP77JnEFRudnernPVB842hHT/HQu/4TMQKBgQDB0P4mdEN6Y3ghibKwBbPooh7I8wF1oZ68PUqD2celgBOkk3zP07nkFSjO52rMkakOgTyub6n6P96dh7UbW8VQCjHy/7LZ/kLILzcbwoHM2As0T5m6MXVRaPQ1FSYKlt6R9a4n01DGTxcAFEaf/vVq2k0grEWWfAsxHKYa7Rx+PQKBgQCynn47v0IOkKQXjSTLnd8f86Ho1V6PqJLclARk2ejcFWc13a7KUZHlCjC1NXWgTNLqLEOJrSCouqA95Xmt9f+qfKCwLBajzMk8fv4u1rUqJGRdqk9BsCeXulI9wXaltss7hahsFQaFsxm1cpijYOWS6m5D/+N0wH47aqpaDVSk4wKBgQCLEFh64OrVsu8sKS+zyrO2lDRAfNOsQkWxzMxdZHIyVn5BlK12NPVpKKF6K2Ne2piRVrtica5lZ1RkdU3GDoe5kUcbksoSTbQ/DFmfKmWVw+HuK7sidIA35HVsbPs5l9ykn8HQw3dugqr/HI08GWSfwXibm9/mRKSHHYY1RbIvBQKBgQCvsHGdtvv0c5TTjYMZvIkRVoR1Dhpa14bM69J+mFAQ2gSQ2SHp4t3MGX/bXV/7clUq/KrZqq6rCBZBi4tp7sOxH7C2WEdUikON+6Ns0seTUgRelPwsMmZfOWdXUwmu6eNxAoCs/ulRbN7muHcmjFKDdY9L11AVMJl5O+ufc+lD3QKBgGhGSxR01IuAn0R4rRRxTjZpXIsBIiv8XgJbzdc1hymG1b/z6r4CFGpjTPxTfXbOfV+SbCFnONVhWqoweTz537+RI7jyNTJpTTRVGc1LOyrPoYpgo2WvF1z+xhjipVhEY+eJ7dBojy2XUdy/vdDotc/WYAEO2D3yE43y1ZHApgQw";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqHRbRB2JPW+GaWvHG8mNCxaQvSFZDiymQWp6wLK6wBCUOVM7TBIH28TpnSn7MP8XjtbwrEHQ9Z8eMJoeYNyBb2gcAAPOepY8pGadI3C5HRHhWfhS4XYcMRJaAHrCe4KLXdR2u30XCwKV5HCN9qb/WGogXGDDr2n4ER6OPJn+YXniB6XJhpNAKTlcJbAb3bbaS65XOudhJQCdgQywYXb+aHmVtZy4VS0mvPuNQx0kN0eUEvNqD0lZwG8brefvxVZpnNmsfriUbwLkEnmdZgdMJJX+h3QE8OekKjODCRZd8hBN0ZCKRh3uE86SEF/5Z95C+bqLCgF1Glh0jKgtbTpA2QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://mydev.galacard.me/alipay_notify_url.jsp";//"http://owlweb.devoa.galacard.me/alipaynotify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://owlweb.devoa.galacard.me/admin/MUserCenterOrderAlipayReturn/show";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "/data/applog/web/xueqiao_admin_web/";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

