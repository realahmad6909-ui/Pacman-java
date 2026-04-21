import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Game setup
        GameBoard board = new GameBoard();
        MovementController mc = new MovementController(board);

        Pacman pac = new Pacman("Packy", 1, 1, mc);
        Ghost red = new Ghost(4, 4, mc);

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- PAC-MAN GAME START ---");
        System.out.println("Instructions: W(Up), S(Down), A(Left), D(Right), Q(Quit)");

        while (pac.isAlive() && board.hasFood()) {


            board.printBoard(pac, red);

            System.out.print("YOUR TURN: ");
            char input = scanner.next().toUpperCase().charAt(0);

            if (input == 'Q') {
                System.out.println("GAME EXIT");
                break;
            }

            if (input == 'W') pac.move(-1, 0);
            else if (input == 'S') pac.move(1, 0);
            else if (input == 'A') pac.move(0, -1);
            else if (input == 'D') pac.move(0, 1);
            else {
                System.out.println("WRONG BUTTON! PRESS W, A, S, OR D ");
                continue;
            }

            board.eatFood(pac.getRow(), pac.getCol(), pac);

            red.followPacman(pac.getRow(), pac.getCol());

            board.checkDeath(pac, red);
        }

        // --- GAME END LOGIC ---
        board.printBoard(pac, red);

        if (!pac.isAlive()) {
            System.out.println("***************************");
            System.out.println("GAME OVER! Ghost CAUGHT YOU.");
            System.out.println("Final Score: " + pac.getScore());
            System.out.println("***************************");
        } else if (!board.hasFood()) {
            System.out.println("***************************");
            System.out.println("CONGRATULATIONS! YOU WON!");
            System.out.println("YOU HAVE EATEN ALL FOOD! Score: " + pac.getScore());
            System.out.println("***************************");
        }

        scanner.close();
    }
}