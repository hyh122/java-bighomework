/**
 * 
 */
package edu.fjnu.empmis.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import edu.fjnu.empmis.exception.EmployeeMISException;
import edu.fjnu.empmis.ui.UIFactory;

/**
 * @author Administrator
 *
 */
public class SysBaseUtil {
	//�ļ�·����
	public static final String FILEPATH="G:\\record.txt";
	//װ��UI
	public static void loadUI(String UIType){
		UIFactory.getInstance().getComponent(UIType).run();
		
	}
	
	//����ļ��Ƿ����,���������׳��쳣
	public static void checkFile(){
		File file=new File(FILEPATH);
		if(!file.exists()){
			throw new EmployeeMISException("Employee information datafile isn��t existed! Now exit!");
		}
	}
	/**
	 * �ӿ���̨����һ������
	 * @return �����һ������
	 */
	public static String getEntry(){
		
		//ͨ��io�ض����ȡ����̨������
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		String entry = null;
		try {
			//��enter������ܽ��������ݷ���
			entry = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new EmployeeMISException("Read entry from console failed! please check!!");
		}
		return entry;
	}
	/**
	 * �ж�һ���ַ����Ƿ�Ϊ��
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s){
		return s==null||s.trim().length()==0;
	}
	/**
	 * ����ʾ������ͣ
	 * @param message
	 */
	public static void pause(String message){
		System.out.println(message);
		getEntry();
	}
	
}
