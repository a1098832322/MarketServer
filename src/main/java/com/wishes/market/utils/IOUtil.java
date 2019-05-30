package com.wishes.market.utils;


import java.io.*;

/**
 * IO操作工具类
 *
 * @author 郑龙
 */
public class IOUtil {
    /**
     * 将图片保存到本地
     *
     * @param inputStream 文件流
     * @param path        文件保存路径
     * @param fileName    保存的文件名
     */
    public static void saveImg(InputStream inputStream, String path, String fileName) {
        OutputStream os = null;
        try {
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件

            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有连接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
