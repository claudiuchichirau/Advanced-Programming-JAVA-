package laborator_13.res;
import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {
    private static final String BUNDLE_NAME = "laborator_13.res.Messages";
    private static ResourceBundle resourceBundle;

    static {
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault());
    }

    public static String getString(String key) {
        return resourceBundle.getString(key);
    }
}