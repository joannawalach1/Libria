package pl.com.coders.libria1.mapper;

import org.mapstruct.Mapper;
import pl.com.coders.libria1.domain.Category;
import pl.com.coders.libria1.domain.CategoryView;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryView map(Category category);
}
