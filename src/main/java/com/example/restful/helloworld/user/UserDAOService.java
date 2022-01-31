package com.example.restful.helloworld.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDAOService {

    private static int userCount = 3;

    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1,"taii",new Date(),"test1","800111-2211222"));
        users.add(new User(2,"taiwon",new Date(),"test2","810111-2211222"));
        users.add(new User(3,"nayul",new Date(),"test3","820111-2211222"));
    }

    public List<User> findAll () {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for(User user:users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    public User updateUser(int id, User user) {

        for (User updateUser : users) {
            if (updateUser.getId() == id) {
                updateUser.setName(user.getName());
                updateUser.setJoinDate(user.getJoinDate());

                return updateUser;
            }
        }

        return null;
    }
}
