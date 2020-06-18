package ntou.wbse.hytc.service;

import ntou.wbse.hytc.entity.*;
import ntou.wbse.hytc.exception.NotFoundException;
import ntou.wbse.hytc.model.WeightRandom;
import ntou.wbse.hytc.repository.HistoryRepository;
import ntou.wbse.hytc.repository.OptionRepository;
import ntou.wbse.hytc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HytcService {

    @Autowired
    private static OptionRepository optionRepository;
    @Autowired
    private static UserRepository userRepository;
    @Autowired
    private static HistoryRepository historyRepository;

    public HytcService(OptionRepository optionRepository, UserRepository userRepository, HistoryRepository historyRepository){
        this.optionRepository = optionRepository;
        this.userRepository = userRepository;
        this.historyRepository = historyRepository;
    }

    public static History rollNormalDice(){
        //RollResult result = new RollResult();
        History result = new History();
        int score = (int)(Math.random()*6 + 1);
        result.setResult(score);
        result.setAction("1d6");
        result.setDetail(null);
        result.setTarget(null);
        //result.setScore((int)(Math.random()*6) + 1);
        return result;
    }

    public static History rollSingleTypeDice(String cmd){
        // same type dice roll result, e.g. 2d6
        String[] tokens = cmd.split("d");
        int round = Integer.parseInt(tokens[0]);
        int size = Integer.parseInt(tokens[1]);
        //RollResult result = new RollResult();
        History result = new History();
        ArrayList<Integer> detail = new ArrayList<>();
        int sum=0;
        for(int i=0; i<round; i++){
            int roll = (int)(Math.random() * size) + 1;
            detail.add(roll);
            //sum += (int)(Math.random() * size);
            sum += roll;
        }
        //result.setScore(sum);
        result.setAction(cmd);
        result.setResult(sum);
        result.setTarget(null);
        result.setDetail(detail);
        return result;
    }

    public static History rollDice(DiceRequest request){
        History result = new History();
        System.out.println(request);
        Map<String, Integer> map = new HashMap<>();
        Map<String, ArrayList<Integer>> detail = new HashMap<>();
        map.put("four", request.getFour());
        map.put("six", request.getSix());
        map.put("eight", request.getEight());
        map.put("ten", request.getTen());
        map.put("twelve", request.getTwelve());
        map.put("twenty", request.getTwenty());
        map.put("hundred", request.getHundred());
        int sum=0;
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            ArrayList<Integer> current = new ArrayList<>();
            for(int i=0; i<value; i++){
                //int score = (int)(Math.random() * Integer.parseInt(key)) + 1;
                int score = (int)(Math.random() * getDiceValue(key)) + 1;
                current.add(score);
                sum += score;
                // maybe store each dice result here
            }
            detail.put(key, current);
        }
        //RollResult result = new RollResult(sum);
        result.setTarget(request);
        result.setResult(sum);
        result.setAction("roll any type of dice");
        result.setDetail(detail);
        return result;
    }

    public static OptionList addOptionList(OptionListRequest request){
        // add optionListRequest -> optionList
        //System.out.println(newOption);
        // maybe store data in database here
        return generateOptionList(request);
    }

    public static History rollOptionList(OptionListRequest request){
        OptionList target = generateOptionList(request);
        Map<String, Integer> map = target.getOptions();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 0) // remove weight 0 options
                map.remove(entry.getKey());
        }
        //String result = WeightRandom.roll(map);
        History result = new History();
        result.setAction("roll option list");
        result.setResult(WeightRandom.roll(map));
        result.setDetail(map);
        result.setTarget(request);
        return result;
    }

    public static OptionListResponse saveOptionList(OptionListRequest request){
        OptionList list = generateOptionList(request);
        list.setUid("init");
        optionRepository.insert(list);
        //System.out.println(list);

        return generateOptionResponse(list);
    }

    public static OptionList updateOptionList(String id){
        // todo: search from database and update optionList
        return null;
    }

    public static int removeOptionList(String id){
        // todo: remove optionList from database
        return 0;
    }

    public static OptionList getOptionList(String id){
        return optionRepository.findById(id).orElseThrow(() -> new NotFoundException("No OptionList Found !"));
    }

    public static OptionListResponse generateOptionResponse(OptionList list){
        OptionListResponse response = new OptionListResponse();
        Map<String, Integer> map = list.getOptions();
        ArrayList<String> options = new ArrayList<>();
        ArrayList<Integer> weights = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            options.add(entry.getKey());
            weights.add(entry.getValue());
        }
        response.setId(list.getId());
        response.setUid(list.getUid());
        response.setCount(list.getCount());
        response.setOptions(options);
        response.setWeights(weights);
        return response;
    }

    public static OptionList generateOptionList(OptionListRequest request){
        OptionList newOption = new OptionList();
        newOption.setCount(request.getCount());
        Map<String, Integer> options = new HashMap<>();
        ArrayList<String> option = request.getOptions();
        ArrayList<Integer> weight = request.getWeights();
        for(int i=0; i<request.getCount(); i++){
            options.put(option.get(i), weight.get(i));
        }
        newOption.setOptions(options);
        return newOption;
    }

    public static Integer getDiceValue(String number){
        switch (number){
            case "four":
                return 4;
            case "six":
                return 6;
            case "eight":
                return 8;
            case "ten":
                return 10;
            case "twelve":
                return 12;
            case "twenty":
                return 20;
            case "hundred":
                return 100;
            default:
                return -2;
        }
    }

    public static User signUp(String username){
        User user = new User();
        String random = UUID.randomUUID().toString();
        // search if uuid exist
        while(userRepository.findUserByUserId(random) != null){
            random = UUID.randomUUID().toString();
        }
        user.setUserName(username);
        user.setUserId(random);
        // store in database
        userRepository.insert(user);
        System.out.println(user);
        return user;
    }

    public static User signIn(String uid){
        System.out.println(uid);
        //User user = userRepository.findUserByUserId(uuid);
        return userRepository.findUserByUserId(uid);
    }

    public static History save(History target){
        // create history timestamp
        //Date date = new Date();
        //target.setTimestamp(date);
        // create history id
        String random = UUID.randomUUID().toString();
        while (historyRepository.findHistoryByHistoryId(random) != null){
            random = UUID.randomUUID().toString();
        }
        target.setHistoryId(random);
        // save in database
        historyRepository.insert(target);
        System.out.println(target);
        return target;
    }
}
