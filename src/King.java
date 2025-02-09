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
        return "К";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        return false;
    }
}
