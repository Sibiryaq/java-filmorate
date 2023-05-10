package ru.yandex.practicum.filmorate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exceptions.EntityNotFoundException;
import ru.yandex.practicum.filmorate.exceptions.ValidatorException;
import ru.yandex.practicum.filmorate.model.Film;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.yandex.practicum.filmorate.exceptions.EntityNotFoundException.FILM_ALREADY_EXISTS;
import static ru.yandex.practicum.filmorate.exceptions.EntityNotFoundException.FILM_NOT_FOUND;

@Service
@Slf4j
public class FilmService {
    private final Map<Long, Film> films = new HashMap<>();
    private long uniqueID = 0;


    public List<Film> getAllFilms() {
        return new ArrayList<>(films.values());
    }

    public Film create(Film film) {
        if (films.containsKey(film.getId())) {
            throw new EntityNotFoundException(
                    String.format(FILM_ALREADY_EXISTS, film));
        }

        film.setId(++uniqueID);
        films.put(film.getId(), film);
        log.info("Успешно добавлен фильм: {}.", film);

        return film;
    }

    public Film update(Film film) {
        if (!films.containsKey(film.getId())) {
            throw new EntityNotFoundException(String.format(FILM_NOT_FOUND, film));
        }

        films.put(film.getId(), film);
        log.info("Фильм успешно обновлён: {}.", film);

        return film;
    }

}
