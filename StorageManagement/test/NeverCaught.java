import java.lang.RuntimeException;


public class NeverCaught {
    static void g(){
        throw new RuntimeException("From g()");
    }
    static void f(){
        g();

    }
    public static void main(String[] args){
        f();
    }
}
