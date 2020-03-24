package com.tj.ex.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.NoticeDao;
import com.tj.ex.dto.NoticeDto;

public class NListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		NoticeDao dao = NoticeDao.getInstance();
		ArrayList<NoticeDto> dtos = dao.allgetNotice();
		request.setAttribute("notice", dtos);
	}

}
