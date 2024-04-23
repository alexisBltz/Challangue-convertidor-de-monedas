import javax.swing.*;

public class main {
    public static void main(String[] args) {
        String [] opciones = {"Conversor de moneda","Conversor de temperatura"};
        String [] conversores = {"Soles a Dólar","Soles a Euro","Soles a Libras", "Soles a Yen","Soles a Won Coreano",
                "Dólar a Soles", "Euro a Soles", "Libras a Soles","Yen a Soles", "Won Coreano a Soles"};

        JOptionPane.showInputDialog(null, "Elige una opción: ","Entrada",JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        String inputValue = JOptionPane.showInputDialog("Ingrese la cantidad de dinero que deseas convertir ");

        JOptionPane.showInputDialog(null, "Elige:", "Entrada",JOptionPane.INFORMATION_MESSAGE, null, conversores, conversores[0]);



    }
}
