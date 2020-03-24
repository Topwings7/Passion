package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.ex.dao.MasterDao;
import com.tj.ex.dto.MasterDto;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		MasterDao dao = MasterDao.getInstance();
		int result = dao.MLoginConfirm(mid, mpass);
		if(result == dao.SUCCESS) {
			MasterDto dto = new MasterDto(mid, mpass);
			HttpSession session = request.getSession();
			session.setAttribute("master", dto);
			request.setAttribute("mloginsucess", "관리자계정으로 접근하셨습니다");
		}else {
			request.setAttribute("mloginerror", "아이디와 비밀번호가 다릅니다");
		}
	}

}
