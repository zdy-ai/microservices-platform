package com.erp.sdk.oms.amz.spapi.utils;

import com.common.core.exception.ServiceException;
import com.erp.sdk.oms.amz.spapi.client.JSON;
import com.erp.sdk.oms.amz.spapi.csv.ReportListingCsvEntity;
import com.erp.sdk.oms.amz.spapi.csv.ReportReservedCsvEntity;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.*;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * 亚马逊SP-API报告工具类
 *
 * @author Jim
 * @date 2023/10/16 12:13
 */
@Slf4j
public class AmazonSpApiReportUtils {

    /**
     * 下载并转换库存报告
     */
    public static List<ReportListingCsvEntity> downloadAndParseListing(String url) throws IOException {
        String csvContent = download(url);
        CSVReader reader = parseCSV(csvContent);
        // 转换bean
        return toBean(reader, ReportListingCsvEntity.class);
    }

    /**
     * 下载并转换
     */
    public static <T> List<T> downloadAndParse(String url, Class<T> tClass) throws IOException {
        String csvContent = download(url);
        CSVReader reader = parseCSV(csvContent);
        // 转换bean
        return toBean(reader, tClass);
    }

    /**
     * 解析csv内容
     */
    public static CSVReader parseCSV(String csvContent) {
        CSVParser parser = new CSVParserBuilder()
                .withSeparator('\t')
                .withIgnoreQuotations(true)
                .build();
        return new CSVReaderBuilder(new StringReader(csvContent))
                .withCSVParser(parser)
                .build();
    }

    /**
     * 转换成指定class对象
     */
    public static <T> List<T> toBean(CSVReader reader, Class<T> clazz) {
        // 创建CsvToBean对象并指定映射到的类
        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                .withType(clazz)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        // 通过CsvToBean的parse方法解析CSV并将数据映射到对象列表
        return csvToBean.parse();
    }

    /**
     * Download and optionally decompress the document retrieved from the given url.
     *
     * @param url the url pointing to a document
     * @throws IOException              when there is an error reading the response
     * @throws IllegalArgumentException when the charset is missing
     */
    public static String download(String url) throws IOException, IllegalArgumentException {
        OkHttpClient httpclient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = httpclient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                String errorMsg = String.format("[Amazon SP-APi] report download Call to download content was unsuccessful with response code: %d and message: %s", response.code(), response.message());
                throw new ServiceException(errorMsg);
            }
            // 获取响应头中的 Content-Type
            String contentType = response.header("Content-Type");
            if (contentType.contains("gzip")) {
                // 如果 Content-Type 包含 "gzip"，则解压缩响应体
                GZIPInputStream gzipInputStream = new GZIPInputStream(response.body().byteStream());
                return convertStreamToString(gzipInputStream);
            }
            return response.body().string();
        }
    }

    /**
     * 将输入流转换为字符串
     */
    private static String convertStreamToString(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
//        String url = "https://d34o8swod1owfl.cloudfront.net/Report_47700__GET_MERCHANT_LISTINGS_ALL_DATA_.txt";
//        List<ListingCsvReportEntity> list = downloadAndParseListing(url);
//        System.out.println(JSONUtil.toJsonStr(list));
        // 亚马逊物流管理库存 - 已存档
//        String url = "https://tortuga-prod-na.s3-external-1.amazonaws.com/2a2d3258-3b23-4f23-8eb6-c019f45bab25.amzn1.tortuga.4.na.T1507HA60E8SWN?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20231103T004815Z&X-Amz-SignedHeaders=host&X-Amz-Expires=300&X-Amz-Credential=AKIA5U6MO6RAETTDXOQT%2F20231103%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=c3e2ede4089507b180769c7d0459665988e9cf4f4f5730c01a1a2468094de64d";
//        List<FbaMyiAllInventoryCsvReportEntity> list = downloadAndParseFbaAllInventory(url);
//        System.out.println(JSONUtil.toJsonStr(list));

        // 亚马逊物流管理库存状况报告


        // 亚马逊物流预留库存报告
//        String url = "https://tortuga-prod-na.s3-external-1.amazonaws.com/f36c2976-2253-451b-bb3d-e6e47a43ffca.amzn1.tortuga.4.na.TUE3ZIC1NB3GN?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20231106T035045Z&X-Amz-SignedHeaders=host&X-Amz-Expires=300&X-Amz-Credential=AKIA5U6MO6RAETTDXOQT%2F20231106%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=6917ebea79e4002c53e43a9fafee2e6889f462e25bbf3f9d7f93bffde5dba47d";
//        String cvsContent = download(url);
//        System.out.println(cvsContent);

        String cvsResult = "sku\tfnsku\tasin\tproduct-name\treserved_qty\treserved_customerorders\treserved_fc-transfers\treserved_fc-processing\n" +
                "1963-US7\tX002LU31MH\tB08F7T3N5G\tPICTRON Phone Tripod Mount with Remote Cell Phone Tripod Adapter Grip Holder with Detachable Wireless Shutter for iPhone Video Photo Shooting (Black)\t7\t1\t3\t3\n" +
                "2660-US7\tX00327F3RJ\tB09K7785NL\tULANZI VL110 RGB Light Wand, Handheld Light Stick Camera LED Video Tube Light Bar, 2500-9000K Dimmable, 2600mAh Battry CRI 95+ with Magnetic Attraction for Photography Vlog TIK Tok\t109\t3\t102\t4\n" +
                "2685-US7\tX002ZPSKOH\tB09D7FRW5T\tPICTRON LS11 Camera Mount Desk Stand with Auxiliary Holding Arm, Flexible Overhead Camera Mount, Webcam Table C-Clamp Multi Mount for Photography Videography Live Stream\t214\t7\t168\t39\n" +
                "2245-US7\tX002PH22GR\tB08N4DY3VX\tSmartphone Video Rig ULANZI U200 Camera Video Rig Phone Video Stabilizer LED Ring Light Selfie Light for Smartphone, Camera, Gopro, YouTube,Vlogging, Filmmaking, Makeup\t66\t3\t21\t42\n" +
                "2676-US7\tX002Z0U5X1\tB09BJ63R8B\tPICTRON VIJIM LS06 Flexible Arm Detachable 2-Section Magic Arm with 1/4\" Interface Mount on Any Camera Desk Mount Stand for Overhead Shooting\t51\t0\t10\t41\n" +
                "2229-US7\tX002N4TMZL\tB08HQVZ2PC\tWide Angle Lens for Sony ZV1 ULANZI WL-1 ZV1 18mm Wide Angle/ 10X Macro 2-in-1 Additional Lens for Sony ZV1/RX100 VII Camera\t44\t2\t36\t6\n" +
                "2326-US7\tX002Q9Y4N3\tB08P8JZZG8\tVlogging Light PICTRON VL28 LED Light for iPhone Mini LED Camera Light Rechargeable 5600K 95+ Long-Lasting Fill Light for Gopro Hero 9 8 7 6 5 DJI OSMO Smartphone Sony ZV-1 A7 RX100 VII Canon Camera\t45\t4\t39\t2\n" +
                "2336-US7\tX002RAXEAP\tB08RDNBBGK\tPortable Desktop Mini Tripod PICTRON MT-24 Compact Camera Tripod Aluminum Alloy with 360° Ball Head,1/4 inches Quick Release Plate for DSLR Camera Video Camcorder, Load up to 11lbs/5kg\t103\t2\t98\t3\n" +
                "2873-M7\tX003CI20Z1\tB0B27JSRGN\tPICTRON VIJIM LS25 Camera Desk Mount, Flexible Overhead Webcam Stand with Boom Arm, Table C-Clamp Suitable for Photography Videography Live Stream\t56\t0\t54\t2\n" +
                "2346-US7\tX002UEVKXB\tB08Z3BQYM1\tVIJIM VL120 RGB Video Light, Portable LED Camera Light Panel 0-360 Full Color, CRI 95+ 2500-9000K LED 3100mAh Rechargeable DSLR Lighting for Vlogging, Photography, Video Conference\t192\t4\t177\t11\n" +
                "2460-US7\tX002X4KSLN\tB096LX62RK\tMT-40 Remote Shooting Grip Extendable Vlogging Handle Tripod Camera Selfie Video Recording Accessorries for Sony ZV-1, A7C, A7R IV, RX100 VII, RX100M7, A7 III, A7R III, A7R IV, A9\t11\t7\t2\t2\n" +
                "2235-US7\tX002OL1K17\tB08L9QJWSQ\tTripod Ball Head ULANZI U-80L Camera Quick Release Metal Ball Head Camera Mount Arca Swiss 360° Rotating with Quick Release Plate & Cold Shoe, 22lbs/10kg Load for 1/4\" Tripod,Monopod,DSLR,Camera\t216\t4\t210\t2\n" +
                "2437-US7\tX002X4PR9B\tB096MKL5DK\tWide Angle Lens for Sony ZV1, ULANZI WL-1 ZV1 18mm Wide Angle/ 10X Macro 2-in-1 Additional Lens for Sony ZV1 Camera (White)\t104\t0\t104\t0\n" +
                "2476-US7\tX002X3B6GF\tB096KMZVJ2\tPICTRON Metal Phone Tripod Mount 3 Cold Shoes & Arca Port, 360° Smartphone Tripod Adapter for iPhone Samsung Cell Phone Stand Holder for Desktop Tripod Video Live Streaming Vlogging Rig\t2087\t18\t1485\t584\n" +
                "2089-US7\tX002OYE5SJ\tB08LZ58T2L\tLive Broadcast Boom Arm, ULANZI Flexible Desk Mount Camera Arm Clamp Webcam Stand, Microphone Boom Arm for Blue Yeti Snowball Yeti Nano, Webcam, Camera, LED Light, Voice Recording, Podcasting (LS01)\t2\t0\t1\t1\n" +
                "2110-US7\tX002MRVZ59\tB08H1NGLLF\tULANZI ST-14 Smartphone Tripod Mount Adapter Aluminum with Cold Shoe, 360° Cell Phone Stand Holder Clamp for iPhone 13 12 11 Max Pro iPhone X XR Xs 6 7 Plus\t592\t12\t571\t9\n" +
                "2666-US7\tX002Z539UH\tB09BQST3S4\tVIJIM LS08 Flexible Overhead Camera Mount Desk Stand, Webcam Stand Microphone Boom Arm Tabletop Photography Videography Live Stream Table clamp Mount\t247\t9\t233\t5\n" +
                "2731-US7\tX002ZPTPRD\tB09W5CRYZ3\tPICTRON LS10 Camera Desk Mount Table Stand with 1/4\" Ball Head, 16\"-33.8\" Adjustable Light Stand, Tabletop C Clamp Arm for DSLR Camera, Ring Light, Live Streaming, Photo Video Shooting\t129\t1\t91\t37\n" +
                "2665-US7\tX002Z0U5XB\tB09BJB1YZ2\tPICTRON VIJIM Flexible Arm Auxiliary Holding Arm, Detachable 2-Section Magic Arm for Any Camera Desk Mount, Cameras, Lights and More, Multi Mount Accessory (LS04)\t168\t1\t129\t38\n" +
                "2574-US7\tX002W5K77N\tB09493DCS9\tVIJIM Camera Desk Mount Stand, Extendable Up to 125 CM/ 49 Inches, Tabletop C Clamp Light Stand with 360° Ball Head and Phone Grip for DSLR Camera, Ring Light, Panel Light, Gopro, Phone, Webcam\t2\t1\t0\t1\n" +
                "2245-US7New\tX002R5DMGB\tB08R4SWQLP\tSmartphone Video Rig PICTRON U200 Handheld LED Ring Light Selfie Light Phone Video Stabilizer for Camera, Smartphone, Gopro, YouTube, Setup, Filmmaking, Makeup, Vlogging\t304\t5\t293\t6";
        CSVReader reader = parseCSV(cvsResult);
        // 转换bean
        List<ReportReservedCsvEntity> bean = toBean(reader, ReportReservedCsvEntity.class);
        System.out.println(JSON.toJsonStr(bean));
    }
}
