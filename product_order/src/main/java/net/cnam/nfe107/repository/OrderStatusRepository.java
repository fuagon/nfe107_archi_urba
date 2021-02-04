package net.cnam.nfe107.repository;

/*
 * @created 27/11/2020/11/2020 - 17:56
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.repository.model.OrderStatusModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatusModel, Long> {
}
