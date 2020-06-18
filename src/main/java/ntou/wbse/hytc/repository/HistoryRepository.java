package ntou.wbse.hytc.repository;

import ntou.wbse.hytc.entity.History;
import ntou.wbse.hytc.entity.OptionList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface HistoryRepository extends MongoRepository<History, String> {
    History findHistoryByHistoryId(String historyId);
    List<History> findAllByUserIdOrderByTimestampDesc(String userId);
}
