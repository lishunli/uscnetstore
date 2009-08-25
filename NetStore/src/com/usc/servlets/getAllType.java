package com.usc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.usc.daos.Producttype;
import com.usc.daos.ProducttypeDAO;

public class getAllType extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ServletContext servletContext = request.getSession()
				.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		ProducttypeDAO pTypeDao = (ProducttypeDAO) ctx
				.getBean("ProducttypeDAO");

		try
		{

			request.setCharacterEncoding("utf-8");
			String idStr = request.getParameter("parent_id");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();

			// 1.È¡²ÎÊý
			String SFTypeID = request.getParameter("FTypeID");
			if("".equals(SFTypeID))
				SFTypeID = "0";
			else
				SFTypeID = URLDecoder.decode(SFTypeID, "UTF-8");
			int FTypeID = 0;
			try
			{
				FTypeID = Integer.parseInt(SFTypeID);
			} catch (Exception e)
			{
			}
			StringBuffer allTypes = new StringBuffer();
			response.setContentType("text/xml");
			allTypes.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			allTypes.append("<allTypes>");

			if(!pTypeDao.findByFartherTypeId(FTypeID).isEmpty())
			{
				for(Producttype pT : pTypeDao.findByFartherTypeId(FTypeID))
				{
					allTypes.append("<Type>");
					allTypes.append("<TypeID>" + pT.getProductTypeId() + "</TypeID>");
					allTypes.append("<TypeName>" + pT.getProductTypeName() + "</TypeName>");
					allTypes.append("<TypeFID>" + pT.getFartherTypeId() + "</TypeFID>");
					allTypes.append("</Type>");
				}
			}
			allTypes.append("</allTypes>");
			out.print(allTypes.toString());
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}

}
