package com.hyd.mercury.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MD5Util {
	
	public static String md5(String plainText) {
        //定义一个字节数组
        byte[] secretBytes = null;
        try {
              // 生成一个MD5加密计算摘要  
            MessageDigest md = MessageDigest.getInstance("MD5");
            //对字符串进行加密
            md.update(plainText.getBytes());
            //获得加密后的数据
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        //将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
	
	
	  
	//sha1 加密
	private static final char[] HEX = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式  
        for (int j = 0; j < len; j++) {
            buf.append(HEX[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }
    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //主函数调用测试
    public static void main(String[] args) {
        //String res = md5(encode("admin") + "A?x\"nbN7hp,$<|ItOU^@Cc#&1%qyX.iPdH~u-8Jm");
        
        System.out.println(encode("admin")); //d033e22ae348aeb5660fc2140aec35850c4da997
        //System.out.println(res.equals("fd31791700e0009547a2385194305613"));
        //md5(sha1($str) . $key);
        // 'A?x"nbN7hp,$<|ItOU^@Cc#&1%qyX.iPdH~u-8Jm'
    	
    	//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //System.out.println(new Date().getTime());// new Date()为获取当前系统时间
    }
    
}
