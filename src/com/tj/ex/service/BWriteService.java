package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.BoardDao;
import com.tj.ex.dto.BoardDto;

public class BWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("cid");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip = request.getRemoteAddr();
		BoardDto dto = new BoardDto();
		dto.setCid(cid);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		dto.setBip(bip);
		BoardDao dao = BoardDao.getInstance();
		dao.writeBoard(dto);
	}
}
