package net.cnam.nfe107.repository;

import net.cnam.nfe107.repository.model.AddressModel;
import net.cnam.nfe107.repository.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <CustomerModel, Long> {
}
