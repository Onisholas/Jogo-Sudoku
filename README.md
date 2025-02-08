# Jogo de Sudoku em Java

Este é um jogo de **Sudoku** implementado em Java. O programa gera um tabuleiro de Sudoku com níveis de dificuldade ajustáveis e permite que o usuário interaja, preenchendo as células do tabuleiro. O objetivo é completar o tabuleiro com os números de 1 a 9, respeitando as regras do Sudoku.

## Funcionalidades

- **Gerar tabuleiro aleatório**: O tabuleiro é gerado automaticamente com um número aleatório de células preenchidas, baseado no nível de dificuldade escolhido.
  
- **Validação de entradas**: O programa verifica se o número inserido é válido, ou seja, se não há números repetidos na mesma linha, coluna ou região 3x3.

- **Exibição do tabuleiro**: O tabuleiro é exibido de forma clara e legível no console.

- **Controle de erros**: O programa lida com entradas inválidas e oferece mensagens de erro para entradas fora do intervalo de 1 a 9 ou tentativas de preencher células já preenchidas.

- **Escolha de níveis de dificuldade**: O usuário pode escolher entre os níveis **fácil**, **médio** e **difícil**, o que influencia a quantidade de células preenchidas e a complexidade do tabuleiro.

- **Solução**: O programa pode mostrar a solução completa do Sudoku, caso o usuário deseje.

## Requisitos

- Java 8 ou superior.

## Como rodar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/sudoku-java.git
