package xueqiao.trade.admin.web.api.broker;

public class BrokerApiFactory {
    private static BrokerApiFactory ourInstance = new BrokerApiFactory();

    public static BrokerApiFactory getInstance() {
        return ourInstance;
    }

    private BrokerApiFactory() {
    }

    public IBrokerApi getDefault() {
        return new BrokerApi();
    }
}
