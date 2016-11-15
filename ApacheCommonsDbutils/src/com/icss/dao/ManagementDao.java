package com.icss.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.icss.modal.Management;
import com.icss.modal.MenuPermission;
import com.icss.modal.User;
import com.icss.utils.JDBCConnect;


public class ManagementDao {
	
	//超级用户  可以看到所有的信息
	public List<Management> findAllUser(){
		Connection conn=JDBCConnect.getConnect();
		String sql="select * from goods_management where pid = ?";
		ResultSetHandler<List<Management>> h=new BeanListHandler<Management>(Management.class);
		QueryRunner qr=new QueryRunner();	
		try {
			//根目录的pid为 -1
			List<Management> root=	qr.query(conn, sql, h,-1);
		for(int i=0;i<root.size();++i){
			root.get(i).setChildren(qr.query(conn,sql, h,root.get(i).getId()));
			
		}	
			
			
			return root;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	//根据角色  查找展示的信息   存到缓存中，供后面直接使用
	public List<Management> getRoleTwoShow(int roleId){
		Connection conn=JDBCConnect.getConnect();
		String sql="select * from menu_permission where role_id ='"+roleId+"'";
		ResultSetHandler<List<MenuPermission>> h=new BeanListHandler<MenuPermission>(MenuPermission.class);
		QueryRunner qr=new QueryRunner();	
		List<Management> allMenu=findAllUser();
		try {
			List<MenuPermission> roleMenu=	qr.query(conn, sql, h);
	
			//remove后list索引会改变，影响到后面元素的索引，所以从后往前遍历
			boolean flag=true;
			for(int j=allMenu.size()-1;j>-1;--j){
				 flag=true;
				for(int i=0;i<roleMenu.size();++i){	
					if(roleMenu.get(i).getMenu_id().equals(allMenu.get(j).getId()+"")){
						flag=false;		
					}
				}
				if(flag){
					System.out.println(allMenu.get(j).getId()+"被移除了！！！！！！！！！！！！1");
					allMenu.remove(j);
					
				}			
			}	
		
			
			
			return allMenu;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public User checkUser(String name,String pwd){
		Connection conn=JDBCConnect.getConnect();
		String sql="select * from custom where name = '"+name+"'";
		ResultSetHandler<List<User>> h=new BeanListHandler<User>(User.class);
		QueryRunner qr=new QueryRunner();	
		
		
		try {
			List<User> users=	qr.query(conn, sql, h);
		for(int i=0;i<users.size();++i){
			if(pwd.equals(users.get(i).getPwd())){
				return users.get(i);
			}	
		}	
			
			
			return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
}
