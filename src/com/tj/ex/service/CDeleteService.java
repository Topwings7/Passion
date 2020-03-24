package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.ex.dao.CustomerDao;
import com.tj.ex.dto.CustomerDto;

public class CDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("cid");
		CustomerDao dao = CustomerDao.getInstance();
		int result = dao.deleteCustomer(cid);
		if(result == dao.SUCCESS) {
			request.setAttribute("deleteResult", "성공적으로 탈퇴되었습니다.");
			HttpSession session = request.getSession();
			session.invalidate();
		}
	}
}
