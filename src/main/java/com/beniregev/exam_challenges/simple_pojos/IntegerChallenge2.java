package com.beniregev.exam_challenges.simple_pojos;

/**
 * <div>
 *     <h3>Java Integer Challenge</h3>
 *     <p>
 *         What would be the result of running the following code?
 *         <div>
 *             <ol>
 *                 <li>a. Your Native Int concept </li>
 *                 <li>b. Your Native Int concept </li>
 *                 <li>c. Challenge Your Integer Object concept</li>
 *                 <li>d. Challenge Your Java Skill</li>
 *             </ol>
 *         </div>
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class IntegerChallenge2 {

    /**
     * <div>
     *     <p>
     *         The challenge looks pretty simple here, but wait; there is a concept. In
     *         <b>Java 5</b>, a new feature was introduced to save the memory and improve
     *         performance for {@code Integer} type object handling. {@code Integer} objects \
     *         are cached internally and reused via the same referenced objects.
     *     </p>
     *     <p>
     *         <ul>
     *             <li>
     *                 This is applicable for {@code Integer} values in the range between
     *                 {@code –128} to {@code +127}.
     *             </li>
     *             <li>
     *                 This {@code Integer caching} works only on auto-boxing. {@code Integer}
     *                 objects will not be cached when they are built using the constructor.
     *             </li>
     *         </ul>
     *     </p>
     *     <p>
     *         We have a dedicated {@code IntegerCache} class under the {@code Integer} class which
     *         is private and static in nature, which means you can not change its behavior, but you
     *         can control the size. oh, how???
     *     </p>
     *     <p>
     *         <p>
     *             Let’s go through the code.
     *         </p>
     *         <pre>
     *             <code>
     * private static class IntegerCache {
     *     static final int low = -128;
     *     static final int high;
     *     static final Integer cache[];
     *
     *     static {
     *         // high value may be configured by property
     *         int h = 127;
     *         String integerCacheHighPropValue =
     *             sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
     *         if (integerCacheHighPropValue != null) {
     *             try {
     *                 int i = parseInt(integerCacheHighPropValue);
     *                 i = Math.max(i, 127);
     *                 // Maximum array size is Integer.MAX_VALUE
     *                 h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
     *             } catch( NumberFormatException nfe) {
     *                 // If the property cannot be parsed into an int, ignore it.
     *             }
     *         }
     *         high = h;
     *
     *         cache = new Integer[(high - low) + 1];
     *         int j = low;
     *         for(int k = 0; k < cache.length; k++)
     *             cache[k] = new Integer(j++);
     *
     *         // range [-128, 127] must be interned (JLS7 5.1.7)
     *         assert IntegerCache.high >= 127;
     *     }
     *
     *     private IntegerCache() {}
     * }
     *             </code>
     *         </pre>
     *     </p>
     *     <p>
     *         Let’s understand it from java-docs first.
     *     </p>
     *     <p>
     *         <i>
     *             Cache to support the object identity semantics of autoboxing for values between {@code -128} and {@code 127} (inclusive) as required by JLS. The cache is initialized on first usage. The size of the cache may be controlled by the {@code -XX:AutoBoxCacheMax=<size>} option. During VM initialization, {@code java.lang.Integer.IntegerCache.high} property may be set and saved in the private system properties in the {@code sun.misc.VM} class.
     *         </i>
     *     </p>
     *     <p>
     *         So, firstly it checks if the user has set the value of “{@code  -XX:AutoBoxCacheMax}” at the time of the virtual machine initialization, then it picks that value as max and create an {@code Integer} (not {@code int}, the primitive one) array of size (max-low+1) and allocate memory to each element of the array. if you see, the entire code is inside the static block, and we know that static block is executed only once: the first time the class is loaded into memory. So be careful while changing the cache size else it will occupy unnecessary memory which might affect the performance. Let’s see the answer to the challenge now, you know it already.
     *     </p>
     *     <p>
     *         It will print “{@code num1 == num2}”. Whenever two different object references are compared using “{@code ==},” the value is always {@code false}. But here, because of the {@code Integer} caching, {@code num1} and {@code num2} are auto-boxed. Thus {@code num1==num2} returns {@code true}.
     *     </p>
     *     <p></p>
     * </div>
     * @param arr {@link String} array arguments received from calling the method, or running from command-line.
     */
    public static void main(String[] arr){
        Integer num1 = 106;
        Integer num2 = 106;
        Integer num3 = 206;
        Integer num4 = 206;

        if(num1==num2){
            System.out.print("Challenge ");
        }
        else{
            System.out.print("Your Native Int concept");
        }
        if(num3 == num4){
            System.out.print("Your Integer Object concept");
        }
        else{
            System.out.print("Your Java Skill");
        }
    }
}
