package com.thehecklers.sburrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
	private List<Book> books = new ArrayList<>();

	public RestApiDemoController() {
		books.addAll(List.of(
				new Book("Dom Casmurro"),
				new Book("Memórias Póstumas de Brás Cubas"),
				new Book("Vidas Secas"),
				new Book("Grande Sertão: Veredas")
		));
	}

	@GetMapping
	Iterable<Book> getBooks() {
		return books;
	}

	@GetMapping("/{id}")
	Optional<Book> getBookById(@PathVariable String id) {
		for (Book b: books) {
			if (b.getId().equals(id)) {
				return Optional.of(b);
			}
		}

		return Optional.empty();
	}

	@PostMapping
	Book postBook(@RequestBody Book book) {
		books.add(book);
		return book;
	}

	@PutMapping("/{id}")
	ResponseEntity<Book> putBook(@PathVariable String id,
								 @RequestBody Book book) {
		int bookIndex = -1;

		for (Book b: books) {
			if (b.getId().equals(id)) {
				bookIndex = books.indexOf(b);
				books.set(bookIndex, book);
			}
		}

		return (bookIndex == -1) ?
				new ResponseEntity<>(postBook(book), HttpStatus.CREATED) :
				new ResponseEntity<>(book, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void deleteBook(@PathVariable String id) {
		books.removeIf(b -> b.getId().equals(id));
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