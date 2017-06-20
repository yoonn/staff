package com.kedu.project.controller;

import com.kedu.common.Action;
import com.kedu.project.action.ProjectDeleteAction;
import com.kedu.project.action.ProjectListAction;
import com.kedu.project.action.ProjectUpdateAction;
import com.kedu.project.action.ProjectUpdateFormAction;
import com.kedu.project.action.ProjectViewAction;
import com.kedu.project.action.ProjectWriteAction;
import com.kedu.project.action.ProjectWriteFormAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance(){
		return instance;
	}
	
	public Action getAction(String command){
		Action action = null;
		
		if(command.equals("proj_list")){
			action = new ProjectListAction();
			System.out.println("return projectListAction");
		}else if(command.equals("proj_write_form")){
			action = new ProjectWriteFormAction();
			System.out.println("return projectWriteFormAction");
		}else if(command.equals("proj_write")){
			action = new ProjectWriteAction();
			System.out.println("return projectWriteAction");
		}else if(command.equals("proj_view")){
			action = new ProjectViewAction();
			System.out.println("return ProjectViewAction");
		}else if(command.equals("proj_update_form")){
			action = new ProjectUpdateFormAction();
			System.out.println("return ProjectUpdateFormAction");
		}else if(command.equals("proj_update")){
			action = new ProjectUpdateAction();
			System.out.println("return ProjectUpadateAction");
		}else if(command.equals("proj_delete")){
			action = new ProjectDeleteAction();
			System.out.println("return ProjectDeleteAction");
		}
		
		return action;
	}
}
