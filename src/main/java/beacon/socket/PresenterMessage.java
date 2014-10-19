package beacon.socket;

/**
 * Created by mmazilu on 10/18/2014.
 */
public class PresenterMessage {
    private String message;
    private Long user;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
