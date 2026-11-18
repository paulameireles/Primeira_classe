import java.time.LocalDate;

public class VOO {
    private static int CAPACIDADE_MAXIMA = 150;
    private Rota rota;
    private LocalDate data;
    private double precoBase;
    private int lugaresOcupados;
    


    public Voo(Rota r, LocalDate d, double p){
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
    public double getPreco(){
        return precoBase;
    }
    public int getLugaresDisponiveis(){
        return CAPACIDADE_MAXIMA-lugaresOcupados;
    }
    public boolean temLugarDisponivel(){
        return CAPACIDADE_MAXIMA==lugaresOcupados ? false : true;
    }
    public boolean ocuparLugar(){
    }


}
