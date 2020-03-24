package com.tj.ex.service;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.EventDao;
import com.tj.ex.dto.EventDto;

public class EventCreateNumberService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		TreeSet<Integer> chancenum = new TreeSet<Integer>();
		Random random = new Random();
		int no1=0, no2=0, no3=0, no4=0, no5=0;
		while(chancenum.size()<5) {
			chancenum.add(random.nextInt(99)+1);
		}
		Iterator<Integer> key = chancenum.iterator();
		while(key.hasNext()) {
			no1=key.next();
			no2=key.next();
			no3=key.next();
			no4=key.next();
			no5=key.next();
		}
		EventDto dto = new EventDto();
		dto.setNo1(no1);
		dto.setNo2(no2);
		dto.setNo3(no3);
		dto.setNo4(no4);
		dto.setNo5(no5);
		EventDao dao = EventDao.getInstance();
		dao.insertnumber(dto);
	}

}
