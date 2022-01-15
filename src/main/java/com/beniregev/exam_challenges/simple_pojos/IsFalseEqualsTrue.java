package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h1>Is Logical {@code false} equals {@code true} ?</h1>
 *     <p>
 *         What would be the result of running the following code, and why?
 *         a. Nothing will be printed.
 *         b. false is true
 *         c. Don't know.
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class IsFalseEqualsTrue {
    public static void main(String[] args) {
        if ( false == true ) { //You will be challenged: \u000a\u007d\u007b
            System.out.println("false is true!");
        }
    }
}
//  region What would be the result of running the following code, and why?
//    <h1>Explaining the source of the problem</h1>
//    <p>
//        <p>
//            What do you think guys, what will be the output? Can {@code false==true} be {@code true}?
//        </p>
//        <p>
//            Again a new tricky challenge that uses Unicode characters. It’s hard to find out the
//            behavior unless you know about those Unicode. Surprisingly, those Unicode are in the
//            comment section and still will have an impact.
//        </p>
//        <pre>
/*             \u000a\u007d\u007b */
//        </pre>
//        <p>
//            What are these Unicode?
//        </p>
//        <pre>
//            <code>
/*               \u000a = Line Feed
                 \u000d = Carriage Return
                 \u007d = }
                 \u007b = {                */
//            </code>
//        </pre>
//        <p>
//            The Java compiler parses Unicode escape sequences very early in the process. In
//            particular, it does this before stripping comments or checking for syntax. The
//            parser is actually parsing the following program: —
//        </p>
//        <pre>
//            <code>
//                public class JavaChallenge30 {
//                 public static void main(String[] args) {
//                     if ( false == true ) {
//                     }
//                     {
//                         System.out.println("false is true!");
//                     }
//                 }
//                }
//            </code>
//        </pre>
//        <p>
//            So, it will print {@code false} is {@code true} but guys notice here, it’s not because
//            of if statement returned {@code true}, that is still {@code false}.
//        </p>
//        <p>
//            <a href="https://en.wikipedia.org/wiki/List_of_Unicode_characters">
//                List of Unicode characters
//            </a>
//        </p>
//    </p>
//  endregion