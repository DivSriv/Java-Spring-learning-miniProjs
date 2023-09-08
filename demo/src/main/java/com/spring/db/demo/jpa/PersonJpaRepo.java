package com.spring.db.demo.jpa;

import com.spring.db.demo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonJpaRepo {
    @PersistenceContext
    EntityManager entityManager;
    public Person findById(int id){
        return entityManager.find(Person.class, id);
    }
    public Person update(Person person){
        return entityManager.merge(person);
    }
    public Person insert(Person person){
        return entityManager.merge(person);
    }
    public void deleteById(int id){
        Person person1 = findById(id);
        entityManager.remove(person1);
    }
}
