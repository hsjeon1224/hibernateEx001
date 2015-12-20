package com.usrsmile.hibernate.dao;

import java.util.List;

import com.usrsmile.hibernate.model.Book;

public class BookService 
{
	private static BookDao bookDao;
	public BookService()
	{
		bookDao = new BookDao();
	}
	
	public void persist(Book entity)
	{
		bookDao.openCurrentSessionWithTransaction();
		bookDao.persist(entity);
		bookDao.closeCurrentSessionwithTransaction();
	}
	
	public void update(Book entity)
	{
		bookDao.openCurrentSessionWithTransaction();
		bookDao.update(entity);
		bookDao.closeCurrentSessionwithTransaction();
	}
	
	public Book findById(String id)
	{
		bookDao.openCurrentSession();
		Book book = bookDao.fineById(id);
		bookDao.closeCurrentSession();
		return book;
	}
	
	public void delete(String id)
	{
		bookDao.openCurrentSessionWithTransaction();
		Book book = bookDao.fineById(id);
		bookDao.delete(book);
		bookDao.closeCurrentSessionwithTransaction();
	}
	
	public List<Book> findAll()
	{
		bookDao.openCurrentSession();
		List<Book> books = bookDao.findAll();
		bookDao.closeCurrentSession();
		return books;
	}
	
	public void deleteAll()
	{
		bookDao.openCurrentSessionWithTransaction();
		bookDao.deleteAll();
		bookDao.closeCurrentSessionwithTransaction();
	}
}
