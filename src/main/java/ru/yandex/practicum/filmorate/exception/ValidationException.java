package ru.yandex.practicum.filmorate.exception;

import lombok.extern.slf4j.Slf4j;

/*
Вопрос:
Может в целом только один класс ValidationException оставить, удалив EntityNotFoundException?
 */
@Slf4j
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        log.error(message);
    }
}
