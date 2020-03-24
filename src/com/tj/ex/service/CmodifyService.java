package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.ex.dao.CustomerDao;
import com.tj.ex.dto.CustomerDto;

public class CmodifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("cid");
		String cpass = request.getParameter("cpass");
		String cname = request.getParameter("cname");
		String ctel = request.getParameter("ctel");
		String caddress = request.getParameter("caddress");
		CustomerDto dto = new CustomerDto(cid, cpass, cname, ctel, caddress, null, 0);
		CustomerDao dao = CustomerDao.getInstance();
		int result = dao.modifyCustomer(dto);
		if(result==dao.SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("customer", dto);
			request.setAttribute("modifyResult", "정보수정 완료되었습니다");
		}else {
			request.setAttribute("modifyResult", "길어서 가입이 실패되었습니다");
		}
	}

}
