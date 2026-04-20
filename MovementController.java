public class MovementController {
    private GameBoard board;

    public MovementController(GameBoard board) {
        this.board = board;
    }

    public boolean canMove(int nextRow, int nextCol) {

        return nextRow >= 0 && nextRow < board.getRows() &&
                nextCol >= 0 && nextCol < board.getCols() &&
                !board.isWall(nextRow, nextCol);
    }
}
