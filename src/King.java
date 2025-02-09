public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8 ||
                (line == toLine && column == toColumn)) {
            return false;
        }

        int deltaLine = Math.abs(toLine - line);
        int deltaColumn = Math.abs(toColumn - column);
        return (deltaLine <= 1 && deltaColumn <= 1);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    // Проверяет, находится ли король в безопасности (не под шахом)
    public boolean isSafe(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board.board[i][j];
                if (piece != null && !piece.getColor().equals(this.getColor())) {
                    if (piece.canMoveToPosition(board, i, j, line, column)) {
                        this.setCheck(true); // Король под шахом
                        return false; // Король не в безопасности
                    }
                }
            }
        }
        this.setCheck(false); // Король не под шахом
        return true; // Король в безопасности
    }
}