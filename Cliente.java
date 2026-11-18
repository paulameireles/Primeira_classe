import java.util.*;

public class Cliente {
    private String nome;
    private String sobrenome;
    private String numeroRegistro;
    private List<Bilhete> bilhetes;

    public Cliente(String nome, String sobrenome, String numeroRegistro){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroRegistro = numeroRegistro;
        this.bilhetes = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }

    public String getNumeroRegistro(){
        return numeroRegistro;
    }

    public void adicionarBilhete(Bilhete bilhete){
        if(bilhete == null){
            throw new IllegalArgumentException("Bilhete não pode ser nulo");
        }else if(bilhetes.contains(bilhete)){
            throw new IllegalArgumentException("Bilhete já adicionado");
        }
        bilhetes.add(bilhete);
    }

    public double calcularTotalGasto(){
        double total = 0.0;
        for(Bilhete bilhete : bilhetes){
            total += bilhete.calcularPreco;
        }
        return total;
    }

    public String gerarRelatorio(){
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório do Cliente: ").append(nome).append(" ").append(sobrenome).append("\n");
        relatorio.append("Número de Registro: ").append(numeroRegistro).append("\n");
        relatorio.append("Bilhetes:\n");
        for(Bilhete bilhete : bilhetes){
            relatorio.append(bilhete.toString()).append("\n");
        }
        relatorio.append("Total Gasto: R$").append(calcularTotalGasto()).append("\n");
        return relatorio.toString();
    }

}
