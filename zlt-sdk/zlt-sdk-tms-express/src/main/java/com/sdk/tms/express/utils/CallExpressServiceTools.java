package com.sdk.tms.express.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.sdk.tms.express.constants.PathConstants;
import com.sdk.tms.express.service.IServiceCodeStandard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author zdy
 * @ClassName CallExpressServiceTools
 * @description: TODO
 * @date 2023年10月30日
 * @version: 1.0
 */
public class CallExpressServiceTools {
    private static Logger logger = LoggerFactory.getLogger(CallExpressServiceTools.class);

    private static CallExpressServiceTools tools = new CallExpressServiceTools();

    public static CallExpressServiceTools getInstance() {
        synchronized (CallExpressServiceTools.class) {
            if (tools == null)
                tools = new CallExpressServiceTools();
        }
        return tools;
    }

    public static String callSfExpressServiceByCSIM(String reqURL, String reqXML, String clientCode, String checkword) {
        String result = null;
        String verifyCode = VerifyCodeUtil.md5EncryptAndBase64(String.valueOf(reqXML) + checkword);
        result = querySFAPIservice(reqURL, reqXML, verifyCode);
        return result;
    }

    public static String querySFAPIservice(String url, String xml, String verifyCode) {
        HttpClientUtil httpclient = new HttpClientUtil();
        if (url == null)
            url = "http://bsp-oisp.sf-express.com/bsp-oisp/sfexpressService";
        String result = null;
        try {
            result = httpclient.postSFAPI(url, xml, verifyCode);
            return result;
        } catch (Exception e) {
            logger.warn(" " + e);
            return null;
        }
    }

    public static String packageMsgData(IServiceCodeStandard serviceCode) {
        String jsonString = "";
        try {
            InputStream is = new FileInputStream(PathConstants.filePath + serviceCode.getPath());
            byte[] bs = new byte[is.available()];
            is.read(bs);
            jsonString = new String(bs);
        } catch (Exception exception) {}
        return jsonString;
    }

    public static String getMsgDigest(String msgData, String timeStamp, String md5Key) throws UnsupportedEncodingException {
        String msgDigest = VerifyCodeUtil.md5EncryptAndBase64(URLEncoder.encode(String.valueOf(msgData) + timeStamp + md5Key, "UTF-8"));
        return msgDigest;
    }
}
