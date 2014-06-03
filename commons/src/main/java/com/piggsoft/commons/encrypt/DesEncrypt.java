package com.piggsoft.commons.encrypt;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author piggsoft@163.com
 * @version 1.0.0
 * @since 2014/2/20
 */
public class DesEncrypt {
	private static final Logger logger = LoggerFactory
			.getLogger(DesEncrypt.class);

	private static final String PUB_PASSWORD_KEY = "national";

	private Cipher encryptCipher = null;

	private Cipher decryptCipher = null;

	private static DesEncrypt defaultDesEncrypt = null;

	public static synchronized DesEncrypt getDefaultDesEncrypt() {
		try {
			if (defaultDesEncrypt == null)
				defaultDesEncrypt = new DesEncrypt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defaultDesEncrypt;
	}

	private static String byteArr2HexStr(byte[] arrB) {
		int iLen = arrB.length;

		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];

			while (intTmp < 0) {
				intTmp += 256;
			}

			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	private static byte[] hexStr2ByteArr(String strIn) {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i += 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[(i / 2)] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	public DesEncrypt() throws Exception {
		this(PUB_PASSWORD_KEY);
	}

	public DesEncrypt(String strKey) throws Exception {
		Key key = getKey(strKey.getBytes());

		this.encryptCipher = Cipher.getInstance("DES");
		this.encryptCipher.init(1, key);

		this.decryptCipher = Cipher.getInstance("DES");
		this.decryptCipher.init(2, key);
	}

	public byte[] encrypt(byte[] arrB) {
		try {
			return this.encryptCipher.doFinal(arrB);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	public String encrypt(String strIn) {
		return byteArr2HexStr(encrypt(strIn.getBytes()));
	}

	public byte[] decrypt(byte[] arrB) {
		try {
			return this.decryptCipher.doFinal(arrB);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	public String decrypt(String strIn) {
		return new String(decrypt(hexStr2ByteArr(strIn)));
	}

	private Key getKey(byte[] arrBTmp) {
		byte[] arrB = new byte[8];

		for (int i = 0; (i < arrBTmp.length) && (i < arrB.length); i++) {
			arrB[i] = arrBTmp[i];
		}

		Key key = new SecretKeySpec(arrB, "DES");

		return key;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(new DesEncrypt().encrypt("123456"));
		System.out.println(new DesEncrypt().decrypt("25b7f5afee0d962a"));
		System.out.println(new DesEncrypt().decrypt("07978f4f1843f50b"));
	}
}