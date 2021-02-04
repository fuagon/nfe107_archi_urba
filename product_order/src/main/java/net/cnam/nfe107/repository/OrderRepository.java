package net.cnam.nfe107.repository;

import net.cnam.nfe107.repository.model.CustomerModel;
import net.cnam.nfe107.repository.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <OrderModel, Long> {
}
