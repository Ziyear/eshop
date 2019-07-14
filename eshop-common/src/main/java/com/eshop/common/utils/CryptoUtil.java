package com.eshop.common.utils;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.RandomAccessFile;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;


/**
 * AES加密算法
 * 
 * @author lanjun 2012-11-22
 */
public class CryptoUtil {
	
	private final static String HEX = "0123456789ABCDEF";

	public static final String DEFAULT_KEY = "zving10301zving10301";//16到24字节

	/**
	 * 加密
	 * 
	 * @param seed
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String seed, String data) {
		byte[] da = null;
		try {
			da = data.getBytes("UTF-8");
		} catch (Exception e) {
			return "";
		}
		byte[] result = encrypt(seed.getBytes(), da);
		return toHex(result);
	}

	/**
	 * 解密
	 * 
	 * @param seed
	 * @param encrypted
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String seed, String encrypted) {
		if (StringUtils.isNotBlank(encrypted)) {
			encrypted = encrypted.trim().replaceAll("(\r\n)|(\r)|(\n)", "");
		}
		byte[] enc = toByte(encrypted);
		byte[] result = decrypt(seed.getBytes(), enc);
		String returnStr = "";
		try {
			returnStr = new String(result, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return returnStr;
	}

	public static byte[] decryptByte(String seed, String encrypted) {
		byte[] enc = toByte(encrypted);
		byte[] result = decrypt(seed.getBytes(), enc);
		return result;
	}

	private static byte[] encrypt(byte[] seed, byte[] data) {
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(seed, "DESede");
			Z3DESCipher cipher = new Z3DESCipher();
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(data);
			return encrypted;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static byte[] decrypt(byte[] seed, byte[] encrypted) {
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(seed, "DESede");
			Z3DESCipher cipher = new Z3DESCipher();
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] decrypted = cipher.doFinal(encrypted);
			return decrypted;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String toHex(String txt) {
		return toHex(txt.getBytes());
	}

	public static String fromHex(String hex) {
		return new String(toByte(hex));
	}

	public static byte[] toByte(String hexString) {
		int len = hexString.length() / 2;
		byte[] result = new byte[len];
		for (int i = 0; i < len; i++){
			result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();}
		return result;
	}

	public static String toHex(byte[] buf) {
		if (buf == null){
			return "";}
		StringBuffer result = new StringBuffer(2 * buf.length);
		for (int i = 0; i < buf.length; i++) {
			appendHex(result, buf[i]);
		}
		return result.toString();
	}

	private static void appendHex(StringBuffer sb, byte b) {
		sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
	}

//	/**
//	 * 得到课件加密key
//	 *
//	 * @param username
//	 * @return String
//	 * @TODO
//	 */
//	// public static String getKeyCode() {
//	// String flag = "exam2013";
//	// String key = Config.getValue("EncryptKey");
//	// if (StringUtil.isEmpty(key)) {
//	// key = "qwexxx(exam2012)xxxasd";
//	// }
//	// String md5UserName = StringUtil.md5Hex(flag);
//	// String md5Key = StringUtil.md5Hex(key);
//	// String md5Code = md5UserName + StringUtil.md5Hex(md5UserName + md5Key)
//	// + md5Key;
//	// String begin9 = md5Code.substring(0, 9);
//	// String end9 = md5Code.substring(md5Code.length() - 9, md5Code.length());
//	// String center = md5Code.substring(9, md5Code.length() - 9);
//	// String result = end9 + center + begin9;
//	//
//	// result = StringCodeUtil.encode(result);
//	// result = result.substring(0, 23);
//	// return result;
//	// }
//
//	/**
//	 * 加密PC端下载文件
//	 *
//	 * @param file
//	 * @param seed
//	 * @return
//	 */
//	public static boolean encryptDownFile(String srcFile, String kid) {
//		try {
//			// 读取文件头
//			RandomAccessFile raf = new RandomAccessFile(srcFile, "rw");
//			raf.seek(0);
//			byte[] headByte = new byte[1024];
//			raf.read(headByte);
//			// 写入加密数据
//			byte[] encryptData = CryptoUtil.encryptDown(headByte);
//			raf.seek(0);
//			if (encryptData != null) {
//				raf.write(encryptData);
//			}
//			raf.close();
//			addKidToVideo(srcFile, kid);// 把课件ID加到视频文件末尾
//			return true;
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	/**
//	 * 加密文件
//	 *
//	 * @param data
//	 * @return byte[]
//	 * @TODO
//	 */
//	private static byte[] encryptDown(byte[] data) {
//		try {
//			for (int i = 0; i < data.length; i++) {
//				data[i] = (byte) ~data[i];
//			}
//			return data;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	/**
//	 * 把课件ID加到视频文件后面，默认加10个字节
//	 *
//	 * @param srcFile
//	 * @param kid
//	 *            void
//	 * @TODO
//	 */
//	public static void addKidToVideo(String srcFile, String kid) {
//		StringBuffer sb = new StringBuffer();
//		if (kid.length() < 10) {
//			for (int i = kid.length(); i < 10; i++) {
//				sb.append("0");
//			}
//			sb.append(kid);
//		}
//		kid = sb.toString();
//		byte[] kids = kid.getBytes();
//		try {
//			byte[] buffer = new byte[1024];
//			// 源文件
//			FileInputStream fileInputStream = new FileInputStream(new File(srcFile));
//			String file = srcFile.substring(0, srcFile.indexOf("."));
//			String suffix = srcFile.substring(srcFile.indexOf(".") + 1, srcFile.length());
//			FileOutputStream fileOutputStream = new FileOutputStream(new File(file + "_tmp" + "." + suffix));
//			while (true) {
//				if (fileInputStream.available() < 1024) {
//					// 剩于的数据比1024少
//					// 一位一位读出再写入目的文件
//					int remain = -1;
//					while ((remain = fileInputStream.read()) != -1) {
//						fileOutputStream.write(remain);
//					}
//					break;
//				} else {
//					// 从来源文件读取数据至缓冲区
//					fileInputStream.read(buffer);
//					// 将数组数据写入目的文件
//					fileOutputStream.write(buffer);
//				}
//			}
//			fileOutputStream.write(kids);
//			// 关闭流
//			fileInputStream.close();
//			fileOutputStream.close();
//			FileUtil.delete(srcFile);
//			FileUtil.move(file + "_tmp" + "." + suffix, file + ".e" + suffix);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 加密PC端下载文件
//	 *
//	 * @return
//	 */
//	public static boolean encryptDownJY(String srcFile) {
//		try {
//			// 读取文件头
//			RandomAccessFile raf = new RandomAccessFile(srcFile, "rw");
//			raf.seek(0);
//			byte[] headByte = new byte[(int) raf.length()];
//			raf.read(headByte);
//			// 写入加密数据
//			byte[] encryptData = CryptoUtil.encryptDown(headByte);
//			raf.seek(0);
//			if (encryptData != null) {
//				raf.write(encryptData);
//			}
//			raf.close();
//			addDateToJY(srcFile);// 把课件ID加到视频文件末尾
//			return true;
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	/**
//	 * 把课件过期时间加到视频文件后面
//	 *
//	 * @param srcFile

//	 *            void
//	 * @TODO
//	 */
//	public static void addDateToJY(String srcFile) {
//		// 得到课件的过期时间
//		String usedate = getKJDate();
//		byte[] kids = usedate.getBytes();
//		try {
//			byte[] buffer = new byte[1024];
//			// 源文件
//			FileInputStream fileInputStream = new FileInputStream(new File(srcFile));
//			String file = srcFile.substring(0, srcFile.indexOf("."));
//			String suffix = srcFile.substring(srcFile.indexOf(".") + 1, srcFile.length());
//			FileOutputStream fileOutputStream = new FileOutputStream(new File(file + "_tmp" + "." + suffix));
//			while (true) {
//				if (fileInputStream.available() < 1024) {
//					// 剩于的数据比1024少
//					// 一位一位读出再写入目的文件
//					int remain = -1;
//					while ((remain = fileInputStream.read()) != -1) {
//						fileOutputStream.write(remain);
//					}
//					break;
//				} else {
//					// 从来源文件读取数据至缓冲区
//					fileInputStream.read(buffer);
//					// 将数组数据写入目的文件
//					fileOutputStream.write(buffer);
//				}
//			}
//			fileOutputStream.write(kids);
//			// 关闭流
//			fileInputStream.close();
//			fileOutputStream.close();
//			FileUtil.delete(srcFile);
//			FileUtil.move(file + "_tmp" + "." + suffix, file + ".e" + suffix);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 得到课件的过期时间

//	 * @return
//	 *         String
//	 * @TODO
//	 */
//	public static String getKJDate() {
//		String date = Config.getValue("DefaultKJJYUseDate");
//		if (StringUtil.isEmpty(date)) {
//			date = "2013-10-01 00:00:00";
//		}
//		return date;
//	}
//
//	/**
//	 * 导出局域网版课件时加密
//	 *
//	 * @param key
//	 * @param srcFile
//	 *            void
//	 * @TODO
//	 */
//	public static boolean encryptLocalFile(String key, String srcFile) {
//		try {
//			// 读取文件头
//			RandomAccessFile raf = new RandomAccessFile(srcFile, "rw");
//			raf.seek(0);
//			byte[] headByte = new byte[2048];
//			raf.read(headByte);
//			// 写入加密数据
//			byte[] encryptData = CryptoUtil.encryptDown(headByte);
//			raf.seek(0);
//			if (encryptData != null) {
//				raf.write(encryptData);
//			}
//			raf.close();
//			addKeyToEmportVideo(key, srcFile);// 把加密串加到视频文件末尾
//			return true;
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	/**
//	 * @param key
//	 * @param srcFile
//	 *            void
//	 * @TODO
//	 */
//	public static void addKeyToImportKJ(String key, String srcFile) {
//		byte[] keys = key.getBytes();
//		try {
//			byte[] buffer = new byte[1024];
//			// 源文件
//			FileInputStream fileInputStream = new FileInputStream(new File(srcFile));
//			String file = srcFile.substring(0, srcFile.indexOf("."));
//			String suffix = srcFile.substring(srcFile.indexOf(".") + 1, srcFile.length());
//			FileOutputStream fileOutputStream = new FileOutputStream(new File(file + "_tmp" + "." + suffix));
//			while (true) {
//				if (fileInputStream.available() < 1024) {
//					// 剩于的数据比1024少
//					// 一位一位读出再写入目的文件
//					int remain = -1;
//					while ((remain = fileInputStream.read()) != -1) {
//						fileOutputStream.write(remain);
//					}
//					break;
//				} else {
//					// 从来源文件读取数据至缓冲区
//					fileInputStream.read(buffer);
//					// 将数组数据写入目的文件
//					fileOutputStream.write(buffer);
//				}
//			}
//			fileOutputStream.write(keys);
//			// 关闭流
//			fileInputStream.close();
//			fileOutputStream.close();
//			FileUtil.delete(srcFile);
//			FileUtil.move(file + "_tmp" + "." + suffix, file + ".e" + suffix);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * @param key
//	 * @param srcFile
//	 *            void
//	 * @TODO
//	 */
//	public static void addKeyToEmportVideo(String key, String srcFile) {
//		byte[] keys = key.getBytes();
//		try {
//			byte[] buffer = new byte[1024];
//			// 源文件
//			FileInputStream fileInputStream = new FileInputStream(new File(srcFile));
//			String file = srcFile.substring(0, srcFile.indexOf("."));
//			String suffix = srcFile.substring(srcFile.indexOf(".") + 1, srcFile.length());
//			FileOutputStream fileOutputStream = new FileOutputStream(new File(file + "_tmp" + "." + suffix));
//			while (true) {
//				if (fileInputStream.available() < 1024) {
//					// 剩于的数据比1024少
//					// 一位一位读出再写入目的文件
//					int remain = -1;
//					while ((remain = fileInputStream.read()) != -1) {
//						fileOutputStream.write(remain);
//					}
//					break;
//				} else {
//					// 从来源文件读取数据至缓冲区
//					fileInputStream.read(buffer);
//					// 将数组数据写入目的文件
//					fileOutputStream.write(buffer);
//				}
//			}
//			fileOutputStream.write(keys);
//			// 关闭流
//			fileInputStream.close();
//			fileOutputStream.close();
//			FileUtil.delete(srcFile);
//			FileUtil.move(file + "_tmp" + "." + suffix, file + "." + suffix);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}