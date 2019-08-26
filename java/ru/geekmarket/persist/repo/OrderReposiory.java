package com.geekbrains.spring2.persist.repo;

import com.geekbrains.spring2.persist.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReposiory extends JpaRepository<Order, Long> {
}
