package ntou.wbse.hytc.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "history")
public class History {

    private String historyId;
    private String action; // what user do
    private Object result; // what user got as result
    private Object detail = null; // action details
    private Object target = null; // object used

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public String getHistoryId() {
        return historyId;
    }

    public String getAction() {
        return action;
    }

    public Object getResult() {
        return result;
    }

    public Object getDetail() {
        return detail;
    }

    public Object getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "History{" +
                "historyId='" + historyId + '\'' +
                ", action='" + action + '\'' +
                ", result='" + result + '\'' +
                ", detail='" + detail + '\'' +
                ", target=" + target +
                '}';
    }
}
