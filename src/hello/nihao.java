package hello;
class Storage {
    int getsum1;
    int getsum2;
    public void put(int sum) {
        getsum1 = sum;
        System.out.println(getsum1);
    }

    public void put2(int sum) {
        getsum2 = sum;
        System.out.println(getsum2+getsum1);
    }
}
class Input1 implements Runnable {
    private Storage st;
    private int sum;
    Input1(Storage st) {
        this.st = st;
    }
    public void run() {
        for (int i = 0; i < 11; i++) {
       sum=sum+i;
        }st.put(sum);
    }
}
class Input2 implements Runnable {
    private Storage st;
    private int sum;
    Input2(Storage st) {
        this.st = st;
    }
    public void run() {
        for (int i = 11; i < 21; i++) {
            sum=sum+i;
        }st.put2(sum);
    }
}
public class nihao {
    public static void main(String[] args) {
        Storage st = new Storage();
        Input1 input1 = new Input1(st);
        Input2 input2 = new Input2(st);
        new Thread(input1).start();
        new Thread(input2).start();
    }
}
