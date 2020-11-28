package net.cnam.nfe107.repository;

/*
 * @created 29/10/2020/10/2020 - 10:40
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.repository.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
}
