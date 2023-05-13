package ru.yandex.practicum.filmorate.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import ru.yandex.practicum.filmorate.exception.EntityNotFoundException;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.yandex.practicum.filmorate.exception.EntityNotFoundException.FILM_ALREADY_EXISTS;

@Component
@Slf4j
public class InMemoryFilmStorage implements FilmStorage {
    private final Map<Long, Film> films = new HashMap<>();
    private Long filmID = 0L;

    @Override
    public List<Film> getAllFilms() {
        return new ArrayList<>(films.values());
    }

    @Override
    public Film create(Film film) {
        if (films.containsKey(film.getId())) {
            throw new EntityNotFoundException(
                    String.format(FILM_ALREADY_EXISTS, film));
        }
        film.setId(++filmID);
        films.put(film.getId(), film);
        log.info("Успешно добавлен фильм: {}.", film);
        return film;
    }

    @Override
    public Film update(Film film) {
        if (!films.containsKey(film.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Фильм с id=" + film.getId() + " не найден!");
        }
        films.put(film.getId(), film);
        log.info("Фильм успешно обновлён: {}.", film);
        return film;
    }

    @Override
    public Film getFilmById(Long filmId) {
        if (!films.containsKey(filmId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Фильм с id=" + filmId + " не найден!");
        }
        return films.get(filmId);
    }

    @Override
    public Film delete(Long filmId) {
        if (filmId == null) {
            throw new ValidationException("Передан пустой ID!");
        }
        if (!films.containsKey(filmId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Фильм с id=" + filmId + " не найден!");
        }
        return films.remove(filmId);
    }
}
