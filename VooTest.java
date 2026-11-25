/*
 * VooTest - testes da classe Voo (Tarefa 3)
 *
 * USO DE IA: este arquivo foi gerado com Claude Opus 5.5 (claude-opus-5-5),
 * via Claude Code (Anthropic).
 * Revisado por: Vinicius Lima Mota
 *
 * Como rodar (na pasta do projeto, com Rota.java e Cidade.java presentes):
 *   javac *.java
 *   java VooTest
 */
import java.time.LocalDate;

public class VooTest {
    static int ok = 0, falha = 0;

    // Imprime [OK] ou [FALHA] e conta o resultado
    static void check(String nome, boolean cond) {
        System.out.println((cond ? "[OK]    " : "[FALHA] ") + nome);
        if (cond) ok++; else falha++;
    }

    // Retorna true se o codigo dentro de r lancar IllegalArgumentException
    static boolean lanca(Runnable r) {
        try {
            r.run();
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    public static void main(String[] args) {
        Rota bhRec = new Rota("1350", Cidade.BELO_HORIZONTE, Cidade.RECIFE);
        LocalDate dia = LocalDate.of(2026, 12, 10);

        System.out.println("--- Construtor ---");
        Voo v = new Voo(bhRec, dia, 500.0);
        check("cria voo valido", v.getRota() == bhRec && v.getData().equals(dia) && v.getPrecoBase() == 500.0);
        check("recusa rota nula", lanca(() -> new Voo(null, dia, 500)));
        check("recusa data nula", lanca(() -> new Voo(bhRec, null, 500)));
        check("recusa preco negativo", lanca(() -> new Voo(bhRec, dia, -10)));
        check("recusa preco zero", lanca(() -> new Voo(bhRec, dia, 0)));
        check("aceita preco pequeno (0.01)", !lanca(() -> new Voo(bhRec, dia, 0.01)));

        System.out.println("--- Capacidade ---");
        check("comeca com 150 lugares", v.getLugaresDisponiveis() == 150);
        check("comeca com lugar disponivel", v.temLugarDisponivel());
        check("ocupar 1 lugar retorna true", v.ocuparLugar());
        check("sobram 149", v.getLugaresDisponiveis() == 149);
        for (int i = 0; i < 149; i++) {
            v.ocuparLugar();
        }
        check("apos 150 passageiros: 0 lugares", v.getLugaresDisponiveis() == 0);
        check("apos 150: sem lugar disponivel", !v.temLugarDisponivel());
        check("151o passageiro recusado (false)", !v.ocuparLugar());
        check("contador nao passa de 150", v.getLugaresDisponiveis() == 0);

        System.out.println();
        System.out.println("Resultado: " + ok + " OK, " + falha + " falha(s)");
    }
}
