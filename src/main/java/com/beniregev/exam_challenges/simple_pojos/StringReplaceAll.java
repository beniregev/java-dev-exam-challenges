package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h1></h1>
 *     <p>
 *         <p>What would be the result of running the following code, and why?</p>
 *         <p>
 *             <h3></h3>
 *             <p>
 *                 Most of you might have got the answer correct. For those who did not get it, It's a
 *                 code that will print {@code Java Challenge} 1000 times without using any loop/recursion
 *                 but {@code replaceAll} method is using loop only internally. If we count the total number
 *                 of execution here, it will be —
 *             </p>
 *             <pre>
 *                 <code>
 *             first replace statement - 1
 *             second replace statement - 10
 *             third replace statement - 100
 *             fourth replace statement - 1000
 *                 </code>
 *             </pre>
 *             <p>
 *                 So the counter count is 1111 in this case but if you try to print anything 1000 times
 *                 with any loop so that will have 1000 counters only.
 *             </p>
 *             <p>
 *                 Thanks. Let me know if you know any other way to print anything 1000 times without
 *                 using a loop/recursion.
 *             </p>
 *         </p>
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class StringReplaceAll {
    public static void main(String[] args) {
        String name = "Java Challenge";
        String test = "i";
        test = test.replaceAll("i","iiiiiiiiii");
        test = test.replaceAll("i","iiiiiiiiii");
        test = test.replaceAll("i","iiiiiiiiii");
        test = test.replaceAll("i",name + "\n");
        System.out.println(test);
    }
}
