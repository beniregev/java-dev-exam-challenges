package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h3>What will be the result of running the following code?</h3>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class ConstructorsChallenge2 {
    ConstructorsChallenge2 jc = new ConstructorsChallenge2();

    public ConstructorsChallenge2() {
        System.out.println("Got Challenged!");
    }

    /**
     * <div>
     *     <p>
     *         <div>Looks pretty simple, isn’t it; but it can crash your system. What happens, when we initialize the same class in itself???</div>
     *         <div>Whenever we will invoke the constructor, the constructor will also invoke itself, again it will invoke itself, again it will invoke itself….so on.</div>
     *     </p>
     *     <p>
     *         <div>
     *             <strong>
     *                 Definitely, this gonna result in some error, either in {@code OutOfMemoryError} or {@code StackOverflowError}.
     *             </strong>
     *         </div>
     *         <div>
     *             When you start {@code JVM} you define how much RAM it can use for processing. {@code JVM} divides this into certain memory locations for its processing purpose, two of those are {@code Stack} and {@code Heap}.
     *         </div>
     *         <div>
     *             <ul>
     *                 <li>{@code OutOfMemoryError} is related to <i>Heap</i>.</li>
     *                 <li>{@code StackOverflowError} is related to <i>stack</i>.</li>
     *             </ul>
     *         </div>
     *     </p>
     *     <p>
     *         <div>{@code StackOverflowError}</div>
     *         <div>All your local variables and methods call-related data will be on the stack. For every method call, one stack frame will be created and local as well as method call-related data will be placed inside the stack frame. Once method execution is completed, the stack frame will be removed.</div>
     *     </p>
     *     <p>
     *         <div>{@code OutOfMemoryError}</div>
     *         <div>It happens when the {@code JVM} runs out of space to allocate new objects. For more info.</div>
     *     </p>
     *     <p>
     *         <div><i><strong>Now we need to find out which will happen first — </strong></i></div>
     *         <div><i><strong>Object initialization or Constructor Call?</strong></i></div>
     *     </p>
     *     <p>
     *         Common Sense — Without calling, how {@JVM} will know the size of memory it has to allocate for the object, so obvious answer {@code StackOverflowError} .
     *     </p>
     * </div>
     * @param args
     */
    public static void main(String[] args) {
        ConstructorsChallenge2 jc = new ConstructorsChallenge2();
    }
}