/*package com.test.importdatas.staticTest.encryption;

import org.springframework.util.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String s = "123454321";
        String s1 = DigestUtils.md5DigestAsHex(s.getBytes());
        System.out.println(s1);
    }
}*/

package com.test.importdatas.staticTest.encryption;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import sun.security.provider.MD5;
@Slf4j
public class Encryption {

    // 带秘钥加密
    public static String md5(String text, String key) throws Exception {
        // 加密后的字符串
        String md5str = DigestUtils.md5Hex(text + key);
        log.info("MD5加密后的字符串为:" + md5str);
        return md5str;
    }

    // 不带秘钥加密
    public static String md52(String text) throws Exception {
        // 加密后的字符串
        String md5str = DigestUtils.md5Hex(text);
        log.info("MD52加密后的字符串为:" + md5str + "\t长度：" + md5str.length());
        return md5str;
    }


    // 根据传入的密钥进行验证
    public static boolean verify(String text, String key, String md5) throws Exception {
        String md5str = md5(text, key);
        if (md5str.equalsIgnoreCase(md5)) {
            System.out.println("MD5验证通过");
            return true;
        }
        return false;
    }

    // 测试
    public static void main(String[] args) throws Exception {
        String str = "181115";
        log.info("加密的字符串：" + str + "\t长度：" + str.length());
        String s = new Encryption().md5(str,"cmd");
        String s2 = new Encryption().md5(str,"");
        String s1 = new Encryption().md52("181115");
        boolean flag = new Encryption().verify("181115", "cmd", "b0f6cd567ea4750afcfd0c2cb0c6b94e");
        boolean flag2 = new Encryption().verify("181115", "", s1);
//        log.info(String.valueOf(flag));
        System.out.println("f1======="+flag);
        System.out.println("f2======="+flag);
    }
}


