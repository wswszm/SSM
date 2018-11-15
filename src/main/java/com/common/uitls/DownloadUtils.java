package com.common.uitls;


import com.common.base.contants.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 下载公共类
 */
public class DownloadUtils {

    public static void downLoadFile(HttpServletRequest request, HttpServletResponse response, String filePath, String filename) {
        try {
            File file = new File(filePath);
            // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称 用于浏览器的下载框中自动显示的文件名
            String userAgent = request.getHeader("User-Agent");
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                filename = java.net.URLEncoder.encode(filename, "UTF-8");
            } else {
                filename = new String(filename.getBytes("utf-8"), "iso8859-1");
            }
            response.addHeader("Content-Disposition", "attachment;filename=" + filename);
            response.setContentType("multipart/form-data");
            byte[] b = new byte[1024];
            int len = 0;
            FileInputStream fs = new FileInputStream(file);
            PrintWriter writer = response.getWriter();
            while ((len = fs.read()) != -1) {
                writer.write(len);
            }
            fs.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void batchDownLoadFile(HttpServletRequest request, HttpServletResponse response, String filename, String[] filepath, String[] documentname) {
        byte[] buffer = new byte[1024];
        Date date = new Date();
        //生成zip文件存放位置
        String strZipPath = Constants.uploadFilePath + File.separator + DateUtils.toString(new Date(), "yyyyMMdd") + File.separator + System.currentTimeMillis() + ".zip";
        File file = new File(Constants.uploadFilePath + File.separator + DateUtils.toString(new Date(), "yyyyMMdd"));
        if (!file.isDirectory() && !file.exists()) {
        // 创建多层目录
            file.mkdirs();
        }
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(strZipPath));
            // 需要同时下载的多个文件
            for (int i = 0; i < filepath.length; i++) {
                File f = new File(filepath[i]);
                FileInputStream fis = new FileInputStream(f);
                System.out.println(documentname[i]);
                out.putNextEntry(new ZipEntry(documentname[i]));
                //设置压缩文件内的字符编码，不然会变成乱码
//                out.setEncoding("GBK");
                int len;
                // 读入需要下载的文件的内容，打包到zip文件
                while ((len = fis.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
                out.closeEntry();
                fis.close();
            }
            out.close();
            downLoadFile(request, response, strZipPath, filename + ".zip");
            File temp = new File(strZipPath);
            if (temp.exists()) {
                temp.delete();
            }
        } catch (Exception e) {
            System.out.println("文件下载错误");
        }
    }
}
