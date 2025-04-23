package edu.miu.cs.cs489appsd.lab7.repository;

import edu.miu.cs.cs489appsd.lab7.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByUnitNo(String unitNo);
}
