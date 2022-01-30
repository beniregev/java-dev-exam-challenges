package com.beniregev.exam_challenges.permutation_challenge;

import java.util.*;

/**
 * <div>
 *     <p>
 *         Write a method {@code isPermutation} that receives 2 strings
 *         as parameters and returns whether they are permutations of
 *         each other.
 *     </p>
 *     <p>
 *         <b>Bonus: </b> Write a method that receives a list of
 *         {@code Strings} and returns a list of {@code Strings} and
 *         their permutations.
 *     </p>
 * </div>
 * @author binyamin.regev
 */
public class ExamPermutationSolution1 {

    private Map<Character, Integer> stringToMap(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        return map;
    }

    /**
     * Check is 2 Strings received as parameters are permutations of each other.
     * @param str1 First {@link String} to compare.
     * @param str2 Second {@link String} to compare.
     * @return {@link Boolean}, {@code true} if the strings are permutations, otherwise {@code false}.
     */
    public boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        Map<Character, Integer> map1 = this.stringToMap(str1);
        Map<Character, Integer> map2 = this.stringToMap(str2);
        return map1.equals(map2);
    }

    /**
     * <div>
     *     <p>
     *         <h3>Bonus Question</h3>
     *         <p>
     *             Write a method that receives a list of {@code Strings} and
     *             returns a list of {@code Strings} and their permutations.
     *         </p>
     *     </p>
     *     <p>
     *         <h3>Solution</h3>
     *         <p>
     *             <p>Loop over the {@link List}, for each {@link String} element:</p>
     *             <p>1. Convert the {@link String} to it's signature.</p>
     *             <p>
     *                 2. If the signature exists in the {@code resultMap} then
     *                 <div>Add it to the {@link List} of the appropriate key </div>
     *                 <div>Otherwise, </div>
     *                 <div>
     *                     Add the signature as a new key in the {@code resultMap} and the
     *                     {@link String} as the first element in its {@link List} of strings.
     *                 </div>
     *             </p>
     *         </p>
     *     </p>
     * </div>
     * @param listStrings {@link List} of strings to be compared as permutations.
     * @return {@link Map}, each element's key is the signature of the all the strings in the strings {@link List} in its value.
     */
    public Map<Map<Character, Integer>, ArrayList<String>> allPermutations(List<String> listStrings) {
        Map<Map<Character, Integer>, ArrayList<String>> resultMap = new HashMap<>();
        for (String str1 : listStrings) {
            Map<Character, Integer> signature1 = this.stringToMap(str1);
            ArrayList<String> listOfStrings = resultMap.get(signature1);
            if (listOfStrings != null) {
                listOfStrings.add(str1);
                resultMap.put(signature1, listOfStrings);
            } else {
                resultMap.put(signature1, new ArrayList<>(Arrays.asList(str1)));
            }
        }
        return resultMap;
    }

    public static void main(String[] args) {
        ExamPermutationSolution1 exam = new ExamPermutationSolution1();
        System.out.println("Is permutation? " + exam.isPermutation("abc", "abc1"));      //  False. Strings are NOT permutations, length is different.
        System.out.println("Is permutation? " + exam.isPermutation("Abca", "abAc"));     //  True. Strings are permutations
        System.out.println("Is permutation? " + exam.isPermutation("Abca", "abac"));     //  False. Strings are NOT permutations
        System.out.println("Is permutation? " + exam.isPermutation("AbCccA", "AcAcbC")); //  True. Strings are permutations

        ArrayList<String> list = new ArrayList<>(Arrays.asList("abc", "abc1", "Abca", "bAca", "Abca", "abac", "bcAa", "AbCccA", "AcAcbC", "abAc", "AbCAcc"));
        Map<Map<Character, Integer>, ArrayList<String>> resultMap = exam.allPermutations(list);
        System.out.println("Result is: " + ((resultMap == null) ? "null" : resultMap));
        //  Output format:
        //      {string-signature} = [ list-of-Strings ]
        //  {
        //      {a=1, b=1, c=1}=[abc],
        //      {a=1, 1=1, b=1, c=1}=[abc1],
        //      {A=1, a=1, b=1, c=1}=[Abca, bAca, Abca, bcAa, abAc],
        //      {a=2, b=1, c=1}=[abac],
        //      {A=2, b=1, C=1, c=2}=[AbCccA, AcAcbC, AbCAcc]
        //  }
    }
}
