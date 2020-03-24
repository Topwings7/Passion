package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.BoardDao;
import com.tj.ex.dto.BoardDto;

public class BReplyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("cid");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		int bgroup = Integer.parseInt(request.getParameter("bgroup"));
		int bstep = Integer.parseInt(request.getParameter("bstep"));
		int bindent = Integer.parseInt(request.getParameter("bindent"));
		String bip = request.getRemoteAddr();
		BoardDao dao = BoardDao.getInstance();
		BoardDto dto = new BoardDto();
		dto.setCid(cid);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		dto.setBgroup(bgroup);
		dto.setBstep(bstep);
		dto.setBindent(bindent);
		dto.setBip(bip);
		dao.replyWriteBoard(dto);
	}

}
