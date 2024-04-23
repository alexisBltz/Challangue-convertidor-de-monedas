import javax.swing.*;
import java.util.Objects;
import java.text.DecimalFormat;

public class Conversor {
    public static String [] opciones = {"Conversor de moneda","Conversor de temperataura"};
    public static String [] conversores = {"Soles a Dólar","Soles a Euro","Soles a Libras", "Soles a Yen","Soles a Won Coreano",
            "Dólar a Soles", "Euro a Soles", "Libras a Soles","Yen a Soles", "Won Coreano a Soles"};
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
                String convertidorSeleccionado = (String) JOptionPane.showInputDialog(null, "Elige:", "Entrada", JOptionPane.INFORMATION_MESSAGE, null, conversores, conversores[0]);
                System.out.println(convertidorSeleccionado);
                result = conversor(convertidorSeleccionado, inputValue);

            } else {
                System.out.println("gaaa");
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

        for (int i=0; i<conversores.length; i++){
            if (convertidorSeleccionado.equals(conversores[i])){
                monedaCambio = i;
                System.out.println(i);
            }
        }
        switch (monedaCambio) {
            // Soles a Dólar
            case 0:
                double resultadoSolesADolar = dinero * 3.81;
                return formatearDecimal(resultadoSolesADolar);

            // Soles a Euro
            case 1:
                double resultadoSolesAEuro = dinero * 0.85; // Tasa de cambio aproximada
                return formatearDecimal(resultadoSolesAEuro);

            // Soles a Libras
            case 2:
                double resultadoSolesALibras = dinero * 0.72; // Tasa de cambio aproximada
                return formatearDecimal(resultadoSolesALibras);

            // Soles a Yen
            case 3:
                double resultadoSolesAYen = dinero * 101.13; // Tasa de cambio aproximada
                return formatearDecimal(resultadoSolesAYen);

            // Soles a Won Coreano
            case 4:
                double resultadoSolesAWonCoreano = dinero * 1253.94; // Tasa de cambio aproximada
                return formatearDecimal(resultadoSolesAWonCoreano);

            // Dólar a Soles
            case 5:
                double resultadoDolarASoles = dinero / 3.81;
                return formatearDecimal(resultadoDolarASoles);

            // Euro a Soles
            case 6:
                double resultadoEuroASoles = dinero / 0.85; // Tasa de cambio aproximada
                return formatearDecimal(resultadoEuroASoles);

            // Libras a Soles
            case 7:
                double resultadoLibrasASoles = dinero / 0.72; // Tasa de cambio aproximada
                return formatearDecimal(resultadoLibrasASoles);

            // Yen a Soles
            case 8:
                double resultadoYenASoles = dinero / 101.13; // Tasa de cambio aproximada
                return formatearDecimal(resultadoYenASoles);

            // Won Coreano a Soles
            case 9:
                double resultadoWonCoreanoASoles = dinero / 1253.94; // Tasa de cambio aproximada
                return formatearDecimal(resultadoWonCoreanoASoles);
        }
        return 0;
    }

    public static double formatearDecimal(double numero) {
        DecimalFormat df = new DecimalFormat("#.##");
        String numeroFormateado = df.format(numero);
        return Double.parseDouble(numeroFormateado);
    }
}
