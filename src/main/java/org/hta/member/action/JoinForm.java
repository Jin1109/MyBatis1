package org.hta.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;

public class JoinForm implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);// 주소 변경 없이 jsp페이지의 내용을 보여줍니다.
		forward.setPath("jsp/joinForm.jsp");
		return forward;
	}
}
