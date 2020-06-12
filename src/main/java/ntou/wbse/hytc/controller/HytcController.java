package ntou.wbse.hytc.controller;

import ntou.wbse.hytc.entity.*;
import ntou.wbse.hytc.service.HytcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/hytc")
public class HytcController {
    // todo : add error exception handle, 404

    @GetMapping(value = "/test")
    public ResponseEntity<History> getNormalDiceRoll(){
        // GET mapping, return cube(6) rolling result
        History result = HytcService.getNormalDiceResult();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{cmd}")
    public ResponseEntity<History> getSameDiceRoll(@PathVariable("cmd") String cmd){
        // GET mapping, return multiple dice rolling result, same type of dice
        History result = HytcService.getSameRollDiceResult(cmd);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{userId}/history")
    public ResponseEntity<Object> getHistoryResultList(@PathVariable String userId){
        // TODO : GET mapping, return past result list
        return null;
    }

    @PostMapping(value = "/roll")
    public ResponseEntity<History> rollDice(@RequestBody DiceRequest request){
        // POST mapping, return multiple type dice roll result
        History result = HytcService.getRollDiceResult(request);
        //URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/roll").build().toUri();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/option/roll")
    public ResponseEntity<History> getOptionListResult(@RequestBody OptionListRequest request){
        // todo: GET mapping, return optionList roll result
        History result = HytcService.rollOptionList(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{optionId}")
    public ResponseEntity<Map<String, Integer>> getOptionList(@PathVariable String optionId){
        // TODO : GET mapping, return all user defined options
        return null;
    }

    @GetMapping(value = "/{optionId}/import")
    public ResponseEntity<Object> importOptionList(@PathVariable String optionId){
        // todo: let user import optionList via optionList id?
        return null;
    }

    @PostMapping(value = "/option/add")
    public ResponseEntity<OptionList> addOption(@RequestBody OptionListRequest request){
        // TODO : POST mapping, add user defined options with weight
        //System.out.println(request);
        OptionList list = HytcService.addOptionList(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/option/add").build().toUri();
        return ResponseEntity.created(location).body(list);
    }

    @PutMapping(value = "/{optionId}/update")
    public ResponseEntity<Map<String, Integer>> updateOption(@PathVariable String optionId, @RequestBody OptionListRequest request){
        // TODO : PUT mapping, update user defined options
        return null;
    }

    @DeleteMapping(value = "/{optionId}/delete")
    public ResponseEntity<Map<String, Integer>> removeOption(@PathVariable String optionId){
        // TODO : DELETE mapping, remove user defined option
        return null;
    }
}
// add user login?
// add user option import?
/*
POST expect json format
expect option json format
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