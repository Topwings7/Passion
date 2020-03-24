package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.NoticeDao;
import com.tj.ex.dto.NoticeDto;

public class NWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String nname = request.getParameter("nname");
		String ncontent = request.getParameter("ncontent");
		NoticeDao dao = NoticeDao.getInstance();
		NoticeDto dto = new NoticeDto();
		dto.setMid(mid);
		dto.setNname(nname);
		dto.setNcontent(ncontent);
		request.setAttribute("NWriteResult", dao.writeNotice(dto));
	}

}
