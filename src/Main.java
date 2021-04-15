import java.util.Scanner;

/**
 * Created by 林夕
 * Date 2021/4/8 20:39
 */
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int sum = 0;
            for(int j=0;j<m;j++){
                sum+=scanner.nextInt();
            }
            System.out.println(sum);
            System.out.println();
        }
    }
}
