package laborator_13.com;

import laborator_13.res.Messages;

import java.util.Locale;

public class SetLocale implements Command {
    private Locale locale;

    public SetLocale(Locale locale) {
        this.locale = locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void execute() {
        Locale.setDefault(locale);
        System.out.println(Messages.getString("locale.set") + " " + locale);
    }

}

