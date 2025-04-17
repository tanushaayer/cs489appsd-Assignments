package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.repository;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByUnitNo(String unitNo);
}
