package encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: liyq
 * @createtime: 2023-04-18 11:50
 */
public class RSA {

    public static void main(String[] args) {
        //解密数据
        try {
            //生成公钥和私钥
            genKeyPair();
            // String publicKey = keyMap.get(0);
            // System.out.println("公钥:" + publicKey);
            // String privateKey = keyMap.get(1);
            // System.out.println("私钥:" + privateKey);

            String orgData = "123456781668745014120123D";

            String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCi552DrWsfuvWruSU4kM6WRTlKM0r4CoGi8Lgx\n\ntkz2dZs+PR3OrrfL0/f1hrlDH4vFVC+TI8QsAC3f5L6p7ryHIbdkqr2ZlZcDd1xtXpSNRIpLsjvp\n\nNwMTxfdKHdVseZLlE3yAPAMSgIJ7Yr8itGJBL51qjoxLUCmkExaLvsTOdwIDAQAB";

            System.out.println("原数据：" + orgData);
            String encryptStr = encrypt(orgData, publicKey);
            System.out.println("加密结果：" + encryptStr);

            String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKLnnYOtax+69au5JTiQzpZFOUoz\nSvgKgaLwuDG2TPZ1mz49Hc6ut8vT9/WGuUMfi8VUL5MjxCwALd/kvqnuvIcht2SqvZmVlwN3XG1e\nlI1EikuyO+k3AxPF90od1Wx5kuUTfIA8AxKAgntivyK0YkEvnWqOjEtQKaQTFou+xM53AgMBAAEC\ngYB9mNV4kFvnOt3uZ/Cqi/q7IOPqsWE7m94XIkDhEwyDeGkYs0Yn880A+YxTYGu1tLyuhxmm+Axn\nYDv+Qv49RjNTQBFnZsiQd8Y18MtITh0Quy2UzTpazrjUjLWjsNKI9GPAfPIuthLHeUZd+0ck0CDp\nNJgyTWRykozVbHPJuU48AQJBAN/dBPwN1x5WEj2oTzcIXYA/WXPeR5M5PRZXgMg7PNzhRoTqPj/5\nsGbUUl41I8One+jJ4UqKTZaqw2QZUZhOrucCQQC6Sl3Gw0JiD+kAoNwKLNx46W0pst63TnFT+GMp\nOo/hiKhH83m29m0536dOmwTSOHQajuvPpZQQEy8v/w9xusHxAkBgXvCHZZnm+Fyv6GX5pgNCc4MZ\ny2X6rhhrJs5M5JuF5wEJtSGJPv8+tUakQbIcx1wjUc1H3pQaOXcV/4RN0gmfAkEAoXA02Dz6WDTl\nfQ/p4D+ESJwxZ8OE0mH+QACvHlmLuq1M+B19Sxs/CLpTKQGaKfuWUjWtEWOybkPRzsxAvBRWYQJB\nALHJ7LVcUGICD61bWwqHOAjmUoSSxW0J/O0u1+UzQWZWRLklEoYW4tu5J9mBWqY0FIUOkeyBQ9SV\nj6zxIcVQiQY=";

            String decryptStr = decrypt(encryptStr, privateKey);
            System.out.println("解密结果：" + decryptStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = decryptBASE64(publicKey);
        // Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = encryptBASE64(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 明文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = decryptBASE64(str);
        //base64编码的私钥
        byte[] decoded = decryptBASE64(privateKey);
        // Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

    //编码返回字符串
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    //解码返回byte
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * 密钥长度 于原文长度对应 以及越长速度越慢
     */
    private final static int KEY_SIZE = 1024;
    /**
     * 用于封装随机产生的公钥与私钥
     */
    private static Map<Integer, String> keyMap = new HashMap<Integer, String>();

    /**
     * 随机生成密钥对
     * @throws Exception
     */
    public static void genKeyPair() throws Exception {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器
        keyPairGen.initialize(KEY_SIZE, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 得到私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 得到公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        String publicKeyString = encryptBASE64(publicKey.getEncoded());
        // 得到私钥字符串
        String privateKeyString = encryptBASE64(privateKey.getEncoded());
        // 将公钥和私钥保存到Map
        //0表示公钥
        keyMap.put(0, publicKeyString);
        //1表示私钥
        keyMap.put(1, privateKeyString);
    }

}
