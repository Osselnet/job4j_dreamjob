package ru.job4j.dreamjob.service;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.User;
import ru.job4j.dreamjob.store.UserDBStore;

import java.util.Optional;

@ThreadSafe
@Service
public class UserService {
    @GuardedBy("this")
    private final UserDBStore userStore;

    public UserService(UserDBStore userStore) {
        this.userStore = userStore;
    }

    public Optional<User> add(User user) {
        return userStore.add(user);
    }

    public Optional<User> findUserByNameAndPwd(String name, String password) {
        return userStore.findUserByNameAndPwd(name, password);
    }
 }
