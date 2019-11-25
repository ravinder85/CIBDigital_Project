package za.com.absa.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.com.absa.assignment.entity.PhoneBook;
import za.com.absa.assignment.entity.PhoneNumbers;
import za.com.absa.assignment.service.PhoneBookService;
import za.com.absa.assignment.service.PhoneNumbersService;


@RestController
public class PhoneBookController {
	
	 @Autowired
	 PhoneBookService authorService;

	    @Autowired
	    PhoneNumbersService bookService;

	  


	    @RequestMapping(value = "/getAllPhoneBooks", method = RequestMethod.GET)
	    public List<PhoneBook> getAuthors() {
	        return authorService.getAuthors();
	    }

	    //
	    @RequestMapping(value = "/addphonebook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public PhoneBook createAuthor(@RequestBody PhoneBook phoneBook) {
	        return authorService.createAuthor(phoneBook);
	    }

	 


	    @RequestMapping(value = "/phoneBook/{authorId}", method = RequestMethod.GET)
	    public Optional<PhoneBook> getAuthorById(@PathVariable(value = "authorId") Long authorId) {
	        return authorService.getAuthorById(authorId);
	    }

	    @RequestMapping(value = "/updatephoneBook", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public PhoneBook updateAuthor(@PathVariable(value = "authorId") Long authorId, @RequestBody PhoneBook author) {
	        return authorService.updateAuthorById(authorId, author);
	    }

	    @RequestMapping(value = "/phoneBook/{authorId}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> deleteAuthorById(@PathVariable(value = "authorId") long authorId) {
	        return authorService.deleteAuthorById(authorId);
	    }

	    @RequestMapping(value = "/getAllphoneNumbers", method = RequestMethod.GET)
	    public List<PhoneNumbers> getBooks() {
	        return bookService.getAllBooks();
	    }


	    //
	    @RequestMapping(value = "/{authorId}/phoneNumbers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public PhoneNumbers createBook(@PathVariable(value = "authorId") Long authorId, @RequestBody PhoneNumbers book) {
	        return bookService.createBook(authorId, book);
	    }

	    @RequestMapping(value = "/phoneNumbers/{bookId}", method = RequestMethod.GET)
	    public Optional<PhoneNumbers> getBookById(@PathVariable(value = "bookId") Long bookId) {
	        return bookService.getBookById(bookId);
	    }


	    @RequestMapping(value = "/phoneNumbers", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public PhoneNumbers updateBook(@PathVariable(value = "bookId") Long bookId, @RequestBody PhoneNumbers book) {
	        return bookService.updateBookById(bookId, book);
	    }

	    @RequestMapping(value = "/phoneNumbers/{bookId}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> deleteBookById(@PathVariable(value = "bookId") long bookId) {
	        return bookService.deleteBookById(bookId);
	    }


	  

}


