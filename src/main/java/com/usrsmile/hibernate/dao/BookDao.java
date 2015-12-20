package com.usrsmile.hibernate.dao;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.usrsmile.hibernate.model.Book;

public class BookDao implements BookDaoInterface<Book, String> 
{
	private Session 		mCurrentSession;
	private Transaction 	mCurrentTransaction;
	
	public BookDao()
	{
		
	}
	
	public Session openCurrentSession()
	{
		mCurrentSession = getSessionFactory().openSession();
		return mCurrentSession;
	}
	
	public Session  openCurrentSessionWithTransaction()
	{
		System.out.println("Dao!!");
		mCurrentSession = getSessionFactory().openSession();
		mCurrentTransaction = mCurrentSession.beginTransaction();
        return mCurrentSession;
	}
	
	public void closeCurrentSession()
	{
		mCurrentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction()
	{
		mCurrentTransaction.commit();
		mCurrentSession.close();
	}
	
	private static SessionFactory getSessionFactory()
	{
		
		if(new File("/resources/hibernate.cfg.xml").isFile())
		{
			System.out.println("파일 있음");
		}
		else
		{
			System.out.println("파일 없음");
		}
		
		ClassLoader classLoader = BookDao.class.getClassLoader();
		

		
		Configuration 					configuration 	= new Configuration().configure(classLoader.getResource("hibernate.cfg.xml"));
		StandardServiceRegistryBuilder 	builder 		= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory 					sessionFactory 	= configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public Session getCurrentSession()
	{
		return mCurrentSession;
	}
	
	public void setCurrentSession(Session currentSession)
	{
		this.mCurrentSession = currentSession;
	}
	
	public Transaction getCurrentTransaction()
	{
		return mCurrentTransaction;
	}
	
	public void setCurrentTransaction(Transaction currentTransaction)
	{
		this.mCurrentTransaction = currentTransaction;
	}
	
	public void persist(Book entity) 
	{
		getCurrentSession().save(entity);
	}

	public void update(Book entity) 
	{
		getCurrentSession().update(entity);
	}

	public Book fineById(String id) 
	{
		return (Book)getCurrentSession().get(Book.class, id);
	}

	public void delete(Book entity) 
	{
		getCurrentSession().delete(entity);
	}
	
	public List<Book> findAll() 
	{
		List<Book> books = (List<Book>) getCurrentSession().createQuery("from Book").list();
		return books;
	}

	public void deleteAll() 
	{
		List<Book> entityList = findAll();
		for(Book entity : entityList)
		{
			delete(entity);
		}
	}

}
