package pl.com.coders.libria1.controller;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.coders.libria1.domain.Category;
import pl.com.coders.libria1.domain.CategoryView;
import pl.com.coders.libria1.mapper.CategoryMapper;
import pl.com.coders.libria1.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
//FIXME ADD SERVICE
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryView> getAll() {

        List<Category> categories = IterableUtils.toList((categoryRepository.findAll()));
        return categories.stream().map(category -> categoryMapper.map(category))
                .collect(Collectors.toList());
    }
}
