package com.psl.model;

import java.util.List;

import org.hibernate.Session;

import com.psl.controller.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		UserBean userBean = (UserBean) session.load(UserBean.class, 8);
		userBean.setRole("Admin");
		userBean.setStatus("Deactive");
		session.getTransaction().commit();
		session.close();
	}
}
