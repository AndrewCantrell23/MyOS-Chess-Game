public class Queen implements Piece {
    private boolean white;

    public Queen(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    @Override
    public String toString() {
        if (white){
            return "wQu";
        } else {
            return "bQu";
        }
    }
}
