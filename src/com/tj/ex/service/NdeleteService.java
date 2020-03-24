package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.NoticeDao;

public class NdeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nnum = Integer.parseInt(request.getParameter("nnum"));
		System.out.println(nnum);
		NoticeDao dao = NoticeDao.getInstance();
		request.setAttribute("ndeleteResult", dao.deleteNotice(nnum));
	}

}
