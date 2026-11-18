public class Rota {
    private final String codigo;
    private final Cidade origem;
    private final Cidade destino;

    public Rota(String codigo, Cidade origem, Cidade destino) {
        if (codigo == null || !codigo.matches("[0-9]{4}")) {
            throw new IllegalArgumentException("O código da rota deve ter quatro dígitos");
        }
        if (origem == null || destino == null) {
            throw new IllegalArgumentException("A origem e o destino não podem ser nulos");
        }
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
    }

    public String getCodigo() {
        return codigo;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return codigo + ": " + origem.getNome() + " -> " + destino.getNome();
    }
}
