package luka.proyectointegrador;

/**
 * @author lucas
 */

import java.util.Arrays;
import java.util.Random;

public class Carta {
    private int rango; // 1 a 13
    private Palo palo;
    private boolean disponible; // Estado

    public Carta(int rango, Palo palo) {
        this.rango = rango;
        this.palo = palo;
        this.disponible = true; // Por defecto inicia disponible
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public int getRango() {
        return this.rango;
    }
    
    // Convierte el valor int (1-13) a su representación en texto (A, 2-10, J, Q, K)
    private String getRangoTexto() {
        switch (this.rango) {
            case 1: return "A";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return String.valueOf(this.rango);
        }
    }

    // 3. TO STRING: Genera el dibujo ASCII de la carta
    @Override
    public String toString() {
        String strRango = getRangoTexto();
        char p = this.palo.simbolo;
        String[] lineas = new String[14];

        lineas[0] = "";
        lineas[1] = "┌───────────────┐";
        lineas[2] = String.format("│ %-2s            │", strRango);
        lineas[3] = "│ " + p + "             │";

        String[] centro = generarCentro(strRango, p);
        for (int i = 0; i < 7; i++) {
            lineas[4 + i] = "│" + centro[i] + "│";
        }

        // Lógica para invertir el 6 y el 9 abajo a la derecha
        String botRango;
        if (strRango.equals("6")) botRango = " 9";
        else if (strRango.equals("9")) botRango = " 6";
        else botRango = String.format("%2s", strRango);

        lineas[11] = "│             " + p + " │";
        lineas[12] = "│            " + botRango + " │";
        lineas[13] = "└───────────────┘";
        //lineas[14] = "Disponible: " + this.disponible;

        // Unir todas las líneas con saltos de línea
        StringBuilder cartaFinal = new StringBuilder();
        for (String linea : lineas) {
            cartaFinal.append(linea).append("\n");
        }
        return cartaFinal.toString();
    }

    // Helper para dibujar los símbolos en el centro
    private String[] generarCentro(String rango, char p) {
        String[] c = {"               ", "               ", "               ", "               ", "               ", "               ", "               "};
        String doble = "   " + p + "       " + p + "   ";
        String centro = "       " + p + "       ";         

        switch (rango) {
            case "A": c[3] = centro; break;
            case "2": c[1] = centro; c[5] = centro; break;
            case "3": c[1] = centro; c[3] = centro; c[5] = centro; break;
            case "4": c[1] = doble; c[5] = doble; break;
            case "5": c[1] = doble; c[3] = centro; c[5] = doble; break;
            case "6": c[1] = doble; c[3] = doble; c[5] = doble; break;
            case "7": c[1] = doble; c[2] = centro; c[3] = doble; c[5] = doble; break;
            case "8": c[1] = doble; c[2] = centro; c[3] = doble; c[4] = centro; c[5] = doble; break;
            case "9": c[0] = doble; c[2] = doble; c[3] = centro; c[4] = doble; c[6] = doble; break;
            case "10": c[0] = doble; c[1] = centro; c[2] = doble; c[4] = doble; c[5] = centro; c[6] = doble; break;
            case "J": case "Q": case "K": c[3] = "       " + rango + "       "; break;
        }
        return c;
    }
}
