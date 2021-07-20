package vn.molu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.molu.entity.CategoryEntity;
import vn.molu.repository.CategoryRepository;
import vn.molu.service.ICategoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;


    @Override
    public Map<String, String> findAll() {
        Map<String, String> result = new HashMap<>();
        List<CategoryEntity> entities = categoryRepository.findAll();
        for (CategoryEntity item: entities) {
            result.put(item.getCode(), item.getName());
        }
        return result;
    }
}