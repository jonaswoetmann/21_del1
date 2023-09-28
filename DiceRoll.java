import java.util.Random;
import java.util.Scanner;

public class DiceRoll {
    private int d1;
    private int d2;
    private int sum;
    private int p1Score;
    private int p2Score;
    private static boolean p1Turn;
    // ændring
    private boolean p1RolledTwoSixes;
    private boolean p2RolledTwoSixes;
    private boolean extraTurn;
    private Scanner scan;

    public DiceRoll() {
        sum = 0;
        p1Score = 0;
        p2Score = 0;
        p1Turn = true;
        p1RolledTwoSixes = false;
        p2RolledTwoSixes = false;
    }

    public void rollDice() {

        Random ran = new Random();
        // ændring

        d1 = ran.nextInt(6) + 1;
        d2 = ran.nextInt(6) + 1;
        calculate(d1, d2);
        if (extraTurn) {
            rollDice();
        }
    }

    public void calculate(int d1, int d2) {
        sum = d1 + d2;
        extraTurn = false;
        if (p1Turn) {
            p1Score += sum;
        } else {
            p2Score += sum;
        }
        if (d1 == 1 && d2 == 1) {
            if (p1Turn) {
                System.out.println("Oh no, player 1 rolled two 1's and lost all points.");
                p1Score = 0;
            } else {
                System.out.println("Oh no, player 2 rolled two 1's and lost all points.");
                p2Score = 0;
            }
            extraTurn = true;
            if (p1Turn) {
                p1RolledTwoSixes = false;
            } else {
                p2RolledTwoSixes = false;
            }
        }
        if (d1 == 6 && d2 == 6) {
            if ((p1Turn && !p1RolledTwoSixes) || (!p1Turn && !p2RolledTwoSixes)) {
                System.out.println("The dice rolled the same number " + d1 + ", roll again.");
                if (p1Turn)
                    System.out.println("Total score - Player 1: " + p1Score);
                else
                    System.out.println("Total score - Player 2: " + p2Score);
                // rollDice();
                extraTurn = true;
            } else {
                if (p1Turn) {
                    System.out.println("congratulation player 1, you won the game by drawing to sixs in a row");
                    System.out.println("Press enter to exit game");
                    System.exit(0);
                } else
                    System.out.println("congratulation player 2, you won the game by drawing to sixs in a row");
                System.out.println("Press enter to exit game");
                System.exit(0);
            }
            checkWinner();
            if (p1Turn) {
                p1RolledTwoSixes = true;
            } else {
                p2RolledTwoSixes = true;
            }
        } else if (d1 == d2) {
            System.out.println("The dice rolled the same number " + d1 + ", roll again.");
            if (p1Turn)
                System.out.println("Total score - Player 1: " + p1Score);
            else
                System.out.println("Total score - Player 2: " + p2Score);
            // rollDice();
            extraTurn = true;
            if (p1Turn) {
                p1RolledTwoSixes = false;
            } else {
                p2RolledTwoSixes = false;
            }
            checkWinner();
        }

    }

    public void checkWinner() {

        if (getP1Score() >= 40 && (p1Turn)) {
            System.out.println("Player 1 wins the game!");
            System.out.println("Press enter to exit game");
            scan.close();
            System.exit(0);
        }
        if (getP2Score() >= 40 && (!p1Turn)) {
            System.out.println("Player 2 wins the game!");
            ;
            System.out.println("Press enter to exit game");
            scan.close();
            System.exit(0);
        }
    }

    public boolean getExtraTurn() {
        return extraTurn;
    }

    public int getD1() {
        return d1;
    }

    public int getD2() {
        return d2;
    }

    public int getSum() {
        return sum;
    }

    public int getP1Score() {
        return p1Score;
    }

    public int getP2Score() {
        return p2Score;
    }

    public static void main(String[] args) {
        DiceRoll diceRoll = new DiceRoll();
        diceRoll.scan = new Scanner(System.in);

        System.out.println("DiceGame" + "\n" + "Press enter to play");

        while (true) {
            diceRoll.scan.nextLine();

            diceRoll.rollDice();

            System.out.println("First dice: " + diceRoll.getD1());
            System.out.println("Second dice: " + diceRoll.getD2());
            System.out.println("Sum of the 2 die: " + diceRoll.getSum());

            if (DiceRoll.p1Turn) {
                System.out.println("Total score - Player 1: " + diceRoll.getP1Score());
                p1Turn = false;
            } else {
                System.out.println("Total score - Player 2: " + diceRoll.getP2Score());
                p1Turn = true;
            }

        }
    }
}