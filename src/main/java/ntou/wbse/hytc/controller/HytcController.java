package ntou.wbse.hytc.controller;

import ntou.wbse.hytc.entity.DiceRequest;
import ntou.wbse.hytc.entity.OptionListRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/hytc")
public class HytcController {

    @GetMapping
    public ResponseEntity<Integer> getNormalDiceRoll(){
        // TODO : GET mapping, return normal dice rolling result
        return null;
    }

    @GetMapping(value = "/cmd")
    public ResponseEntity<Integer> getSameDiceRoll(@PathVariable("cmd") String cmd){
        // TODO : GET mapping, return dice command result, e.g. 2d10
        return null;
    }

    @GetMapping
    public ResponseEntity<Map<String, Integer>> getAllOption(){
        // TODO : GET mapping, return all user defined options
        return null;
    }

    @GetMapping
    public ResponseEntity<String> getResultList(){
        // TOdO : GET mapping, return pass result list
        return null;
    }

    public ResponseEntity<Integer> rollDice(@RequestBody DiceRequest request){
        // TODO: POST mapping, return multiple type dice roll result
        return null;
    }

    @PostMapping
    public ResponseEntity<Map<String, Integer>> addOption(@RequestBody OptionListRequest request){
        // TODO : POST mapping, add user defined options with weight
        return null;
    }

    @PutMapping
    public ResponseEntity<Map<String, Integer>> updateOption(){
        // TODO : PUT mapping, update user defined options
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Map<String, Integer>> removeOption(){
        // TODO : DELETE mapping, remove user defined option
        return null;
    }
}
/*
POST expect json format
{
  "count": 3,
  "options": ["option1", "option2", "option3"],
  "weights": [10, 20, 30]
}

expect dice types
{
  "4": 0,
  "6": 1,
  "8": 2,
  "10": 0,
  "12": 0,
  "20": 0,
  "100": 1
}
or
[0,1,2,0,0,0,1]
 */