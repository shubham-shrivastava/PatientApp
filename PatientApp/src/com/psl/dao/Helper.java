package com.psl.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;


import com.psl.controller.HibernateUtil;
import com.psl.model.Facility;
import com.psl.model.UserBean;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class Helper {
	private static UserBean bean = null;
	private static Session session = null;
	public static UserBean login(UserBean userBean){
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<UserBean> list = session.createQuery("From user_table").list();	
		session.getTransaction().commit();
		session.close();
		Iterator<UserBean> iterator  =list.iterator();
		while(iterator.hasNext()){
			bean = (UserBean)iterator.next();
			System.out.println("Email: "+userBean.getEmail());
			if(userBean.getEmail().equals(bean.getEmail()) && userBean.getPassword().equals(bean.getPassword())){
				System.out.println(bean.getFirstName());
				bean.setValid(true);
				break;
			}
			else{
				bean.setValid(false);
			}
		}
		return bean;
	}
	
	
	public static List<UserBean> displayUser(){
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<UserBean> users = session.createQuery("from user_table").list();
		session.getTransaction().commit();
		session.close();
		return users;
	}
	
	public static List<Facility> displayFacility(){
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Facility> facility = session.createQuery("from facility").list();
		session.getTransaction().commit();
		session.close();
		return facility;
	}

	
	public static void saveData(Object object) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		if(object instanceof UserBean){
			session.saveOrUpdate((UserBean)object);
		}
		else if(object instanceof Facility){
			session.saveOrUpdate((Facility)object);
		}
		
		session.getTransaction().commit();
		session.close();
		
	}
	public static void update(String[] arr){
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for(String str: arr){
			if(str!=null)
			{
				String a[]=str.split(" ");
				System.out.println(a[0]+" "+a[1]);
				String hql = "from user_table where id="+a[0];
				org.hibernate.Query query = session.createQuery(hql);
				//uery.setParameter("id", Integer.getInteger(a[0]));
				@SuppressWarnings("unchecked")
				
				List<UserBean> beans = (List<UserBean>)query.list();
				// UserBean bean = (UserBean) query.getSingleResult();
				for(UserBean userBean : beans){
					userBean.setStatus(a[1]);
					//session.saveOrUpdate(userBean);
				}
				
				
			}
		}
		session.getTransaction().commit();
		session.close();
	}
}
