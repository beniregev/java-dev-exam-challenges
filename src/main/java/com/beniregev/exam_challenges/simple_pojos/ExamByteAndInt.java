package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h1>Byte And Int Challenge</h1>
 *     <p>
 *         What would be the result of the following code, and why?
 *         a. 4
 *         b. 3
 *         c. Compilation Error
 *         d. 2
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class ExamByteAndInt {
    public void theChallenge() {
//        byte b= 1;
//        b++;
//        b+=1;
//        b = b+1;
//        System.out.println(b);
    }

    public void theSolution() {
        byte b= 1;
        b++;
        b+=1;
        //b = b + 1;
        System.out.println(b);
    }

    /**
     * <div>
     *     <h1>The correct answer: </h1>
     *     <p>
     *         When you will compile the above code snippet, you will get —
     *     </p>
     *     <pre>
     *         <code>
     *         incompatible type: possibly lossy conversion from int to byte at line 6
     *         </code>
     *     </pre>
     *     <p>
     *         <h3>So, how b++ and b+=1 is getting compiled successfully?</h3>
     *         <p>Let’s remove line 4 in {@code theChallenge} method — </p>
     *     </p>
     *     <pre>
     *         <code>
     *         public class JavaChallenge37 {
     *             public static void main(String[] args) {
     *                 byte b= 1;
     *                 b++;
     *                 b+=1;
     *                 //b = b + 1;
     *                 System.out.println(b);
     *             }
     *         }
     *         </code>
     *     </pre>
     *     <p>After compiling the above code —</p>
     *     <pre>
     *         <code>
     *         public class JavaChallenge37 {
     *             public JavaChallenge37() {
     *             }
     *
     *             public static void main(String[] args) {
     *                 byte b = 1;
     *                 byte b = (byte)(b + 1);
     *                 ++b;
     *                 System.out.println(b);
     *             }
     *         }
     *         </code>
     *     </pre>
     *     <p>
     *         <p>If we observe the above JavaChallenge37.java file you will notice —</p>
     *         <p>
     *             <ol>
     *                 <li>Default constructor has been added.</li>
     *                 <li>
     *                     <code>b++</code> has been converted to <code>byte b = (byte)(b+1)</code>
     *                     which concludes that implicit casting is happening after summing up
     *                     <code>b+1</code>.
     *                 </li>
     *                 <li>
     *                     <code>b+=1</code> is converted to <code>++b</code> which is same as
     *                     <code>byte b = (byte)(b+1)</code>. You can verify this by compiling
     *                     <code>byte b = (byte)(b+1)</code> which will convert to <code>++b</code> .
     *                 </li>
     *             </ol>
     *             <p>
     *                 The problem in the <code>b = b + 1</code> statement is, here implicit cast can
     *                 not happen because compiler is not pre-performing any action so it will directly
     *                 get compiled.
     *             </p>
     *         </p>
     *     </p>
     * </div>
     * @param args arguments for running as a Java application
     */
    public static void main(String[] args) {
        ExamByteAndInt challenge = new ExamByteAndInt();
        challenge.theChallenge();

        //  region what will be the result of running the code?
        challenge.theSolution();
        //  endregion
    }

}
