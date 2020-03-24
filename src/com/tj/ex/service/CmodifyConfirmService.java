package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.CustomerDao;
import com.tj.ex.dto.CustomerDto;

public class CmodifyConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("cid");
		String dbpw = request.getParameter("dbpw");
		CustomerDao dao = CustomerDao.getInstance();
		CustomerDto dto = dao.getCustomer(cid);
		String cpass = dto.getCpass();
		if(dbpw.equals(cpass)) {
			request.setAttribute("cmodifyConfirmResult", "정보수정 가능합니다");
		}else {
			request.setAttribute("cmodifyConfirmResult", "기존비밀번호가 다릅니다");
		}
	}
}
