package net.cnam.nfe107.repository;

/*
 * @created 28/11/2020/11/2020 - 15:46
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.repository.model.OrderProductIdModel;
import net.cnam.nfe107.repository.model.OrderProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProductModel, OrderProductIdModel> {
}
