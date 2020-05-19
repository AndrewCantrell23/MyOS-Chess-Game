public class Pawn implements Piece {
    private boolean white;

    public Pawn(boolean white) {
        this.white = white;
    }

    public boolean isWhite(){
        return white;
    }

    @Override
    public String toString() {
        if (white){
            return "wPa";
        } else {
            return "bPa";
        }
    }
}
