
/**
 * @author lucas
 */

package luka.uno_helper;

import java.util.Scanner;

/**
 * Clase utilitaria para la lectura segura de datos por consola.
 * Utiliza Autoboxing/Unboxing para soportar tanto datos primitivos como Wrappers.
 * @author lucas
 */
public class HELPPER3 {
    
    // Instancia única y estática del Scanner para toda la aplicación
    private static final Scanner scanner = new Scanner(System.in);

    // ========================================================================
    // 1. TEXTO (String y char / Character)
    // ========================================================================

    public static String leerString(String mensaje, int minCaracteres, int maxCaracteres) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            
            if (entrada.length() >= minCaracteres && entrada.length() <= maxCaracteres) {
                return entrada;
            }
            System.out.println("❌ Error: Debes ingresar entre " + minCaracteres + " y " + maxCaracteres + " caracteres.");
        }
    }

    public static Character leerChar(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            
            if (entrada.length() == 1) {
                return entrada.charAt(0);
            }
            System.out.println("❌ Error: Debes ingresar exactamente un carácter.");
        }
    }

    // ========================================================================
    // 2. NÚMEROS ENTEROS (int / Integer)
    // ========================================================================

    /**
     * Lee cualquier número entero (positivo o negativo).
     */
    public static Integer leerInt(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.valueOf(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Formato inválido. Ingresa un número entero.");
            }
        }
    }

    /**
     * Lee estrictamente un número entero positivo (incluye el 0).
     */
    public static Integer leerIntPositivo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                Integer valor = Integer.valueOf(scanner.nextLine().trim());
                if (valor < 0) {
                    System.out.println("❌ Error: Solo se permiten números enteros positivos o cero.");
                    continue; 
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Formato inválido. Ingresa un número entero.");
            }
        }
    }

    /**
     * Lee un número entero dentro de un rango específico.
     */
    public static Integer leerIntEnRango(String mensaje, int minimo, int maximo) {
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

    // ========================================================================
    // 3. NÚMEROS DECIMALES (double / Double)
    // ========================================================================

    /**
     * Lee cualquier número decimal (positivo o negativo).
     */
    public static Double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.valueOf(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Formato inválido. Usa un punto (.) para los decimales.");
            }
        }
    }

    /**
     * Lee estrictamente un número decimal positivo (incluye el 0.0).
     */
    public static Double leerDoublePositivo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                Double valor = Double.valueOf(scanner.nextLine().trim());
                if (valor < 0) {
                    System.out.println("❌ Error: Solo se permiten números decimales positivos o cero.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Formato inválido. Usa un punto (.) para los decimales.");
            }
        }
    }

    /**
     * Lee un número decimal dentro de un rango específico.
     */
    public static Double leerDoubleEnRango(String mensaje, double minimo, double maximo) {
        while (true) {
            System.out.print(mensaje);
            try {
                Double valor = Double.valueOf(scanner.nextLine().trim());
                if (valor < minimo || valor > maximo) {
                    System.out.println("❌ Error: Ingresa un número decimal entre " + minimo + " y " + maximo + ".");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Formato inválido. Usa un punto (.) para los decimales.");
            }
        }
    }

    // ========================================================================
    // 4. BOOLEANOS (boolean / Boolean)
    // ========================================================================

    /**
     * Lee un valor de verdadero o falso.
     */
    public static Boolean leerBoolean(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (true/false): ");
            String entrada = scanner.nextLine().trim().toLowerCase();
            
            if (entrada.equals("true")) {
                return true;
            } else if (entrada.equals("false")) {
                return false;
            }
            System.out.println("❌ Error: Debes escribir exactamente 'true' o 'false'.");
        }
    }
    public static String leerStringObligatorio(String mensaje) {
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
    
    public static String leerSoloAlgo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                String entrada = scanner.nextLine().trim();
                
                // Validamos que la entrada sea exactamente "ahorro" o "corriente"
                if (!entrada.equalsIgnoreCase("Programado") && !entrada.equalsIgnoreCase("En Vuelo") && !entrada.equalsIgnoreCase("Cancelado") && !entrada.equalsIgnoreCase("Aterrizado")) {
                    System.out.println("Error: Solo se permite ingresar 'Programado' o 'En Vuelo' o 'Cancelado' o 'Aterrizado'");
                    continue;
                }
                
                return entrada.toLowerCase(); // Retornamos normalizado en minúsculas si lo deseas
            } catch (Exception e) {
                System.out.println("Error inesperado al leer la entrada.");
            }
        }
    }
    
    public static String leerSoloLetras(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                String entrada = scanner.nextLine().trim();
                if (entrada.isEmpty()) {
                    System.out.println("Error: La entrada no puede estar vacía.");
                    continue;
                }
                
                // 2. Validamos que contenga solo letras (incluyendo acentos y ñ) y espacios
                // ^ indica el inicio, $ indica el final.
                // [a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+ significa "uno o más caracteres de este tipo"
                if (!entrada.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    System.out.println("Error: Solo se permiten caracteres alfabéticos y espacios.");
                    continue;
                }
                
                return entrada;
            } catch (Exception e) {
                System.out.println("Error inesperado al leer la entrada.");
            }
        }
    }
    
    public static int leerNumeroDel1al9(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                String entrada = scanner.nextLine().trim();

                if (entrada.isEmpty()) {
                    System.out.println("Error: La entrada no puede estar vacía.");
                    continue;
                }

                // Intentamos convertir el String a int
                int numero = Integer.parseInt(entrada);

                // Evaluamos el rango matemáticamente
                if (numero < 1 || numero > 9) {
                    System.out.println("Error: El número debe estar entre 1 y 9.");
                    continue; // Vuelve al inicio del bucle
                }

                return numero; // Devuelve un int, listo para ser usado

            } catch (NumberFormatException e) {
                // Esto atrapa el error si el usuario escribe letras o símbolos (ej: "A", "hola")
                System.out.println("Error: Ingresa un número válido, no letras ni símbolos.");
            } catch (Exception e) {
                System.out.println("Error inesperado al leer la entrada.");
            }
        }
    }
    
}