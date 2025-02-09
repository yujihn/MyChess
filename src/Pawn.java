public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8 ||
                (line == toLine && column == toColumn)) {
            return false;
        }

        if (color.equals("Белые")) {
            if (line == 1) {
                return (toLine == line + 2 && column == toColumn) || (toLine == line + 1 && column == toColumn);
            } else {
                return toLine == line + 1 && column == toColumn;
            }
        } else {
            if (line == 6) {
                return (toLine == line - 2 && column == toColumn) || (toLine == line - 1 && column == toColumn);
            } else {
                return toLine == line - 1 && column == toColumn;
            }
        }
    }

    @Override
    public String getSymbol() {
        return "П";
    }
}