package vn.molu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.molu.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> { /*Long là kiểu dữ liệu của id*/

}
