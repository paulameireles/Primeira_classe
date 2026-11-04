# ✈️ Primeira Classe Agência de Viagens

Trabalho prático em grupo de **Programação Modular**
PUC Minas · Prof. Lucca Lacerda · Semestre 2/2026

**Grupo:** Primeira Classe

---

## 📌 Sobre o projeto

Sistema de informação da **Primeira Classe**, uma agência de viagens que vende bilhetes com um ou mais voos entre Belo Horizonte, Fortaleza, Recife, João Pessoa, São Luís e Natal.

---

## 🗂️ Sprint 1 – Tarefa 1: Cartão CRC

O cartão CRC (**C**lasse – **R**esponsabilidades – **C**olaboradores) descreve o que uma classe **sabe**, o que ela **faz** e com quais outras classes ela precisa **conversar** para cumprir cada responsabilidade.

### Classe `Cliente`

| Responsabilidades | Colaboradores | Explicação |
|---|:---:|---|
| Conhecer nome, sobrenome e número de registro | — | Nenhum colaborador: são dados do próprio cliente. |
| Guardar os bilhetes comprados | `Bilhete` | O cliente tem uma lista de bilhetes. |
| Calcular o total gasto | `Bilhete` | O cliente não sabe o preço de cada bilhete. Ele pergunta a cada um "quanto você custa?" (`calcularPreco()`) e soma as respostas. |
| Gerar seu relatório (dados + bilhetes + total gasto) | `Bilhete` | O relatório lista os bilhetes e precisa pedir os dados de cada um. |

---

## 👩‍💻 Autora

**Paula Meireles** · [@paulameireles](https://github.com/paulameireles)
