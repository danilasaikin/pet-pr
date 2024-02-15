import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyExchange {
    private Map<String, Double> exchangeRates = new HashMap();

    public CurrencyExchange() {
        this.exchangeRates.put("USD", 1.0);
        this.exchangeRates.put("EUR", 0.85);
        this.exchangeRates.put("GBP", 0.75);
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (this.exchangeRates.containsKey(fromCurrency) && this.exchangeRates.containsKey(toCurrency)) {
            double rateFrom = (Double)this.exchangeRates.get(fromCurrency);
            double rateTo = (Double)this.exchangeRates.get(toCurrency);
            return amount / rateFrom * rateTo;
        } else {
            return -1.0;
        }
    }

    public void startExchange() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сумму: ");
        double amount = scanner.nextDouble();
        System.out.print("Введите валюту (USD, EUR, GBP): ");
        String fromCurrency = scanner.next().toUpperCase();
        System.out.print("Введите желаемую валюту (USD, EUR, GBP): ");
        String toCurrency = scanner.next().toUpperCase();
        double convertedAmount = this.convertCurrency(amount, fromCurrency, toCurrency);
        if (convertedAmount >= 0.0) {
            System.out.println("Сумма " + amount + " " + fromCurrency + " эквивалентна " + convertedAmount + " " + toCurrency);
        } else {
            System.out.println("Некорректные валюты.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        CurrencyExchange exchange = new CurrencyExchange();
        exchange.startExchange();
    }
}
