package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.BoardDao;
import com.tj.ex.dto.BoardDto;

public class BModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		BoardDto dto = new BoardDto();
		dto.setBid(bid);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		BoardDao dao = BoardDao.getInstance();
		dao.modifyBoard(dto);
	}

}
