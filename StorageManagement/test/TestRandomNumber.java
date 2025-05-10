import java.util.Random;

public class TestRandomNumber {
    public static int getRandomNumber(int x, int y) {
        Random random = new Random();
        return random.nextInt(y - x + 1) + x;
    }
}
