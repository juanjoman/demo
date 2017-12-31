/**
 * 
 */
package com.example.demo.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.BookDao;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

/**
 * @author denisputnam
 *
 */
@Service("bookService")
@Transactional(value="transactionManager")
public class BookServiceImpl implements BookService {
	private final Logger log = Logger.getLogger (this.getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private BookDao bookDao;

	/* (non-Javadoc)
	 * @see com.example.demo.service.BookService#getByAuthorName(java.lang.String)
	 */
	@Override
	public List<Book> getByAuthorName(String name) {
		return null;
//		return this.bookDao.getByAuthor(name);
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.BookService#getByTitle(java.lang.String)
	 */
	@Override
	public List<Book> getByTitle(String title) {
		return this.bookDao.getByTitle(title);
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.BookService#create(java.lang.String, java.lang.String)
	 */
	@Override
	public Book create(String title, String author) throws Exception {
		Book book = null;
		try {
			book = new Book();
//			book.setAuthorName(author);
			book.setTitle(title);
			this.bookDao.saveAndFlush(book);
		}catch( Exception e ) {
			log.error("Error creating book: " + e.getMessage());
			throw new Exception(e);
		}

		return book;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.BookService#updateBook(java.lang.Long, java.lang.String, java.lang.String)
	 */
	@Override
	public Book updateBook(Long id, String title, String author) throws Exception {
		Book book = null;
		try{
			book = bookDao.findOne(id);
//			book.setAuthorName(author);
			book.setTitle(title);
			bookDao.saveAndFlush(book);
		}catch( Exception e ){
			log.error("Error updating the book: " + e.getMessage());
			throw new Exception(e);
		}
		return book;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.BookService#delete(java.lang.Long)
	 */
	@Override
	public Book delete(Long id) throws Exception {
		Book book = null;
		try {
			book = bookDao.findOne(id);
			bookDao.delete(book);
		} catch (Exception e) {
			log.error("Error deleting the book: " + e.getMessage());
			throw new Exception(e);
		}
		return book;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.BookService#findAll()
	 */
	@Override
	public List<Book> findAll() {
		return this.bookDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.BookService#findOne(java.lang.Long)
	 */
	@Override
	public Book findOne(Long id) {
		return this.bookDao.findOne(id);
	}

}