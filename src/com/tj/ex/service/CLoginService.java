package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.ex.dao.CustomerDao;
import com.tj.ex.dto.CustomerDto;

public class CLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("cid");
		String cpass = request.getParameter("cpass");
		CustomerDao dao = CustomerDao.getInstance();
		int result = dao.cLoginConfirm(cid, cpass);
		if(result == dao.SUCCESS) {
			CustomerDto dto = dao.getCustomer(cid);
			HttpSession session = request.getSession();
			session.setAttribute("customer", dto);
			request.setAttribute("cloginsuccess", "어서오세요 환영합니다");
		}else {
			request.setAttribute("cloginerror", "아이디와 비밀번호가 다릅니다");
		}
	}

}
