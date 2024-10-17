package br.com.rts.estudos.graphql.mutations.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Integer pages;

    private String author;

    private String gender;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private List<Review> reviews;

}
