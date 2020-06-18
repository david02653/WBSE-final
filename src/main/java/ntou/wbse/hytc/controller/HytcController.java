package ntou.wbse.hytc.controller;

import ntou.wbse.hytc.entity.*;
import ntou.wbse.hytc.exception.NotFoundException;
import ntou.wbse.hytc.service.HytcService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/hytc")
public class HytcController {
    // todo: complete save function, complete user control

    @GetMapping(value = "/test")
    public ResponseEntity<History> getNormalDiceRoll(){
        // GET mapping, return cube(6) rolling result
        History result = HytcService.rollNormalDice();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{cmd}")
    public ResponseEntity<History> getSameDiceRoll(@PathVariable("cmd") String cmd){
        // GET mapping, return multiple dice rolling result, same type of dice
        History result = HytcService.rollSingleTypeDice(cmd);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/roll")
    public ResponseEntity<History> rollDice(@RequestBody DiceRequest request){
        // POST mapping, return multiple type dice roll result
        History result = HytcService.rollDice(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/roll").build().toUri();
        return ResponseEntity.created(location).body(result);
    }

    @PostMapping(value = "/option/roll")
    public ResponseEntity<History> getOptionListResult(@RequestBody OptionListRequest request){
        History result = HytcService.rollOptionList(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/option/roll").build().toUri();
        return ResponseEntity.created(location).body(result);
    }

    @GetMapping(value = "/{optionId}/import")
    public ResponseEntity<OptionListResponse> getOptionList(@PathVariable String optionId){
        OptionList list = HytcService.getOptionList(optionId);
        OptionListResponse resp = HytcService.generateOptionResponse(list);
        return ResponseEntity.ok(resp);
    }

    @GetMapping(value = "/{optionId}")
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
    public ResponseEntity<OptionListResponse> updateOption(@PathVariable String optionId, @RequestBody OptionListRequest request){
        OptionListResponse response = HytcService.updateOptionList(optionId, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/option/save")
    public ResponseEntity<OptionListResponse> saveOptionList(@RequestBody OptionListRequest request){
        OptionListResponse list = HytcService.saveOptionList(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/option/save").build().toUri();
        return ResponseEntity.created(location).body(list);
    }

    @DeleteMapping(value = "/{optionId}/delete")
    public ResponseEntity<Map<String, Integer>> removeOption(@PathVariable String optionId){
        // TODO : DELETE mapping, remove user defined option
        return null;
    }

    @PostMapping(value = "/signUp")
    public ResponseEntity<User> signUp(@RequestBody String username){
        User user = HytcService.signUp(username);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/signUp").build().toUri();
        return ResponseEntity.created(location).body(user);
    }

    @PostMapping(value = "/signIn")
    public ResponseEntity<User> signIn(@RequestBody String uid){
        User user = HytcService.signIn(uid);
        if(user == null){
            System.out.println("error occur");
            throw new NotFoundException("User Not Found");
        }else{
            System.out.println("User Found: " + user);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/signIn").build().toUri();
            return ResponseEntity.created(location).body(user);
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<History> saveHistory(@RequestBody History target){
        History history = HytcService.save(target);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/save").build().toUri();
        return ResponseEntity.created(location).body(history);
    }

    @GetMapping(value = "/{userId}/history")
    public ResponseEntity<ArrayList<History>> getHistoryResultList(@PathVariable String userId){
        // TODO : GET mapping, return past result list
        ArrayList<History> list = HytcService.getAllHistory(userId);
        return ResponseEntity.ok(list);
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