package xueqiao.mailbox.sending.daemon.api;

import org.apache.thrift.TException;
import xueqiao.mail.ContentType;
import xueqiao.mail.MailContent;
import xueqiao.mail.MailEntity;
import xueqiao.mail.MailSettings;
import xueqiao.mail.ao.thriftapi.client.MailAoStub;

public class MailAoApi {

    private static MailAoStub mailAoStub = new MailAoStub();

    public static void sendMail(String mail, String title, String content) throws TException {
        MailContent mailContent = new MailContent();
        mailContent.setContentType(ContentType.HTML);
        mailContent.setContent(content);

        MailEntity mailEntity = new MailEntity();
        mailEntity.addToReceivers(mail);
        mailEntity.setSubject(title);
        mailEntity.setContent(mailContent);
        mailAoStub.sendMail(getSettings(), mailEntity);
    }

    private static MailSettings getSettings() {
        MailSettings settings = new MailSettings();
        settings.setSmtpHost("smtp.xueqiao.cn");
        settings.setSender("service@xueqiao.cn");
        settings.setPasswd("SerVice1919");
        settings.setSenderAlias("雪橇科技");
        return settings;
    }
}
