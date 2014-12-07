package edu.fjnu.empmis.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.imageio.stream.FileImageInputStream;

import edu.fjnu.empmis.domain.Employee;


public class FileUtil {

	/**
	 * 
	 * @param file
	 *            �ļ���
	 * @param message
	 *            Ҫ�����ļ�����Ϣ
	 * @throws IOException
	 *             �쳣�׳�
	 */
	public void writeToFile(File file, String... message) throws IOException {
		PrintStream printStream=null;
		// true��ʾ����׷���ļ������ݶ����ᱻ����
		OutputStream fileOutPutStream = new FileOutputStream(file, true);
		//����һ����ӡ��
		printStream=new PrintStream(fileOutPutStream);
		printStream.println();
		for (int i = 0; i < message.length; i++) {
			printStream.print(message[i]);
			if(i!=message.length-1){
				printStream.print(":");
			}
		}

		printStream.close();

	}

	/**
	 * 
	 * @param file�ļ���
	 * 
	 * @return ����һ��String���͵�ֵ
	 * @throws IOException
	 */
	public String readFromFile(File file) throws IOException {
		InputStream fileInputStream = new FileInputStream(file);
		int length = (int) file.length();
		byte[] b = new byte[length];

		fileInputStream.read(b);
		String str = new String(b);
		/**
		 * �ر�������
		 */
		fileInputStream.close();
		return str;
	}

	/**
	 * ���ļ���ȡ��������Ϣ���б�����һ��List������
	 * 
	 * @param file
	 *            �ļ���
	 * @return
	 * @throws IOException
	 */
	public List<String> readFileByLine(File file) throws IOException {
		List<String> strs = new ArrayList<String>();
		InputStream fileInputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(
				fileInputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String temp = null;
		while ((temp = bufferedReader.readLine()) != null) {
			if(!temp.equals("")){
			strs.add(temp);
			}
			

		}

		return strs;

	}

}
