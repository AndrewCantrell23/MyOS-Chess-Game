public class Bishop implements Piece {
    private boolean white;

    public Bishop(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    @Override
    public String toString() {
        if (white){
            return "wBi";
        } else {
            return "bBi";
        }
    }
}
