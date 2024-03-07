package com.examplepointofsale.possystem.repo;

import com.examplepointofsale.possystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    public List<Customer>findAllByActiveEquals(boolean statue);

}
