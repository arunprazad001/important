package com.service;
import java.util.List;

import com.exceptions.BookException;
import com.model.*;
public interface BookManager {
  public List<Book> getAllBooks()throws BookException;
  public Book getBookById(int id)throws BookException;
  public String AddBook(Book b)throws BookException;
  public String DeleteBook(int id)throws BookException;
  public Book UpdateBook(Book b)throws BookException;
}
