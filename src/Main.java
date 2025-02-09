import java.util.Scanner;

public class Main {

    public static ChessBoard buildBoard() {
        ChessBoard board = new ChessBoard("Белые");

        board.board[0][0] = new Rook("Белые");
        board.board[0][1] = new Horse("Белые");
        board.board[0][2] = new Bishop("Белые");
        board.board[0][3] = new Queen("Белые");
        board.board[0][4] = new King("Белые");
        board.board[0][5] = new Bishop("Белые");
        board.board[0][6] = new Horse("Белые");
        board.board[0][7] = new Rook("Белые");
        board.board[1][0] = new Pawn("Белые");
        board.board[1][1] = new Pawn("Белые");
        board.board[1][2] = new Pawn("Белые");
        board.board[1][3] = new Pawn("Белые");
        board.board[1][4] = new Pawn("Белые");
        board.board[1][5] = new Pawn("Белые");
        board.board[1][6] = new Pawn("Белые");
        board.board[1][7] = new Pawn("Белые");

        board.board[7][0] = new Rook("Черные");
        board.board[7][1] = new Horse("Черные");
        board.board[7][2] = new Bishop("Черные");
        board.board[7][3] = new Queen("Черные");
        board.board[7][4] = new King("Черные");
        board.board[7][5] = new Bishop("Черные");
        board.board[7][6] = new Horse("Черные");
        board.board[7][7] = new Rook("Черные");
        board.board[6][0] = new Pawn("Черные");
        board.board[6][1] = new Pawn("Черные");
        board.board[6][2] = new Pawn("Черные");
        board.board[6][3] = new Pawn("Черные");
        board.board[6][4] = new Pawn("Черные");
        board.board[6][5] = new Pawn("Черные");
        board.board[6][6] = new Pawn("Черные");
        board.board[6][7] = new Pawn("Черные");
        return board;
    }

    public static void main(String[] args) {

        ChessBoard board = buildBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Команды:
                Выход - 'exit'
                Перезапуск - 'replay'
                Рокировка - 'castling0' или 'castling7'
                Ход - 'move 1 0 3 0'
                
                Сначала вводятся исходные координаты по вертикале, потом через пробел по горизонтале
                Далее необходимо аналогично ввести координаты назначения
                
                Обозначения фигур:
                К - король
                Q - королева
                Т - тура(ладья)
                С - слон
                Л - лошадь
                П - пешка""");
        System.out.println();
        board.printBoard();
        while (true) {
            // Сообщение о текущем игроке
            if (board.nowPlayerColor().equals("Белые")) {
                System.out.print("Ходят белые: ");
            } else {
                System.out.print("Ходят черные: ");
            }

            // Ввод пользователя
            String s = scanner.nextLine();
            if (s.equals("exit")) break;
            else if (s.equals("replay")) {
                System.out.println("Запуск новой игры");
                board = buildBoard();
                board.printBoard();
            } else {
                if (s.equals("castling0")) {
                    if (board.castling0()) {
                        System.out.println("Успешная рокировка");
                        board.printBoard();
                    } else {
                        System.out.println("Ошибка рокировки");
                    }
                } else if (s.equals("castling7")) {
                    if (board.castling7()) {
                        System.out.println("Успешная рокировка");
                        board.printBoard();
                    } else {
                        System.out.println("Ошибка рокировки");
                    }
                } else if (s.contains("move")) {
                    String[] a = s.split(" ");
                    try {
                        int line = Integer.parseInt(a[1]);
                        int column = Integer.parseInt(a[2]);
                        int toLine = Integer.parseInt(a[3]);
                        int toColumn = Integer.parseInt(a[4]);
                        if (board.moveToPosition(line, column, toLine, toColumn)) {
                            System.out.println("Ход осуществлен");
                            System.out.println();
                            board.printBoard();
                        } else {
                            System.out.println("Неправильный ход");
                        }
                    } catch (Exception e) {
                        System.out.println("Неверная команда");
                    }

                }
            }
        }
    }
}