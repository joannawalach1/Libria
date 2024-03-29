package pl.com.coders.libria1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.com.coders.libria1.controller.view.BookCreateRequest;
import pl.com.coders.libria1.controller.view.BookView;
import pl.com.coders.libria1.controller.view.CategoryName;
import pl.com.coders.libria1.domain.Book;
import pl.com.coders.libria1.domain.Category;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookView toView(Book book);

    Book toEntity(BookView view);

    @Mapping(source = "categoryName", target = "category", qualifiedByName = "categoryNameToCategory")
    Book toEntity(BookCreateRequest bookCreateRequest);

    @Named("categoryNameToCategory")
    static Category categoryNameToCategory(CategoryName categoryName) {
        return new Category(categoryName.name());
    }




}
