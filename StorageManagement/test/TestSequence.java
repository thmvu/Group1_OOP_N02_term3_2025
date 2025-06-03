import Review.Sequence;  // 👈 import class trong package

public class TestSequence {
    public static void test() {
        Sequence seq = new Sequence(6);
        seq.add("A", 2);
        seq.add("B", 0);
        seq.add("C", 1);
        seq.add("D", 3);
        seq.add("E", 4);

        Sequence.Selector selector = seq.getSelector();  // 👈 Gọi đúng kiểu
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }
}
