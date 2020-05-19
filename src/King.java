public class King implements Piece {
    private boolean white;

    public King(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    @Override
    public String toString() {
        if (white){
            return "wKi";
        } else {
            return "bKi";
        }
    }
}
