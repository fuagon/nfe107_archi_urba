package net.cnam.nfe107.repository;

/*
 * @created 29/10/2020/10/2020 - 10:40
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.repository.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
}
