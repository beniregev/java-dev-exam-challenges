package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h1>Try-Finally Challenge</h1>
 *     <p>
 *         1. What would be the output result of the following code, and why?
 *            a. true
 *            b. false
 *            c. Ambiguities
 *            d. Compilation Error
 *            Please explain your answer
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class ExamTryFinally {
    /**
     * <div>
     *     <h1></h1>
     *     <p></p>
     *     <p></p>
     * </div>
     * @param args arguments for running as a Java application
     */
    public static void main(String[] args) {
        System.out.println(ret());
    }

    public static boolean ret(){
        try {
            return true;
        } finally {
            return false;
        }
    }

}
