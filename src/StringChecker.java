public class StringChecker {
    public static void main(String[] args) {
        String str = "You know nothing, Jon Snow";
        System.out.println("The string is: " + str);
        System.out.println("The Length of this string is: " + str.length());
        System.out.println("The character at position 7 is : " + str.charAt(7));
        System.out.println("The substring between the 9th and 16th index is: " + str.substring(9, 16));
        System.out.println("The index of the first 'w' is: " + str.indexOf('w'));
        System.out.println("The index of th beginning of the " + "substring + \"Jon\": " + str.indexOf("Jon"));
        System.out.println("The string in uppercase: " + str.toUpperCase());

        int accountBalance = 5005;
        System.out.format("Balance: $%,d%n", accountBalance);

        double pi = Math.PI;
        System.out.format("%.11f%n", pi);

        float x = 5.0F;
        float y = 2.0F;

        int result = (int) (x / y);
        System.out.println(result);

        String str1, str2;
        str1 = "Boy that escalated quickly.";
        str2 = str1;

        System.out.println("String1: " + str1);
        System.out.println("String2: " + str2);
        System.out.println("Same object? " + (str1 == str2));

        str2 = new String(str1);

        // a change in object reference in memory but value is still in place
        System.out.println("String1: " + str1);
        System.out.println("String2: " + str2);
        System.out.println("Same object? " + (str1 == str2));
        System.out.println("Same value? " + str1.equals(str2));


    }
}

