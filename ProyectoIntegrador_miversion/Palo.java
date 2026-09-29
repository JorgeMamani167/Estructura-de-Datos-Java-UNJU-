package luka.proyectointegrador;

/**
 *
 * @author lucas
 */
public enum Palo {
    PICA('\u2660'), CORAZON('\u2665'), DIAMANTE('\u2666'), TREBOL('\u2663');
    public final char simbolo;
        
    Palo(char simbolo) {
        this.simbolo = simbolo;
    }
}
