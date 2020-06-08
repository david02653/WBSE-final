package ntou.wbse.hytc.repository;

import ntou.wbse.hytc.entity.History;
import ntou.wbse.hytc.entity.OptionList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoryRepository extends MongoRepository<History, String> {
    //TODO: define extends types
}
