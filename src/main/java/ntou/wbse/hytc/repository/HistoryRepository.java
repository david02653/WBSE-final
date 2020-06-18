package ntou.wbse.hytc.repository;

import ntou.wbse.hytc.entity.History;
import ntou.wbse.hytc.entity.OptionList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HistoryRepository extends MongoRepository<History, String> {
    History findHistoryByHistoryId(String historyId);
}
