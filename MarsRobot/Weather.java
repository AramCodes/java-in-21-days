public class Weather {
    public static void main(String[] args) {
        float fah = 86;
        System.out.println(fah + " degrees Fahrenheit is ...");
//        To convert Fahrenheit into Celsius
//        begin by subtracting 32
        fah = fah - 32;
//        Then divide the answer by nine
        fah = fah / 9;
//        Then multiply that answer by 5
        fah = fah * 5;
        System.out.println(fah + " degrees Celsius\n");

        float cel = 33;
        System.out.println(cel + " degrees Celsius is ...");
//        To convert Celsius into Fahrenheit
//        begin by multiplying by 9 then divide by 5 then add 32 to the answer
        cel = cel * 9;
        cel = cel / 5;
        cel = cel + 32;

        System.out.println(cel + " degrees Fahrenheit");
    }
}
