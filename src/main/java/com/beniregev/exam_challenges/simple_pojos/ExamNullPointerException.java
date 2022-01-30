package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h1>NullPointerException Challenge</h1>
 *     <p>
 *         what will be the output result of running the following
 *         code of class {@link ExamNullPointerException}, and why?
 *         <br />
 *         a. Compile-time Error.
 *         b. At runtime a NullPointerException will be thrown.
 *         b. Code will run and output the text "nullJava Challenge".
 *         d. None of the above, specify what you think/know will be the result?
 *     </p>
 *     <p>Try to solve this challenge by yourself first</p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class ExamNullPointerException {
    /**
     * <div>
     *     <h1>The correct answer is: </h1>
     *     <p>
     *         Surprisingly, It will not throw NullPointerException
     *         instead it will print nullJava Challenge. This is
     *         because all the + operations are automatically compiled
     *         to StringBuilder flows so that a+b+c (where all variables
     *         are Strings) becomes:
     *     </p>
     *     <pre>
     *         <code>
     *     new StringBuilder().append(a).append(b).append(c).toString();
     *         </code>
     *     </pre>
     *     <p>
     *         The Java language provides special support for the string
     *         concatenation operator ( + ), and for conversion of other
     *         objects to strings. String concatenation is implemented
     *         through the StringBuilder(or StringBuffer) class and its
     *         append method.
     *     </p>
     *     <p>
     *         We can see from <code>StringBuilder.append(Object o)</code>'s
     *         Javadoc, that nulls are handled by printing <em>"null"</em>
     *         instead of throwing an exception.
     *     </p>
     * </div>
     *
     * @param args args for running as a Java application
     */
    public static void main(String[] args) {
        String s = null;
        System.out.println(s + "Java Challenge");
    }
}
