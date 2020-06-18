package ntou.wbse.hytc.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "history")
public class History {

    private String userId = "init";
    private String historyId;
    private Date timestamp = null;
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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

    public String getUserId() {
        return userId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "History{" +
                "userId='" + userId + '\'' +
                ", historyId='" + historyId + '\'' +
                ", action='" + action + '\'' +
                ", result=" + result +
                ", detail=" + detail +
                ", target=" + target +
                '}';
    }
}
