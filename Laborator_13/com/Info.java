package laborator_13.com;

import laborator_13.res.Messages;

import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Locale;

public class Info implements Command {
    private Locale locale;

    public Info(Locale locale) {
        this.locale = locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void execute() {
        System.out.println(Messages.getString("info") + " " + locale);
        System.out.println("Country: " + locale.getDisplayCountry(locale));
        System.out.println("Language: " + locale.getDisplayLanguage(locale));

        // Verifică disponibilitatea valutei pentru localizarea curentă
        Currency currency = null;
        for (Currency c : Currency.getAvailableCurrencies()) {
            if (c.getDisplayName(locale).equals("Romanian Leu")) {
                currency = c;
                break;
            }
        }
        if (currency != null) {
            System.out.println("Currency: " + currency.getCurrencyCode() +
                    " (" + currency.getDisplayName(locale) + ")");
        } else {
            System.out.println("Currency: N/A");
        }

        System.out.println("Week Days: " + String.join(", ", DateFormatSymbols.getInstance(locale).getWeekdays()));
        System.out.println("Months: " + String.join(", ", DateFormatSymbols.getInstance(locale).getMonths()));
        System.out.println("Today: " + DateFormatSymbols.getInstance(locale).getShortMonths()[4] +
                " 8, 2016 (8 mai 2016)");
    }

}