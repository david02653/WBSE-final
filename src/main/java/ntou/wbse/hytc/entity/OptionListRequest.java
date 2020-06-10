package ntou.wbse.hytc.entity;

import java.util.ArrayList;
import java.util.UUID;

public class OptionListRequest {

    private int count;
    private ArrayList<String> options;
    private ArrayList<Integer> weights;

    public void setCount(int count) {
        this.count = count;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public void setWeights(ArrayList<Integer> weights) {
        this.weights = weights;
    }

    public int getCount() {
        return count;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public ArrayList<Integer> getWeights() {
        return weights;
    }

    @Override
    public String toString() {
        return "OptionListRequest{" +
                "count=" + count +
                ", options=" + options +
                ", weights=" + weights +
                '}';
    }
}
/*
expect option json format
{
  "count": 3,
  "options": ["option1", "option2", "option3"],
  "weights": [10, 20, 30]
}
*/