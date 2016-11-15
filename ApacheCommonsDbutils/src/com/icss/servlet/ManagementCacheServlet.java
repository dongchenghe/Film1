package com.icss.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.cache.ManagementCache;
import com.icss.dao.ManagementDao;
import com.icss.modal.User;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class ManagementCacheServlet
 */
@WebServlet(loadOnStartup=1,urlPatterns={"/managementCacheServlet"})
public class ManagementCacheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
public void init(ServletConfig config) throws ServletException {
	ManagementDao ud=new ManagementDao();   
	ManagementCache.MANAGEMENT.put("management", ud.findAllUser());
	ManagementCache.MANAGEMENT.put("roleId2", ud.getRoleTwoShow(2));
	ManagementCache.MANAGEMENT.put("roleId3", ud.getRoleTwoShow(3));
}
   
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/json;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	HttpSession session =((HttpServletRequest)request).getSession();
    	User user=(User) session.getAttribute("user");
    	
    	 String json="";
    	if(user!=null){
    	if(user.getRole_id()==1){
    		//1为超级管理员
    		  json=	JSONArray.fromObject(ManagementCache.MANAGEMENT.get("management")).toString();
    	}else if(user.getRole_id()==2){
    		 json=	JSONArray.fromObject(ManagementCache.MANAGEMENT.get("roleId2")).toString();
    	}else if(user.getRole_id()==3){
    		 json=	JSONArray.fromObject(ManagementCache.MANAGEMENT.get("roleId3")).toString();
    	}else{
    		//无权限 登入时需过滤掉  role_id==4
    	}
    	}
	    out.println(json);
	    out.flush();
	    out.close();
    }
   

}
