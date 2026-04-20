public class Ghost {
    private Position position;
    private MovementController controller;

    public Ghost(int startRow, int startCol, MovementController controller) {
        this.position = new Position(startRow, startCol);
        this.controller = controller;
    }

    public void followPacman(int pacRow, int pacCol) {
        int dRow = 0;
        int dCol = 0;


        if (pacRow > position.getRow()) dRow = 1;
        else if (pacRow < position.getRow()) dRow = -1;

        if (pacCol > position.getCol()) dCol = 1;
        else if (pacCol < position.getCol()) dCol = -1;

        if (controller.canMove(position.getRow() + dRow, position.getCol() + dCol)) {
            position.setPosition(position.getRow() + dRow, position.getCol() + dCol);
        } else if (controller.canMove(position.getRow() + dRow, position.getCol())) {
            position.setPosition(position.getRow() + dRow, position.getCol());
        } else if (controller.canMove(position.getRow(), position.getCol() + dCol)) {
            position.setPosition(position.getRow(), position.getCol() + dCol);
        }
    }

    public int getRow() { return position.getRow(); }
    public int getCol() { return position.getCol(); }
}