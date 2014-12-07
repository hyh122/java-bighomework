package edu.fjnu.empmis.ui;

import edu.fjnu.empmis.exception.EmployeeMISException;
/**
 * UIFactory����Ϊ����ģʽ
 * @author Administrator hyh
 *
 */
public class UIFactory {
	private static final UIFactory FACTORY=new UIFactory();
	
	public static UIFactory getInstance(){
		return FACTORY;
	}
	private UIFactory(){
		
	}
	/**
	 * ���������ui���ഴ��ui
	 * @param uiType ui����
	 * @return
	 */
	public static BaseUI getComponent(String uiType){
		BaseUI ui=null;
		if(uiType.equals(UIType.MAIN_MENU)){
			ui= new MainMenuUI();
		}else if(uiType.equals(UIType.ADD_EMPLOYEE)){
			ui=new AddEmployeeUI();
		}
		else if(uiType.equals(UIType.QueryEmployeeByKeyWordUI)){
			ui=new QueryEmployeeByKeyWordUI();
		}else if(uiType.equals(UIType.DELETEEMPLOYEEUI)){
			ui=new DeleteEmployeeUI();
		}
		if(ui==null){
			throw new EmployeeMISException("UI����������,������:"+uiType);
		}
		
		return ui;
	}
	
	
}
