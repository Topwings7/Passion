package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.ProductDao;

public class ProductModifyVeiwService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pcode = request.getParameter("pcode");
		ProductDao dao = ProductDao.getInstance();
		request.setAttribute("dto", dao.getDetileProduct(pcode));
	}

}
