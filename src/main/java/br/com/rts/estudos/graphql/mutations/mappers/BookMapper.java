package br.com.rts.estudos.graphql.mutations.mappers;

import br.com.rts.estudos.graphql.mutations.controllers.requests.BookInput;
import br.com.rts.estudos.graphql.mutations.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    Book inputToEntity(BookInput input);
}
