package za.com.absa.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.com.absa.assignment.entity.PhoneNumbers;

public interface PhoneNumbersRepository extends JpaRepository<PhoneNumbers, Long> {

}
