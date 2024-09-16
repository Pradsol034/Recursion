public class msg {
    public static void main(String[] args) {
        message();
        System.out.println("Hello 8  :");
    }
    static void message()
    {
        System.out.println("Hello 1  :");
        msg1();
        System.out.println("Hello 7  :");
    }
    static void msg1()
    {
        System.out.println("Hello 2  :");
        msg2();
        System.out.println("Hello 6  :");
    }
    static void msg2()
    {
        System.out.println("Hello 3  :");
        msg3();
        System.out.println("Hello 5  :");


    }
    static void msg3()
    {
        System.out.println("Hello 4: ");
    }
    
}
