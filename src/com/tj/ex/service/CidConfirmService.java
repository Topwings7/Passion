package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.CustomerDao;

public class CidConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("cid");
		CustomerDao dao = CustomerDao.getInstance();
		int result = dao.cidConfirm(cid);
		if(result== CustomerDao.SUCCESS) {
			request.setAttribute("idConfirmResult", "사용가능한 ID입니다");
		}else {
			request.setAttribute("idConfirmResult", "중복된 ID입니다");
		}
	}

}
