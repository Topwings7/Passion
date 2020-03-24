package com.tj.ex.service;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.EventDao;

public class EventCustomerViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Random random = new Random();
		EventDao dao = EventDao.getInstance();
		int totCnt = dao.getEventTotCnt();
		int num = random.nextInt(totCnt)+1;
		request.setAttribute("nums", dao.getChanceNumber(num));
	}

}
