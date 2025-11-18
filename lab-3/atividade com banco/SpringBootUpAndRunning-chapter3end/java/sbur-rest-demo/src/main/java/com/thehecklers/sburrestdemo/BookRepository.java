package com.thehecklers.sburrestdemo;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<Book> BOOK_ROW_MAPPER = (rs, rowNum) ->
            new Book(rs.getString("id"), rs.getString("name"));

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT id, name FROM books ORDER BY name", BOOK_ROW_MAPPER);
    }

    public Optional<Book> findById(String id) {
        try {
            Book book = jdbcTemplate.queryForObject(
                    "SELECT id, name FROM books WHERE id = ?",
                    BOOK_ROW_MAPPER,
                    id
            );
            return Optional.ofNullable(book);
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public Book insert(Book book) {
        jdbcTemplate.update(
                "INSERT INTO books (id, name) VALUES (?, ?)",
                book.getId(),
                book.getName()
        );
        return book;
    }

    public int update(Book book) {
        return jdbcTemplate.update(
                "UPDATE books SET name = ? WHERE id = ?",
                book.getName(),
                book.getId()
        );
    }

    public int deleteById(String id) {
        return jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
    }
}


