package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h1></h1>
 *     <p></p>
 *     <p></p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class ExamOperatorPrecedence {
    /**
     * <div>
     *     <h1>Operator Precedence Challenge</h1>
     *     <p>
     *         <p>I got surprised when I saw the bytecode of the above code —</p>
     *         <pre>
     *             <code>
     *         public class JavaChallenge42 {
     *             public JavaChallenge42() {
     *             }
     *
     *             public static void main(String[] args) {
     *                 int[] arr = new int[5];
     *                 int index = 0;
     *                 byte var10001 = index;
     *                 int index = true;
     *                 arr[var10001] = 3;
     *                 System.out.println("The value of first element is " + arr[0]);
     *                 System.out.println("The value of fourth element is " + arr[3]);
     *             }
     *         }
     *             </code>
     *         </pre>
     *         <p>Before understanding the bytecode, let me tell you the answer which is —</p>
     *         <pre>
     *             <code>
     *             The value of first element is 3
     *             The value of fourth element is 0
     *             </code>
     *         </pre>
     *         <p>Yes, that’s what the answer is. So this challenge is on Java Precedence. Let’s see that —</p>
     *         <p>
     *             <h3>Java Operator Precedence Table</h3>
     *         </p>
     *         <pre>
     *         +------------+------------+-----------------------------------------+---------------+
     *         | precedence |  operator  | Type                                    | Associativity |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |     15     |     ()     | Parameters                              | Left To Right |
     *         |            |     []     | Array subscript                         |               |
     *         |            |      .     | Member selection                        |               |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |     14     |     ++     | Unary post-increment                    | Right To Left |
     *         |            |     --     | Unary post-decrement                    |               |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |     13     |     ++     | Unary pre-increment                     | Right To Left |
     *         |            |     --     | Unary pre-decrement                     |               |
     *         |            |      +     | Unary plus                              |               |
     *         |            |      -     | Unary minus                             |               |
     *         |            |      !     | Unary logical negation                  |               |
     *         |            |      ~     | Unary bitwise complement                |               |
     *         |            |   (type)   | Unary type cast                         |               |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |     12     |      *     | Multiplication                          | Left To Right |
     *         |            |      /     | Division                                |               |
     *         |            |      %     | Modulus                                 |               |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |     11     |      +     | Addition                                | Left To Right |
     *         |            |      -     | Subtraction                             |               |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |     10     |     <<     | Bitwise left shift                      | Left To Right |
     *         |            |     >>     | Bitwise right shift with sign extension |               |
     *         |            |    >>>     | Bitwise right shift with zero extension |               |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |      9     |      <     | Unary pre-increment                     | Left To Right |
     *         |            |     <=     | Unary pre-decrement                     |               |
     *         |            |      >     | Unary plus                              |               |
     *         |            |     =>     | Unary minus                             |               |
     *         |            | instanceof | Unary logical negation                  |               |
     *         |            |      ~     | Unary bitwise complement                |               |
     *         |            |   (type)   | Unary type cast                         |               |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |      8     |     ==     | Relational is equal to                  | Left To Right |
     *         |            |     !=     | Relational is not equal to              |               |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |      7     |      &     | Bitwise AND                             | Left To Right |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |      6     |      ^     | Bitwise exclusive OR                    | Left To Right |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |      5     |      |     | Bitwise inclusive OR                    | Left To Right |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |      4     |     &&     | Logical AND operator                    | Left To Right |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |      3     |     ||     | Logical OR operator                     | Left To Right |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |      2     |     ?:     | Ternary conditional                     | Right To Left |
     *         +------------+------------+-----------------------------------------+---------------+
     *         |      1     |      +     | Assignment                              | Right To Left |
     *         |            |     +=     | Addition assignment                     |               |
     *         |            |     -=     | subtraction assignment                  |               |
     *         |            |     *=     | Multiplication assignment               |               |
     *         |            |     /=     | Division assignment                     |               |
     *         |            |     %=     | Modulus assignment                      |               |
     *         ------------+------------+-----------------------------------------+---------------+
     *             <br/>
     *             <div>Larger number mean higher precedence.</div>
     *         </pre>

     *         <p>There are three operators- [], =, = as —</p>
     *         <pre>
     *             <code>
     *             1. arr [index]
     *             2. arr [index]= index
     *             3. index = 3
     *             </code>
     *         </pre>
     *         <p>
     *             So according to the precedence table <code>arr[index]</code> has become
     *             <code>arr[0]</code> because currently <code>index=0</code>; Now there
     *             are 2 <code>=</code> (equal signs) so which one will be evaluated first?
     *             So we can get that info from the precedence table itself. In case of
     *             <code>=</code> operator the evaluation happens from Right to Left, so
     *             now <code>index=3</code> evaluated first and now the value of the
     *             </code>index</code> is 3 which will be assigned to <code>arr[0]</code>. The
     *             value <code>arr[3]</code> is 0 which is a default value of primitive int.
     *         </p>
     *     </p>
     *     <p></p>
     * </div>
     * @param args arguments for running as a Java application
     */
    public static void main(String[] args) {
        int[] arr = new int [5];
        int index= 0;
        arr [index]= index = 3;
        System.out.println("The value of first element is " + arr[0]);
        System.out.println("The value of fourth element is " + arr[3]);
    }
}
