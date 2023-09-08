package com.spring.db.demo.jdbc;

import com.spring.db.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll(){
        return jdbcTemplate.query("Select * From Person", new BeanPropertyRowMapper<>(Person.class));
    }
    public Person findById(int id){
        return jdbcTemplate.queryForObject("Select * From Person where id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
    }
    public int deleteById(int id){
        return jdbcTemplate.update("Delete From Person where id=?",
                new Object[]{id});
    }

    public int insert(Person person){
        return jdbcTemplate.update("Insert into Person (id, name, location, birth_date)" + "values(?,?,?,?)",
                new Object[]{person.getId(),person.getName(), person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime())});
    }
    public int update(Person person){
        return jdbcTemplate.update("Update Person " +
                        " set name = ?, location = ?, birth_date = ? " +
                        " where id = ? ",
                new Object[]{person.getName(), person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime()),person.getId()});
    }
}
