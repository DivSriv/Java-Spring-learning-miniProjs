package com.div.rest.restful.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Component
public class UserDaoService {


    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static{
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(29)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Devil", LocalDate.now().minusYears(27)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id) {
//        Predicate<? super User> predicate = user -> user.getId().equals(id);
//        return users.stream().filter(predicate).findFirst().get();

        Predicate<? super User> predicate = user -> Objects.equals(user.getId(), id);
        return users.stream().filter(predicate).findFirst().get();
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> Objects.equals(user.getId(), id);
        users.removeIf(predicate);
    }
}
