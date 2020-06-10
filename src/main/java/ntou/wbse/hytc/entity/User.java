package ntou.wbse.hytc.entity;

import java.util.UUID;

public class User {

    private String userName;
    private String uuid;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", uuid=" + uuid +
                '}';
    }
}
