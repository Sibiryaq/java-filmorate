package ru.yandex.practicum.filmorate.storage.inMemory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.storage.interfaces.FilmStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Фильм c id=" + film.getId() + " добавлен ранее");
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
        if (!films.containsKey(filmId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Фильм с id=" + filmId + " не найден!");
        }
        return films.remove(filmId);
    }
}
