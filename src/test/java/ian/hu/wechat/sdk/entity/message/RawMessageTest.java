package ian.hu.wechat.sdk.entity.message;

import ian.hu.wechat.sdk.utils.MashallerUtils;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * 测试是否能正确序列化和反序列化
 */
public class RawMessageTest {

    @Test
    public void test_RawMessage2Xml_text() throws JAXBException {
        RawMessage msg = new RawMessage();
        msg.setFromUserName("A");
        msg.setToUserName("B");
        msg.setMsgType(RawMessage.TYPE_TEXT);
        msg.setContent("Hello World!");

        Marshaller marshaller = MashallerUtils.getMarshaller(RawMessage.class);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(msg, sw);
        System.out.println(sw.getBuffer());
    }

    @Test
    public void test_RawMessage2Xml_ScanCodeInfo() throws JAXBException {
        RawMessage msg = new RawMessage();
        msg.setFromUserName("wechat");
        msg.setToUserName("me");
        msg.setMsgType("event");
        msg.setEvent(RawMessage.EVENT_MENU_SCANCODE_PUSH);
        RawMessage.ScanCodeInfo scanCodeInfo = new RawMessage.ScanCodeInfo();
        scanCodeInfo.setScanResult("ABCDEFG");
        scanCodeInfo.setScanType("qrcode");
        msg.setScanCodeInfo(scanCodeInfo);

        Marshaller marshaller = MashallerUtils.getMarshaller(RawMessage.class);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(msg, sw);
        System.out.println(sw.getBuffer());
    }

    @Test
    public void test_Xml2RawMessage_text() throws JAXBException {
        String xml = "<xml>\n" +
                " <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                " <FromUserName><![CDATA[fromUser]]></FromUserName> \n" +
                " <CreateTime>1348831860</CreateTime>\n" +
                " <MsgType><![CDATA[text]]></MsgType>\n" +
                " <Content><![CDATA[this is a test]]></Content>\n" +
                " <MsgId>1234567890123456</MsgId>\n" +
                " </xml>";


        RawMessage msg = MashallerUtils.fromXml(xml, RawMessage.class);
        Assert.assertTrue(msg.isText());
    }

    @Test
    public void test_Xml2RawMessage_ScanCodePush() throws JAXBException {
        String xml = "<xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>\n" +
                "<FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>\n" +
                "<CreateTime>1408090502</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[scancode_push]]></Event>\n" +
                "<EventKey><![CDATA[6]]></EventKey>\n" +
                "<ScanCodeInfo><ScanType><![CDATA[qrcode]]></ScanType>\n" +
                "<ScanResult><![CDATA[1]]></ScanResult>\n" +
                "</ScanCodeInfo>\n" +
                "</xml>";

        RawMessage msg = MashallerUtils.fromXml(xml, RawMessage.class);
        Assert.assertTrue(msg.isEvent() && RawMessage.EVENT_MENU_SCANCODE_PUSH.equals(msg.getEvent()));
        Assert.assertEquals("1", msg.getScanCodeInfo().getScanResult());
    }

}
