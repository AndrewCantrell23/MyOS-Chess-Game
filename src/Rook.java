public class Rook implements Piece {
    private boolean white;

    public Rook(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    @Override
    public String toString() {
        if (white){
            return "wRo";
        } else {
            return "bRo";
        }
    }
}
