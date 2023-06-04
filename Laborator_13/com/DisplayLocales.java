package laborator_13.com;
import laborator_13.res.Messages;

import java.util.Locale;

public class DisplayLocales implements Command {
    @Override
    public void execute() {
        System.out.println(Messages.getString("locales"));
        Locale[] availableLocales = Locale.getAvailableLocales();
        for (Locale locale : availableLocales) {
            System.out.println(locale.getDisplayName());
        }
    }
}