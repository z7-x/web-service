package com.webservicesinterface;

import org.codehaus.xfire.client.Client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class OAManagerWebService {

    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://10.40.72.72/defaultroot/xfservices/GeneralWeb?wsdl");

        StringBuffer xml = new StringBuffer();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.append("<input>");

        xml.append("<key>").append(toMd5("ezOFFICE12.4")).append("</key>");
        xml.append("<cmd>information_getMobileList</cmd>");
        xml.append("<domain>0</domain>");

        xml.append("<userId></userId>");
        xml.append("<orgId></orgId>");
        xml.append("<orgIdString></orgIdString>");
        xml.append("<type>all</type>");
        xml.append("<userChannelName>信息管理</userChannelName>");
        xml.append("<search>1</search>");
        xml.append("<channelType>0</channelType>");
        xml.append("<data>");

//            xml.append("<list>");
//            xml.append("<ptable name=\"SHDC_OA_GZHCSY\">");
//            xml.append("<field name=\"DJKS\" type=\"String\"><![CDATA["+DJKS+"]]></field>");
//            xml.append("<field name=\"SKKSBM\" type=\"String\"><![CDATA["+SKKSBM+"]]></field>");
//            xml.append("<field name=\"HCBM\" type=\"String\"><![CDATA["+HCBM+"]]></field>");
//            xml.append("<field name=\"HCMC\" type=\"String\"><![CDATA["+HCMC+"]]></field>");
//            xml.append("<field name=\"GG\" type=\"String\"><![CDATA["+GG+"]]></field>");
//            xml.append("<field name=\"CJ\" type=\"String\"><![CDATA["+CJ+"]]></field>");
//            xml.append("<field name=\"SL\" type=\"Float\">"+SL+"</field>");
//            xml.append("<field name=\"JE\" type=\"Float\">"+JE+"</field>");
//            xml.append("<field name=\"KS\" type=\"String\">"+KS+"</field>");
//            xml.append("<field name=\"BZ\" type=\"String\"><![CDATA["+BZ+"]]></field>");
//            xml.append("<field name=\"SYSJ\" type=\"String\"><![CDATA["+SYSJ+"]]></field>");
//            xml.append("</ptable>");
//            xml.append("</list>");

        xml.append("</data>");
        xml.append("</input>");
        try {
            Client client = new Client(url);
            Object[] results = client.invoke("OAManager",new Object[] { xml.toString() });
            System.out.println(results[0]+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String toMd5(String str) {
        String md5 = null;
        if (str != null && str.length() != 0) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(str.getBytes());
                byte b[] = md.digest();

                int i;
                StringBuffer buf = new StringBuffer("");
                for (int offset = 0; offset < b.length; offset++) {
                    i = b[offset];
                    if (i < 0)
                        i += 256;
                    if (i < 16)
                        buf.append("0");
                    buf.append(Integer.toHexString(i));
                }
                //32位
                //md5Str = buf.toString();
                //16位
                md5 = buf.toString().substring(8, 24);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return md5;
    }

    public static void getWebServicesArticles() throws IOException {
    }
}
