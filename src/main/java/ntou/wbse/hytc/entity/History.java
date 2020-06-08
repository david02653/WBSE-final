package ntou.wbse.hytc.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "history")
public class History {

    private String action; // what user do
    private String result; // what user got as result
    private String detail; // action details

    public void setAction(String action) {
        this.action = action;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAction() {
        return action;
    }

    public String getResult() {
        return result;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return "History{" +
                "action='" + action + '\'' +
                ", result='" + result + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
