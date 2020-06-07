package ntou.wbse.hytc.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "option")
public class OptionList {
    //TODO: complete getter and setter

    private String id;
    private String userId;
    private int optionCount;
    private Map<String, Integer> options;

    public void setOptionCount(int optionCount) {
        this.optionCount = optionCount;
    }

    public void setOptions(Map<String, Integer> options) {
        //this.options = options;
        // TODO: initialize Map<> list
    }

    public int getOptionCount() {
        return optionCount;
    }

    public Map<String, Integer> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return "OptionList{" +
                "optionCount=" + optionCount +
                ", options=" + options +
                '}';
    }
}
