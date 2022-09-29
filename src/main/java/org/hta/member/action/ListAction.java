package org.hta.member.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.MemberDao;
import org.hta.member.domain.Member;

public class ListAction implements Action {
	 public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
		ActionForward forwoard=new ActionForward();
		
		MemberDao md = new MemberDao();
		List<Member> list = md.list();
		
		request.setAttribute("list", list);
		forwoard.setRedirect(false);
		forwoard.setPath("jsp/list.jsp");
		return forwoard;
	}
}
