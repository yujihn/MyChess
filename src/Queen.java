public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8 ||
                (line == toLine && column == toColumn)) {
            return false;
        }

        return Math.abs(toLine - line) == Math.abs(toColumn - column) ||
                (toLine == line || toColumn == column);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
