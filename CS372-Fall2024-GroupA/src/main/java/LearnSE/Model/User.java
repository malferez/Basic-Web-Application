package LearnSE.Model;

public class User {
    private String userId;
    private String firstName;
    private String username;
    private String accessLevel;

    // Constructor
    public User(String userId, String firstName, String username, String accessLevel) {
        this.userId = userId;
        this.firstName = firstName;
        this.username = username;
        this.accessLevel = accessLevel;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }

    public String getAccessLevel() {
        return accessLevel;
    }
}