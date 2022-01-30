package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h1>Conditional-Expression Using ? Operator Challenge</h1>
 *     <p>
 *         What would be the result of the following code, and why?
 *         a. Compilation will fail because primitive(int) type can not be null.
 *         b. It will throw NullPointerException.
 *         c. 0
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class ExamConditionalExpressionUsingQuestionMarkOperator {
    private static int temp() {
        return (true ? null : 0);
    }

    /**
     * <div>
     *     <h1>The correct answer</h1>
     *     <p>
     *         This seems a pretty simple challenge, the compilation
     *         should fail because primitive type data can not be <code>null</code>
     *         because the ternary operator will fall to <code>null</code>
     *         case and <code>temp()</code> method will return <code>null</code>
     *         but <code>int</code> can not hold nor return <code>null</code>; but
     *         that’s not the case, the compilation will happen gracefully.
     *     </p>
     *     <p>
     *         This code is compiled because the compiler interprets {@code null}
     *         as a legal value of Integer and then performs autoboxing/unboxing,
     *         i.e. calls {@code intValue()} of Integer object that contains {@code null}.
     *         This will generate a {@code NullPointerException} at runtime, which you can
     *         confirm by trying it.
     *     </p>
     *     <p>
     *
     *         Its all explained in the
     *             <a href="https://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.25-300-A">
     *                 Java Language Specification
     *             </a>.
     *             font-family: fell, Georgia, Cambria, "Times New Roman", Times, serif;
     *             font-style: italic;
     *             font-weight: 400;
     *             font-size: 21px;
     *             color: rgba(248, 234, 234, 1);
     *             <span>The type of a conditional expression is determined as follows:</span> —
     *         <pre>
     *             <span>
     *                 <em>
     *                 If the second and third operands have the same type
     *                 (which may be the null type), then that is the type
     *                 of the conditional expression.
     *                 </em>
     *             </span>
     *         </pre>
     *     </p>
     *     <p>
     *         Therefore the “null” in the return statement<code>(true ? null : 0)</code> 
     *         gets an int type and then is auto-boxed to Integer.
     *     </p>
     *     <p>
     *         Try something like this to verify this <code>(true ? null : null)</code> 
     *         and you will get the compiler error.
     *     </p>
     * </div>
     * @param args arguments for running as a Java application
     */
    public static void main(String[] args) {
        System.out.println(temp());
    }
}
