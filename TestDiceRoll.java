



public class TestDiceRoll {
    private DiceRoll diceRoll = new DiceRoll();

    public void testTwoSixsInARow() {
        diceRoll.calculate(6, 6);
        diceRoll.calculate(5, 6);
        diceRoll.calculate(4, 5);
        diceRoll.calculate(6, 6);
    }

    public void testTwoOnes() {
        diceRoll.calculate(1, 1);
    }

    public void testTwoTwos() {
        diceRoll.calculate(2, 2);
        if (diceRoll.getExtraTurn()) {
            diceRoll.calculate(01, 2);
        }
        if (diceRoll.getP1Score() != 7) {

            System.out.println("logik er forkert svaret skal være 7");
        } else {
            System.out.println("logik er korrekt");
        }
    }

    public static void main(String[] args) {
        var test = new TestDiceRoll();
        test.testTwoSixsInARow();
        // test.testTwoOnes();
        // test.testTwoTwos();
    }
}
