package laborator_13.app;


import laborator_13.com.*;
import laborator_13.res.Messages;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class LocaleExplore {
    private static final Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("locales", new DisplayLocales());
        commands.put("locale.set", new SetLocale(null));
        commands.put("info", new Info(null));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        Locale.setDefault(new Locale("ro")); // Setează localizarea curentă la română

        while (true) {
            System.out.println(Messages.getString("prompt"));

            command = scanner.nextLine().trim();

            if ("exit".equals(command)) {
                break;
            }

            String[] parts = command.split(" ");
            String commandName = parts[0];

            if (commands.containsKey(commandName)) {
                Command cmd = commands.get(commandName);
                if (cmd instanceof SetLocale) {
                    String localeTag = parts.length > 1 ? parts[1] : null;
                    Locale locale = localeTag != null ? Locale.forLanguageTag(localeTag) : Locale.getDefault();
                    ((SetLocale) cmd).setLocale(locale);
                } else if (cmd instanceof Info) {
                    String localeTag = parts.length > 1 ? parts[1] : null;
                    Locale locale = localeTag != null ? Locale.forLanguageTag(localeTag) : Locale.getDefault();
                    ((Info) cmd).setLocale(locale);
                }

                cmd.execute();
            } else {
                System.out.println(Messages.getString("invalid"));
            }
        }

        scanner.close();
    }
}