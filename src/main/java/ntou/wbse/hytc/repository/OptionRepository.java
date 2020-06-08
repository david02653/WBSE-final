package ntou.wbse.hytc.repository;

import ntou.wbse.hytc.entity.OptionList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends MongoRepository<OptionList, String> {
}
