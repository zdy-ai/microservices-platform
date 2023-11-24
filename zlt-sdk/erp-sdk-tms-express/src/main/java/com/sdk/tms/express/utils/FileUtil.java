package com.sdk.tms.express.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.IdGenerator;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.Base64;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zdy
 * @ClassName FileUtil
 * @description: TODO
 * @date 2023年11月13日
 * @version: 1.0
 */
public class FileUtil {
    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static void main(String[] args) {
        String urlString = "";
        String fileName = "test.pdf";

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = connection.getInputStream();
            connection.addRequestProperty("","");
            try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }

            connection.disconnect();
            System.out.println("File downloaded successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBase64ByPDFUrl(String token,String urlString) throws IOException {
        File file = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            String fileName = System.currentTimeMillis() + UUID.randomUUID().toString();
            file = File.createTempFile("label_file", fileName);
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Auth-token", token);
            inputStream = connection.getInputStream();
            outputStream = Files.newOutputStream(file.toPath());
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != outputStream){
                    outputStream.close();
                }
                if (null != inputStream){
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        String fileHeader = "data:image/png;base64,";
        String fileHeader = "data:application/pdf;base64,";
        return fileHeader + getBase64(file);
    }

    public String getBase64(File file) throws IOException {
        String base64Str = null;
        FileInputStream inputStream = null;
        try {
            Base64.Encoder encoder = Base64.getEncoder();
            inputStream = new FileInputStream(file);
            int available = inputStream.available();
            byte[] bytes = new byte[available];
            inputStream.read(bytes);
            base64Str = encoder.encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            inputStream.close();
        }
        return replaceEnter(base64Str);
    }

    public static String replaceEnter(String str){
        String reg ="[\n-\r]";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        return m.replaceAll("");
    }
}
