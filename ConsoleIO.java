import java.util.Scanner;
public class ConsoleIO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String s1 = sc.next();
        System.out.println(a);
        System.out.println(s1);
        sc.close();
    }
}
