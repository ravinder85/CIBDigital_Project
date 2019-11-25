package za.com.absa.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import za.com.absa.assignment.entity.PhoneBook;
import za.com.absa.assignment.exception.ResourceNotFoundException;
import za.com.absa.assignment.repository.PhoneBookRepository;
import za.com.absa.assignment.repository.PhoneNumbersRepository;

@Service
public class PhoneBookService {

	@Autowired
	private PhoneBookRepository phoneBookRepository;
     
	

	    public List<PhoneBook> getAuthors() {
	        return phoneBookRepository.findAll();
	    }


	    public Optional<PhoneBook> getAuthorById(Long phoneBookId) {
	        if (!phoneBookRepository.existsById(phoneBookId)) {
	            throw new ResourceNotFoundException("Author with id " + phoneBookId + " not found");
	        }
	        return phoneBookRepository.findById(phoneBookId);
	    }


	    public PhoneBook createAuthor(PhoneBook phoneBook) {
	        return phoneBookRepository.save(phoneBook);

	    }

	    public PhoneBook updateAuthorById(Long phoneBookId, PhoneBook phoneBookRequest) {
	        if (!phoneBookRepository.existsById(phoneBookId)) {
	           // throw new ResourceNotFoundException("Author with id " + authorId + " not found");
	        }
	        Optional<PhoneBook> phoneBook = phoneBookRepository.findById(phoneBookId);

	        if (!phoneBook.isPresent()) {
	            throw new ResourceNotFoundException("Author with id " + phoneBookId + " not found");
	        }

	        PhoneBook phoneBook1 = phoneBook.get();
	        phoneBook1.setFirstName(phoneBookRequest.getFirstName());
	        phoneBook1.setLastName(phoneBookRequest.getLastName());
	        return phoneBookRepository.save(phoneBook1);

	    }

	    public ResponseEntity<Object> deleteAuthorById(long phoneBookId) {
	        if (!phoneBookRepository.existsById(phoneBookId)) {
	            throw new ResourceNotFoundException("Author with id " + phoneBookId + " not found");
	        }

	        phoneBookRepository.deleteById(phoneBookId);

	        return ResponseEntity.ok().build();

	    }




	}
