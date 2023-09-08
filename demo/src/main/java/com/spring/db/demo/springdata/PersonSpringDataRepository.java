package com.spring.db.demo.springdata;

import com.spring.db.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {

}
