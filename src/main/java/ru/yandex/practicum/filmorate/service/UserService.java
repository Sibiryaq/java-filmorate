package ru.yandex.practicum.filmorate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exceptions.EntityNotFoundException;
import ru.yandex.practicum.filmorate.exceptions.ValidatorException;
import ru.yandex.practicum.filmorate.model.User;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.yandex.practicum.filmorate.exceptions.EntityNotFoundException.USER_ALREADY_EXISTS;
import static ru.yandex.practicum.filmorate.exceptions.EntityNotFoundException.USER_NOT_FOUND;

@Service
@Slf4j
public class UserService {
    private final Map<Long, User> users = new HashMap<>();
    private long uniqueID = 0;

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User createUser(User user) {
        if (users.containsKey(user.getId())) {
            throw new EntityNotFoundException(String.format(USER_ALREADY_EXISTS, user));
        }
        if (user.getName() == null || user.getName().isBlank()) {
            user.setName(user.getLogin());
        }

        user.setId(++uniqueID);
        users.put(user.getId(), user);
        log.info("Успешно добавлен пользователь: {}.", user);

        return user;
    }

    public User updateUser(User user) {
        if (!users.containsKey(user.getId())) {
            throw new EntityNotFoundException(
                    String.format(USER_NOT_FOUND, user));
        }

        users.put(user.getId(), user);
        log.trace("Пользователь успешно обновлён: {}.", user);

        return user;
    }


}
