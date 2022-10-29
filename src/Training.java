package Thread1.Example;

import java.util.Scanner;

public class Training {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = 0;

        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.printf("%d %s\n", ++i, s);
        }
        sc.close();
    }
}
