package br.com.rts.estudos.graphql.mutations.repositories;

import br.com.rts.estudos.graphql.mutations.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
