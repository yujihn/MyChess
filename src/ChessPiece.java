public abstract class ChessPiece {
    protected String color;
    protected boolean check = false; // По умолчанию фигура не под шахом

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    // Устанавливает, находится ли фигура под шахом
    public void setCheck(boolean check) {
        this.check = check;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();
}