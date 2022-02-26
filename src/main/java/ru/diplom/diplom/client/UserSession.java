package ru.diplom.diplom.client;

public final class UserSession {

    private static UserSession instance;

    private String userName;
    private String role;
    private String sessionKey;

    private UserSession(String userName, String role, String sessionKey) {
        this.userName = userName;
        this.role = role;
        this.sessionKey = sessionKey;
    }

    public static UserSession getInstace(String userName, String role, String sessionKey) {
        if(instance == null) {
            instance = new UserSession(userName, role, sessionKey);
        }
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    public String role () {
        return role;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public void cleanUserSession() {
        userName = "";// or null
        role = "";// or null
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + userName + '\'' +
                ", role=" + role +
                '}';
    }
}