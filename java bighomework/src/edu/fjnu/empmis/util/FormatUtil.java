package edu.fjnu.empmis.util;

public class FormatUtil {
	/**
	 * ����һ���ַ����øý����ַ���ת���ɹ̶�ռ�ü����ֽڿռ���ַ���
	 * 
	 * @param s
	 *            ������ַ���
	 * @param num
	 *            �ֽ���
	 * @return �ı���ռ�ֽ�������ַ���
	 */
	public static String getRegularBytesOfString(String s, int num) {

		int length = s.length();
		for (int i = length; i < num; i++) {
			s += " ";
		}

		return s;
	}
}
