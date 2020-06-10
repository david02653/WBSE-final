package ntou.wbse.hytc.repository;

import ntou.wbse.hytc.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByUuidExists(String uuid);
    User findUserByUuid(String uuid);
}
