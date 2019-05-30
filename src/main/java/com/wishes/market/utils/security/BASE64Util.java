package com.wishes.market.utils.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * BAESE64常用工具方法
 */
public class BASE64Util {

    public static String getBase64(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    public static String base64ToString(String base64) {
        String s = null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            s = decoder.decodeBuffer(base64).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static byte[] base64ToByte(String base64) {
        byte[] bytes = new byte[]{};
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            bytes = decoder.decodeBuffer(base64);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * @param base64sString 编码字符串
     */
    public String base64StringToPDF(String base64sString, String fileName, String fileType) {
        BASE64Decoder decoder = new BASE64Decoder();
        BufferedInputStream bin = null;
        FileOutputStream fout = null;
        BufferedOutputStream bout = null;
        String fileAddress = "D:/test/" + fileName + ".pdf";
        try {
            //将base64编码的字符串解码成字节数组
            byte[] bytes = decoder.decodeBuffer(base64sString);
            //byte[] bytes = Base64.decodeBase64(base64sString);  
            //创建一个将bytes作为其缓冲区的ByteArrayInputStream对象  
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            //创建从底层输入流中读取数据的缓冲输入流对象  
            bin = new BufferedInputStream(bais);
            //指定输出的文件  
            File file = new File(fileAddress);
            //创建到指定文件的输出流  
            fout = new FileOutputStream(file);
            //为文件输出流对接缓冲输出流对象  
            bout = new BufferedOutputStream(fout);
            byte[] buffers = new byte[1024];
            int len = bin.read(buffers);
            while (len != -1) {
                bout.write(buffers, 0, len);
                len = bin.read(buffers);
            }
            //刷新此输出流并强制写出所有缓冲的输出字节，必须这行代码，否则有可能有问题  
            bout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bin.close();
                fout.close();
                bout.close();
                return fileAddress;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileAddress;
    }
}
