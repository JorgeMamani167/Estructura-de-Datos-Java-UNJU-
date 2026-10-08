package luka.punto4_tp5;

/**
 * @author lucas
 */
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import java.util.Scanner;

/**
 * Clase utilitaria para la lectura segura de datos por consola.
 * Utiliza Autoboxing/Unboxing para soportar tanto datos primitivos como Wrappers.
 * @author lucas
 */
public class Helper {
    
    // Instancia única y estática del Scanner para toda la aplicación
    private static final Scanner scanner = new Scanner(System.in);
    
    public static LocalDate getLocalDate(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String fechaStr = scanner.nextLine().trim();
            try {
                return LocalDate.parse(fechaStr); // Intenta convertir el String a LocalDate
            } catch (DateTimeParseException e) {
                System.out.println("Error: Formato de fecha incorrecto. Asegúrate de usar YYYY-MM-DD (ejemplo: 2024-12-31).");
            }
        }
    }
    
    public static Integer getIntPositivo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                Integer valor = Integer.valueOf(scanner.nextLine().trim());
                if (valor <= 0) {
                    System.out.println("Error: Solo se permiten números enteros positivos.");
                    continue; 
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: Formato inválido. Ingresa un número entero.");
            }
        }
    }
    
    public static Integer getOpcion(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                Integer valor = Integer.valueOf(scanner.nextLine().trim());
                if (valor < 0) {
                    System.out.println("Error: Solo se permiten opciones validas.");
                    continue; 
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: Formato inválido. Ingresa un número entero.");
            }
        }
    }

    public static String getStringObligatorio(String mensaje) {
        String texto = "";
        
        // El bucle se repite mientras el texto esté vacío (incluso si son solo espacios)
        while (texto.trim().isEmpty()) {
            System.out.print(mensaje);
            texto = scanner.nextLine();
            
            if (texto.trim().isEmpty()) {
                System.out.println("Error: Este campo no puede estar vacio. Intente de nuevo.");
            }
        }
        return texto.trim(); // .trim() quita los espacios sobrantes al principio y al final
    }
    
    public static Boolean getBoolean(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (true/false): ");
            String entrada = scanner.nextLine().trim().toLowerCase();
            
            if (entrada.equals("true")) {
                return true;
            } else if (entrada.equals("false")) {
                return false;
            }
            System.out.println("Error: Debes escribir exactamente 'true' o 'false'.");
        }
    }
    
    public static Double getDoublePositivo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                Double valor = Double.valueOf(scanner.nextLine().trim());
                if (valor < 0) {
                    System.out.println("Error: Solo se permiten numeros decimales positivos o cero.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: Formato invalido. Usa un punto (.) para los decimales.");
            }
        }
    }
    
}
