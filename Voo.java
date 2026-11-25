/*
 * Voo - Tarefa 3
 * Autor: Vinicius Lima Mota
 *
 * USO DE IA: Claude Opus 5.5 (claude-opus-5-5), via Claude Code (Anthropic),
 * usado para revisar o código.
 * restante feito por mim.
 */

import java.time.LocalDate;

public class Voo {
    private static final int CAPACIDADE_MAXIMA = 150;
    private Rota rota;
    private LocalDate data;
    private double precoBase;
    private int lugaresOcupados;
    


    public Voo(Rota r, LocalDate d, double p){
        if (r == null || d == null || p <= 0){
            throw new IllegalArgumentException(
                "Dados inválidos para criação do Voo"
            );
        }
        this.rota=r;
        this.data=d;
        this.precoBase=p;

    }
    public Rota getRota(){
        return rota;
    }
    public LocalDate getData(){
        return data;
    }
    public double getPrecoBase(){
        return precoBase;
    }
    public int getLugaresDisponiveis(){
        return CAPACIDADE_MAXIMA-lugaresOcupados;
    }
    public boolean temLugarDisponivel(){
        return CAPACIDADE_MAXIMA==lugaresOcupados ? false : true;
    }
    public boolean ocuparLugar(){
        if (!temLugarDisponivel()){
            return false;
        }
        lugaresOcupados+=1;
        return true;
    }
}
