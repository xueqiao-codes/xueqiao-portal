package xueqiao.quotation.admin.web.api.utils;

import com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv;
import xueqiao.quotation.account.thriftapi.QuotationPlatformEnv;
import xueqiao.quotation.account.thriftapi.QuotationTechPlatform;

public class BeanMapping {

    public static TechPlatform map2TechPlatform(QuotationTechPlatform quotationTechPlatform) {
        TechPlatform techPlatform;
        switch (quotationTechPlatform) {
            case CTP:
                techPlatform = TechPlatform.CTP;
                break;
            case ESUNNY:
                techPlatform = TechPlatform.ESUNNY;
                break;
            case NONE:
            default:
                techPlatform = TechPlatform.NONE;
        }

        return techPlatform;
    }

    public static TechPlatformEnv map2PlatformEnv(QuotationPlatformEnv quotationPlatformEnv) {
        TechPlatformEnv techPlatformEnv;
        switch (quotationPlatformEnv) {
            case SIM:
                techPlatformEnv = TechPlatformEnv.SIM;
                break;
            case REAL:
                techPlatformEnv = TechPlatformEnv.REAL;
                break;
            case NONE:
            default:
                techPlatformEnv = TechPlatformEnv.NONE;
        }

        return techPlatformEnv;
    }

    public static QuotationTechPlatform map2QuoTechPlatform(TechPlatform techPlatform) {
        QuotationTechPlatform quotationTechPlatform;
        switch (techPlatform) {
            case CTP:
                quotationTechPlatform = QuotationTechPlatform.CTP;
                break;
            case ESUNNY:
                quotationTechPlatform = QuotationTechPlatform.ESUNNY;
                break;
            case NONE:
                quotationTechPlatform = null;
                break;
            default:
                quotationTechPlatform = QuotationTechPlatform.NONE;
        }
        return quotationTechPlatform;

    }

    public static QuotationPlatformEnv map2QuoPlatformEnv(TechPlatformEnv techPlatformEnv) {
        QuotationPlatformEnv quotationPlatformEnv;
        switch (techPlatformEnv) {
            case SIM:
                quotationPlatformEnv = QuotationPlatformEnv.SIM;
                break;
            case REAL:
                quotationPlatformEnv = QuotationPlatformEnv.REAL;
                break;
            case NONE:
                quotationPlatformEnv = null;
                break;
            default:
                quotationPlatformEnv = QuotationPlatformEnv.NONE;
        }
        return quotationPlatformEnv;
    }

    public static TechPlatformEnv map2PlatformEnv(com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv brokerPlatformEnv) {
        TechPlatformEnv techPlatformEnv;
        switch (brokerPlatformEnv) {
            case SIM:
                techPlatformEnv = TechPlatformEnv.SIM;
                break;
            case REAL:
                techPlatformEnv = TechPlatformEnv.REAL;
                break;
            case NONE:
            default:
                techPlatformEnv = TechPlatformEnv.NONE;
        }

        return techPlatformEnv;
    }

    public static com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv map2BrokerPlatformEnv(TechPlatformEnv platformEnv) {

        com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv techPlatformEnv;
        switch (platformEnv) {
            case SIM:
                techPlatformEnv = com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv.SIM;
                break;
            case REAL:
                techPlatformEnv = com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv.REAL;
                break;
            case NONE:
            default:
                techPlatformEnv = null;
        }
        return techPlatformEnv;
    }

    public static TechPlatform map2TechPlatform(BrokerPlatform brokerPlatform) {
        TechPlatform techPlatform;
        switch (brokerPlatform) {
            case CTP:
                techPlatform = TechPlatform.CTP;
                break;
            case ESUNNY:
                techPlatform = TechPlatform.ESUNNY;
                break;
            case NONE:
            default:
                techPlatform = TechPlatform.NONE;
        }

        return techPlatform;
    }
}
