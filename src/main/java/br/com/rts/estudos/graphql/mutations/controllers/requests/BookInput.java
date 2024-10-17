package br.com.rts.estudos.graphql.mutations.controllers.requests;

public record BookInput(
        String title,
        Integer pages,
        String author,
        String gender) {
}
