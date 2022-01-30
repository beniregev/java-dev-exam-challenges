package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <p>
 *         What would be the result of running the following code, and why?
 *         <ol>
 *             <li>NullPointerException</li>
 *             <li>Got Challenged</li>
 *         </ol>
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class StaticMethodChallenge {
    /**
     * <div>
     *     <p>
     *         Many would say, it’s {@code NullPointerException}. But it’s not. It
     *         will print “Got Challenged”. But why, how? We are accessing a {@code null}
     *         object, it should throw NullPointerException, but it’s not throwing.
     *         Here is the catch-
     *     </p>
     *     <p>
     *         <strong>
     *             Test Class has a static method. So when you call any static method,
     *             it does not check for object reference instead it’s class reference,
     *             so the call will be successful.
     *         </strong>
     *     </p>
     * </div>
     * @param args {@link String} array of arguments from command-line interface (CLI)
     */
    public static void main(String[] args) {
        execute(null);
    }
    public static void execute(Challenge ch) {
        ch.print();
    }
}

class Challenge{
    public static void print() {
        System.out.println("Got Challenged");
    }
}
