public class Knight implements Piece {
    private boolean white;

    public Knight(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    @Override
    public String toString() {
        if (white){
            return "wKn";
        } else {
            return "bKn";
        }
    }
}
