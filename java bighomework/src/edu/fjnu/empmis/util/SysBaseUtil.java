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
	//文件路径名
	public static final String FILEPATH="G:\\record.txt";
	//装载UI
	public static void loadUI(String UIType){
		UIFactory.getInstance().getComponent(UIType).run();
		
	}
	
	//检查文件是否存在,不存在则抛出异常
	public static void checkFile(){
		File file=new File(FILEPATH);
		if(!file.exists()){
			throw new EmployeeMISException("Employee information datafile isn’t existed! Now exit!");
		}
	}
	/**
	 * 从控制台输入一行数据
	 * @return 输入的一行数据
	 */
	public static String getEntry(){
		
		//通过io重定向获取控制台的输入
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		String entry = null;
		try {
			//按enter键后才能将这行数据返回
			entry = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new EmployeeMISException("Read entry from console failed! please check!!");
		}
		return entry;
	}
	/**
	 * 判断一个字符串是否为空
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s){
		return s==null||s.trim().length()==0;
	}
	/**
	 * 带提示符的暂停
	 * @param message
	 */
	public static void pause(String message){
		System.out.println(message);
		getEntry();
	}
	
}
