package ntou.wbse.hytc.service;

import org.springframework.stereotype.Service;

@Service
public class HytcService {

    public HytcService(){}

    public static int getNormalDiceResult(){
        return (int)(Math.random() * 6)+1;
    }

    public static int getSameRollDiceResult(String cmd){
        // TODO: same type dice roll result, e.g. 2d6
        return 0;
    }

    public static int getRollDiceResult(String cmd){
        // TODO: multiple dice roll result, e.g. 2d6 + 4d20
        return 0;
    }
}
