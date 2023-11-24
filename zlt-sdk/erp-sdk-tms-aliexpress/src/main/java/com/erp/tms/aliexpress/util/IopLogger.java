package com.erp.tms.aliexpress.util;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * @author zdy
 * @ClassName IopLogger
 * @description: TODO
 * @date 2023年11月14日
 * @version: 1.0
 */
public class IopLogger {
    private static final Log log = LogFactory.getLog(IopLogger.class);

    private static final String LOG_SPLIT = "^_^";

    private static String osName = System.getProperties().getProperty("os.name");

    private static boolean needEnableLogger = true;

    public static void setNeedEnableLogger(boolean needEnableLogger) {
        IopLogger.needEnableLogger = needEnableLogger;
    }

    public static void write(String appKey, String sdkVersion, String apiName, String url, Map<String, String> params, long latency, String errorMessage) {
        if (!needEnableLogger)
            return;
        StringBuilder sb = buildLogApi(appKey, sdkVersion, apiName, url, params, latency, errorMessage);
        log.error(sb.toString());
    }

    private static StringBuilder buildLogApi(String appKey, String sdkVersion, String apiName, String url, Map<String, String> params, long latency, String errorMessage) {
        StringBuilder sb = new StringBuilder();
        sb.append(formatDateTime(new Date()));
        sb.append("^_^");
        sb.append(appKey);
        sb.append("^_^");
        sb.append(sdkVersion);
        sb.append("^_^");
        sb.append(apiName);
        sb.append("^_^");
        sb.append(IopUtils.getIntranetIp());
        sb.append("^_^");
        sb.append(osName);
        sb.append("^_^");
        sb.append(latency);
        sb.append("^_^");
        sb.append(url);
        try {
            sb.append("^_^");
            sb.append(WebUtils.buildQuery(params, "utf-8"));
        } catch (IOException e) {}
        sb.append("^_^");
        sb.append(errorMessage);
        return sb;
    }

    private static String formatDateTime(Date date) {
        return IopUtils.formatDateTime(date, "yyyy-MM-dd HH:mm:ss.SSS");
    }
}
