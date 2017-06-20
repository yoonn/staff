package com.kedu.notice.controller;

import com.kedu.common.Action;
import com.kedu.notice.action.NoticeDeleteAction;
import com.kedu.notice.action.NoticeListAction;
import com.kedu.notice.action.ReplyWriteAction;
import com.kedu.notice.action.NoticeUpdateAction;
import com.kedu.notice.action.NoticeUpdateFormAction;
import com.kedu.notice.action.NoticeViewAction;
import com.kedu.notice.action.NoticeWriteAction;
import com.kedu.notice.action.NoticeWriteFormAction;
import com.kedu.notice.action.ReplyDeleteAction;
import com.kedu.notice.action.ReplyListAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory(){
		super();
	}
	
	public static ActionFactory getInstance(){
		return instance;
	}
	
	public Action getAction(String command){
		Action action = null;
//		System.out.println("ActionFactory : " + command);
		if(command.equals("notice_list")){
			action = new NoticeListAction();
		}else if(command.equals("notice_write_form"))	{
			action = new NoticeWriteFormAction();
		}else if(command.equals("notice_write")){
			action = new NoticeWriteAction();
		}else if(command.equals("notice_view")){
			action = new NoticeViewAction();
		}else if(command.equals("notice_update_form")){
			action = new NoticeUpdateFormAction();
		}else if(command.equals("notice_update")){
			action = new NoticeUpdateAction();
		}else if(command.equals("notice_delete")){
			action = new NoticeDeleteAction();
		}else if(command.equals("reply_write")){
			action = new ReplyWriteAction();
			System.out.println("return : ReplyWriteAction");
		}else if(command.equals("reply_delete")){
			action = new ReplyDeleteAction();
			System.out.println("return : ReplyDeleteAction");
		}else if(command.equals("reply_list")){
			action = new ReplyListAction();
			System.out.println("return : ReplyListAction");
		}
			
		return action;
	}
}
