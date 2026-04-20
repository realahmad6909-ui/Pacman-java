public class GameBoard {
    private char[][] structure = {
            {'#','#','#','#','#','#','#','#','#'},
            {'#','.','.','.','#','.','.','.','#'},
            {'#','.','#','.','#','.','#','.','#'},
            {'#','.','#','.','.','.','#','.','#'},
            {'#','.','.','#',' ','#','.','.','#'},
            {'#','.','#','.','.','.','#','.','#'},
            {'#','.','#','.','#','.','#','.','#'},
            {'#','.','.','.','#','.','.','.','#'},
            {'#','#','#','#','#','#','#','#','#'}
    };

    public boolean isWall(int row, int col) {
        return structure[row][col] == '#';
    }

    public void eatFood(int row, int col, Pacman p) {
        if (structure[row][col] == '.') {
            structure[row][col] = ' ';
            p.addScore(10);
        }
    }

    // Check karna ke kya maze mein abhi bhi khana bacha hai
    public boolean hasFood() {
        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[i].length; j++) {
                // Agar aik bhi '.' mil gaya, to iska matlab khana bacha hai
                if (structure[i][j] == '.') {
                    return true;
                }
            }
        }

        return false;
    }

    public void checkDeath(Pacman p, Ghost g) {
        if (p.getRow() == g.getRow() && p.getCol() == g.getCol()) {
            p.die();
        }
    }

    public void printBoard(Pacman p, Ghost g) {
        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[i].length; j++) {
                if (i == p.getRow() && j == p.getCol()) {
                    System.out.print(p.isAlive() ? '@' : 'X');
                } else if (i == g.getRow() && j == g.getCol()) {
                    System.out.print('G');
                } else {
                    System.out.print(structure[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("Score: " + p.getScore() + (p.isAlive() ? "" : " | GAME OVER!"));
    }

    public int getRows() { return structure.length; }
    public int getCols() { return structure[0].length; }
}