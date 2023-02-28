package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repo.BookRepo;
import com.exceptions.BookException;
import com.model.Book;

@Service
public class BookManagerImpl implements BookManager {

	@Autowired
	BookRepo bRepo;
	
	@Override
	public List<Book> getAllBooks()throws BookException {
		List<Book>books=bRepo.findAll();
		if(books.size()!=0) {
			return books;
		}else {
			throw new BookException("No books found");
		}
	}

	@Override
	public Book getBookById(int id)throws BookException {
		Optional<Book>opt= bRepo.findById(id);
		if(opt.isPresent()) {
			Book b=opt.get();
			return b;
		}else {
			throw new BookException("No book found");
		}
		
	}

	@Override
	public String AddBook(Book b)throws BookException {
		Book b1=bRepo.save(b);
		if(b1!=null) {
			return "Book Added";
		}else {
			throw new BookException("Invalid details , Book not added");
		}
	}

	@Override
	public String DeleteBook(int id)throws BookException {
		Optional<Book> opt=bRepo.findById(id);
		if(opt.isPresent()) {
			Book b=opt.get();
			bRepo.delete(b);
			return "Book Deleted";
		}else {
			throw new BookException("No book found");
		}
	}

	@Override
	public Book UpdateBook(Book b)throws BookException {
		Optional<Book>opt=bRepo.findById(b.getBookId());
		if(opt.isPresent()) {
			Book newbook=opt.get();
			Book b2=bRepo.save(newbook);
			return b2;
		}else {
			throw new BookException("No book found");
		}
	}

}
