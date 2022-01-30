package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h1>Floating Point Math Challenge</h1>
 *     <p>
 *         What would be the output result of the following code, explain why?
 *         a. 1
 *         b. 0.9999999999999999
 *         c. 1.0000000000000001
 *         d. 0.9999999999999999D
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class ExamFloatingPointMath {
    /**
     * <div>
     *     <h1>The correct answer is: </h1>
     *     <p>
     *         The answer should be 1 but that’s not the case
     *         the answer is 0.9999999999999999 .
     *         Let’s see the bytecode
     *     </p>
     *     <pre>
     *         <code>
     *  public class JavaChallenge38 {
     *     public JavaChallenge38() {
     *     }
     *     public static void main(String[] args) {
     *         System.out.println(0.9999999999999999D);
     *     }
     *  }
     *         </code>
     *     </pre>
     *     <p>
     *         <div>So, at compile time only all 0.1 will be added, but it’s weird; so many of you will get a question —</div>
     *         <div>Is floating point math broken???</div>
     *         <div>Please go through the following links, it will help you to understand the entire concept —</div>
     *     </p>
     *     <p>
     *         <div>
     *             From <span>BetterProgramming.pub</span>&nbsp;-&nbsp;
     *         </div>
     *         <div>
     *             <span>
     *                 <a href="https://betterprogramming.pub/why-is-0-1-0-2-not-equal-to-0-3-in-most-programming-languages-99432310d476">
     *                     Why is 0.1 + 0.2 Not Equal to 0.3 in Most Programming Languages?
     *                 </a>
     *             </span>
     *         </div>
     *     </p>
     *     <p>
     *         <div>
     *             <span>stackoverflow.com</span>&nbsp;-&nbsp;
     *         </div>
     *         <div>
     *             <span>
     *                 <a href="https://stackoverflow.com/questions/588004/is-floating-point-math-broken">
     *                     Is floating point math broken?
     *                 </a>
     *             </span>
     *         </div>
     *     </p>
     *     <p>
     *         By the way, it is not restricted to only Java, it happens in Python too.
     *     </p>
     * </div>
     * @param args arguments for running as a Java application
     */
    public static void main(String[] args) {
        System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1);
    }
}
