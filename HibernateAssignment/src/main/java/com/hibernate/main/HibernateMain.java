package com.hibernate.main;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateAnnotationUtil;
import com.model.Book1;
import com.model.Subject1;

public class HibernateMain {

	public static void main(String[] args) {

		Subject1 subject1 = new Subject1();
		subject1.setTitle("Test_Subject");
		subject1.setDurationInHours(4);
		
		Book1 book1 = new Book1();
		book1.setPrice(567.67);
		book1.setTitle("Test_Book1");
        book1.setVolume(3);
        Date input = new Date();
        LocalDate localDate = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
        book1.setPublishDate(localDate);
        book1.setSubject(subject1);
		
		Book1 book2 = new Book1();
		book2.setPrice(667.67);
		book2.setTitle("Test_Book2");
        book2.setVolume(5);
        Date date1 = new Date();
        LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
        book2.setPublishDate(localDate1);
        book2.setSubject(subject1);

        
        Set<Book1> bookList = new HashSet<Book1>();
        bookList.add(book1);
        bookList.add(book2);
        
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		//Get Session
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		//start transaction
		tx = session.beginTransaction();
		//Save the Model object
		session.save(subject1);
		session.save(book1);
		session.save(book2);
		//Commit transaction
		tx.commit();
		System.out.println("subject1 ID="+subject1.getSubjectId());
		System.out.println("book1 ID="+book1.getBookid()+", Foreign Key Cart ID="+book1.getSubject().getSubjectId());
		System.out.println("book2 ID="+book2.getBookid()+", Foreign Key Cart ID="+book2.getSubject().getSubjectId());
		
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}

}
