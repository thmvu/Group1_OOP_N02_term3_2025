class Number {
    int i;
}

public class Test {
    public static void main(String[] args) throws Exception {
        Number n1 = new Number();
        Number n2 = new Number();
        n1.i = 2;
        n2.i = 3;
        n1 = n2;
        n2.i = 10;
        System.out.println(n2.i);
        n1.i =20;
        System.out.println(n1.i);
    }
}
