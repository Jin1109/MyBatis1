package org.hta.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;

public class MainAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("jsp/main.jsp");
		return forward;
	}

}
