package pl.com.coders.libria1.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.com.coders.libria1.controller.AuthorView;
import pl.com.coders.libria1.controller.request.AuthorCreateRequest;
import pl.com.coders.libria1.domain.Author;

@Mapper(componentModel ="spring")

public interface AuthorMapper {

    AuthorView toAuthorView(Author author);
    Author toAuthorEntity(AuthorCreateRequest authorCreateRequest);

}
