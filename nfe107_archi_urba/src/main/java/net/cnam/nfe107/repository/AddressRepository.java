package net.cnam.nfe107.repository;

import net.cnam.nfe107.repository.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository <AddressModel, Long> {
}
