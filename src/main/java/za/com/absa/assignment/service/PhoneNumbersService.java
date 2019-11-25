package za.com.absa.assignment.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import za.com.absa.assignment.entity.PhoneBook;
import za.com.absa.assignment.entity.PhoneNumbers;
import za.com.absa.assignment.exception.ResourceNotFoundException;
import za.com.absa.assignment.repository.PhoneBookRepository;
import za.com.absa.assignment.repository.PhoneNumbersRepository;

@Service
public class PhoneNumbersService {

	  @Autowired
	  PhoneNumbersRepository phoneNumbersRepository;

	    @Autowired
	    PhoneBookRepository phoneBookRepository;

	    public List<PhoneNumbers> getAllBooks() {
	        return phoneNumbersRepository.findAll();
	    }


	    public Optional<PhoneNumbers> getBookById(Long phoneNumberId) {
	        if (!phoneNumbersRepository.existsById(phoneNumberId)) {
	            throw new ResourceNotFoundException("Book with id " + phoneNumberId + " not found");
	        }
	        return phoneNumbersRepository.findById(phoneNumberId);
	    }


	    public PhoneNumbers createBook(Long phonephoneNumberId, PhoneNumbers phoneNumbers) {
	        Set<PhoneNumbers> phoneNumbers2 = new HashSet<>();
	        PhoneBook phoneBook1 = new PhoneBook();

	        Optional<PhoneBook> byId = phoneBookRepository.findById(phonephoneNumberId);
	        if (!byId.isPresent()) {
	            throw new ResourceNotFoundException("Author with id " + phonephoneNumberId + " does not exist");
	        }
	        PhoneBook phoneBook= byId.get();

	        //tie Author to Book
	        phoneNumbers.setPhoneBook(phoneBook);

	        PhoneNumbers phoneNumbers1 = phoneNumbersRepository.save(phoneNumbers);
	        //tie Book to Author
	        phoneNumbers2.add(phoneNumbers1);
	        phoneBook.setPhoneNumbers(phoneNumbers2);

	        return phoneNumbers1;

	    }

	    public PhoneNumbers updateBookById(Long phoneNumberId, PhoneNumbers bookRequest) {
	        if (!phoneNumbersRepository.existsById(phoneNumberId)) {
	            throw new ResourceNotFoundException("Book with id " + phoneNumberId + " not found");
	        }
	        Optional<PhoneNumbers> book = phoneNumbersRepository.findById(phoneNumberId);

	        if (!book.isPresent()) {
	            throw new ResourceNotFoundException("Book with id " + phoneNumberId + " not found");
	        }

	        PhoneNumbers book1 = book.get();
	        book1.setPhoneNumber(bookRequest.getPhoneNumber());
	      

	        return phoneNumbersRepository.save(book1);
	    }

	    public ResponseEntity<Object> deleteBookById(long phoneNumberId) {
	        if (!phoneNumbersRepository.existsById(phoneNumberId)) {
	            throw new ResourceNotFoundException("Book with id " + phoneNumberId + " not found");
	        }

	        phoneNumbersRepository.deleteById(phoneNumberId);

	        return ResponseEntity.ok().build();

	    }
	}
