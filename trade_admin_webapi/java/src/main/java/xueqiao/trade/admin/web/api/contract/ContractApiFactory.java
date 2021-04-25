package xueqiao.trade.admin.web.api.contract;

public class ContractApiFactory {
    private static ContractApiFactory ourInstance = new ContractApiFactory();

    public static ContractApiFactory getInstance() {
        return ourInstance;
    }

    private ContractApiFactory() {
    }

    public IContractApi getDefault() {
        return new ContractApi();
    }
}
