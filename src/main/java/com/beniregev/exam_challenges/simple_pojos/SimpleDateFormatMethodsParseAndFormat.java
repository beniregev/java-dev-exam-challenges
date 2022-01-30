package com.beniregev.exam_challenges.simple_pojos;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <div>
 *     <p>
 *         What would be the result of running the following code, and why?
 *     </p>
 * </div>
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class SimpleDateFormatMethodsParseAndFormat {
    static SimpleDateFormat sdfIn = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat sdfOut = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * <div>What would be the result of running the following code, and why?
     *     <p>
     *         To solve the challenge, we should know about {@code SimpleDateFormat}'s
     *         {@code parse()} and {@code format()} methods. If we see the input which
     *         is {@code 40/20/9999} and the input format is {@code dd/MM/yyyy}, ideally
     *         the {@code parse()} method should throw an exception because month and
     *         day are not in the limit; but {@code parse()} method is very smart and it
     *         will try to parse the input {@code 40/20/9999} to a valid date. Let’s
     *         understand that —
     *     </p>
     *     <p>
     *         Firstly, it will try to parse the month and the max limit is
     *         {@code 12} so parsing will add 1 extra year to {@code yyyy=9999}
     *         and month will be considered as August(08) so now the {@code MM/yyyy}
     *         part is {@code 08/10000} .
     *     </p>
     *     <p>
     *         Secondly, it will try to parse the day and the limit
     *         is 31(August has 31 days), so again here also the carry
     *         forwarding will happen which will make the date {@code dd/MM/yyyy}
     *         as {@code 09/09/10000} .
     *     </p>
     *     <pre>
     *         <code>
     *     System.out.println(parsedDate);
     *         </code>
     *     </pre>
     *     <p>
     *         <code>Sat Sep 09 00:00:00 IST 10000</code>
     *     </p>
     *     <pre>
     *         <code>
     *     System.out.println("output : " + output);
     *         </code>
     *     </pre>
     *     <p></p>
     *     <p><code>output : 10000–09–09</code></p>
     * </div>
     * @param args {@link String} array containing arguments from command-line interface (CLI)
     * @throws ParseException exception thrown in case simpleDateFormatObject.parse(dateTime) fails
     */
    public static void main(String[] args) throws ParseException {
        formatUsingSDF("40/20/9999");
    }

    static void formatUsingSDF(String dt) {
        Date parsedDate = null;
        String output = "";
        try {
            parsedDate = sdfIn.parse(dt);
            output = sdfOut.format(parsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parsedDate);
        System.out.println("output : " + output);
    }
}
