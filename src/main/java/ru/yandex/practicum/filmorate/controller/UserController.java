package ru.yandex.practicum.filmorate.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        log.info("Возвращены все пользователи");
        return userService.getAllUsers();
    }

    @PostMapping
    public User create(@Valid @RequestBody User user) {
        log.info("Получен запрос POST /users на добавление пользователя");
        return userService.createUser(user);
    }

    @PutMapping
    public User update(@Valid @RequestBody User user) {
        log.info("Получен запрос PUT /users' на обновление пользователя с id={}", user.getId());
        return userService.updateUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) { // GET .../users/{id}
        log.info("Получен запрос GET /{id} на получение пользователя с id={}", id);
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/friends")
    public List<User> getFriends(@PathVariable Long id) {
        log.info("Получен запрос GET /{id}/friends на получение друзей пользователя с id={}", id);
        return userService.getFriends(id);
    }

    @GetMapping("/{id}/friends/common/{otherId}")
    public List<User> getCommonFriends(@PathVariable Long id, @PathVariable Long otherId) {
        log.info("Получен запрос GET /{id}/friends/common/{otherId} " +
                "на получение списка друзей общих с другим пользователем с id={}", otherId);
        return userService.getCommonFriends(id, otherId);
    }

    @PutMapping("/{id}/friends/{friendId}")
    public void addFriend(@PathVariable Long id, @PathVariable Long friendId) {
        log.info("Получен запрос PUT /{id}/friends/{friendId} на добавления в друзья пользователя с id={}", friendId);
        userService.addFriend(id, friendId);
    }

    @DeleteMapping("/{id}/friends/{friendId}")
    public void deleteFriend(@PathVariable Long id, @PathVariable Long friendId) {
        log.info("Получен запрос DELETE /{id}/friends/{friendId} на удаление из друзей пользователя с id={}", friendId);
        userService.deleteFriend(id, friendId);
    }

}
