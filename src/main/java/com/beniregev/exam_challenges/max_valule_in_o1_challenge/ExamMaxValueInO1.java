package com.beniregev.exam_challenges.max_valule_in_o1_challenge;

/**
 * <div>
 *     <p>
 *         <div>
 *             We are getting a series of command to add
 *             and remove values to a sequence that we
 *             have and store.
 *         </div>
 *         <div>
 *             At any point I want to call a method that
 *             will return the maximum number in the sequence
 *             to that point and its location in the sequence.
 *             The method must work in O(1) complexity, and be
 *             performance and memory efficient.
 *         </div>
 *     </p>
 *     <div>
 *         <p>
 *             <ol>
 *                 <h4>Your assignment, if you should decide to accept it: </h4>
 *                 <li>1. Choose your data-structure to store the sequence of numbers. </li>
 *                 <li>2. Write a method to add a value to the sequence. </li>
 *                 <li>3. Write a method to remove a value from the sequence. </li>
 *                 <li>4. Write a method to get the number of numbers in the sequence so far. </li>
 *                 <li>5. Write a method to get the maximum number and its location in the sequence. </li>
 *                 <li>6. Write additional methods as you see fit. </li>
 *             </ol>
 *         </p>
 *     </div>
 * </div>
 * @author binyamin.regev
 */
public class ExamMaxValueInO1 {

    //  Add your definitions:
    //  * The data-structure to store the sequence
    //  * Additional properties you require.

    public static void main(String[] args) {
        ExamMaxValueInO1 exam = new ExamMaxValueInO1();

        //  An example series of commands to add and remove numbers,
        //  query the number of numbers in the sequence and print
        //  the maximum number in the sequence and its location in
        //  various points of the series.
        exam.add();
        exam.add();
        exam.add();
        exam.add();
        exam.add();
        exam.add();
        exam.add();
        exam.add();
        exam.add();
        exam.count();
        exam.printMaximumNumberAndLocation();
        exam.remove();
        exam.remove();
        exam.count();
        exam.printMaximumNumberAndLocation();
        exam.remove();
        exam.remove();
        exam.count();
        exam.printMaximumNumberAndLocation();
        exam.add();
        exam.add();
        exam.add();
        exam.count();
        exam.printMaximumNumberAndLocation();
    }

    /**
     * <div>
     *     <p>This method to add a number to the sequence.</p>
     *     <p>You can change the signature of this method.</p>
     * </div>
     */
    public void add() {

    }

    /**
     * <div>
     *     <p>This method to remove a number from the sequence.</p>
     *     <p>You can change the signature of this method.</p>
     * </div>
     */
    public void remove() {

    }

    /**
     * <div>
     *     <p>
     *         This method prints the number of numbers currently in the sequence.
     *     </p>
     *     <p>
     *         You <b>CANNOT</b> change the signature of this method,
     *         but you <b>CAN</b> change the code in the method.
     *     </p>
     * </div>
     */
    public void count() {
        System.out.println("There are {count} numbers in the sequence.");
    }

    /**
     * <div>
     *     <p>This method prints the current maximum number in the sequence and its location. </p>
     *     <p>You <b>CANNOT</b> change the signature of this method, but you <b>CAN</b> change the code in the method. </p>
     * </div>
     */
    public void printMaximumNumberAndLocation() {
        System.out.println("The maximum number is {max-number}, located in index {position} of the sequence.");
    }
}
