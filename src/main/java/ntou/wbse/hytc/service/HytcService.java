package ntou.wbse.hytc.service;

import ntou.wbse.hytc.entity.DiceRequest;
import ntou.wbse.hytc.entity.OptionList;
import ntou.wbse.hytc.entity.OptionListRequest;
import ntou.wbse.hytc.entity.RollResult;
import ntou.wbse.hytc.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class HytcService {

    @Autowired
    private OptionRepository repository;

    public HytcService(OptionRepository repository){
        this.repository = repository;
    }

    public static RollResult getNormalDiceResult(){
        RollResult result = new RollResult();
        result.setScore((int)(Math.random()*6) + 1);
        return result;
    }

    public static RollResult getSameRollDiceResult(String cmd){
        // same type dice roll result, e.g. 2d6
        String[] tokens = cmd.split("d");
        int round = Integer.parseInt(tokens[0]);
        int size = Integer.parseInt(tokens[1]);
        RollResult result = new RollResult();
        int sum=0;
        for(int i=0; i<round; i++){
            sum += (int)(Math.random() * size);
            sum += 1;
        }
        result.setScore(sum);
        return result;
    }

    public static RollResult getRollDiceResult(DiceRequest request){
        Map<String, Integer> map = new HashMap<>();
        map.put("4", request.getFour());
        map.put("6", request.getSix());
        map.put("8", request.getEight());
        map.put("10", request.getTen());
        map.put("12", request.getTwelve());
        map.put("20", request.getTwenty());
        map.put("100", request.getHundred());
        int sum=0;
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            for(int i=0; i<value; i++){
                int score = (int)(Math.random() * Integer.parseInt(key)) + 1;
                sum += score;
                // maybe store each dice result here
            }
        }
        RollResult result = new RollResult(sum);
        return result;
    }

    public static OptionList addOptionList(OptionListRequest request){
        // todo : add optionListRequest -> optionList

        return null;
    }
}
