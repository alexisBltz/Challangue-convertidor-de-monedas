import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class Challangue {
    //Array de opciones, por ahora solo COnversor de mondedas y conversor de temperatura
    public static String [] opciones = {"Conversor de moneda","Conversor de temperataura"};
    //Las opciones de conversion de monedas
    public static String [] conversoresMonedas = {"Soles a Dólar","Soles a Euro","Soles a Libras", "Soles a Yen","Soles a Won Coreano",
            "Dólar a Soles", "Euro a Soles", "Libras a Soles","Yenes a Soles", "Won Coreano a Soles"};
    //Las opciones de conversion de temperaturas
    public static String [] conversoresTemp = {"Grados celcius a Farenheit","Grados Celcius a Kelvin","Grados Farenheit a Grados Celcius",
            "Kelvin a Grados Celcius","Kelvin a Grados Farenheit"};
    public static void main(String[] args) {

        //Valor que nos permetira ver si continuamos o no
        int continuar = JOptionPane.YES_OPTION;

        //Declaracion de la instancia de ConversorMonedas, el cual llama a la API y ademas nos dan el valor de la conversion a 2 decimales.
        Conversor conversor = new Conversor();

        //Sera la variable donde se obtendra el resultado de la conversion, ya sea monedas o temperaturas
        String result = "";

        boolean validInput= false;

        //bucle mientras el valor de continuar sea un YES, osea 1

        while (continuar == JOptionPane.YES_OPTION) {

            //opcioines para convertir moendas o temperatura

            String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Elige una opción: ", "Entrada", JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            //Ingresamos en un bucle para ver el tema de entradas validas en el monto de conversion
            while (!validInput) {
                double inputValue=0;
                try {
                    //Ingreso del valor que convertiremos
                    if (Objects.equals(opcionSeleccionada, opciones[0])){
                        inputValue = Double.parseDouble((JOptionPane.showInputDialog("Ingrese la cantidad de dinero que deseas convertir ")));
                    }
                    else{
                        inputValue = Double.parseDouble((JOptionPane.showInputDialog("Ingrese la temperatura que deseas convertir ")));
                    }

                    conversor.setValueToConver(inputValue);
                    //La entrada se vuelve valida
                    validInput = true;
                } catch (NumberFormatException e) {
                    // Si la entrada no es un número válido, mostrar un mensaje de error
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                }
            }

            //Se va a verificar si el cambio elegido entre monedas y temperaturas para ver a donde ir
            if (Objects.equals(opcionSeleccionada, opciones[0])) {

                //opciones de conversiones de monedas ejemplo: de dolar a sol
                String convertidorSeleccionado = (String) JOptionPane.showInputDialog(null, "Elige:", "Entrada", JOptionPane.INFORMATION_MESSAGE, null, conversoresMonedas, conversoresMonedas[0]);
                //System.out.println(convertidorSeleccionado);
                conversor.setConverterSelected(convertidorSeleccionado);
                //System.out.println("La opcion elegida es: "+ conversor.getConverterSelected());
                //Entramos a un try donde podremos verificar si se llamo correctamente a la API
                try {
                    //Usamos la variable anteriormente declarada para extraer la conversion que hemos elegido
                    result = conversor.converMoney();
                    //System.out.println("El resultado de apenas salir de la API es: "+result);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            } else {
                String convertidorSeleccionado = (String) JOptionPane.showInputDialog(null, "Elige:", "Entrada", JOptionPane.INFORMATION_MESSAGE, null, conversoresTemp, conversoresTemp[0]);
                //result = conversorTemp(convertidorSeleccionado, inputValue);
                conversor.setConverterSelected(convertidorSeleccionado);
                result = conversor.convertTemp();

            }
            //mensaje de salida de la conversion
            JOptionPane.showMessageDialog(null, "Tienes " + result);
            //restauramos a un valor por defecto para la coreccion de las entradas
            validInput = false;

            //Menu si desea continuar 0 1 2
            continuar = JOptionPane.showConfirmDialog(null, "Desea continuar");
            System.out.println(continuar);
            //Finalizacion

        }

        JOptionPane.showMessageDialog(null, "Fin del programa");

    }


}
