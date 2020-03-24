package com.tj.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.service.BContentViewService;
import com.tj.ex.service.BDeleteService;
import com.tj.ex.service.BListService;
import com.tj.ex.service.BModifyService;
import com.tj.ex.service.BModifyViewService;
import com.tj.ex.service.BReplyService;
import com.tj.ex.service.BReplyVeiwService;
import com.tj.ex.service.BWriteService;
import com.tj.ex.service.CDeleteService;
import com.tj.ex.service.CJoinService;
import com.tj.ex.service.CLoginService;
import com.tj.ex.service.CLogoutService;
import com.tj.ex.service.CidConfirmService;
import com.tj.ex.service.CmodifyConfirmService;
import com.tj.ex.service.CmodifyService;
import com.tj.ex.service.EventCreateNumberService;
import com.tj.ex.service.EventCustomerPalyResultService;
import com.tj.ex.service.EventCustomerViewService;
import com.tj.ex.service.EventMasterViewService;
import com.tj.ex.service.EventResultView;
import com.tj.ex.service.MLoginService;
import com.tj.ex.service.MLogoutService;
import com.tj.ex.service.NContentService;
import com.tj.ex.service.NListService;
import com.tj.ex.service.NWriteService;
import com.tj.ex.service.NdeleteService;
import com.tj.ex.service.ProductAllViewService;
import com.tj.ex.service.ProductDeleteService;
import com.tj.ex.service.ProductDteilService;
import com.tj.ex.service.ProductInsertService;
import com.tj.ex.service.ProductModifyVeiwService;
import com.tj.ex.service.ProductUpdateService;
import com.tj.ex.service.Service;

@WebServlet("*.do")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI(); 
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		Service service = null;
		String viewPage = null;
		//메인이동
		if(command.equals("/main.do")) {
			viewPage = "main/main.jsp";
		
			
			//관리자(master) 로그인 로그아웃
		}else if(command.equals("/mlogin_view.do")) {
			viewPage = "master/mlogin_view.jsp";
		}else if(command.equals("/mloginconfirm.do")) {
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(command.equals("/mlogout.do")) {
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		
			
			//회원 로그인, 로그아웃, 회원가입, 정보수정
		}else if(command.equals("/clogin_view.do")) {
			viewPage = "customer/clogin_view.jsp";
		}else if(command.equals("/cloginconfirm.do")) {
			service = new CLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(command.equals("/clogout.do")) {
			service = new CLogoutService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(command.equals("/cjoin_view.do")) {
			viewPage ="customer/cjoin_view.jsp";
		}else if(command.equals("/cidConfirm.do")) {
			service = new CidConfirmService();
			service.execute(request, response);
			viewPage = "customer/cidConfirm.jsp";
		}else if(command.equals("/cjoin.do")) {
			service = new CJoinService();
			service.execute(request, response);
			viewPage = "customer/clogin_view.jsp";
		}else if(command.equals("/cmodify_view.do")) {
			viewPage = "customer/cmodify_view.jsp";
		}else if(command.equals("/cmodifyConfirm.do")) {
			service = new CmodifyConfirmService();
			service.execute(request, response);
			viewPage = "customer/cmodifyConfirm.jsp";
		}else if(command.equals("/cmodify.do")) {
			service = new CmodifyService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(command.equals("/customerOut.do")) {
			service = new CDeleteService();
			service.execute(request, response);
			viewPage = "main.do";
		
			
			//공지사항 Notice
		}else if(command.equals("/notice_view.do")) {
			service = new NListService();
			service.execute(request, response);
			viewPage = "notice/notice_view.jsp";
		}else if(command.equals("/noticeWrite_view.do")) {
			viewPage = "/notice/noticeWrite_view.jsp";
		}else if(command.equals("/noticeWrite.do")) {
			service = new NWriteService();
			service.execute(request, response);
			viewPage = "notice_view.do";
		}else if(command.equals("/noticeContent_view.do")) {
			service = new NContentService();
			service.execute(request, response);
			viewPage = "notice/noticeContent_view.jsp";
		}else if(command.equals("/deleteNotice.do")) {
			service = new NdeleteService();
			service.execute(request, response);
			viewPage = "notice_view.do";
			
			//답변글 게시판 board
		}else if(command.equals("/board_view.do")) {
			service = new BListService();
			service.execute(request, response);
			viewPage = "board/board_view.jsp";
		}else if(command.equals("/boardcontent_view.do")) {
			service = new BContentViewService();
			service.execute(request, response);
			viewPage = "board/boardcontent_view.jsp";
		}else if(command.equals("/boardwrite_view.do")) {
			viewPage = "board/boardwrite_view.jsp";
		}else if(command.equals("/boardwrite.do")){
			service = new BWriteService();
			service.execute(request, response);
			viewPage = "board_view.do";
		}else if(command.equals("/boardmodify_view.do")) {
			service = new BModifyViewService();
			service.execute(request, response);
			viewPage = "board/boardmodify_view.jsp";
		}else if(command.equals("/boardmodify.do")) {
			service = new BModifyService();
			service.execute(request, response);
			viewPage = "board_view.do";
		}else if(command.equals("/boardreply_view.do")) {
			service = new BReplyVeiwService();
			service.execute(request, response);
			viewPage = "board/boardreply_view.jsp";
		}else if(command.equals("/boardreply.do")) {
			service = new BReplyService();
			service.execute(request, response);
			viewPage = "board_view.do";
		}else if(command.equals("/boarddelete.do")) {
			service = new BDeleteService();
			service.execute(request, response);
			viewPage = "board_view.do";
			
			//이벤트 Event
		}else if(command.equals("/event_master_view.do")) {
			service = new EventMasterViewService();
			service.execute(request, response);
			viewPage = "event/event_master_view.jsp";
		}else if(command.equals("/eventMasterCreateNumber.do")) {
			service = new EventCreateNumberService();
			service.execute(request, response);
			viewPage = "event_master_view.do";
		}else if(command.equals("/eventChkResult.do")) {
			service = new EventResultView();
			service.execute(request, response);
			viewPage = "event_master_view.do";
		}else if(command.equals("/event_customer_view.do")) {
			service = new EventCustomerViewService();
			service.execute(request, response);
			viewPage = "event/event_customer_view.jsp";
		}else if(command.equals("/eventCutomerPlaying.do")) {
			service = new EventCustomerPalyResultService();
			service.execute(request, response);
			viewPage = "event_customer_view.do";
			
			//상품 Product
		}else if(command.equals("/productbrand_view.do")) {
			service = new ProductAllViewService();
			service.execute(request, response);
			viewPage = "product/productbrand_view.jsp";
		}else if(command.equals("/insertproduct_view.do")) {
			viewPage = "product/insertproduct_view.jsp";
		}else if(command.equals("/insertProduct.do")) {
			service = new ProductInsertService();
			service.execute(request, response);
			viewPage = "productbrand_view.do";
		}else if(command.equals("/productditeil_view.do")) {
			service = new ProductDteilService();
			service.execute(request, response);
			viewPage = "product/productdetil_view.jsp";
		}else if(command.equals("/deleteproduct.do")) {
			service = new ProductDeleteService();
			service.execute(request, response);
			viewPage = "productbrand_view.do";
		}else if(command.equals("/modifyproduct_view.do")) {
			service = new ProductModifyVeiwService();
			service.execute(request, response);
			viewPage = "product/modifyproduct_view.jsp";
		}else if(command.equals("/UpdateProduct.do")) {
			service = new ProductUpdateService();
			service.execute(request, response);
			viewPage = "productbrand_view.do";
		}else if(command.equals("/company_view.do")) {
			viewPage = "company/company_view.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
