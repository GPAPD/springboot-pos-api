package com.examplepointofsale.possystem.repo;

import com.examplepointofsale.possystem.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {

    List<Item> getAllByItemNameEqualsAndActiveStateEquals(String itemName, boolean activeStates);

    Page<Item> getAllByActiveStateEquals(boolean activeStatues, Pageable pageable);

    int countAllByActiveStateEquals(boolean activeStatues, PageRequest of);
}
