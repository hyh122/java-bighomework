package edu.fjnu.empmis.ui;

import java.util.regex.Pattern;

import edu.fjnu.empmis.dao.EmployeeDao;
import edu.fjnu.empmis.dao.EmployeeTxtDao;
import edu.fjnu.empmis.domain.Employee;
import edu.fjnu.empmis.exception.InvalidEmployeePropertyException;
import edu.fjnu.empmis.util.DateUtil;
import edu.fjnu.empmis.util.SysBaseUtil;

public class AddEmployeeUI implements BaseUI {
	private EmployeeDao employeeTxtDao;

	public AddEmployeeUI() {
		// TODO Auto-generated constructor stub
		employeeTxtDao = new EmployeeTxtDao();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		boolean isContinue=true;
		boolean isContinue1 = true;
		boolean isContinue2 = true;
		boolean isContinue3 = true;
		boolean isContinue4 = true;
		boolean isContinue5 = true;
		boolean isContinue6 = true;
		boolean isContinue7 = true;
		boolean isContinue8 = true;
		while(isContinue){
		while (isContinue1) {
			System.out.println("Enter employee 3 digit payroll number:");
			String entryOfEmployeeNo = SysBaseUtil.getEntry();
			try {
				checkEmploeeNo(entryOfEmployeeNo);
			} catch (Exception e) {
				SysBaseUtil.pause(e.getMessage());
				continue;
			}
			employee.setEmployeeNo(entryOfEmployeeNo);
			isContinue1 = false;
		}
		while (isContinue2) {
			System.out.println("Enter Phone Number (02-12345678):");
			String entryOfTelephone = SysBaseUtil.getEntry();
			try {
				checkTelePhone(entryOfTelephone);
			} catch (Exception e) {
				SysBaseUtil.pause(e.getMessage());
				continue;
			}
			employee.setTelephoneNumber(entryOfTelephone);
			isContinue2 = false;
		}

		while (isContinue3) {
			System.out.println("Enter Last Name:");
			String entryOfLastName = SysBaseUtil.getEntry();
			try {
				checkProperty(entryOfLastName, EmpPropetyType.LASTNAME);
			} catch (Exception e) {
				SysBaseUtil.pause(e.getMessage());
				continue;
			}
			employee.setLastName(entryOfLastName);
			isContinue3 = false;
		}

		while (isContinue4) {
			System.out.println("Enter First Name:");
			String entryOfFirstName = SysBaseUtil.getEntry();
			try {
				checkProperty(entryOfFirstName, EmpPropetyType.FIRSTNAME);
			} catch (Exception e) {
				SysBaseUtil.pause(e.getMessage());
				continue;
			}
			employee.setFirshName(entryOfFirstName);
			isContinue4 = false;
		}

		while (isContinue5) {
			System.out.println("Enter Middle Init:");
			String entryOfInitial = SysBaseUtil.getEntry();
			try {
				checkProperty(entryOfInitial, EmpPropetyType.INITIAL);
			} catch (Exception e) {
				SysBaseUtil.pause(e.getMessage());
				continue;
			}
			employee.setInitial(entryOfInitial);
			isContinue5 = false;
		}
		while(isContinue6){
			System.out.println("Enter Dept #:");
			String entryOfDept = SysBaseUtil.getEntry();
			try {
				checkDepartMentNo(entryOfDept);
			} catch (Exception e) {
				SysBaseUtil.pause(e.getMessage());
				continue;
			}
			employee.setDepartmentNumber(entryOfDept);
			isContinue6 = false;
		}
		
		while(isContinue7){
			System.out.println("Enter Job Title:");
			String entryOfJobTitle = SysBaseUtil.getEntry();
			try {
				checkProperty(entryOfJobTitle,EmpPropetyType.JOBTITLE);
			} catch (Exception e) {
				SysBaseUtil.pause(e.getMessage());
				continue;
			}
			employee.setJobTitle(entryOfJobTitle);
			isContinue7 = false;
		}
		
		while(isContinue8){
			System.out.println("Enter Date Hired (dd-mm-yyyy):");
			String entryOfHireDate = SysBaseUtil.getEntry();
			try {
				checkDate(entryOfHireDate);
			} catch (Exception e) {
				SysBaseUtil.pause(e.getMessage());
				continue;
			}
			employee.setDateOfHiring(entryOfHireDate);
			isContinue8 = false;
		}
		//��Ա����Ϣ���뵽�ļ���
		employeeTxtDao.saveEmployee(employee);
		System.out.println("\nRecord Saved");
		System.out.println("Add another employee record? (y)es or (n)o:");
		String entryOfYOrN = SysBaseUtil.getEntry();
		if(entryOfYOrN.equalsIgnoreCase("Y")){
			isContinue1 = true;
			 isContinue2 = true;
			 isContinue3 = true;
			isContinue4 = true;
			 isContinue5 = true;
			 isContinue6 = true;
			 isContinue7 = true;
			 isContinue8 = true;
			continue;
		}else{
			isContinue=false;
		}
		
		}
	}

	/**
	 * ��������Ա�����Ƿ����Ҫ��
	 * 
	 * @param empNo
	 */
	private void checkEmploeeNo(String empNo) {
		// ���������ֵΪ��
		if (SysBaseUtil.isEmpty(empNo)) {
			throw new InvalidEmployeePropertyException(
					"No payroll number entered �C try again");
		}
		// ���������ֵ������λ��
		else if (empNo.length() != 3) {
			throw new InvalidEmployeePropertyException(
					"Payroll number can contain only numerical characters");
		}
		/**
		 * ʹ��������ʽ���ж��ַ����Ƿ����������
		 */
		// �������������ֵ����������
		else if (!Pattern.compile("[0-9]+").matcher(empNo).matches()) {

			throw new InvalidEmployeePropertyException(
					"Payroll number can contain only numerical characters");
		} else {// ���������Ա�����Ѿ�����
			if (employeeTxtDao.checkEmployeeNo(empNo)) {
				throw new InvalidEmployeePropertyException(
						"this employeeNo has exites!! please input another!!");
			}
		}

	}

	private void checkTelePhone(String telephone) {
		// ���������ֵΪ��
		if (SysBaseUtil.isEmpty(telephone)) {
			throw new InvalidEmployeePropertyException(
					"No phone number entered �C try again");
		}
		/**
		 * ����������ʽ�ж�����ĵ绰�����Ƿ���Ϲ淶: ��Ч�ĵ绰������02, 03, 04, 05, 06, 07, 08.
		 * �绰�������λ(����������)������ 1 �� 9 ֮����������֣� �� 7�����ֿ�����0 �� 9 ֮�����������
		 */
		else if (!Pattern.compile("[0]{1}[2-8]{1}-[1-9]{1}[0-9]{7}")
				.matcher(telephone).matches()) {
			throw new InvalidEmployeePropertyException(
					"Invalid phone number �C try again");
		}

	}

	private void checkProperty(String property, String propertyType) {
		// ���������ֵΪ��
		if (SysBaseUtil.isEmpty(property)) {
			String exceptionMessage = null;
			if (propertyType.equals(EmpPropetyType.LASTNAME)) {
				exceptionMessage = "No last name entered �C try again";
			} else if (propertyType.equals(EmpPropetyType.FIRSTNAME)) {
				exceptionMessage = "No First name entered �C try again";
			} else if (propertyType.equals(EmpPropetyType.INITIAL)) {
				exceptionMessage = "No Middle Init entered �C try again";
			}else if(propertyType.equals(EmpPropetyType.JOBTITLE)){
				exceptionMessage = "No Job title entered �C try again";
			}
			throw new InvalidEmployeePropertyException(exceptionMessage);

		} else if (!Pattern
				.compile(
						"[a-zA-Z]*\\s*|\\s*[a-zA-Z]*|\\s*[a-zA-Z]*\\s*|[a-zA-Z]*\\s*[a-zA-Z]*")
				.matcher(property).matches()) {
			String exceptionMessage = null;
			if (propertyType.equals(EmpPropetyType.LASTNAME)) {
				exceptionMessage = "Last name can contain only alphabetical characters and spaces ";
			} else if (propertyType.equals(EmpPropetyType.FIRSTNAME)) {
				exceptionMessage = "First name can contain only alphabetical characters and spaces ";
			} else if (propertyType.equals(EmpPropetyType.INITIAL)) {
				exceptionMessage = "Middle Init can contain only alphabetical characters and spaces";
			}else if (propertyType.equals(EmpPropetyType.JOBTITLE)) {
				exceptionMessage = "job title can contain only alphabetical characters and spaces";
			}
			throw new InvalidEmployeePropertyException(exceptionMessage);
		}
	}
	private void checkDepartMentNo(String departMentNo){
		// ���������ֵΪ��
				if (SysBaseUtil.isEmpty(departMentNo)) {
					throw new InvalidEmployeePropertyException(
							"No Dept # entered �C try again");
				}else if(!Pattern.compile("\\d+")
				.matcher(departMentNo).matches()){
					throw new InvalidEmployeePropertyException(
							"Dept # can contain only digits with no spaces");
				}
	}
	private void checkDate(String hireDate){
		// ���������ֵΪ��
		if (SysBaseUtil.isEmpty(hireDate)) {
			throw new InvalidEmployeePropertyException(
					"No date hired entered �C try again");
		}
		else if(!DateUtil.checkDateFormat(hireDate)){
			throw new InvalidEmployeePropertyException(
			"Invalid Date Hired");
		}

	}

}
