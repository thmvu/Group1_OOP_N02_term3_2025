package Review;

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        try {
            items = new Object[size];
        } catch (NegativeArraySizeException e) {
            System.out.println("Kích thước mảng không hợp lệ: " + e.getMessage());
            items = new Object[10]; // fallback
        } catch (Exception e) {
            System.out.println("Lỗi khởi tạo Sequence: " + e.getMessage());
            items = new Object[10];
        }
    }

    public void add(Object x) {
        try {
            if (next < items.length) {
                items[next++] = x;
            } else {
                throw new ArrayIndexOutOfBoundsException("Vượt quá kích thước mảng!");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm phần tử: " + e.getMessage());
        }
    }

    // Inner class implement interface Selector
    private class SSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            try {
                return items[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Chỉ số vượt quá giới hạn mảng: " + e.getMessage());
                return null;
            } catch (Exception e) {
                System.out.println("Lỗi khi truy cập phần tử hiện tại: " + e.getMessage());
                return null;
            }
        }

        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new SSelector();
    }

    // Interface Selector
    public interface Selector {
        boolean end();
        Object current();
        void next();
    }
}
