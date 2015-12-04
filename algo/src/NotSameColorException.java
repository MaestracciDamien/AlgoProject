/**
 * Created by E133641M on 19/11/15.
 */
public class NotSameColorException extends Exception {
    private String mString;

    public NotSameColorException(String mString) {
        this.mString = mString;
    }
}
