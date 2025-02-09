public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell
                this.nowPlayer = this.nowPlayerColor().equals("Белые") ? "Черные" : "Белые";

                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Ходят " + nowPlayer);
        System.out.println();
        System.out.println("Игрок 2(Черные)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");
        System.out.println();
        System.out.println("Игрок 1(Белые)");
        System.out.println();
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    // Рокировка на стороне короля (короткая рокировка)
    public boolean castling0() {
        int line = nowPlayer.equals("Белые") ? 0 : 7; // Определяем линию для рокировки
        if (board[line][4] instanceof King king && board[line][0] instanceof Rook rook) {

            // Проверяем, что король и ладья не двигались
            if (!king.isInCheck() && !rook.isInCheck()) {
                // Проверяем, что клетки между королём и ладьёй свободны
                if (board[line][1] == null && board[line][2] == null && board[line][3] == null) {
                    // Перемещаем короля и ладью
                    board[line][2] = king;
                    board[line][3] = rook;
                    board[line][4] = null;
                    board[line][0] = null;
                    return true;
                }
            }
        }
        return false;
    }

    // Рокировка на стороне ферзя (длинная рокировка)
    public boolean castling7() {
        int line = nowPlayer.equals("Белые") ? 0 : 7; // Определяем линию для рокировки
        if (board[line][4] instanceof King king && board[line][7] instanceof Rook rook) {

            // Проверяем, что король и ладья не двигались
            if (!king.isInCheck() && !rook.isInCheck()) {
                // Проверяем, что клетки между королём и ладьёй свободны
                if (board[line][5] == null && board[line][6] == null) {
                    // Перемещаем короля и ладью
                    board[line][6] = king;
                    board[line][5] = rook;
                    board[line][4] = null;
                    board[line][7] = null;
                    return true;
                }
            }
        }
        return false;
    }
}