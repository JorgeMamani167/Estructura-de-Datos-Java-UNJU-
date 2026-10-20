package luka.punto8_tp5;

/**
 * @author lucas
 */
import java.util.Random;
public class Punto8_tp5 {
    
    public static void duplicarDivisores3(StackMio<Integer> numeros){
        StackMio<Integer> numerosAux = new StackMio<>(numeros.size());
        while(!numeros.isEmpty()){
            numerosAux.push(numeros.pop());
        }
        
        while(!numerosAux.isEmpty()){
            int auxNumero = numerosAux.pop();
            if(auxNumero % 3 == 0){
                //numeros.push(auxNumero * 2); una sola linea pero para entender
                auxNumero = auxNumero * 2;
                numeros.push(auxNumero);
            }else{
                numeros.push(auxNumero);
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int dimencion = Helper.getIntPositivo("Escrbir la cantidad de numeros aletorios: ");
        StackMio<Integer> numeros = new StackMio(dimencion);
        for (int i = 0; i<dimencion; i++){
            int numero = random.nextInt(1,100);
            numeros.push(numero);
        }
        System.out.println(numeros);
        //el for each solo ve no modifica valores o si? va si con el set pero en la
        //aplicacion orginal no lo tiene asi que usamos otros metodos
        
        duplicarDivisores3(numeros);
        System.out.println(numeros);
    }
}
