# java-filmorate
Этот проект - это платформа для любителей фильмов, которая предоставляет возможность пользователям выбирать, и оценивать свои любимые фильмы, а также находить наиболее популярные среди них. Так же есть возможность добавлять друзей

# Структура базы данных:

![диаграмма по ссылке на локальный файл в проекте](/diagram.png)

## Примеры запросов к базе данных

_________
 * Добавить фильм
  ```
  INSERT INTO film (film_id, title, description, duration, release_date) VALUES (ID, 'TITLE', 'DESCRIPTION', DURATION , 'RELEASE (YYYY-MM-DD)';
  ```

* Добавить жанр и рейтинг MPA
```
INSERT INTO film_genre (film_id, genre_id, mpa_rating_id) VALUES (FILM_ID, GENRE_ID, MPA_RATING_ID);;
```

* Добавить в друзья
```
INSERT INTO friends (user_id, friend_id, status)  VALUES (USER_ID, FRIEND_ID, 'FALSE');
```

* Подтверждение дружбы
```
UPDATE friends
SET status = TRUE
WHERE user_id = ID_ПОЛЬЗОВАТЕЛЯ;
```


