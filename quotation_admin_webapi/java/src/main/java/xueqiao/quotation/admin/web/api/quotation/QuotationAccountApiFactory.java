package xueqiao.quotation.admin.web.api.quotation;

public class QuotationAccountApiFactory {
    private static QuotationAccountApiFactory ourInstance = new QuotationAccountApiFactory();

    public static QuotationAccountApiFactory getInstance() {
        return ourInstance;
    }

    private QuotationAccountApiFactory() {
    }

    public IQuotationAccountApi getDefault(){
        return new QuotationAccountApi();
    }
}
