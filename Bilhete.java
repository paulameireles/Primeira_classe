import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Bilhete {
    private final List<Voo> voos;

    public Bilhete(Voo primeiroVoo) {
        if (primeiroVoo == null) {
            throw new IllegalArgumentException("O primeiro voo não pode ser nulo");
        }
        this.voos = new ArrayList<>();
        this.voos.add(primeiroVoo);
    }

    /** Retorna false sem alterar o bilhete quando a conexão for inválida. */
    public boolean adicionarVoo(Voo voo) {
        if (voo == null || !validarSequencia(voo)) {
            return false;
        }
        voos.add(voo);
        return true;
    }

    private boolean validarSequencia(Voo novoVoo) {
        Voo ultimoVoo = voos.get(voos.size() - 1);
        long intervaloEmDias = ChronoUnit.DAYS.between(
                ultimoVoo.getData(), novoVoo.getData());

        return ultimoVoo.getRota().getDestino() == novoVoo.getRota().getOrigem()
                && (intervaloEmDias == 0 || intervaloEmDias == 1);
    }

    public double calcularPreco() {
        if (voos.size() == 1) {
            return voos.get(0).getPrecoBase();
        }

        // A ordem por preço é usada apenas no cálculo, preservando a viagem.
        List<Voo> voosPorPreco = new ArrayList<>(voos);
        voosPorPreco.sort(Comparator.comparingDouble(Voo::getPrecoBase).reversed());

        double preco = voosPorPreco.get(0).getPrecoBase() * 0.60
                + voosPorPreco.get(1).getPrecoBase() * 0.40;
        for (int i = 2; i < voosPorPreco.size(); i++) {
            preco += voosPorPreco.get(i).getPrecoBase() * 0.10;
        }
        return preco;
    }

    public Cidade getOrigem() {
        return voos.get(0).getRota().getOrigem();
    }

    public Cidade getDestino() {
        return voos.get(voos.size() - 1).getRota().getDestino();
    }

    /** Retorna uma cópia não modificável para preservar a sequência validada. */
    public List<Voo> getVoos() {
        return Collections.unmodifiableList(new ArrayList<>(voos));
    }

    @Override
    public String toString() {
        return String.format(Locale.forLanguageTag("pt-BR"),
                "Bilhete: %s -> %s | %d voo(s) | R$ %.2f",
                getOrigem().getNome(), getDestino().getNome(),
                voos.size(), calcularPreco());
    }
}
