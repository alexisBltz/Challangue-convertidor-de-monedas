import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class ConversorMonedas {
    private String converterSelected;
    private double money;

    public String getConverterSelected() {
        return converterSelected;
    }

    public void setConverterSelected(String converterSelected) {
        this.converterSelected = converterSelected;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void connectApi() throws IOException {
        // Setting URL


    }

    public double extractCOnvert() throws IOException {
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

        String opcitonSelected = getConverterSelected();

        double convert;
        double result=7000;

        switch (opcitonSelected){
            case("Soles a Dólar"):

                convert = 1/conversionRates.get("PEN").getAsDouble();
                //System.out.println("Entra a conversion de dolares: "+ convert);
                result = formatearDecimal(convert *this.getMoney());
                //System.out.println("los dolares que tiene es: "+result);
                break;

            case("Soles a Euro"):
                convert= 1/conversionRates.get("EUR").getAsDouble();
                result = formatearDecimal(convert *this.getMoney());
                //System.out.println(convert);
                break;

            case("Soles a Libras"):
                convert= 1/conversionRates.get("GBP").getAsDouble();
                result = formatearDecimal(convert *this.getMoney());
                System.out.println(convert);
                break;

            case("Soles a Yen"):
                convert= conversionRates.get("YEN").getAsDouble();
                result = formatearDecimal(convert *this.getMoney());
                System.out.println(convert);
                break;

            case("Soles a Won Coreano"):
                convert= conversionRates.get("KRW").getAsDouble();
                result = formatearDecimal(convert *this.getMoney());
                System.out.println(convert);
                break;

            case("Dólar a Soles"):
                convert =conversionRates.get("PEN").getAsDouble();
                result = formatearDecimal(convert *this.getMoney());
                System.out.println(convert);
                break;

        }
        return result;
    }

    public double formatearDecimal(double numero) {
        DecimalFormat df = new DecimalFormat("#.##");
        String numeroFormateado = df.format(numero);
        return Double.parseDouble(numeroFormateado.replace(',', '.'));
    }

}
