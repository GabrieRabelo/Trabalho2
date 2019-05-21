import java.util.Scanner;
/**
 * Esta aplicação troca a ordem das letras de forma que pegue a ultima e a primeira letra até terminar a palavra.
 *
 * @author Arthur Dutra e Gabriel Rabelo
 * @version 1.0
 */
public class Apravla{
    public static void main (String args[]) {
        Scanner teclado = new Scanner(System.in);
        while(true){
            System.out.println("Informe a palavra a ser transformada: ");
            String palavra = teclado.nextLine();
            System.out.println("Entrada: " + palavra + " Saída: " + deformaPalavraI(palavra));
            System.out.println("Entrada: " + palavra + " Saída: " + deformaPalavraR(palavra, palavra.length()-1));
        }
    }
  
    /**
    ** Este método iterativo deforma palavras conforme enunciado do exercício de forma Iterativa.
    ** @param palavra Palavra a ser deformada
    **/
    public static String deformaPalavraI(String palavra) {
        int tamanho = (palavra.length()-1)/2;
        String saida = "";
        for(int pos = 0;pos<=tamanho;pos++){
            int pos2 = (palavra.length()-1)-pos;
                if (pos2 != pos) {
                    saida += palavra.charAt(pos2);
                }
            saida += palavra.charAt(pos);
        }
        return saida;
    }

    /**
    ** Este método iterativo deforma palavras conforme enunciado do exercício de forma Recursiva.
    ** @param palavra Palavra a ser deformada
    ** @param pos Comprimento da palavra.
    **/
    public static String deformaPalavraR(String palavra,int pos) {
        int pos2 = (palavra.length() -1) -pos;
            if (pos2 == pos || pos2-pos == 1) {
                return "";
            }
        return "" + palavra.charAt(pos) + palavra.charAt(pos2) + deformaPalavraR(palavra, pos-1);
        }
}