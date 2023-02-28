package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exceptions.BookException;
import com.model.Book;
import com.service.BookManager;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/bookservice")
public class BookController {

	@Autowired
	BookManager bM;
	
	@PostMapping("/book")
	public ResponseEntity<String>AddBookHandler(@RequestBody Book b)throws BookException{
		     String message=bM.AddBook(b);
		     return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book>GetBookByIdHandler(@PathVariable("id") Integer id)throws BookException{
		Book b=bM.getBookById(id);
		return new ResponseEntity<Book>(b,HttpStatus.OK);
	}
	@GetMapping("/books")
	public ResponseEntity<List<Book>>GetAllBooksHandler()throws BookException{
		List<Book>books=bM.getAllBooks();
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<String>DeleteBookHandler(@PathVariable("id") Integer id)throws BookException{
		String message=bM.DeleteBook(id);
		 return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PutMapping("/book")
	public ResponseEntity<Book>UpdateBookHandler(@RequestBody Book b)throws BookException{
		     Book b1=bM.UpdateBook(b);
		     return new ResponseEntity<Book>(b1,HttpStatus.ACCEPTED);
	}
	
	
	
}
