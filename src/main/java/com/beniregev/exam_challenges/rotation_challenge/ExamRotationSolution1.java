package com.beniregev.exam_challenges.rotation_challenge;

import java.util.LinkedList;
import java.util.List;

/**
 * <div>
 *     <p>
 *         We have a series of elements (e.g. numbers) that are stored
 *         in a sort order of some kind. The order of the elements and
 *         data-structure that stores them is at your discretion - you
 *         decide.
 *     </p>
 *     <p>
 *         <b>for example,</b> the elements are numbers <em>1, 2, 3, 4, 5, 6</em>
 *     </p>
 *     <p>
 *         <h4>Your challenge, should you agree to accept it, is to:</h4>
 *         <p>
 *             1. Create a class in Java to initialize the storage and the
 *             elements in it.
 *         </p>
 *         <p>
 *             <div>
 *                 2. Write a method to do a shift, i.e. to take the
 *                 last element and make it the first element.
 *             </div>
 *             <div>
 *                 In our example above: I take the "6" and put it
 *                 at the start of the series of elements. After the
 *                 rotating it will look like this: <em>6, 1, 2, 3, 4, 5</em>
 *             </div>
 *         </p>
 *         <p>
 *             <div>
 *                 3. Write a method that receives as a parameter
 *                 a positive integer "n" that is the number of
 *                 rotations.
 *             </div>
 *             <div>
 *                 <b>Note:</b> the number "n" can be bigger than
 *                 the number of elements in the storage.
 *             </div>
 *             <div>The original/start order in all examples is: <em>1, 2, 3, 4, 5, 6</em></div>
 *             <p>
 *                 <div><b>example #1:</b> I call the method with the number 3</div>
 *                 <div>After the method finishes, the new order is <em>4, 5, 6, 1, 2, 3</em></div>
 *             </p>
 *             <p>
 *                 <div><b>Example #2:</b> I call the method with the number 14</div>
 *                 <div>After the method finishes, the new order is <em>5, 6, 1, 2, 3, 4</em></div>
 *             </p>
 *         </p>
 *         <p>
 *             4. What is the complexity of your code?
 *         </p>
 *         <p>
 *             5. Can you think of a more efficient way?
 *         </p>
 *         <p>
 *             6. Do you know other ways to solve this challenge?
 *         </p>
 *      </p>
 * </div>
 * @author binyamin.regev
 */
public class ExamRotationSolution1 {

    private List<Integer> rotate(List<Integer> list) {
        int num  = ((LinkedList<Integer>) list).getLast();
        list.remove(list.size()-1);
        ((LinkedList<Integer>) list).addFirst(num);
        return list;
    }

    public List<Integer> doRotations(List<Integer> list, int numberOfRotations) {
        if ((list.size() < 1) ||  (numberOfRotations < 1))
            return list;
        int steps = numberOfRotations%list.size();
        for (int i=0; i<steps; i++)
            list = this.rotate(list);
        return list;
    }

    public static void main(String[] args) {
        ExamRotationSolution1 exam = new ExamRotationSolution1();
        List<Integer> series = new LinkedList<>();
        series.add(1);
        series.add(2);
        series.add(3);
        series.add(4);
        series.add(5);
        series.add(6);

        System.out.print("The original order: ");
        series.forEach(x -> System.out.print(x + "  "));
        System.out.println();

        series = exam.rotate(series);
        System.out.print("After one rotations: ");
        series.forEach(x -> System.out.print(x + "  "));
        System.out.println();

        int numberOfRotations = 27;
        series = exam.doRotations(series,numberOfRotations);
        System.out.print("After additional " + numberOfRotations + " rotations: ");
        series.forEach(x -> System.out.print(x + "  "));
        System.out.println();

    }
}
