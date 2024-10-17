package br.com.rts.estudos.graphql.mutations.controllers;

import br.com.rts.estudos.graphql.mutations.controllers.requests.BookInput;
import br.com.rts.estudos.graphql.mutations.entities.Book;
import br.com.rts.estudos.graphql.mutations.mappers.BookMapper;
import br.com.rts.estudos.graphql.mutations.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository repository;
    private final BookMapper mapper;

    @QueryMapping
    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    @MutationMapping
    public Book createBook(@Argument String title,
                           @Argument Integer pages,
                           @Argument String author,
                           @Argument String gender) {

        return repository.save(Book
                .builder()
                .title(title)
                .pages(pages)
                .author(author)
                .gender(gender)
                .build());
    }

    @MutationMapping
    public Book addBook(@Argument BookInput bookInput){
        return repository
                .save(mapper
                        .inputToEntity(bookInput));
    }

    @MutationMapping
    public List<Book> batchCreate(@Argument List<BookInput> bookInputs){
        return repository
                .saveAll(bookInputs.stream()
                        .map(mapper::inputToEntity)
                        .toList());
    }
}
