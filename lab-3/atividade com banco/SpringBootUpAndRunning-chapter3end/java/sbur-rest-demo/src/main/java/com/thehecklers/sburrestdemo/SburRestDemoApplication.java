package com.thehecklers.sburrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class SburRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SburRestDemoApplication.class, args);
	}

}

@RestController
@RequestMapping("/books")
class RestApiDemoController {
    private final BookRepository repository;

    public RestApiDemoController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Book> getBooks() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Book> getBookById(@PathVariable String id) {
        return repository.findById(id);
    }

    @PostMapping
    Book postBook(@RequestBody BookRequest request) {
        Book toInsert = new Book(request.getName());
        return repository.insert(toInsert);
    }

    @PutMapping("/{id}")
    ResponseEntity<Book> putBook(@PathVariable String id,
                                 @RequestBody BookRequest request) {
        Book updated = new Book(id, request.getName());
        int rows = repository.update(updated);
        if (rows == 0) {
            repository.insert(updated);
            return new ResponseEntity<>(updated, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable String id) {
        repository.deleteById(id);
    }
}

class Book {
	private final String id;
	private String name;

	public Book(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Book(String name) {
		this(UUID.randomUUID().toString(), name);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}