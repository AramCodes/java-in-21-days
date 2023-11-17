public class Variables {
    public static void main(String[] args) {
        final char UP = 'U';
        byte currentLevel = 12;
        short location = 13250;
        int score = 3_500_100;
        boolean newGame = true;

        System.out.println("You have reached level " + currentLevel + " with a score of " + score + " at location " + location + ".");

        System.out.println("Press " + UP + " to go up.");
        System.out.println("is this a new game? " + newGame);

    }
}
