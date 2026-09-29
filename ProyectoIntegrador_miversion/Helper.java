package luka.proyectointegrador;

import java.util.Scanner;
public class Helper {
    
    // Instancia única y estática del Scanner para toda la aplicación
    private static final Scanner scanner = new Scanner(System.in);

    public static Integer getIntPositivo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                Integer valor = Integer.valueOf(scanner.nextLine().trim());
                if (valor <= 0) {
                    System.out.println("❌ Error: Solo se permiten números enteros positivos.");
                    continue; 
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Formato inválido. Ingresa un número entero.");
            }
        }
    }
    
    public static Integer getIntRango(String mensaje, int minimo, int maximo) {
        while (true) {
            System.out.print(mensaje);
            try {
                Integer valor = Integer.valueOf(scanner.nextLine().trim());
                if (valor < minimo || valor > maximo) {
                    System.out.println("❌ Error: Ingresa un número entre " + minimo + " y " + maximo + ".");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Formato inválido. Ingresa un número entero.");
            }
        }
    }
    public static Integer getOpcion(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                Integer valor = Integer.valueOf(scanner.nextLine().trim());
                if (valor < 0) {
                    System.out.println("❌ Error: Solo se permiten opciones validas.");
                    continue; 
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Formato inválido. Ingresa un número entero.");
            }
        }
    }

    public static String getString(String mensaje) {
        String texto = "";
        
        // El bucle se repite mientras el texto esté vacío (incluso si son solo espacios)
        while (texto.trim().isEmpty()) {
            System.out.print(mensaje);
            texto = scanner.nextLine();
            
            if (texto.trim().isEmpty()) {
                System.out.println("⚠️ Error: Este campo no puede estar vacío. Intente de nuevo.");
            }
        }
        return texto.trim(); // .trim() quita los espacios sobrantes al principio y al final
    }
}