package br.com.rts.estudos.graphql.mutations;

import br.com.rts.estudos.graphql.mutations.entities.Book;
import br.com.rts.estudos.graphql.mutations.entities.Review;
import br.com.rts.estudos.graphql.mutations.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
@RequiredArgsConstructor
public class DataLoaderCommandLineRunner implements CommandLineRunner {

    public static final int COUNT_TAGS = 20;
    public static final int COUNT_SESSIONS = 100;
    public static final int COUNT_SPEAKERS = 1000;
    public static final int COUNT_EVENTS = 10;

    private final BookRepository repository;

    private final Faker faker;

    @Override
    public void run(String... args) throws Exception {

        this.createBooks().forEach(book -> {
            book.setReviews(this.createReviews(book));
            log.info("Saving the {}", book.toString());
            repository.save(book);
        });
    }

    private List<Review> createReviews(Book book) {

        log.info("Creating the Reviewa List..");

        List<Review> reviews = new ArrayList<>();

        for (int count = 0; count < COUNT_SESSIONS; count++) {
            reviews.add(Review
                    .builder()
                    .title(faker.book().title())
                    .comment(faker.lorem().paragraph(1))
                    .book(book)
                    .build());
        }
        return reviews;
    }

    private List<Book> createBooks() {

        log.info("Creating the Events List in dataBase");

        var books = new ArrayList<Book>();
        for (int count = 0; count < COUNT_EVENTS; count++) {

            books.add(Book
                    .builder()
                    .title(faker.book().title())
                    .author(faker.book().author())
                    .gender(faker.book().genre())
                    .pages(faker.number().numberBetween(50, 1000))
                    .build());
        }

        return books;
    }

}
