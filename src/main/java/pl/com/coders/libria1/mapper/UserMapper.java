package pl.com.coders.libria1.mapper;

import org.mapstruct.Mapper;
import pl.com.coders.libria1.controller.request.UserCreateRequest;
import pl.com.coders.libria1.domain.User;
import pl.com.coders.libria1.controller.UserView;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserView toView(User user);
    User toEntity(UserCreateRequest userCreateRequest);
}
