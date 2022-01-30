package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h1></h1>
 *     <p>
 *         What would be the result of running the following code, and why?
 *         a. Static Block 20
 *         b. 20 Static Block
 *         c. 20
 *         d. Static Block
 *     </p>
 *
 * </div>
 */
public class StaticBlock {
    public static void main(String[] args) {
        System.out.println(JavaChallenge31.x);
    }
}

//  region what would be the result of running this code, and why?
// <div>
//     <h1>Explaining the problem and the solution</h1>
//     <p>
//         As we know the {@code Static Block} will always get executed when the class is loaded but does
//         it get executed always? Here, the static block will not get executed. This is because of compiler
//         optimization. The compiler will do some performance optimization here where it will not load the
//         {@code JavaChallenge31} class because the compiler noticed, only {@code x} is getting used from
//         the class {@code JavaChallenge31} which is static in nature and it's actually available inside the
//         metaspace, the common memory allocation of Java memory. So without loading the class, it will be
//         directly taken from common memory. Hence it will only print {@code 20} not the {@code Static Block}.
//         So guys, be careful when you say “Static block is always executed”.
//     </p>
// </div>
//  endregion
class JavaChallenge31 {
    static {
        System.out.println("Static Block");
    }
    public static final int x=20;
}

