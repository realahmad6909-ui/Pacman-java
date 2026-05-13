public class Ghost {
    private Position position;
    private MovementController controller;

    public Ghost(int startRow, int startCol, MovementController controller) {
        this.position = new Position(startRow, startCol);
        this.controller = controller;
    }

    public void followPacman(int pacRow, int pacCol) {
        int currentRow = position.getRow();
        int currentCol = position.getCol();

        // Possible moves: Up, Down, Left, Right
        int[][] directions = {
                {-1, 0}, // Up
                {1, 0},  // Down
                {0, -1}, // Left
                {0, 1}   // Right
        };

        double minDistance = Double.MAX_VALUE;
        int bestRow = currentRow;
        int bestCol = currentCol;

        for (int[] dir : directions) {
            int nextRow = currentRow + dir[0];
            int nextCol = currentCol + dir[1];

            if (controller.canMove(nextRow, nextCol)) {
                // Euclidean Distance formula
                double distance = Math.sqrt(Math.pow(pacRow - nextRow, 2) + Math.pow(pacCol - nextCol, 2));

                if (distance < minDistance) {
                    minDistance = distance;
                    bestRow = nextRow;
                    bestCol = nextCol;
                }
            }
        }

        position.setPosition(bestRow, bestCol);
    }
    public int getRow() { return position.getRow(); }
    public int getCol() { return position.getCol(); }
}