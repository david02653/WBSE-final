package ntou.wbse.hytc.service;

import ntou.wbse.hytc.entity.*;
import ntou.wbse.hytc.model.WeightRandom;
import ntou.wbse.hytc.repository.OptionRepository;
import ntou.wbse.hytc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class HytcService {

    @Autowired
    private static OptionRepository repository;
    @Autowired
    private static UserRepository userRepository;

    public HytcService(OptionRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
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
            ArrayList<Integer> current = new ArrayList<>();
            for(int i=0; i<value; i++){
                int score = (int)(Math.random() * Integer.parseInt(key)) + 1;
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

    public static OptionList saveOptionList(String id){
        return null;
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
        // todo: search from database and return target optionList
        return null;
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
}
