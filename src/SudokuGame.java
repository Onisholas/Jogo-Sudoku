import java.util.Scanner;

public class SudokuGame {
    private SudokuBoard board;
    private Scanner scanner;

    public SudokuGame() {
        board = new SudokuBoard();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Escolha o nível de dificuldade (1 - Fácil, 2 - Médio, 3 - Difícil): ");
        int difficulty = scanner.nextInt();
        board.generateBoard(difficulty);
        play();
    }

    private void play() {
        while (true) {
            board.printBoard();
            System.out.println("Digite a linha (0-8), coluna (0-8) e número (1-9) para preencher (ou -1 para sair): ");
            int row = scanner.nextInt();
            if (row == -1) break; // Exit the game
            int col = scanner.nextInt();
            int num = scanner.nextInt();

            if (board.setCell(row, col, num)) {
                System.out.println("Número adicionado com sucesso!");
            } else {
                System.out.println("Movimento inválido! Tente novamente.");
            }

            if (board.isComplete()) {
                System.out.println("Parabéns! Você completou o Sudoku!");
                break;
            }
        }

        System.out.println("Deseja ver a solução completa? (s/n)");
        char showSolution = scanner.next().charAt(0);
        if (showSolution == 's' || showSolution == 'S') {
            System.out.println("Solução completa:");
            board.showSolution();
        }
    }
}