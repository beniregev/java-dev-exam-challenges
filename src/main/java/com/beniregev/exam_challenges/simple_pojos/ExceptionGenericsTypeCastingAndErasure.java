package com.beniregev.exam_challenges.simple_pojos;

import java.sql.SQLException;

/**
 * <div>
 *     <h1></h1>
 *     <p>
 *         What would be the result of running the following code, and why?
 *         a. Compilation fails because no SQLException is thrown.
 *         b. Throws ClassCastException because SQLException is not instance of RuntimeException.
 *         c. No problem, the program prints the stacktrace of newly thrown SQLException.
 *         d. Compilation fails because we can not cast SQLException to RuntimeException.
 *     </p>
 *     <p>
 *         <p>
 *             This is a difficult challenge. To solve the challenge you should have knowledge
 *             about {@code Exception} hierarchy, Java Generics, Type Casting, Type Erasure.
 *             Let’s note down our observations —
 *         </p>
 *         <pre>
 *             Object
 *                +- Throwable
 *                     +- Error
 *                          +- VirtualMachineError
 *                          +- AssertionError
 *                     +- Exception
 *                          +- I/O Exception
 *                          +- SQL Exception
 *                          +- Runtime Exception
 *                               +- ArithmeticException
 *                               +- NullPointerException
 *                               +- NumberFormatException
 *
 *         </pre>
 *         <h6>
 *             <a href="http://testingpool.com/what-is-exception-handling-in-java/">
 *                 What is {@code Exception} handling in Java
 *             </a>
 *         </h6>
 *         <p>
 *             <ol>
 *                 <li>RuntimeException and SQLException both inherit from Exception, while RuntimeException is unchecked and SQLException is a checked exception.</p></li>
 *                 <li>Java generics are not reified, meaning that in compile-time, the generic type information is “lost” and treated as if the code is replaced with the type’s bound or with Object if it doesn't exist. This is what you call type erasure.</li>
 *             </ol>
 *         </p>
 *         <p>
 *             <p>
 *                 Naively we’d expect line 5 to cause a compilation error since you can’t cast SQLException to RuntimeException, but that’s not the case. What happens is that T is replaced with Exception so we have:
 *             </p>
 *             <pre>
 *                 <code>
 *                     throw (Exception) t;  // t is also an Exception
 *                 </code>
 *             </pre>
 *         </p>
 *         <p>
 *             <p>
 *                 Since {@code pleaseThrow} expects an {@code Exception}, and {@code T} is replaced with
 *                 {@code Exception}, the cast is eliminated as if it wasn't written. Now that we’re convinced
 *                 there’s no casting involved, we can scratch off 2nd and 4th options: —
 *             </p>
 *             <p>
 *                 <ol>
 *                     <li>
 *                         1. Compilation fails because we cannot cast SQLException to {@code RuntimeException}.
 *                     </li>
 *                     <li>
 *                         2. Throws {@code ClassCastException} because {@code SQLException} is not {@code instanceof}
 *                         {@code RuntimeException}
 *                     </li>
 *                 </ol>
 *             </p>
 *         </p>
 *         <p>
 *             <strong>
 *                 So we throw a {@code SQLException} after all, and you’d expect it to get caught by the catch
 *                 block and get its stack trace. Well, not really. This game is rigged. Turns out the compiler
 *                 gets confused just as we do, because compiler is also expecting {@code RuntimeException} because of —
 *             </strong>
 *         </p>
 *         <p>
 *             <code>
 *                 new JavaChallenge34<RuntimeException>()
 *             </code>
 *         </p>
 *     </p>
 *     <p>
 *         <p>
 *            <p>
 *                but compiler does not know that {@code T} has been converted to {@code Exception} so if any
 *                exception can be thrown; thus the code makes it think that the catch block is unreachable. The
 *                correct answer is that compilation fails because the compiler doesn't expect a {@code SQLException}
 *                to be thrown from the try block — When in fact it does get thrown!
 *            </p>
 *            <p>
 *                To see exactly what’s wrong here and how the {@code SQLException} actually gets thrown is to replace
 *                the catch block and make it expect a {@code RuntimeException} instead like —
 *            </p>
 *            <pre>
 *                <code>
 *          public class JavaChallenge34<T extends Exception> {
 *              private void pleaseThrow(final Exception t) throws T{
 *                  throw (T) t;
 *              }
 *
 *              public static void main(String[] args) {
 *                  try {
 *                      new JavaChallenge34<RuntimeException>().pleaseThrow(new SQLException());
 *                  } catch (final RuntimeException e){
 *                      e.printStackTrace();
 *                  }
 *              }
 *          }
 *                </code>
 *            </pre>
 *         </p>
 *         <p>
 *             <p>
 *                 This way you’ll see the actual stack trace of the SQLException which is —
 *             </p>
 *             <pre>
 *                 <code>
 *          Exception in thread "main" java.sql.SQLException
 *           at java_challenge.JavaChallenge34.main(JavaChallenge34.java:12)
 *                 </code>
 *             </pre>
 *         </p>
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 * @param <T>
 */
public class ExceptionGenericsTypeCastingAndErasure<T extends Exception> {
    private void pleaseThrow(final Exception t) throws T {
        throw (T) t;
    }

    public static void main(String[] args) {
        //try {
        //    new ExceptionGenericsTypeCastingAndErasure<RuntimeException>().pleaseThrow(new SQLException());
        //} catch (final SQLException e){
        //    e.printStackTrace();
        //}

        //  region What would be the result of running the code?
        try {
            new ExceptionGenericsTypeCastingAndErasure<RuntimeException>().pleaseThrow(new SQLException());
        } catch (final RuntimeException e){
            e.printStackTrace();
        }
        //  endregion

    }

    //  region What would be the result of running the code?
    private void pleaseThrowSolution(final Exception t) throws T {
        throw (T) t;
    }
    //  endregion
}
