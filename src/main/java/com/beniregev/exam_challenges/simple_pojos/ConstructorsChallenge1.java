package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h3>What will be the result of running the following code?</h3>
 *     <p>
 *         <ol>1. (0.0 + 0.0i)</ol>
 *         <ol>2. Compile time error</ol>
 *         <ol>3. Run time error</ol>
 *         <ol>4. Nothing will be printed</ol>
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class ConstructorsChallenge1 {
    private double re, im;
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
    ConstructorsChallenge1(ConstructorsChallenge1 jc23) {
        re = jc23.re;
        im = jc23.im;
    }

    /**
     * <div>
     *     <p>It’s a quite simple challenge but, just want you to remind core concepts.</p>
     *     <p>
     *         If you observe the challenge closely, you will notice things like-
     *         <ol>
     *             <li>1. There is no default constructor.</li>
     *             <li>2. Not providing any values to parameters such as re and im .So what’s the default value of these fields?</li>
     *             <li>3. Parameters are primitive so the value be 0.0 not {@code null}.</li>
     *             <li>4. {@code toString()} method is overridden so it will not return objectId instead it will return the constructed value.</li>
     *             <li>5. There is a constructor which consumes the same type of object.</li>
     *         </ol>
     *     </p>
     *     <p>
     *         <div>What else??? I think a couple of more observations-</div>
     *         <div>While instantiating the object in the first case we are not providing any value/object but in the second case we are providing the first object {@code jc23_1}.</div>
     *         <div>But!!!</div>
     *         <div><strong>Do you think, are we missing anything or something wrong here?</strong></div>
     *         <div><strong><i>I think, YES!</i></strong></div>
     *         <div>If you remember the core concepts- <strong>If you are specifying any constructor so the compiler will not create the default constructor(Without any parameters) for the class.</strong></div>
     *     </p>
     *     <p>
     *         <div>That means, there is no default constructor hence the first instantiation will fail and throw a compile-time error. So the culprit is-</div>
     *         <p>
     *             <pre>
     *                 <code>
     *         JavaChallenge23 jc23_1 = new JavaChallenge23();
     *                 </code>
     *             </pre>
     *         </p>
     *     </p>
     * </div>
     * @param args arguments received from running the method, or the {@code JAR} file from command-line.
     */
    public static void main(String[] args) {
        //ConstructorsChallenge jc23_1 = new ConstructorsChallenge();
        //ConstructorsChallenge jc23_2 = new ConstructorsChallenge(jc23_1);
        //System.out.println(jc23_2);
    }
}
