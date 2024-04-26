import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class Conversor {
    private String converterSelected;
    private double valueToConver;

    public String getConverterSelected() {
        return converterSelected;
    }

    public void setConverterSelected(String converterSelected) {
        this.converterSelected = converterSelected;
    }

    public double getValueToConver() {
        return valueToConver;
    }

    public void setValueToConver(double valueToConver) {
        this.valueToConver = valueToConver;
    }

    public void connectApi() throws IOException {
        // Setting URL


    }

    public String converMoney() throws IOException {
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
        System.out.println("accediendo al json de las conversiones");
        JsonObject conversionRates = jsonObj.getAsJsonObject("conversion_rates");
        //System.out.println(conversionRates);

        String optionSelected = getConverterSelected();

        double convert;
        String result="7000";

        switch (optionSelected){
            case("Soles a Dólar"):

                convert = 1/conversionRates.get("PEN").getAsDouble();
                //System.out.println("Entra a conversion de dolares: "+ convert);
                result = "$ " + formatearDecimal(convert *this.getValueToConver()) + " dólares";
                //System.out.println("los dolares que tiene es: "+result);
                break;

            case("Soles a Euro"):
                convert= 1/conversionRates.get("EUR").getAsDouble();
                result = "€ " + formatearDecimal(convert *this.getValueToConver()) + " euros";
                //System.out.println(convert);
                break;

            case("Soles a Libras"):
                convert= 1/conversionRates.get("GBP").getAsDouble();
                result = "£ " + formatearDecimal(convert *this.getValueToConver()) + "libras esterlinas";
                System.out.println(convert);
                break;

            case("Soles a Yen"):
                convert= 1/conversionRates.get("YEN").getAsDouble();
                result = "¥ "+ formatearDecimal(convert *this.getValueToConver()) + "yenes";
                System.out.println(convert);
                break;

            case("Soles a Won Coreano"):
                convert= 1/conversionRates.get("KRW").getAsDouble();
                result = "₩ " + formatearDecimal(convert *this.getValueToConver())+ "wones coreanos";
                System.out.println(convert);
                break;

            case("Dólar a Soles"):
                convert =conversionRates.get("PEN").getAsDouble();
                result = "S/ "+formatearDecimal(convert *this.getValueToConver()) + "soles";
                System.out.println(convert);
                break;
            case("Euro a Soles"):
                convert =conversionRates.get("EUR").getAsDouble();
                result = "S/ "+formatearDecimal(convert *this.getValueToConver()) + "soles";
                System.out.println(convert);
                break;
            case("Yenes a Soles"):
                convert =conversionRates.get("GBP").getAsDouble();
                result = "S/ "+formatearDecimal(convert *this.getValueToConver()) + "soles";
                System.out.println(convert);
                break;
            case("Libras a Soles"):
                convert =conversionRates.get("YEN").getAsDouble();
                result = "S/ "+formatearDecimal(convert *this.getValueToConver()) + "soles";
                System.out.println(convert);
                break;
            case("Won Coreano a Soles"):
                convert =conversionRates.get("KWR").getAsDouble();
                result = "S/ "+formatearDecimal(convert *this.getValueToConver()) + "soles";
                System.out.println(convert);
                break;

        }
        return result;
    }

    public String convertTemp(){
        String result="7000";
        String optionSelected = getConverterSelected();
        switch (optionSelected) {
            case ("Grados celcius a Farenheit"):
                result = formatearDecimal((getValueToConver() * 9 / 5) + 32);
                break;
            case ("Grados Celcius a Kelvin"):
                result = formatearDecimal(getValueToConver() + 273.15);
                break;
            case ("Grados Farenheit a Grados Celcius"):
                result = formatearDecimal((getValueToConver() - 32) * 5 / 9);
                break;
            case ("Kelvin a Grados Celcius"):
                result = formatearDecimal(getValueToConver() - 273.15);
                break;
            case ("Kelvin a Grados Farenheit"):
                result = formatearDecimal((getValueToConver() - 273.15) * 9 / 5 + 32);
                break;
        }
        return result;
    }

    public String formatearDecimal(double numero) {
        DecimalFormat df = new DecimalFormat("#.##");
        String numeroFormateado = df.format(numero);
        return numeroFormateado.replace(',', '.');
    }

}
