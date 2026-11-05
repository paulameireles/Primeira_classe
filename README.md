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

### Classe `Cidade`

| Responsabilidades | Colaboradores | Explicação |
|---|:---:|---|
| Conhecer nome e código da cidade | — | São dados próprios da cidade, usados para identificar origem e destino das rotas. |

### Classe `Rota`

| Responsabilidades | Colaboradores | Explicação |
|---|:---:|---|
| Conhecer o código de quatro dígitos da rota | — | O código identifica a rota cadastrada. |
| Conhecer as cidades de origem e destino | `Cidade` | A rota relaciona duas cidades. |

### Classe `Voo`

| Responsabilidades | Colaboradores | Explicação |
|---|:---:|---|
| Conhecer a rota e a data do voo | `Rota` | O voo associa uma rota a uma data. |
| Guardar o preço base | — | O preço base é definido no cadastro do voo. |
| Controlar a quantidade de lugares disponíveis | `Bilhete` | A ocupação é afetada pelos bilhetes vendidos; o limite é de 150 passageiros por voo. |

### Classe `Bilhete`

| Responsabilidades | Colaboradores | Explicação |
|---|:---:|---|
| Guardar os voos que compõem o bilhete | `Voo` | Um bilhete pode conter um ou mais voos. |
| Validar a sequência de voos | `Voo`, `Rota` | A origem do próximo voo deve ser igual ao destino do anterior; as datas devem ser iguais ou consecutivas. |
| Calcular o preço de venda | `Voo` | Para mais de um voo, usa 60% do preço do mais caro, 40% do segundo mais caro e 10% de cada adicional. |
| Informar origem e destino da viagem | `Voo`, `Rota` | A origem é a do primeiro voo e o destino é o do último. |

### Classe `Agencia`

| Responsabilidades | Colaboradores | Explicação |
|---|:---:|---|
| Cadastrar clientes | `Cliente` | Mantém os registros dos clientes da agência. |
| Manter os voos disponíveis para os próximos 12 meses | `Voo` | Disponibiliza os voos cadastrados para consulta. |
| Buscar combinações de bilhetes por origem, destino e data | `Voo`, `Rota`, `Bilhete` | Apresenta opções de viagem de acordo com os critérios escolhidos. |
| Registrar vendas de bilhetes | `Cliente`, `Bilhete`, `Voo` | Associa o bilhete ao cliente e considera a disponibilidade dos voos. |
| Emitir relatório de cliente com bilhetes comprados e total gasto | `Cliente`, `Bilhete` | Reúne os dados e valores das compras do cliente. |
| Emitir relatório de bilhetes vendidos a partir de uma origem | `Bilhete`, `Rota` | Filtra os bilhetes vendidos pela origem escolhida. |
| Apurar arrecadação e comissão | `Bilhete` | Soma os valores dos bilhetes vendidos e calcula a comissão de 6%. |

---

## 👩‍💻 Autora

**Paula Meireles** · [@paulameireles](https://github.com/paulameireles)
**Pedro Cordeiro Ventura** . [@pedrocventura](https://github.com/pedrocventura)
**Vinicius** . [@Vinizon](https://github.com/Vinizon)
