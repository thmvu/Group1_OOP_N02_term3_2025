package Review; // 👈 Bắt buộc phải khai báo package đúng tên thư mục

public class Sequence {
    private Object[] objects;

    public Sequence(int size) {
        objects = new Object[size];
    }

    public void add(Object x, int index) {
        objects[index] = x;
    }

    public interface Selector {
        boolean end();
        Object current();
        void next();
    }

    private class SSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == objects.length;
        }

        public Object current() {
            return objects[i];
        }

        public void next() {
            if (i < objects.length) i++;
        }
    }

    public Selector getSelector() {
        return new SSelector();
    }

  
   
}
