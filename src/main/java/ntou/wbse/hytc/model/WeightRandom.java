package ntou.wbse.hytc.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class WeightRandom {

    public static void main(String[] argv) throws JsonProcessingException {

        Map<String, Integer> map = mapInit();
        //map.remove("C");
        //System.out.println(map);
        //mapSort(map);
        System.out.println(roll(map));

        //ObjectMapper mapper = new ObjectMapper();
        //System.out.println(mapper.writeValueAsString(map));
    }

    public static Map<String, Integer> mapInit(){
        Map<String, Integer> map = new HashMap<>();
        map.put("C", 120);
        map.put("A", 10);
        map.put("B", 80);
        map.put("E", 200);
        map.put("D", 50);

        System.out.println(map);
        return map;
    }

    public static void mapSort(Map<String, Integer> map){
        int totalWeight = 0;
        NavigableMap<Integer, String> sortedMap = new TreeMap<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            int weight = entry.getValue();
            String letter = entry.getKey();
            totalWeight += weight;
            sortedMap.put(totalWeight, letter);
        }

        System.out.println(sortedMap);

        Map<String, Integer> counter = new HashMap<>();
        int runtime = 10000000;
        Random random = new Random();

        for(int i = 0; i < runtime; i++){
            Double randomDouble = random.nextDouble()*totalWeight;
            String letter = sortedMap.ceilingEntry(randomDouble.intValue()).getValue();

            if(counter.get(letter) != null)
                counter.put(letter, counter.get(letter) + 1);
            else
                counter.put(letter, 1);
        }
        System.out.println(counter);

        for(Map.Entry<String, Integer> entry : counter.entrySet()){
            String letter = entry.getKey();
            double showRate = (double) entry.getValue()/runtime;
            int showWeight = (int)(showRate*totalWeight);
            System.out.println(letter + ": " + showWeight);
        }
    }

    public static String roll(Map<String, Integer> map){
        int total = 0;
        NavigableMap<Integer, String> sortedMap = new TreeMap<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            int weight = entry.getValue();
            String letter = entry.getKey();
            total += weight;
            sortedMap.put(total, letter);
        }
        System.out.println(sortedMap);
        Double randomDouble = Math.random()*total;
        String letter = sortedMap.ceilingEntry(randomDouble.intValue()).getValue();
        return letter;
    }
}
