package ntou.wbse.hytc.entity;

import java.util.ArrayList;

public class OptionListResponse {

    private String id;
    private String uid;
    private int count;
    private ArrayList<String> options;
    private ArrayList<Integer> weights;

    public void setId(String id) {
        this.id = id;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public void setWeights(ArrayList<Integer> weights) {
        this.weights = weights;
    }

    public String getId() {
        return id;
    }

    public String getUid() {
        return uid;
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
        return "OptionListResponse{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", count=" + count +
                ", options=" + options +
                ", weights=" + weights +
                '}';
    }
}
