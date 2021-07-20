package vn.molu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.molu.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> { /*Long là kiểu dữ liệu của id*/
	CategoryEntity findOneByCode(String code);
}
