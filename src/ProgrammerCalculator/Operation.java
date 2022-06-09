package ProgrammerCalculator;

import java.util.List;

/**
 * Created by 林夕
 * Date 2022/6/5 18:01
 */
public class Operation {

    //对传入的list进行计算
    String operation(List<String> list){
        String res = "";
        if(list.size()==1)
            return list.get(0);
        else if(list.size()==2){
            if(list.get(1).equals("+")||list.get(1).equals("*")||list.get(1).equals("/")
            ||list.get(1).equals("OR")||list.get(1).equals("XOR")||list.get(1).equals("AND")||list.get(1).equals("SHF"))
                throw new RuntimeException("操作异常");
        }
        switch (list.get(1)){
            case "+": res = add(list.get(0),list.get(2)); break;
            case "-": res = reduce(list.get(0),list.get(2));break;
            case "*": res = multiply(list.get(0),list.get(2));break;
            case "/": res = except(list.get(0),list.get(2));break;
            case "OR": res = or(list.get(0),list.get(2));break;
            case "XOR": res = xor(list.get(0),list.get(2));break;
            case "AND": res = and(list.get(0),list.get(2));break;
            case "SHF": res = shf(list.get(0),list.get(2));break;
            default: res = reduce(list.get(0),list.get(1));break;
        }
        return res;
    }

    //加
    String add(String s1,String s2){
        int a,b;
        if(Interface.bit==10) {
            a = Integer.parseInt(s1);
            b = Integer.parseInt(s2);
            return String.valueOf(a+b);
        }
        else if(Interface.bit==16){
            a = Integer.parseInt(Integer.valueOf(s1, 16).toString());
            b = Integer.parseInt(Integer.valueOf(s2, 16).toString());
            return Integer.toHexString(a+b);
        }
        return "0";
    }

    //减
    String reduce(String s1,String s2){

        int a,b;
        if(Interface.bit==10) {
            a = Integer.parseInt(s1);
            b = Integer.parseInt(s2);
            if(b>0)
                return String.valueOf(a-b);
            else return String.valueOf(a+b);
        }
        else if(Interface.bit==16){
            a = Integer.parseInt(Integer.valueOf(s1, 16).toString());
            b = Integer.parseInt(Integer.valueOf(s2, 16).toString());
            if(b>0)
                return Integer.toHexString(a-b);
            else return String.valueOf(a+b);
        }
        return "0";
    }

    //乘
    String multiply(String s1,String s2){
        int a,b;
        if(Interface.bit==10) {
            a = Integer.parseInt(s1);
            b = Integer.parseInt(s2);
            return String.valueOf(a*b);
        }
        else if(Interface.bit==16){
            a = Integer.parseInt(Integer.valueOf(s1, 16).toString());
            b = Integer.parseInt(Integer.valueOf(s2, 16).toString());
            return Integer.toHexString(a*b);
        }
        return "0";
    }

    //除
    String except(String s1,String s2){
        int a,b;
        if(Interface.bit==10) {
            a = Integer.parseInt(s1);
            b = Integer.parseInt(s2);
            return String.valueOf(a/b);
        }
        else if(Interface.bit==16){
            a = Integer.parseInt(Integer.valueOf(s1, 16).toString());
            b = Integer.parseInt(Integer.valueOf(s2, 16).toString());
            if(b==0)
                throw new RuntimeException("被除数不能为0");
            return Integer.toHexString(a/b);
        }
        return "0";
    }

    //或运算
    String or(String s1,String s2){
        int a,b;
        if(Interface.bit==10) {
            a = Integer.parseInt(s1);
            b = Integer.parseInt(s2);
            return String.valueOf(a|b);
        }
        else if(Interface.bit==16){
            a = Integer.parseInt(Integer.valueOf(s1, 16).toString());
            b = Integer.parseInt(Integer.valueOf(s2, 16).toString());
            return Integer.toHexString(a|b);
        }
        return "0";
    }

    //异或运算
    String xor(String s1,String s2){
        int a,b;
        if(Interface.bit==10) {
            a = Integer.parseInt(s1);
            b = Integer.parseInt(s2);
            return String.valueOf(a^b);
        }
        else if(Interface.bit==16){
            a = Integer.parseInt(Integer.valueOf(s1, 16).toString());
            b = Integer.parseInt(Integer.valueOf(s2, 16).toString());
            return Integer.toHexString(a^b);
        }
        return "0";
    }

    //与运算
    String and(String s1,String s2){
        int a,b;
        if(Interface.bit==10) {
            a = Integer.parseInt(s1);
            b = Integer.parseInt(s2);
            return String.valueOf(a&b);
        }
        else if(Interface.bit==16){
            a = Integer.parseInt(Integer.valueOf(s1, 16).toString());
            b = Integer.parseInt(Integer.valueOf(s2, 16).toString());
            return Integer.toHexString(a&b);
        }
        return "0";
    }

    //移位计算
    String shf(String s1,String s2){
        int a,b
                ;
        if(Interface.bit==10) {
            throw new RuntimeException("移位只支持16进制");
        }
        else if(Interface.bit==16){
            a = Integer.parseInt(Integer.valueOf(s1, 16).toString());
            b = Integer.parseInt(Integer.valueOf(s2, 16).toString());
            if(b>=0)
                return Integer.toHexString(a<<b);
            else return Integer.toHexString(a>>-b);
        }
        return "0";
    }

    //10进制 转16进制
    String hex(String s){
        return Integer.toHexString(Integer.parseInt(s));
    }

    //16进制转10进制
    String dec(String s){
        return String.valueOf(Integer.parseInt(Integer.valueOf(s, 16).toString()));
    }

    //反码操作
    String sc(String s){
        int a;
        if(Interface.bit==10) {
            a = Integer.parseInt(s);
            return String.valueOf(~a);
        }
        else if(Interface.bit==16){
            a = Integer.parseInt(Integer.valueOf(s, 16).toString());
            return Integer.toHexString(~a);
        }
        return "";
    }

    //补码操作
    String addAndReduce(String s){
        if(Interface.bit==10) {
            return "-"+s;
        }
        else if(Interface.bit==16){
            int a;
            int b = 0xFFFFFFFF;
            a = Integer.parseInt(Integer.valueOf(s, 16).toString());
            return Integer.toHexString(b-a);
        }
        return "";
    }
}
