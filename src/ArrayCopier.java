public class ArrayCopier {
    public static void main(String[] args) {
        int[] array1 = {7, 4, 8, 1, 4, 1, 4};
        float [] array2 = new float[array1.length];

        System.out.print("array1: [ ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println("]");

        System.out.print("array2: [ ");
        int count = 0;
        while (count < array1.length && array1[count] != 1) {
            array2[count] = (float) array1[count];
            System.out.print(array2[count++] + " ");
        }
        System.out.println("]");

        float x = 9;
        float y = 5;
        int z = (int) (x/y);
        switch (z) {
            case 1:
                x = x +2;
                System.out.println(x);
                break;
            case 2:
                x = x + 3;
                System.out.println(x);
                break;
            default:
                x = x + 1;
                System.out.println(x);

        }
    }
}
