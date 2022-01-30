package com.beniregev.exam_challenges.simple_pojos;

/**
 * Print all combination for placing 20 identical balls in 10 cells
 * -------------------------------------------------
 * 20 0 0 0 0 0 0 0 0 0
 * 19 1 0 0 0 0 0 0 0 0
 * 19 0 1 0 0 0 0 0 0 0
 * ...
 * 0 0 0 10 0 2 0 0 8 0
 * ...
 * 0 0 0 0 0 0 0 0 0 20
 * -------------------------------------------------
 * sub-case: 20 balls in 2 cells
 * -------------------------------------------------
 * 20  0
 * 19  1
 * 18  2
 * 17  3
 * 10 10
 * ...
 *  0 20
 * -------------------------------------------------
 * sub-case: 20 balls in 3 cells
 * -------------------------------------------------
 * 20 0 0
 * 19 1 0
 * 19 0 1
 * 18 2 0
 * 18 0 2
 * 18 1 1
 * -------------------------------------------------
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class AllCombinationsOfBallsInCells {
    //  TODO - Benny Regev - Finish the algorithm
    public void solve(final int balls, final int cells) {
        if (cells == 1) {
            System.out.println(balls);
            return;
        } else {
            for (int i = balls; i > 0; i--) {
                System.out.print(i + "  ");
                solve(balls - i, cells - 1);
            }
            return;
        }
    }

    public static void main(String[] args) {
        AllCombinationsOfBallsInCells challenge = new AllCombinationsOfBallsInCells();
        challenge.solve(20, 10);

    }
}
