package ntou.wbse.hytc.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "option")
public class OptionList {

    private String id;
    private int count;
    private Map<String, Integer> options;

    public void setCount(int count) {
        this.count = count;
    }

    public void setOptions(Map<String, Integer> options) {
        //this.options = options;
        // TODO: initialize Map<> list
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public Map<String, Integer> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return "OptionList{" +
                "optionCount=" + count +
                ", options=" + options +
                '}';
    }
}
