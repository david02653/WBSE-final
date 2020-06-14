package ntou.wbse.hytc.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "option")
public class OptionList {

    private String id;
    private String uid;
    private int count;
    private Map<String, Integer> options;

    public void setCount(int count) {
        this.count = count;
    }

    public void setOptions(Map<String, Integer> options) {
        this.options = options;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return "OptionList{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", count=" + count +
                ", options=" + options +
                '}';
    }
}
