package com.chenyee.common.utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * @author Gionee yubo 2016-11-29 add for CR01774887
 * @version 1.0.0
 */
public class AESUtil {

    private static final String UTF_8 = "UTF-8";
    private static final String KEY_ALGORITHM = "AES";
    private static final int KEY_SIZE = 256;
    /** 加密/解密算法/工作模式/填充方法 */
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    /** 密钥 */
    public static final String KEY = "E7QlEfDTIkbYGM6klfZ4OYcghiGYa8l3XXuLlS5EzHg=";

    /**
     * 生成密钥
     * 
     * @return 长度为32密钥(256位)
     * @throws Exception
     */
    public static String getKey() throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        // AES 要求密钥长度为128位、192位或256位
        kg.init(KEY_SIZE);
        // 生成密钥
        SecretKey secretKey = kg.generateKey();
        return GNBase64.encodeToString(secretKey.getEncoded());
    }

    /**
     * 加密
     * 
     * @param data
     *            待加密数据
     * @param key
     *            密钥
     * @return String 加密后数据
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {
        byte[] dataBytes = data.getBytes(UTF_8);
        byte[] keyBytes = GNBase64.decode(key);

        Key k = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM); // "算法/模式/补码方式"
        // 初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, k);

        return GNBase64.encodeToString(cipher.doFinal(dataBytes));
    }

    /**
     * 解密
     * 
     * @param data
     *            待解密数据
     * @param key
     *            密钥
     * @return String 解密后数据
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws Exception {
        byte[] keyBytes = GNBase64.decode(key);
        byte[] dataBytes = GNBase64.decode(data);

        Key k = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);// "算法/模式/补码方式"
        // 初始化，设置解密模式
        cipher.init(Cipher.DECRYPT_MODE, k);

        return new String(cipher.doFinal(dataBytes), UTF_8);
    }
    public static void main(String[] args){
    	String s ="gs55tWJawFqgds31TPXdoQ3dnR2LUoswJq2G1WTgd6N+BQOS094lYy+T3rOMxvEnOJLtp/mCw/QG"
    			+ "p+e3zEg+jf3rn3CQ2oqRsciW+AxUZQHAfBB96kL2UEzTykKlOQAKoXmsi84fFLPLPVerIjLPEkrJ"
    			+ "VBnJtlGCXLVlY68G/7kWlEEz7r0bwCMvMGMYt16oeo97MguG++rtzqQosu84wBvEsq4mmgUqO4D/"
    			+ "EFk84+Y9L+Sdr51px7PrxBkekpSXCWi/am0vKWjhW32z+QWZ3qV5NXqdoLap+Tenmjq56iceOFTp"
    			+ "hAOtSJwZ26mBqMX5dy88twRY6d2eZ47cJq6Ai51v/JXEVQpBfpgqRPQxbGYe5fQLAOCTxhy4DucDyC4A";
    	try {
    		System.out.println(s);
			String result = decrypt(s,KEY);
			System.out.println(result);
			//不包含地址信息
			s1();
			//mSdOCqU9fgwFbTWadyJzqf+Y+MFMPNBUY4KpnavLATBUrJfwz+afHHFA8jpKnJJ9uLu0CRDomx6YfiEYogviPNZLH6p6Pyd59axvmW4juzDPgGUw8pYi79OZEgUhf+gLD4TIqw2eHpQ0TH5hR/1uwsS/7qqEv3fE5BK/7yUGi+cP5EaOUvVnOPCosm4phPVAh7dbP6HkxoUpWiSFHj3TlY6SdNe1Dc14f4kmQceTB+QKSBNjjQW1wzdpXIkNSscTrND1cq9lF7AnsZUFv+GmD4msHuAq+HDE9bpgPoD9r1Dp3ZEv03ajJl9YEo3UVRsb
			//不含含mcc信息
			s2();
			//包含所有信息
			s3();
			
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static void s1(){
    	//不包含地址信息
		String s = "{\"e\":\"S6%20Pro\",\"i\":\"GBL7533GI\",\"i1\":\"123456789009876\",\"i2\":\"123456789012345\",\"t\":\"9599423384\",\"v\":\"T5972\",\"f\":\"GIONEE/S6_Pro/GIONEE_GBL7529:6.0/MRA58K/1478677548:eng/release-keys\",\"c\":\"city\",\"p\":\"\",\"co\":\"\",\"fu\":\"\",\"mcc\":\"\"}";
		System.out.println(s);
		try {
			String result = encrypt(s, KEY);
			System.out.println(result);
			//mSdOCqU9fgwFbTWadyJzqf+Y+MFMPNBUY4KpnavLATBUrJfwz+afHHFA8jpKnJJ9uLu0CRDomx6YfiEYogviPNZLH6p6Pyd59axvmW4juzDPgGUw8pYi79OZEgUhf+gLD4TIqw2eHpQ0TH5hR/1uwsS/7qqEv3fE5BK/7yUGi+cP5EaOUvVnOPCosm4phPVAh7dbP6HkxoUpWiSFHj3TlY6SdNe1Dc14f4kmQceTB+QKSBNjjQW1wzdpXIkNSscTrND1cq9lF7AnsZUFv+GmD4msHuAq+HDE9bpgPoD9r1Dp3ZEv03ajJl9YEo3UVRsb
			String st = "mSdOCqU9fgwFbTWadyJzqf+Y+MFMPNBUY4KpnavLATBUrJfwz+afHHFA8jpKnJJ9uLu0CRDomx6Y"
					+ "fiEYogviPNZLH6p6Pyd59axvmW4juzDPgGUw8pYi79OZEgUhf+gLD4TIqw2eHpQ0TH5hR/1uwsS/"
					+ "7qqEv3fE5BK/7yUGi+cP5EaOUvVnOPCosm4phPVAh7dbP6HkxoUpWiSFHj3TlY6SdNe1Dc14f4km"
					+ "QceTB+QKSBNjjQW1wzdpXIkNSscTrND1cq9lF7AnsZUFv+GmD4msHuAq+HDE9bpgPoD9r1Dp3ZEv03ajJl9YEo3UVRsb";
			System.out.println(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static void s2(){
    	//不包含地址信息
    	String s = "{\"e\":\"S6%20Pro\",\"i\":\"GBL7533GI\",\"i1\":\"123456789009876\",\"i2\":\"123456789012345\",\"t\":\"9599423384\",\"v\":\"T5972\",\"f\":\"GIONEE/S6_Pro/GIONEE_GBL7529:6.0/MRA58K/1478677548:eng/release-keys\",\"c\":\"city\",\"p\":\"province\",\"co\":\"country\",\"fu\":\"fullLocation\",\"mcc\":\"\"}";
		System.out.println(s);
		try {
			String result = encrypt(s, KEY);
			System.out.println(result);
			String st = "mSdOCqU9fgwFbTWadyJzqf+Y+MFMPNBUY4KpnavLATBUrJfwz+afHHFA8jpKnJJ9uLu0CRDomx6Y"
					+ "fiEYogviPNZLH6p6Pyd59axvmW4juzDPgGUw8pYi79OZEgUhf+gLD4TIqw2eHpQ0TH5hR/1uwsS/"
					+ "7qqEv3fE5BK/7yUGi+cP5EaOUvVnOPCosm4phPVAh7dbP6HkxoUpWiSFHj3TlY6SdNe1Dc14f4km"
					+ "QceTB+QKSBNjjQW1wzdpXIkNSscT+ydwLsrRr3odIceIbk8qniCRdfPVY+LnFfgvw1LoV4RR6SQ9"
					+ "RWp9JKDf4kgNhkj4uh0tM73PnEbonLnhUZCh0g==";
			System.out.println(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static void s3(){
    	//包含地址信息
    	String s = "{\"e\":\"S6 Pro\",\"i\":\"GBL7533GI\",\"i1\":\"123456789009876\",\"i2\":\"123456789012345\",\"t\":\"9599423384\",\"v\":\"T5972\",\"f\":\"GIONEE/S6_Pro/GIONEE_GBL7529:6.0/MRA58K/1478677548:eng/release-keys\",\"c\":\"city\",\"p\":\"province\",\"co\":\"country\",\"fu\":\"fullLocation\",\"mcc\":\"mcc\"}";
		System.out.println(s);
		try {
			String result = encrypt(s, KEY);
			System.out.println(result);
			//mSdOCqU9fgwFbTWadyJzqf+Y+MFMPNBUY4KpnavLATBUrJfwz+afHHFA8jpKnJJ9uLu0CRDomx6YfiEYogviPNZLH6p6Pyd59axvmW4juzDPgGUw8pYi79OZEgUhf+gLD4TIqw2eHpQ0TH5hR/1uwsS/7qqEv3fE5BK/7yUGi+cP5EaOUvVnOPCosm4phPVAh7dbP6HkxoUpWiSFHj3TlY6SdNe1Dc14f4kmQceTB+QKSBNjjQW1wzdpXIkNSscTrND1cq9lF7AnsZUFv+GmD4msHuAq+HDE9bpgPoD9r1Dp3ZEv03ajJl9YEo3UVRsb
			String st ="mSdOCqU9fgwFbTWadyJzqf+Y+MFMPNBUY4KpnavLATBUrJfwz+afHHFA8jpKnJJ9uLu0CRDomx6Y"
					+ "fiEYogviPNZLH6p6Pyd59axvmW4juzDPgGUw8pYi79OZEgUhf+gLD4TIqw2eHpQ0TH5hR/1uwsS/"
					+ "7qqEv3fE5BK/7yUGi+cP5EaOUvVnOPCosm4phPVAh7dbP6HkxoUpWiSFHj3TlY6SdNe1Dc14f4km"
					+ "QceTB+QKSBNjjQW1wzdpXIkNSscT+ydwLsrRr3odIceIbk8qniCRdfPVY+LnFfgvw1LoV4RR6SQ9"
					+ "RWp9JKDf4kgNhkj4yDtrAzhGCd9g0ZPoTw915w==";
			System.out.println(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}