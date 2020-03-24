package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.EventDao;

public class EventCustomerPalyResultService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("cid");
		int no1 = Integer.parseInt(request.getParameter("no1"));
		int no2 = Integer.parseInt(request.getParameter("no2"));
		int no3 = Integer.parseInt(request.getParameter("no3"));
		int no4 = Integer.parseInt(request.getParameter("no4"));
		int no5 = Integer.parseInt(request.getParameter("no5"));
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		int su3 = Integer.parseInt(request.getParameter("su3"));
		int su4 = Integer.parseInt(request.getParameter("su4"));
		int su5 = Integer.parseInt(request.getParameter("su5"));
		if(no1==su1 && no2==su2 && no3==su3 && no4==su4 && no5==su5) {
			EventDao dao = EventDao.getInstance();
			dao.ChanceResult(cid);
			request.setAttribute("eventResult", "축하합니다 이벤트에 당첨되셨습니다");
		}else {
			request.setAttribute("eventResult", "아쉽지만 실패하셨습니다");
			request.setAttribute("no1", no1);
			request.setAttribute("no2", no2);
			request.setAttribute("no3", no3);
			request.setAttribute("no4", no4);
			request.setAttribute("no5", no5);
		}
	}

}
