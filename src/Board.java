public class Board {

    private int NUM_ROWS = 8;
    private Tile[][] board;
    private boolean gameOver;

    /**
     * Initializes a chess board to have NUM_ROWS * NUM_ROWS to rows
     * Creates and places all the pieces in their initial starting positions
     * Board works on a coordinate system where characters a-h are the columns and integers 1-8 are the rows
     */
    public Board() {
        board = new Tile[NUM_ROWS][NUM_ROWS];
        for (int i = 1; i <= NUM_ROWS; i++) {
            char h = 'a';
            for (int j = 1; j <= NUM_ROWS; j++) {
                board[i - 1][j - 1] = new Tile(i, h);
                h++;
            }
        }
        // white pieces
        board[0][0].place(new Rook(true));
        board[0][1].place(new Knight(true));
        board[0][2].place(new Bishop(true));
        board[0][3].place(new King(true));
        board[0][4].place(new Queen(true));
        board[0][5].place(new Bishop(true));
        board[0][6].place(new Knight(true));
        board[0][7].place(new Rook(true));
        for (int i = 0; i < NUM_ROWS; i++) {
            board[1][i].place(new Pawn(true));
        }

        // black pieces
        board[7][0].place(new Rook(false));
        board[7][1].place(new Knight(false));
        board[7][2].place(new Bishop(false));
        board[7][3].place(new King(false));
        board[7][4].place(new Queen(false));
        board[7][5].place(new Bishop(false));
        board[7][6].place(new Knight(false));
        board[7][7].place(new Rook(false));
        for (int i = 0; i < NUM_ROWS; i++) {
            board[6][i].place(new Pawn(false));
        }

        gameOver = false;
    }

    /**
     * displays the current state of the board so that each tile follows the below pattern
     * +-------+
     * |       |
     * |pie    |
     * +-------+
     */
    public void displayBoard() {
        System.out.print("    a       b       c       d       e       f       g       h");
        for (int i = 0; i < NUM_ROWS * 3; i++) {
            System.out.println();
            if (i % 3 == 0) {
                System.out.print(" +");
            } else if (i % 3 == 1) {
                System.out.print(" |");
            } else {
                System.out.print(NUM_ROWS - (i / 3) + "|");
            }
            for (int j = 0; j < NUM_ROWS; j++) {
                if (i % 3 == 0) {
                    System.out.print("-------+");
                } else if (i % 3 == 1) {
                    System.out.print("       |");
                } else {
                    if (board[i / 3][j].piece == null) {
                        System.out.print("       |");
                    } else {
                        System.out.print(board[i / 3][j].piece.toString() + "    |");
                    }
                }

            }
        }
        System.out.println();
        System.out.println(" +-------+-------+-------+-------+-------+-------+-------+-------+");

    }

    /**
     * Takes two sets of coordinates and checks what piece is in play then sends the piece to the correct method for
     * that piece
     *
     * @param a     the current x coordinate of the piece to be moved
     * @param currX the current y coordinate of the piece to be moved
     * @param b     the new x coordinate where the piece will be moved
     * @param nextX the new y coordinate where the piece will be moved
     * @throws IllegalArgumentException if (a, currY) does not store a piece
     * @throws IllegalStateException    if the piece is an invalid type
     */
    public void move(char a, int currX, char b, int nextX) {
        int currY = a - 'a';
        currX = 8 - currX;
        int nextY = b - 'a';
        nextX = 8 - nextX;
        Piece piece = board[currX][currY].piece;
        if (piece == null) {
            throw new IllegalArgumentException(a + "" + (8 - currX) + " does not have a piece on it");
        } else {
            board[currX][currY].piece = null;
            board[nextX][nextY].place(piece);
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public class Tile {
        private int x;
        private char y;
        private Piece piece;

        public Tile(int x, char y) {
            this.x = x;
            this.y = y;
            this.piece = null;
        }

        public void place(Piece other) {
            if (piece != null) {
                if (piece.getClass() == King.class) {
                    gameOver = true;
                }
            }
            if (piece == null || (piece.isWhite() && !(other.isWhite())) || (!(piece.isWhite() && other.isWhite()))) {
                piece = other;
            } else {
                System.out.println("That is an illegal move");
            }
        }

    }
}
