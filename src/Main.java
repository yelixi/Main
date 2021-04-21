import java.util.Scanner;

/**
 * Created by 林夕
 * Date 2021/4/8 20:39
 */
public class Main{
    public static void main(String[] args) {
       String s = "1111111111111111111111111111111";
        System.out.println(Integer.valueOf(s,2).toString());
        int a = -65535;
        System.out.println(Integer.toBinaryString(a));
    }
}
