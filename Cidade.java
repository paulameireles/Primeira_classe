/** Cidades atendidas pela agência e seus códigos internos. */
public enum Cidade {
    BELO_HORIZONTE("Belo Horizonte", "BHZ"),
    FORTALEZA("Fortaleza", "FOR"),
    RECIFE("Recife", "REC"),
    JOAO_PESSOA("João Pessoa", "JPA"),
    SAO_LUIS("São Luís", "SLZ"),
    NATAL("Natal", "NAT");

    private final String nome;
    private final String codigo;

    Cidade(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return nome;
    }
}
