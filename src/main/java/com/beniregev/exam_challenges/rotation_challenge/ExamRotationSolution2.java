package com.beniregev.exam_challenges.rotation_challenge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExamRotationSolution2 {

    /**
     * For this method you will write an algorithm to rotate the {@link List} of
     * {@link Integer}s {@code steps} times using <b>ANY</b> of the new
     * features of Java 8, e.g. lambdas, streams, Optionals, etc.
     * NOTE: value of steps can be bigger than the list size.
     *
     * @param steps   Number of steps to rotate {@code intList}
     * @param intList the {@link List} of {@link Integer}s to rotate
     * @return List<Integer> new rotated {@link List} of {@link Integer}s.
     */
    public List<Integer> doRotationsUsingStreamApi(List<Integer> intList, int steps) {
        int numberOfSteps = steps % intList.size();
        if ((intList == null) || (intList.size() < 1) || (numberOfSteps < 1))
            return intList;

        System.out.println("\tCollection size is " + intList.size() +
                ", the requested number of steps is " + steps +
                ", thus the number of rotations will be " + numberOfSteps);

        //  From the item we start with to the end of the List
        List<Integer> resultList = intList.stream()
                .skip(intList.size() - numberOfSteps)
                .collect(Collectors.toList());
        System.out.print("\tResult of .skip(" + (intList.size() - numberOfSteps) + "): ");
        resultList.forEach(num -> System.out.print(num + "  "));
        System.out.println();

        System.out.print("\tResult of .limit(" + (intList.size() - numberOfSteps) + "): ");
        intList.stream()
                .limit(intList.size() - numberOfSteps)
                .forEach(x -> System.out.print(x + "  "));
        System.out.println();

        //  Add the numbers from 0 to the item before the one we started from to the end of the result list
        resultList.addAll(intList.stream()
                .limit(intList.size() - numberOfSteps)
                .collect(Collectors.toList()));
        return resultList;
    }

    public static void main(String[] args) {
        ExamRotationSolution2 exam = new ExamRotationSolution2();
        List<Integer> listIntegers = IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toList());

        System.out.print("The series in original order: ");
        listIntegers.forEach(num -> System.out.print(num + "  "));
        System.out.println();

        int numberOfRotations = 29;
        listIntegers = exam.doRotationsUsingStreamApi(listIntegers,numberOfRotations);

        System.out.print("The series after " + numberOfRotations + " rotations: ");
        listIntegers.forEach(num -> System.out.print(num + "  "));
        System.out.println();

    }
}
