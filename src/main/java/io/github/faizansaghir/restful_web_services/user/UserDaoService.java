package io.github.faizansaghir.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User(1, "Jack", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Jill", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Adam", LocalDate.now().minusYears(15)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }
}
