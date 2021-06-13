package calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 林夕
 * Date 2021/4/17 17:20
 */
public class Operation {

    //true表示输入没有问题,false表示输入有问题
    public static boolean flag = true;

    public static Map<Integer,Integer> map;
    static {
        map = new HashMap<>();
        map.put(4,7);
        map.put(8,127);
        map.put(16,32767);
        map.put(32,2147483647);
    }

    public String operation(List<String> list) {
        for (String s : list) {
            if (s.startsWith("0") || s.startsWith("1")) {
                /*if(s.startsWith("1")){
                    list.remove(s);
                    list.add(i,s.replaceFirst("1","-"));
                }
                else */
                if (s.length() > Interface.bit)
                    throw new RuntimeException(s + "超过了" + Interface.bit + "位数的限制");
                else if (s.length() < Interface.bit)
                    throw new RuntimeException(s + "小于" + Interface.bit + "位数的限制");
            }
        }
        List<String> numberList = new ArrayList<>();
        while (list.contains("NOT")) {
            int i = list.indexOf("NOT");
            String result = not(list.get(i + 1));
            System.out.println(list.get(i + 1));
            list.remove(i);
            list.add(i, result);
            list.remove(i + 1);
        }
        try {
            while (list.size() > 0) {
                String s = list.get(0);
                list.remove(0);
                switch (s) {
                    case "+": {
                        String result = add(numberList.get(0), list.get(0));
                        numberList.remove(0);
                        list.remove(0);
                        numberList.add(result);
                        break;
                    }
                    case "-": {
                        String result = reduce(numberList.get(0), list.get(0));
                        numberList.remove(0);
                        list.remove(0);
                        numberList.add(result);
                        break;
                    }
                    case "AND": {
                        String result = and(numberList.get(0), list.get(0));
                        numberList.remove(0);
                        list.remove(0);
                        numberList.add(result);
                        break;
                    }
                    case "OR": {
                        String result = or(numberList.get(0), list.get(0));
                        numberList.remove(0);
                        list.remove(0);
                        numberList.add(result);
                        break;
                    }
                    case "XOR": {
                        String result = xor(numberList.get(0), list.get(0));
                        numberList.remove(0);
                        list.remove(0);
                        numberList.add(result);
                        break;
                    }
                    default: {
                        numberList.add(s);
                    }
                }
            }
            //System.out.println(list.toString());
            return numberList.get(0);
        }catch (Exception e){
            throw new RuntimeException("非法输入");
        }
    }

    String and(String s1,String s2) {
        int a = Integer.parseInt(Integer.valueOf(s1, 2).toString());
        int b = Integer.parseInt(Integer.valueOf(s2, 2).toString());
        return flagBits(Integer.toBinaryString(a & b));
    }

    String or(String s1,String s2){
        int a = Integer.parseInt(Integer.valueOf(s1,2).toString());
        int b = Integer.parseInt(Integer.valueOf(s2,2).toString());
        return flagBits(Integer.toBinaryString(a | b));
    }

    String xor(String s1,String s2){
        int a = Integer.parseInt(Integer.valueOf(s1,2).toString());
        int b = Integer.parseInt(Integer.valueOf(s2,2).toString());
        return flagBits(Integer.toBinaryString(a ^ b));
    }

    String not(String s){
        return s.replaceAll("0","2").replaceAll("1","0")
                .replaceAll("2","1");
    }

    String add(String s1,String s2){
        if(s1.startsWith("1"))
            s1 = s1.replaceFirst("1","-");
        if(s2.startsWith("1"))
            s2 = s2.replaceFirst("1","-");
        int a = Integer.parseInt(Integer.valueOf(s1,2).toString());
        int b = Integer.parseInt(Integer.valueOf(s2,2).toString());
        System.out.println("a="+a);
        System.out.println("b="+b);
        try {
            int result = a + b;
            if (result > map.get(Interface.bit/2))
                Interface.A = true;
            else if(result > map.get(Interface.bit)){
                Interface.C = true;
                Interface.O = true;
            }
        }catch (Exception e){
            int result = (int)((double)a + (double)b - Math.pow(2,15));
            Interface.C = true;
            Interface.O = true;
            return flagBits(Integer.toBinaryString(result));
        }
        return flagBits(Integer.toBinaryString(a + b));
    }

    String reduce(String s1,String s2){
        if(s1.startsWith("1"))
            s1 = s1.replaceFirst("1","-");
        if(s2.startsWith("1"))
            s2 = s2.replaceFirst("1","-");
        int a = Integer.parseInt(Integer.valueOf(s1,2).toString());
        int b = Integer.parseInt(Integer.valueOf(s2,2).toString());
        try {
            int result = a - b;
            if (result < -map.get(Interface.bit/2) - 1)
                Interface.A = true;
            else if(result < -map.get(Interface.bit) - 1){
                Interface.C = true;
                Interface.O = true;
            }
        }catch (Exception e){
            int result = (int)((double)a - (double)b + Math.pow(2,15));
            Interface.C = true;
            Interface.O = true;
            return flagBits(Integer.toBinaryString(result));
        }
        return flagBits(Integer.toBinaryString(a - b));
    }

    //补码
    String comp(String s){
        System.out.println(s);
        if(s.startsWith("0"))
            return s;
        else{
            String str = "00000000000000000000000000000001";
            return add(s.replaceAll("-","1").replaceAll("0","2").replaceAll("1","0")
                    .replaceAll("2","1").replaceFirst("0","1"),str);
        }
    }

    String flagBits(String s){
        if(s.endsWith("0"))
            Interface.P = true;
        if(s.startsWith("1"))
            Interface.S = true;
        if(allZero(s))
            Interface.Z = true;
        if(s.length()<Interface.bit){
            return "0".repeat(Interface.bit - s.length())+s;
        }
        else if(s.length()>Interface.bit){
            return s.substring(s.length()-Interface.bit);
        }
        return s;
    }

    String hasSign(){
        StringBuilder sb = new StringBuilder();
        if(Interface.A)
            sb.append(" A ");
        if(Interface.Z)
            sb.append(" Z ");
        if(Interface.S)
            sb.append(" S ");
        if(Interface.C)
            sb.append(" C ");
        if(Interface.O)
            sb.append(" O ");
        if(Interface.P)
            sb.append(" P ");
        return sb.toString();
    }

    boolean allZero(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=0)
                return false;
        }
        return true;
    }
}
