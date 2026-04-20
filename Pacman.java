public class Pacman {
    private String name;
    private int score = 0;
    private boolean isAlive = true;
    private Position position;
    private MovementController controller;

    public Pacman(String name, int startRow, int startCol, MovementController controller) {
        this.name = name;
        this.position = new Position(startRow, startCol);
        this.controller = controller;
    }

    public void move(int dRow, int dCol) {
        if (!isAlive) return;

        int nextRow = position.getRow() + dRow;
        int nextCol = position.getCol() + dCol;

        if (controller.canMove(nextRow, nextCol)) {
            position.setPosition(nextRow, nextCol);
        }
    }

    public void addScore(int points) { this.score += points; }
    public void die() { this.isAlive = false; }
    public int getRow() { return position.getRow(); }
    public int getCol() { return position.getCol(); }
    public int getScore() { return score; }
    public boolean isAlive() { return isAlive; }
}