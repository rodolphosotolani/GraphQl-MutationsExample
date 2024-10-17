package br.com.rts.estudos.graphql.mutations.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}