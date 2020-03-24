package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.NoticeDao;
import com.tj.ex.dto.NoticeDto;

public class NContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nnum = Integer.parseInt(request.getParameter("nnum"));
		NoticeDao dao = NoticeDao.getInstance();
		NoticeDto dto = dao.getNotice(nnum);
		request.setAttribute("notice", dto);
	}

}
