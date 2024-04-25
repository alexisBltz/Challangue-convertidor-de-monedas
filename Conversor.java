import javax.swing.*;
import java.util.Objects;
import java.text.DecimalFormat;

public class Conversor {
    public static String [] opciones = {"Conversor de moneda","Conversor de temperataura"};
    public static String [] conversoresMonedas = {"Soles a Dólar","Soles a Euro","Soles a Libras", "Soles a Yen","Soles a Won Coreano",
            "Dólar a Soles", "Euro a Soles", "Libras a Soles","Yen a Soles", "Won Coreano a Soles"};

    public static String [] conversoresTemp = {"Grados celcius a Farenheit","Grados Celcius a Kelvin","Grados Farenheit a Grados Celcius",
            "Kelvin a Grados Celcius","Kelvin a Grados Farenheit"};
    public static void main(String[] args) {


        int continuar = JOptionPane.YES_OPTION;

        while(continuar == JOptionPane.YES_OPTION) {
            //opcioines para convertir moendas o temperatura
            String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Elige una opción: ", "Entrada", JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            System.out.println(opcionSeleccionada);

            Double inputValue = Double.parseDouble((JOptionPane.showInputDialog("Ingrese la cantidad de dinero que deseas convertir ")));

            double result = 0;
            if (Objects.equals(opcionSeleccionada, opciones[0])) {
                //opciones de conversiones de monedas
                String convertidorSeleccionado = (String) JOptionPane.showInputDialog(null, "Elige:", "Entrada", JOptionPane.INFORMATION_MESSAGE, null, conversoresMonedas, conversoresMonedas[0]);
                System.out.println(convertidorSeleccionado);
                result = conversor(convertidorSeleccionado, inputValue);

            } else {
                String convertidorSeleccionado = (String) JOptionPane.showInputDialog(null, "Elige:", "Entrada", JOptionPane.INFORMATION_MESSAGE, null, conversoresMonedas, conversoresMonedas[0]);
                //result = conversorTemp(convertidorSeleccionado, inputValue);

            }


            //mensaje de salida
            JOptionPane.showMessageDialog(null, "Tienes" + result);
            //Menu si desea continuar 0 1 2
            continuar = JOptionPane.showConfirmDialog(null, "Desea continuar");
            //System.out.println(continuar);
            //Finalizacion
            //JOptionPane.showMessageDialog(null, "Fin del programa");
        }
    }

    private static double conversor(String convertidorSeleccionado, Double dinero){
        int monedaCambio=20;

        for (int i = 0; i< conversoresMonedas.length; i++){
            if (convertidorSeleccionado.equals(conversoresMonedas[i])){
                monedaCambio = i;
                System.out.println(i);
            }
        }
        switch (monedaCambio) {
            // Soles a Dólar
            case 0:
                double resultadoSolesADolar = dinero * 0.27;
                return formatearDecimal(resultadoSolesADolar);

            // Soles a Euro
            case 1:
                double resultadoSolesAEuro = dinero * 0.25; // Tasa de cambio aproximada
                return formatearDecimal(resultadoSolesAEuro);

            // Soles a Libras
            case 2:
                double resultadoSolesALibras = dinero * 0.22; // Tasa de cambio aproximada
                return formatearDecimal(resultadoSolesALibras);

            // Soles a Yen
            case 3:
                double resultadoSolesAYen = dinero * 41.89; // Tasa de cambio aproximada
                return formatearDecimal(resultadoSolesAYen);

            // Soles a Won Coreano
            case 4:
                double resultadoSolesAWonCoreano = dinero * 371.73; // Tasa de cambio aproximada
                return formatearDecimal(resultadoSolesAWonCoreano);

            // Dólar a Soles
            case 5:
                double resultadoDolarASoles = dinero * 3.70;
                return formatearDecimal(resultadoDolarASoles);

            // Euro a Soles
            case 6:
                double resultadoEuroASoles = dinero * 3.95; // Tasa de cambio aproximada
                return formatearDecimal(resultadoEuroASoles);

            // Libras a Soles
            case 7:
                double resultadoLibrasASoles = dinero * 4.60; // Tasa de cambio aproximada
                return formatearDecimal(resultadoLibrasASoles);

            // Yen a Soles
            case 8:
                double resultadoYenASoles = dinero * 0.024; // Tasa de cambio aproximada
                return formatearDecimal(resultadoYenASoles);

            // Won Coreano a Soles
            case 9:
                double resultadoWonCoreanoASoles = dinero * 0.0027; // Tasa de cambio aproximada
                return formatearDecimal(resultadoWonCoreanoASoles);
        }
        return 0;
    }
    private static void conversorTemp( String convertidorSeleccionado, double temperatura) {
        int cambiosTemp = 20;
        for (int i = 0; i< conversoresMonedas.length; i++){
            if (convertidorSeleccionado.equals(conversoresMonedas[i])){
                cambiosTemp = i;
                System.out.println(i);
            }
        }
        switch (cambiosTemp) {
            // Grados celcius a Farenheit
            case 0:
                double resultadoCelciusAFarenheit = (temperatura * 9/5) + 32;
                System.out.println("Resultado: " + resultadoCelciusAFarenheit + " F");
                break;

            // Grados Celcius a Kelvin
            case 1:
                double resultadoCelciusAKelvin = temperatura + 273.15;
                System.out.println("Resultado: " + resultadoCelciusAKelvin + " K");
                break;

            // Grados Farenheit a Grados Celcius
            case 2:
                double resultadoFarenheitACelcius = (temperatura - 32) * 5/9;
                System.out.println("Resultado: " + resultadoFarenheitACelcius + " °C");
                break;

            // Kelvin a Grados Celcius
            case 3:
                double resultadoKelvinACelcius = temperatura - 273.15;
                System.out.println("Resultado: " + resultadoKelvinACelcius + " °C");
                break;

            // Kelvin a Grados Farenheit
            case 4:
                double resultadoKelvinAFarenheit = (temperatura - 273.15) * 9/5 + 32;
                System.out.println("Resultado: " + resultadoKelvinAFarenheit + " F");
                break;

            default:
                System.out.println("Opción de conversión de temperatura no válida");
        }
    }

    public static double formatearDecimal(double numero) {
        DecimalFormat df = new DecimalFormat("#.##");
        String numeroFormateado = df.format(numero);
        return Double.parseDouble(numeroFormateado);
    }
}
