package edu.fjnu.empmis.ui;

import edu.fjnu.empmis.exception.EmployeeMISException;
/**
 * UIFactory设置为单例模式
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
	 * 根据输入的ui种类创建ui
	 * @param uiType ui种类
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
			throw new EmployeeMISException("UI部件不存在,部件名:"+uiType);
		}
		
		return ui;
	}
	
	
}
