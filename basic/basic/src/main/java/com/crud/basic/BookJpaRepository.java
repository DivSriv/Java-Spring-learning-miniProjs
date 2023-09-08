package com.crud.basic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book,Integer> {
}
