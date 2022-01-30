package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h1>Does -0.00 == 0.00 Challenge</h1>
 *     <h3>i.e. Minus-Zero Equals Zero ?</h3>
 *     <p>
 *         What would be the result of running the following code, and why?
 *         a. Compile-time exception
 *         b. Runtime exception
 *         c. True, will print the text "Got Challenged!"
 *         d. False, will print the text "Already knew"
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class DoesMinusZeroEqualsZero {
    /**
     * <div>
     *     <h1>The correct answer is:</h1>
     *     <p>
     *         <p>Looks pretty simple, but did you know it already? The answer is —</p>
     *         <p><code>Got Challenged!</code></p>
     *     </p>
     *     <p>
     *         <p>Yes, it’s not <code>Already knew</code>. Not only this, but the following are also true —</p>
     *         <p>
     *             <ol>
     *                 <li>-0==0.0</li>
     *                 <li>-0==0</li>
     *                 <li>-0==0.0D</li>
     *                 <li>-0==0.0f</li>
     *                 <li>0==0.0f</li>
     *                 <li>0==0.0D</li>
     *                 <li>0==0.0</li>
     *                 <li>0.0D==0.0f</li>
     *             </ol>
     *         </p>
     *     </p>
     *     <p>
     *         <h3>But how? How 0, 0.0, -0.0,-0, 0.0D, 0.0f are stored in memory?</h3>
     *         <p>If the above mentioned are true that means all are pointing to the same value which means 0=-0=0.0=-0.0=0.0D=0.0f.</p>
     *         <p>Let’s find out the answer to how?</p>
     *         <p>We know that decimal values are stored in binary format in memory, so let’s find out the binary values of 0 and -0 considering the 8bits machine.</p>
     *         <pre>
     *             <code>
     *             0 = 0000 0000
     *             To get the two's complement of a negative binary number, the <a href="https://en.wikipedia.org/wiki/Bit">bits</a> are inverted, or "flipped", by using the <a href="https://en.wikipedia.org/wiki/Bitwise_operation#NOT">bitwise NOT</a> operation; the value of 1 is then added to the resulting value, ignoring the overflow which occurs when taking the two's complement of 0.
     *             -0 = 1111 1111 (Bits of 0 are inverted) + 1 = 0000 0000 (Ignored the overflow). That means 0=-0.
     *             </code>
     *         </pre>
     *         <p>
     *             Reference —
     *             <a href="https://en.wikipedia.org/wiki/Two's_complement">
     *                 https://en.wikipedia.org/wiki/Two's_complement
     *             </a> and
     *             <a href="https://www.log2base2.com/number-system/binary-number-system.html">
     *                 Binary Number System
     *             </a>.
     *         </p>
     *         <p>Let’s find out how to write a floating-point number in binary —</p>
     *         <p>
     *             <pre>
     *                 Let’s take an example 4.25 Where, 4 is an integral part and 0.25 is a fractional part.
     *                 To convert an integral part into binary, just follow the previously discussed method. Using that method, we can represent 4 as (100)
     *                 Fractional part (0.25) - To convert the fractional part to binary, multiply fractional part with 2 and take the one bit which appears before the decimal point. Follow the same procedure with after the decimal point (.) part until it becomes 1.0.
     *                 Like,
     *                 <code>
     *                     0.25 * 2 =0.50 //take 0 and move 0.50 to next step
     *                     0.50 * 2 =1.00 //take 1 and stop the process
     *                     0.25 = (01) 2
     *                     So, 4.25(Floating point number) = 100.01(Binary number)
     *                 </code>
     *             </pre>
     *         </p>
     *         <p>
     *             Reference —
     *             <a href="http://cstl-csm.semo.edu/xzhang/Class%20Folder/CS280/Workbook_HTML/FLOATING_tut.htm">
     *                 http://cstl-csm.semo.edu/xzhang/Class%20Folder/CS280/Workbook_HTML/FLOATING_tut.htm
     *             </a>.     *
     *         </p>
     *     </p>
     * </div>
     * @param args arguments for running as a Java application
     */
    public static void main(String[] args) {
        if(-0.0==0.0){
            System.out.println("Got Challenged!");
        } else {
            System.out.println("Already knew");
        }
    }
}
