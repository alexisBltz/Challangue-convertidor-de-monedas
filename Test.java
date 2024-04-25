import com.google.gson.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        // Setting URL
        String urlStr = "https://v6.exchangerate-api.com/v6/5bdfb4a0c14b4b52748f948b/latest/USD";

        // Making Request
        URL url = new URL(urlStr);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonObj = root.getAsJsonObject();

        // Accessing conversion rates object
        JsonObject conversionRates = jsonObj.getAsJsonObject("conversion_rates");
        System.out.println(conversionRates);

        // Getting conversion rate of PEN TO USD
        double usdToPenConversionRate = conversionRates.get("PEN").getAsDouble();
        System.out.println(usdToPenConversionRate);

        // Calculate the conversion rate from USD to PEN
        double usdToPenBaseConversionRate = 1.0 / usdToPenConversionRate;
        System.out.println(usdToPenBaseConversionRate);

        // Print the conversion rate from USD to PEN
        System.out.println("Tasa de conversión de USD a PEN: " + usdToPenBaseConversionRate);

    }
}
