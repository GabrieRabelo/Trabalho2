import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Jogo do dado, desenvolvido para o trabalho 2 de fundamentos de programação.
 *
 * @author Arthur Dutra e Gabriel Rabelo.
 * @version 1.0
 */
public class JogoDado{
    public static void main(String args[]) throws FileNotFoundException{
        Scanner teclado = new Scanner(System.in);
        Dado d1 = new Dado();
        Dado d2 = new Dado();
        int max = 7;
        int pontuacao = 0;
        int soma;
        System.out.println("\f=== Acerte a soma dos dados ===");
        System.out.println("- Se a soma dos dados for igual à 2, sua pontuação será zerada.");
        System.out.println("- Se a soma dos dados for igual à 6, sua pontuação sera reduzida pela metade.");
        System.out.println("===      Boa Sorte ;)       ===");
        for(int rodada = 1; rodada<=max; rodada++){
            do{
                System.out.print("\nAdivinhe a soma dos dois dados (2 a 12): ");
                soma = teclado.nextInt();
            }while(soma > 12 || soma < 2);
            d1.jogaDado();
            d2.jogaDado();
            System.out.println("Dado 1: " + d1.getLado() + " \nDado 2: " + d2.getLado());
            if(d1.getLado() + d2.getLado() == soma){
                System.out.println("Booyah, acertou. +200 pontos.");
                pontuacao += 200;
            }
            if(d1.getLado() + d2.getLado() == 2) {
                System.out.println("Que pena, a soma deu 2, perdeu tudo.");
                pontuacao = 0;
            }
            else if(d1.getLado() + d2.getLado() == 6) {
                System.out.println("Poxa vida, a soma deu 6, perdeu metade dos pontos.");
                pontuacao /= 2;
            }
            if (rodada != 7) {
                System.out.println("Pontuação atual: " + pontuacao);
                System.out.println("Restam " + (7 - rodada) + " rodada(s).");
            }
        }
        System.out.println("\n------ Fim de jogo ------");
        System.out.println("Pontuacao final: " + pontuacao);
        verificaVencedor(pontuacao);
    }
    
    private static void verificaVencedor(int pontuacao) throws FileNotFoundException {
        Scanner teclado = new Scanner(System.in);
        int pontuacaoVencedor = leitura();
        if(pontuacao > pontuacaoVencedor){
            System.out.print("Parabéns, você é o novo recordista. Insira seu nome: ");
            String nome = teclado.nextLine();
            gravacao(nome,pontuacao);
            System.out.println("Parabéns, " + nome + "!");
        }
    }
    
    private static int leitura() throws FileNotFoundException {
       int valor = 0;
       try{
           File origem = new File("recorde.txt");
           Scanner arquivo = new Scanner(origem);
       
       String nome="";
       if(arquivo.hasNextLine()){
           nome = arquivo.nextLine();
           if(arquivo.hasNextLine()){
               String pontuacao = arquivo.nextLine();
               valor = Integer.parseInt(pontuacao);
           }
       }
       if(valor!=0) System.out.println("Vencedor atual: " + nome + " Pontuacao: " + valor);
       arquivo.close();     
       }
       catch(FileNotFoundException ex){
            System.out.println("Erro, arquivo não encontrado.");
       }
       return valor;
    }
    
    private static void gravacao(String nome, int pontuacao) throws FileNotFoundException{
       PrintWriter arquivo = new PrintWriter("recorde.txt");
       arquivo.println(nome);
       arquivo.println(pontuacao);
       arquivo.close();
    }
}
