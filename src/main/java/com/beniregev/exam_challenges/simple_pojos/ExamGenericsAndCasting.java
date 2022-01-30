package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h1>Java Generics and Casting Challenge</h1>
 *     <p>
 *         What would be the result of running the following code, and why?
 *         a. Compilation Error
 *         b. ClassA
 *         c. ClassB
 *         d. ClassC
 *         e. ClassC can not be cast to ClassB
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 * @param <T>
 */
public class ExamGenericsAndCasting<T extends ClassA> {
    public T returnString(final Object o){
        return (T) o;
    }

    /**
     * <div>
     *     <h1>The correct answer is: </h1>
     *     <p>
     *         <p>It’s clearly 5th option is the answer because classC can not be cast to classB, which will be caused at line number 4, but that is not the case my friend, what happens is line number 4 will be replaced with —</p>
     *         <p>
     *             <code>return (ClassA) o;</code>
     *         </p>
     *         <p>
     *             So definitely it will not throw {@code ClassCastException}
     *             because {@code ClassC} can be cast to {@code ClassA}. Java
     *             generics are not reified here, meaning that in compile-time,
     *             the generic type information is “lost” and treated as if the
     *             code is replaced with the type’s bound or with {@code Object}
     *             if it doesn't exist, which basically types
     *             <a href="https://docs.oracle.com/javase/tutorial/java/generics/erasure.html">
     *                 erasure concepts
     *             </a>.
     *         </p>
     *         <p></p>
     *         <p>So the answer will be {@code ClassC}.</p>
     *     </p>
     * </div>
     * @param args arguments for running as a Java application.
     */
    public static void main(String[] args) {
        System.out.println(new ExamGenericsAndCasting<ClassB>().returnString(new ClassC()));
    }
}

class ClassA {
    @Override
    public String toString() {
        return "ClassA";
    }
}

class ClassB extends ClassA{
    @Override
    public String toString() {
        return "ClassB";
    }
}

class ClassC extends ClassA{
    @Override
    public String toString() {
        return "ClassC";
    }
}