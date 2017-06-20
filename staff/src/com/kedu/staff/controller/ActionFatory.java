package com.kedu.staff.controller;

import com.kedu.common.Action;
import com.kedu.staff.action.AcadWriteAction;
import com.kedu.staff.action.CarProjWriteAction;
import com.kedu.staff.action.CarWriteAction;
import com.kedu.staff.action.IdCheckAction;
import com.kedu.staff.action.LicWriteAction;
import com.kedu.staff.action.LoginAction;
import com.kedu.staff.action.LoginFormAction;
import com.kedu.staff.action.LogoutAction;
import com.kedu.staff.action.PictureUploadAction;
import com.kedu.staff.action.SkillWriteAction;
import com.kedu.staff.action.StaffListAction;
import com.kedu.staff.action.StaffWriteAction;
import com.kedu.staff.action.StaffWriteFormAction;

public class ActionFatory {

	private static ActionFatory instance = new ActionFatory();
	
	private ActionFatory() {
		super();
	}
	
	public static ActionFatory getInstance(){
		return instance;
	}
	
	public Action getAction(String command){
		Action action = null;
		
		if(command.equals("login_form")){
			action = new LoginFormAction();
			System.out.println("reurn : LoginFormAction()");
		}else if(command.equals("login")){
			action = new LoginAction();
			System.out.println("reurn : LoginAction()");
		}else if(command.equals("logout")){
			action = new LogoutAction();
			System.out.println("return : LogoutAction()");
		}else if(command.equals("staff_write_form")){
			action = new StaffWriteFormAction();
			System.out.println("return : StaffWriteFormAction");
		}else if(command.equals("staff_list")){
			action = new StaffListAction();
			System.out.println("return : StaffListAction");
		}else if(command.equals("staff_write")){
			action = new StaffWriteAction();
			System.out.println("return : StaffWriteAction");
		}else if(command.equals("acad_write")){
			action = new AcadWriteAction();
			System.out.println("return : AcacWriteAction");
		}else if(command.equals("car_write")){
			action = new CarWriteAction();
			System.out.println("return : CarWriteAction");
		}else if(command.equals("car_proj_write")){
			action = new CarProjWriteAction();
			System.out.println("return : CarProjAction");
		}else if(command.equals("lic_write")){
			action = new LicWriteAction();
			System.out.println("return : LicWriteAction");
		}else if(command.equals("id_check")){
			action = new IdCheckAction();
			System.out.println("return : IdCheckAction");
		}else if(command.equals("picture_upload")){
			action = new PictureUploadAction();
			System.out.println("return : PictureUploadAction");
		}else if(command.equals("skill_write")){
			action = new SkillWriteAction();
			System.out.println("return : SkillWriteAction");
		}
		
		return action;
	}
}
