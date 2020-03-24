package com.tj.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tj.ex.dao.ProductDao;
import com.tj.ex.dto.ProductDto;

public class ProductInsertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("productImg");
		int maxSize= 1024*1024*10;
		String[] image = {"","","",""};
		MultipartRequest mrt = null;
		try {
			mrt = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mrt.getFileNames();
			int idx = 0;
			while(params.hasMoreElements()) {
				String param = params.nextElement();
				image[idx] = mrt.getFilesystemName(param);
				idx++;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		for(String imgfile : image) {
			if(imgfile!=null) {
				InputStream is = null;
				OutputStream os = null;
				File serverFile = new File(path+"/"+imgfile);
				if(serverFile.exists()) {
					try {
						is = new FileInputStream(serverFile);
						os = new FileOutputStream("D:/mega_IT/source/8_project/lastpassion/WebContent/productImg/"+imgfile);
						byte[] bs = new byte[(int)serverFile.length()];
						while(true){
							int readbyteCnt = is.read(bs);
							if(readbyteCnt==-1) break;
							os.write(bs, 0, readbyteCnt);
						}
					}catch(Exception e){
						System.out.println(e.getMessage());
					}finally{
							try {
								if(os!=null) os.close();
								if(is!=null) is.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
					}
				}
			}
		}
		String pcode = mrt.getParameter("pcode");
		String pbrand = mrt.getParameter("pbrand");
		String pname = mrt.getParameter("pname");
		String pimg1 = image[0]==null? "NOIMG.PNG": image[0];
		String pimg2 = image[1]==null? "NOIMG.PNG": image[1];
		String pimg3 = image[2]==null? "NOIMG.PNG": image[2];
		String pimg4 = image[3]==null? "NOIMG.PNG": image[3];
		String pinfo = mrt.getParameter("pinfo");
		ProductDao dao = ProductDao.getInstance();
		ProductDto dto = new ProductDto(pcode, pbrand, pname, pimg1, pimg2, pimg3, pimg4, pinfo);
		dao.insertProduct(dto);
	}
}
