package com.examplepointofsale.possystem.repo;

import com.examplepointofsale.possystem.dto.customquarydata.OrderDetailInterface;
import com.examplepointofsale.possystem.entity.Orders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Orders,Integer> {

    @Query(value = "select c.customer_name as customerName, c.customer_address as customerAddress, c.contact_numbers as customerNumber, o.order_date as date , o.total as total from orders o inner join  customer c on c.customer_id = o.customer_id",nativeQuery = true)
    List<OrderDetailInterface> getAllOrderDetails(Pageable pageable);


}
