package Review;

import model.Sequence;

public class TestSequence {
    public static void main(String[] args) {
        try {
            Sequence sequence = new Sequence(5); // tạo sequence có 5 phần tử

            sequence.add("Một");
            sequence.add("Hai");
            sequence.add("Ba");
            sequence.add("Bốn");
            sequence.add("Năm");
            sequence.add("Thừa"); // sẽ bị lỗi và xử lý trong khối try-catch ở add()

            Sequence.Selector selector = sequence.selector();

            System.out.println("Duyệt qua phần tử trong Sequence:");
            while (!selector.end()) {
                System.out.println(selector.current());
                selector.next();
            }

        } catch (Exception e) {
            System.out.println("Lỗi khi chạy TestSequence: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
