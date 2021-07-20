package vn.molu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.molu.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> { /*Long là kiểu dữ liệu của id*/
    UserEntity findOneByUserNameAndStatus(String name, int status);
}
