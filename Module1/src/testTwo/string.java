package testTwo;

public class string {
    public static void main(String[] args) {
        String arr = "abc";
        String result = rollBack(arr);
        System.out.println(result);

    }


    public static String rollBack(String arr) {
        String result = "";
        for (int i = arr.length()-1; i >= 0; i--) {
            char c = arr.charAt(i);
            result = result + c;
        }
        return result;
    }
}
