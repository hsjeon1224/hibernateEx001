package com.usrsmile.hibernate;

import java.util.List;

import com.usrsmile.hibernate.dao.BookService;
import com.usrsmile.hibernate.model.Book;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        BookService bookService = new BookService();
        
        System.out.println("-------------Insert------------");
        
        bookService.persist(new Book("1", "good Hibernate", "usrsmile"));
        bookService.persist(new Book("2", "good Hibernate", "usrsmile"));
        
        
        System.out.println("-------------//Insert------------");
        
        
        System.out.println("-------------List------------");
        
        List<Book> books = bookService.findAll();
        
        for (Book b : books) {
        	System.out.println(b.toString());
		}
        
        System.out.println("-------------//List------------");
        
        
        
    }
}
