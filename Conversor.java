import javax.swing.*;
import java.io.IOException;
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
            ConversorMonedas conversor = new ConversorMonedas();

            String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Elige una opción: ", "Entrada", JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);


            double inputValue = Double.parseDouble((JOptionPane.showInputDialog("Ingrese la cantidad de dinero que deseas convertir ")));
            conversor.setMoney(inputValue);

            double result = 0;
            if (Objects.equals(opcionSeleccionada, opciones[0])) {
                //opciones de conversiones de monedas
                String convertidorSeleccionado = (String) JOptionPane.showInputDialog(null, "Elige:", "Entrada", JOptionPane.INFORMATION_MESSAGE, null, conversoresMonedas, conversoresMonedas[0]);
                //System.out.println(convertidorSeleccionado);
                conversor.setConverterSelected(convertidorSeleccionado);
                System.out.println("La opcion elegida es: "+conversor.getConverterSelected());
                try {
                    result = conversor.extractCOnvert();
                    System.out.println("El resultado de apenas salir de la API es: "+result);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            } else {
                String convertidorSeleccionado = (String) JOptionPane.showInputDialog(null, "Elige:", "Entrada", JOptionPane.INFORMATION_MESSAGE, null, conversoresMonedas, conversoresMonedas[0]);
                //result = conversorTemp(convertidorSeleccionado, inputValue);

            }


            //mensaje de salida
            JOptionPane.showMessageDialog(null, "Tienes " + result);
            //Menu si desea continuar 0 1 2
            continuar = JOptionPane.showConfirmDialog(null, "Desea continuar");
            //System.out.println(continuar);
            //Finalizacion
            //JOptionPane.showMessageDialog(null, "Fin del programa");
        }
    }


}
