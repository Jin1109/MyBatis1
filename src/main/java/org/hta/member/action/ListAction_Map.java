package org.hta.member.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hta.member.controller.Action;
import org.hta.member.controller.ActionForward;
import org.hta.member.dao.MemberDao;

public class ListAction_Map implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		ActionForward forward=new ActionForward();
		
		MemberDao md = new MemberDao();
		List<Map<String,String>> list = md.list2();
		
		//Map<String,String>의 내용을 출력해 봅시다
		for(Map<String,String> map : list) {
			Set<String> keys = map.keySet();
			for(String key : keys) {
				System.out.println(key + "=" + map.get(key) + " ");
			}
			System.out.println();
		}
		
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		forward.setPath("jsp/list_map.jsp");
		return forward;
	}
}
