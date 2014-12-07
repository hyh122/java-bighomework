package edu.fjnu.empmis.util;

import java.util.regex.Pattern;

public class DateUtil {

	public DateUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ��鴫������ڸ�ʽ�Ƿ������ʵ
	 * 
	 * @param date
	 *            ����Ҫ���ʽΪxx-xx-xxxx,��-��-��ĸ�ʽ
	 * @return ����ֵ
	 */
	public static boolean checkDateFormat(String date) {
		boolean isTrue = false;
		// Ҫ��������ڸ�ʽΪxx-xx-xxxx,��-��-��ĸ�ʽ
		if (Pattern.compile("\\d{2}-\\d{2}-\\d{4}").matcher(date).matches()) {
			// ��"-"�ֿ�
			String[] s = date.split("-");
			// �յĲ���
			String day = s[0];
			// �µĲ���
			String month = s[1];
			// ȡ����Ĳ���
			String year = s[2];

			// �����·ݷ��Ϲ淶01-12
			if (Pattern.compile("[0][1-9]|[1][0-2]").matcher(month).matches()) {
				// �����·�Ϊ01,02,05,07,08,10,12��һ������31��
				if (Pattern.compile("[0][13578]|[1][02]").matcher(month)
						.matches()) {
					if (Pattern.compile("[0][1-9]|[1][0-9]|[2][0-9]|[3][0-1]")
							.matcher(day).matches()) {
						isTrue = true;
					}
				}
				// �����Ƕ��·���Ҫ�ж��Ƿ�Ϊ����
				else if (Pattern.compile("[0][2]").matcher(month).matches()) {
					if (checkLeapYear(year)) {// ����������
						if (Pattern.compile("[0][1-9]|[1][0-9]|[2][0-9]")
								.matcher(day).matches()) {
							isTrue = true;
						}
					} else {
						if (Pattern.compile("[0][1-9]|[1][0-9]|[2][0-8]")
								.matcher(day).matches()) {
							isTrue = true;
						}
					}
				}
				// �������·�Ϊ30��
				else {
					if (Pattern.compile("[0][1-9]|[1][0-9]|[2][0-9]|[3][0]")
							.matcher(day).matches()) {
						isTrue = true;
					}
				}

			}
		}
		return isTrue;
	}

	public static boolean checkLeapYear(String year) {
		int intYear = Integer.parseInt(year);
		if (intYear % 4 == 0 && intYear % 100 != 0) {
			return true;
		}
		if (intYear % 400 == 0) {
			return true;
		}
		return false;
	}

	
}
