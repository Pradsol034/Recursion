public class length {
    public static void main(String[] args) {
        String s = "Pradeep";
        System.out.println(len(s));
    }

    static int len(String s) {
        if (s.equals("")) {
            return 0;
        }
        return 1 + len(s.substring(1));
    }
}
