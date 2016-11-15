package com.icss.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dao.ManagementDao;
import com.icss.modal.User;

/**
 * Servlet implementation class RegesterServlet
 */
@WebServlet("/RegesterServlet")
public class RegesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegesterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		ManagementDao md=new ManagementDao ();
		User user=	md.checkUser(name, pwd);		
		if(user==null){
			out.println("{\"msg\":\"密码或账户错误\"}");	
			out.flush();	
		}else if(user.getRole_id()==4){
			out.println("{\"msg\":\"您没有权限！\"}");	
			out.flush();
		}else{
			out.println("{\"msg\":\"success\"}");
			out.flush();
			request.getSession().setAttribute("user", user);
		}
		
		
		
	/*	Map map=request.getParameterMap();
		//System.out.println(map.size());
		Iterator it=map.keySet().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
