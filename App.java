import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App{
    
    private static List<Rota> rotas = new ArrayList<>();
    private static List<Voo> voos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void cadastrarVoo() {
        for(int i = 0; i < rotas.size(); i++){
            System.out.println((i + 1) + " - " + rotas.get(i));
            
        }
        System.out.println("Escolha a rota");
        int escolha = scanner.nextInt();
        Rota rotaEscolhida = rotas.get(escolha -1);
        System.out.println("Voce escolheu: " + rotaEscolhida);
    }

    public static void main(String[]args){
        rotas.add(new Rota("0001", Cidade.BELO_HORIZONTE, Cidade.RECIFE));
        rotas.add(new Rota("0002", Cidade.FORTALEZA, Cidade.RECIFE));
        rotas.add(new Rota("0003", Cidade.JOAO_PESSOA, Cidade.NATAL));

        cadastrarVoo();
    }
}