
/**
 * Objeto Dado, para utilização no trabalho 2.
 *
 * @author Arthur Dutra e Gabriel Rabelo
 * @version 1.0
 */
import java.util.Random;
public class Dado{
    private int lado;
    
    /**
     * Método construtor do dado.
     */
    public Dado(){
    }
    
    /**
     * Este método gera o número aleatório lado do dado.
     */
    public void jogaDado(){
       Random gerador = new Random();
       lado = gerador.nextInt(6)+1;
    }
    
    /**
     * Este método verifica o lado atual do dado.
     */
    public int getLado(){
        return lado;
    }
    
}
