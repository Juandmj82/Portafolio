package com.juandidev.dockerbooksapi.controllers;

import com.juandidev.dockerbooksapi.entities.Book;
import com.juandidev.dockerbooksapi.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class BookController {

    private final BookRepository bookRepository; // Inyección de dependencia por constructor

    // Constructor para inyección de dependencia (preferido sobre @Autowired en el campo)
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // **Obtener Todos los Libros**

    @GetMapping // GET /api/libros
    public ResponseEntity<List<Book>> getAllBooks() { // Retornar ResponseEntity para control total
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(books); // Retorna 200 OK y la lista de libros
    }


    // **Obtener Libro por ID**

    @GetMapping("/{id}") // GET /api/libros/{id}
    public ResponseEntity<Book> getBookById(@PathVariable Long id) { // Retornar ResponseEntity
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No se encontró el libro con el ID: " + id)); // Manejo de 404
        return ResponseEntity.ok(book); // Retorna 200 OK y el libro
    }


    //**Crear un Nuevo Libro**

    @PostMapping // POST /api/libros
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) { // Usar @Valid para activar validaciones
        Book savedBook = bookRepository.save(book);
        // Retorna 201 Created y el libro creado.
        // Es una mejor práctica indicar que un nuevo recurso ha sido creado.
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    // **Actualizar un Libro Existente**

    @PutMapping("/{id}") // PUT /api/libros/{id}
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book bookDetails) { // @Valid en body
        // Busca el libro. Si no existe, lanza 404 NOT FOUND.
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No se encontró el libro con el ID: " + id));

        // Actualiza los campos
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());

        Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook); // Retorna 200 OK y el libro actualizado
    }

    //**Eliminar un Libro**

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) { // Retorna ResponseEntity<Void> para 204 No Content
        // Busca el libro. Si no existe, lanza 404 NOT FOUND.
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No se encontró el libro con el ID: " + id));

        bookRepository.delete(book);

        return ResponseEntity.noContent().build();
    }
}