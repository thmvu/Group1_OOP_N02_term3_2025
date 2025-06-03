package Review;

public class TestSequence {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);

        // Thêm các phần tử vào sequence
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }

        Sequence.Selector selector = sequence.selector();

        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
