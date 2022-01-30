package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h1></h1>
 *     <p>
 *         * What would be the result of running the following code, and why?
 *         * Do you see an error in the code, what is it?
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class MethodDifferentSignatures {
    public static void main(String[] args) {
        JavaChallenge33 javaChallenge33 = new JavaChallenge33();
        System.out.println(javaChallenge33.sum(20, 20));
        System.out.println(javaChallenge33.sum(10, 30));
        System.out.println(javaChallenge33.sum(20L, 10L));
        System.out.println(javaChallenge33.sum(30L, 30L));
    }
}

/**
 * <div>
 *     <p>
 *         <p>
 *             <h3>Explaining the problems and the correct solution</h3>
 *             <p>
 *                 Let’s note down the observations —
 *             </p>
 *             <p>
 *                 <ol>
 *                     <li>
 *                         There are method overloading. Does the method’s parameter sequence matter? Can we overload
 *                         the method with same parameters but in different sequence?
 *                     </li>
 *                     <li>
 *                         In both {@code sum} methods we are adding {@code int} and {@code long}, so can we add two
 *                         different types of data? Will type casting happen here?
 *                     </li>
 *                     <li>
 *                         What type of the data both {@code sum} methods will return? {@code long} or {@code int}?
 *                     </li>
 *                     <li>
 *                         Which method will be called from {@code javaChallenge.sum(20,20)} ? Is it creating a
 *                         situation of ambiguity?
 *                     </li>
 *                 </ol>
 *             </p>
 *             <p>
 *                 Let’s find out the solution of above observations —
 *             </p>
 *             <p>
 *                 Method overloading is allowed with different parameters sequence. In both {@code sum} methods
 *                 {@code int} type data will be casted to {@code long} then addition will happen and final
 *                 {@code sum} method will return {@code long}; that means both method should return {@code long}
 *                 type of data. All type casting and conversion happen at compile time only. Compiler will find
 *                 ambiguity while {@code javaChallenge.sum(20,20)} call because {@code int} can be casted to
 *                 {@code long} and compiler will get confused whether it should cast {@code int} to {@code long}
 *                 or not, if it’s casting then which {@code 20} should be casted to {@code long} to call the
 *                 {@code sum} method and which one it should call?
 *             </p>
 *             <p>
 *                 So when you will compile above code, you find following error —
 *             </p>
 *             <p>
 *                 <ol>
 *                     <li>Reference to sum is ambiguous.</li>
 *                     <li>Incompatible type: possible lossy conversion from {@code long} to {@code int}</li>
 *                 </ol>
 *             </p>
 *             <p>
 *                 Let’s mention here all “which happens when” —
 *             </p>
 *             <p>
 *                 <ul>
 *                     <li>
 *                         <strong>Type casting</strong> — <strong>Compile time</strong> but could not be caught and
 *                         throw {@code ClassCastException} (
 *                         <a href="https://www.baeldung.com/java-type-casting">
 *                             Java Type Casting
 *                         </a>).
 *                     </li>
 *                     <li>
 *                         <strong>Late binding</strong> — <strong>Runtime</strong> in general and
 *                         <strong>Compile time</strong> for calls to {@code final}, {@code private},
 *                         or {@code static} methods (
 *                         <a href="https://stackoverflow.com/questions/22391915/late-binding-in-java/22392047#22392047">
 *                             Late Binding in Java
 *                         </a>).
 *                     </li>
 *                     <li>
 *                         <strong>Accessibility checking</strong> — In Java, they are enforced at
 *                         <strong>runtime</strong>, because Java also has a runtime typesystem,
 *                         and it can dynamically (at runtime) create classes. So it needs to enforce
 *                         access at runtime too for types it doesn't know about at compile time.
 *                         (<a href="https://stackoverflow.com/questions/15564011/oop-access-modifiers-compile-time-or-run-time/15564176#15564176">
 *                             OOP Access Modifiers: Compile-time or Run-time
 *                          </a>).
 *                     </li>
 *                     <li>
 *                         <strong>Type inference</strong> — <strong>Compile time</strong> — Type inference is a
 *                         Java compiler’s ability to look at each method invocation and corresponding declaration
 *                         to determine the type argument (or arguments) that make the invocation applicable
 *                         (<a href="https://docs.oracle.com/javase/tutorial/java/generics/genTypeInference.html">
 *                             Type Inference
 *                          </a>).
 *                     </li>
 *                     <li>
 *                         <strong>Type erasure</strong> — <strong>Compile time</strong> — Type
 *                         erasure can be explained as the process of enforcing type constraints
 *                         only at compile time and discarding the element type information at runtime
 *                         (<a href="https://www.baeldung.com/java-type-erasure">Type Erasure in Java</a>).
 *                     </li>
 *                     <li>
 *                         <strong>Type checking</strong> — <strong>Compile time</strong> but facilitating
 *                         <strong>runtime</strong> type checking e.g. via {@code instanceof}.
 *                     </li>
 *                 </ul>
 *             </p>
 *         </p>
 *     </p>
 * </div>
 */
class JavaChallenge33 {
    long sum(int a,long b) { return a+b; }
    //int sum(long a,int b) { return a+b; }
    long sum(long a,long b) { return a+b; }
}