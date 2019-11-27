//package com.xiexing.iodemo;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.aliyun.oss.OSSClient;
//import com.aliyun.oss.model.OSSObject;
//import com.caxs.hermes.base.utils.CommonEnum;
//import com.caxs.hermes.oss.filestorage.iservice.IFileInfoService;
//import com.caxs.hermes.utils.ReadProperties;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.net.URL;
//import java.net.URLDecoder;
//import java.util.*;
//import java.util.zip.Adler32;
//import java.util.zip.CheckedOutputStream;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipOutputStream;
//
//
///**
// * <p>Description: Themis请求影像系统打包接口
// * <p>Version:v1.0
// * <p>Copyright ©2015 madadai.com All Rights Reserved. </p>
// * <p>Company:caxins</p>
// * <p>Author:shenjie
// * <p>Date: 2019-6-5
// */
//@Controller
//@RequestMapping(value = "/picsFile/api")
//public class ThemisFileController {
//
//    private static final Logger logger = LoggerFactory.getLogger(ThemisFileController.class);
//
////    @Autowired
////    private IFileInfoService fileInfoService;
////    @Autowired
////    private AKVerify aKVerify;//accessToken认证
//
//    /**
//     * @Name: 获取指定照片
//     * @Param: osOutNo 业务流水号
//     * @Param: osFileFullType 模板
//     * @Param: token
//     * @param: account 鉴权账号
//     * @Param: isBase64 是否转base64（Y：是，N：否）
//     * @Author: liyanzhao
//     * @Date: 2019-6-5
//     */
//    @RequestMapping(value = "/getPicsData")
//    @ResponseBody
//    public Map<String, Object> getPicsUrl(HttpServletRequest request, HttpServletResponse response) {
//
//        // 定义返回的结果集对象
//        Map<String, Object> result = new HashMap<String, Object>();
//        Map<String, Object> data_map = new HashMap<String, Object>();
//        try {
//            String jsonString = FileTreeController.receivePost(request);
////            String jsonString= "{'data':{'osOutNo':'5266523','osFileFullType':'/共同申请人资料/征信查询授权书','token':'','account':'','isBase64':''}}";
//            logger.info("获取打包影像的文件参数:"+jsonString);
//            if ("".equals(jsonString)) {
//                result.put("code", CommonEnum.RESPONSE_FORMAT_ERROR.getCode());
//                result.put("message", CommonEnum.RESPONSE_FORMAT_ERROR.getName());
//                data_map.put("dataStream", "");
//                result.put("data", data_map);
//                return result;
//            }
//            // 业务流水号 eg:"920918"
//            String osOutNo = JSON.parseObject(jsonString).getString("osOutNo");
//            // 模板 eg:"/主申请人资料/身份证明材料/身份证,"
//            String osFileFullType = JSON.parseObject(jsonString).getString("osFileFullType");
//            // token
//            String token = JSON.parseObject(jsonString).getString("token");
//            // account鉴权账号
//            String account = JSON.parseObject(jsonString).getString("account");
//            // 是否转base64（Y：是，N：否）
//            String isBase64 = JSON.parseObject(jsonString).getString("isBase64");
//            logger.info("获取打包影像的文件参数业务流水号:"+osOutNo+" 模板:"+osFileFullType+" token:"+token+" account鉴权账号:"+
//                    account+" 是否转base64:"+isBase64);
//            //校验token和account
//            Map<String,Object> verify_result = aKVerify.verifyIden(token, account);
//            Object verify_flag =  verify_result.get("code");
//            if(!CommonEnum.RESPONSE_SUCCESS.getCode().equals(verify_flag)){
//                return verify_result;
//            }
//            if (StringUtils.isEmpty(osOutNo)|| StringUtils.isEmpty(osFileFullType)) {
//                logger.info("业务流水号或模板为空");
//                result.put("code", CommonEnum.RESPONSE_DATA_EMPTY.getCode());
//                result.put("message", CommonEnum.RESPONSE_DATA_EMPTY.getName());
//                data_map.put("dataStream", "");
//                result.put("data", data_map);
//                return result;
//            }
//            // 按照业务流水号和模板查询
//            Map<String, Object> map = fileInfoService.getPicsName(osOutNo, osFileFullType, null, null);
//            logger.info("图片的路径map:" +map);//获取图片map
//            List<String> picNameList = new ArrayList<String>();
//            if(CommonEnum.CODE_STATUS_SUCCESS.getCode().equals(map.get("code"))){
//                Object picsName = map.get("picsName");
//                JSONArray picsUrlJsonArray = JSONArray.parseArray(picsName.toString());
//                picsUrlJsonArray.stream().forEach(object->{
//                    JSONObject jsonObject = JSONObject.parseObject(object.toString());
//                    for(String str:jsonObject.keySet()){
//                        logger.info(str + "图片的路径:" +jsonObject.get(str));//获取图片name
//                        picNameList.add(jsonObject.get(str).toString());
//                    }
//                });
//                //存在图片路径
//                if(picNameList.size()>0){
//                    String picNameSeparated = String.join(",", picNameList);
//                        try {
//                            InputStream picsStream =  getOssFile(picNameSeparated);
//                            List<Object> dataList = new ArrayList<Object>();
//                            if("Y".equals(isBase64)){
//                                String base64FromInputStream=FileToBase64.getBase64FromInputStream(picsStream);
//                                data_map.put("dataStream", base64FromInputStream);
//                                result.put("data", data_map);
//                            }else {
//                                BufferedReader in = new BufferedReader(new InputStreamReader(picsStream));
//                                StringBuffer buffer = new StringBuffer();
//                                String line = "";
//                                while ((line = in.readLine()) != null){
//                                    buffer.append(line);
//                                }
//                                data_map.put("dataStream", buffer.toString());
//                                result.put("data", data_map);
//                                in.close();
//                            }
//                            picsStream.close();
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                }
//            }else{//没查询图片到数据
//                logger.info("没查询图片到数据，业务流水号osOutNo:" +osOutNo);//获取图片map
//                result.put("code", CommonEnum.RESPONSE_FORMAT_ERROR.getCode());
//                result.put("message", map.get("picsName"));
//                data_map.put("dataStream", "");
//                result.put("data", data_map);
//                return result;
//            }
//        } catch (Exception e) {
//            logger.info("[获取指定影像包错误....]->FileTreeController->getPicsData");
//            result.put("code", CommonEnum.RESPONSE_OTHER_ERROR.getCode());
//            result.put("message", CommonEnum.RESPONSE_OTHER_ERROR.getName());
//            data_map.put("dataStream", "");
//            result.put("data", data_map);
//            return result;
//        }
//        result.put("code", CommonEnum.RESPONSE_SUCCESS.getCode());
//        result.put("message", CommonEnum.RESPONSE_SUCCESS.getName());
//        return result;
//    }
//
//    /**
//     * 根据url获取文件流
//     * @param url url
//     * @return 字节流
//     */
//    public static InputStream getFileByUrl(String url) {
//        InputStream inputStream = null;
//        try {
//            inputStream = new URL(url).openStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return inputStream;
//    }
//
//    /**
//     * 获取压缩临时文件流
//     * @param
//     * @return
//     */
//    public InputStream getOssFile(String key){
//
//        // endpoint以杭州为例，其它region请按实际情况填写，1改为自己的
//        String endpoint = ReadProperties.ReadPropertiesFromfiles("/api.properties","oss.endpoint","CONF_HOME");
//        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
//        String accessKeyId = ReadProperties.ReadPropertiesFromfiles("/api.properties","oss.accessId","CONF_HOME");
//        String accessKeySecret = ReadProperties.ReadPropertiesFromfiles("/api.properties","oss.accessKey","CONF_HOME");
//        String bucketName = ReadProperties.ReadPropertiesFromfiles("/api.properties","oss.bucket","CONF_HOME");
//        FileInputStream fis = null;
//        BufferedInputStream buff = null;
//        //要下载的文件名（Object Name）字符串，中间用‘,’间隔。文件名从bucket目录开始.5改为自己的
//        //String key = "cardata/2019/06/06/9288028/59597101-C181-474B-8A93-AE0EF0D691F9.png,cardata/2019/06/06/9288028/7AFECFB5-64A7-4F37-B5F7-5CB9A5A1C420.png";
//        try {
//            // 初始化
//            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//            //改为自己的名称
//            String fileName = "picsFile.zip";
//            // 创建临时文件
//            File zipFile = File.createTempFile("picsFile", ".zip");
//            FileOutputStream f = new FileOutputStream(zipFile);
//            /**
//             * 作用是为任何OutputStream产生校验和
//             * 第一个参数是制定产生校验和的输出流，第二个参数是指定Checksum的类型 （Adler32（较快）和CRC32两种）
//             */
//            CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
//            // 用于将数据压缩成Zip文件格式
//            ZipOutputStream zos = new ZipOutputStream(csum);
//
//            String[] keylist = key.split(",");
//            for (String ossfile : keylist) {
//                // 获取Object，返回结果为OSSObject对象
//                OSSObject ossObject = ossClient.getObject(bucketName, ossfile);
//                // 读去Object内容  返回
//                InputStream inputStream = ossObject.getObjectContent();
//                // 对于每一个要被存放到压缩包的文件，都必须调用ZipOutputStream对象的putNextEntry()方法，确保压缩包里面文件不同名
//
//                zos.putNextEntry(new ZipEntry(ossfile.split("/")[5]));
//                int bytesRead = 0;
//                // 向压缩文件中输出数据
//                while((bytesRead=inputStream.read())!=-1){
//                    zos.write(bytesRead);
//                }
//                inputStream.close();
//                zos.closeEntry(); // 当前文件写完，定位为写入下一条项目
//            }
//            zos.close();
//            //读取压缩包文件流
//            fis = new FileInputStream(zipFile);
//            buff = new BufferedInputStream(fis);
//            ossClient.shutdown();
//            // 删除临时文件
//            zipFile.delete();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return buff;
//    }
//
//}
