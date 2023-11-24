package com.erp.sdk.oms.amz.spapi.documents;// DownloadExample.java

import java.io.BufferedReader;
import java.io.IOException;

import com.erp.sdk.oms.amz.spapi.documents.CompressionAlgorithm;
import com.erp.sdk.oms.amz.spapi.documents.DownloadBundle;
import com.erp.sdk.oms.amz.spapi.documents.DownloadHelper;
import com.erp.sdk.oms.amz.spapi.documents.DownloadSpecification;
import com.erp.sdk.oms.amz.spapi.documents.exception.CryptoException;
import com.erp.sdk.oms.amz.spapi.documents.exception.HttpResponseException;
import com.erp.sdk.oms.amz.spapi.documents.exception.MissingCharsetException;
import com.erp.sdk.oms.amz.spapi.documents.impl.AESCryptoStreamFactory;

public class DownloadExample {
    final DownloadHelper downloadHelper = new DownloadHelper.Builder().build();

    // The key, initializationVector, url, and compressionAlgorithm are obtained from the response to
    // the getReportDocument operation.
    public void downloadAndDecrypt(String key, String initializationVector, String url, String compressionAlgorithm) {
        AESCryptoStreamFactory aesCryptoStreamFactory =
                new AESCryptoStreamFactory.Builder(key, initializationVector).build();

        DownloadSpecification downloadSpec = new DownloadSpecification.Builder(aesCryptoStreamFactory, url)
                .withCompressionAlgorithm(CompressionAlgorithm.fromEquivalent(compressionAlgorithm))
                .build();

        try (DownloadBundle downloadBundle = downloadHelper.download(downloadSpec)) {
            // This example assumes that the downloaded file has a charset in the content type, e.g.
            // text/plain; charset=UTF-8
            try (BufferedReader reader = downloadBundle.newBufferedReader()) {
                String line;
                do {
                    line = reader.readLine();
                    // Process the decrypted line.
                } while (line != null);
            }
        } catch (CryptoException | HttpResponseException | IOException | MissingCharsetException e) {
            // Handle exception here.
        }
    }
}