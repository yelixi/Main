package calculator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 林夕
 * Date 2021/4/14 18:20
 */
public class Interface implements ActionListener {

    public static int bit = 8;

    //进位标志,D3向D4进位则置为true
    public static boolean A = false;

    //进位标志,D7向D8进位则置为true
    public static boolean C = false;

    //溢出标志,溢出置为true
    public static boolean O = false;

    //最后一位为0则置为1
    public static boolean P = false;

    //符号标志,符号位为1置为true
    public static boolean S = false;

    //全0标志,全0为1
    public static boolean Z = false;

    private final Operation operation = new Operation();

    //屏幕
    private final JLabel output = new JLabel("<html></html>");
    private final JLabel input = new JLabel("<html></html>");
    private final JLabel sign = new JLabel("<html></html>");
    //按钮
    private final JButton zero = new JButton("0");
    private final JButton one = new JButton("1");
    private final JButton add = new JButton("+");
    private final JButton reduce = new JButton("-");
    private final JButton and = new JButton("AND");
    private final JButton or = new JButton("OR");
    private final JButton xor = new JButton("XOR");
    private final JButton not = new JButton("NOT");
    private final JButton equal = new JButton("=");
    private final JButton clear = new JButton("CLR");
    private final JButton eightBit = new JButton("8位");
    private final JButton sixteenBit = new JButton("16位");
    private final JButton thirtyTwoBit = new JButton("32位");
    private final JButton comp = new JButton("COMP");

    Interface(){
        //中间容器
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        //显示标志符的区域
        JPanel p4 = new JPanel();

        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        p1.setBorder(blackLine);
        p2.setBorder(blackLine);
        p3.setBorder(blackLine);
        p4.setBorder(blackLine);

        p4.setPreferredSize(new Dimension(0,50));
        p1.setPreferredSize(new Dimension(0,200));
        p2.setPreferredSize(new Dimension(0,200));
        p3.setPreferredSize(new Dimension(0,200));

        //定义按钮字体
        Font buttonFont = new Font("黑体", Font.PLAIN, 20);

        //设置输入输出宽度，以便换行
        input.setSize(200,0);
        output.setSize(200,0);
        sign.setSize(200,0);

        //输入输出前的文字
        JLabel label1 = new JLabel("输出:");
        JLabel label2 = new JLabel("输入:");
        JLabel label3 = new JLabel("标志:");
        //设置文字字体
        label1.setFont(new java.awt.Font("黑体", Font.BOLD,36));//设置字体为黑体，字体大小为36
        label2.setFont(new java.awt.Font("黑体", Font.BOLD,36));//设置字体为黑体，字体大小为36
        label3.setFont(new java.awt.Font("黑体", Font.BOLD,15));//设置字体为黑体，字体大小为36

        //设置按钮字体
        zero.setFont(buttonFont);
        one.setFont(buttonFont);
        add.setFont(buttonFont);
        reduce.setFont(buttonFont);
        and.setFont(buttonFont);
        or.setFont(buttonFont);
        xor.setFont(buttonFont);
        not.setFont(buttonFont);
        equal.setFont(buttonFont);
        clear.setFont(buttonFont);

        //为按钮添加点击事件
        zero.addActionListener(this);
        one.addActionListener(this);
        add.addActionListener(this);
        reduce.addActionListener(this);
        and.addActionListener(this);
        or.addActionListener(this);
        xor.addActionListener(this);
        not.addActionListener(this);
        equal.addActionListener(this);
        clear.addActionListener(this);
        eightBit.addActionListener(this);
        sixteenBit.addActionListener(this);
        thirtyTwoBit.addActionListener(this);
        comp.addActionListener(this);

        /*
         * 在第一个中间容器中定义盒式布局，将文字与{@link output}水平排布
         */
        Box box1 = Box.createHorizontalBox();
        box1.add(label1);
        box1.add(Box.createHorizontalStrut(50));
        box1.add(output);
        p1.setLayout(new BorderLayout());
        p1.add(box1);

        /*
         * 在第二个中间容器中定义盒式布局，将文字与{@link input}水平排布
         */
        Box box2 = Box.createHorizontalBox();
        box2.add(label2);
        box2.add(Box.createHorizontalStrut(50));
        box2.add(input);
        p2.setLayout(new BorderLayout());
        p2.add(box2);

        Box box3 = Box.createHorizontalBox();
        box3.add(label3);
        box3.add(Box.createHorizontalStrut(100));
        box3.add(sign);
        p4.setLayout(new BorderLayout());
        p4.add(box3);

        //在第三个中间容器中设置为一行3列的网格布局
        GridLayout gridLayout = new GridLayout(1,3);

        //网格布局中的三个中间容器
        JPanel pg1 = new JPanel();
        JPanel pg2 = new JPanel();
        JPanel pg3 = new JPanel();

        //对第一二个中间容器设置为4行1列的网格布局，对第三个中间容器设置为2行1列的网格布局
        pg1.setLayout(new GridLayout(5,1));
        pg2.setLayout(new GridLayout(5,1));
        pg3.setLayout(new GridLayout(4,1));

        //将按钮添加至第一个中间容器
        pg1.add(eightBit);
        pg1.add(zero);
        pg1.add(add);
        pg1.add(and);
        pg1.add(or);

        //将按钮添加至第二个中间容器
        pg2.add(sixteenBit);
        pg2.add(one);
        pg2.add(reduce);
        pg2.add(not);
        pg2.add(xor);

        //将按钮添加至第三个中间容器
        pg3.add(thirtyTwoBit);
        pg3.add(clear);
        pg3.add(comp);
        pg3.add(equal);

        //将这些全部添加至第三个容器
        p3.setLayout(gridLayout);
        p3.add(pg1);
        p3.add(pg2);
        p3.add(pg3);

        //设置主面板布局格式为3行一列布局
        JFrame jFrame = new JFrame("二进制计算器");
        Box box = Box.createVerticalBox();
        box.add(p4);
        box.add(p1);
        box.add(p2);
        box.add(p3);
        jFrame.add(box);

        //设置界面大小
        jFrame.setSize(500,650);
        //设置不可最大化
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        //设置可见
        jFrame.setVisible(true);
        jFrame.validate();
        //jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置点击"×"健时什么也不做
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //设置关闭提示信息
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                /*int result = JOptionPane.showConfirmDialog(null,
                        "确认退出?", "确认", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(result == JOptionPane.OK_OPTION){
                    System.exit(0);
                }*/
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {


            if (actionEvent.getSource().equals(zero)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "0");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(one)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "1");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(add)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "+");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(reduce)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "-");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(and)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, " AND ");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(or)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, " OR ");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(xor)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, " XOR ");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(not)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, " NOT ");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(clear)) {
                input.setText("<html></html>");
                output.setText("<html></html>");
                sign.setText("<html></html>");
            } else if (actionEvent.getSource().equals(eightBit)) {
                bit = 8;
            } else if (actionEvent.getSource().equals(sixteenBit)) {
                bit = 16;
            } else if (actionEvent.getSource().equals(thirtyTwoBit)) {
                bit = 32;
            } else if (actionEvent.getSource().equals(comp)) {
                String st = input.getText();
                String s = st.substring(st.indexOf("<html>") + 6, st.indexOf("</html>"));
                StringBuilder sb = new StringBuilder(output.getText());
                int i = sb.indexOf("</html>");
                sb.insert(i, operation.comp(s));
                output.setText(sb.toString());
            } else if (actionEvent.getSource().equals(equal)) {
                //储存输入的二进制数
                String st = input.getText();
                String s = st.substring(st.indexOf("<html>") + 6, st.indexOf("</html>")).replace("+", " + ").replace("-", " - ");
                /*System.out.println(s);*/

                List<String> list = new ArrayList<>(Arrays.asList(s.split(" ")));
                while (list.contains("")) {
                    list.remove("");
                }
            /*int flag = 0;
            for(int i=0;i<s.length();i++) {
                if (s.charAt(i) != '0' && s.charAt(i) != '1'||i==s.length()-1) {
                    list.add(s.substring(i - flag, i));
                    if (i != s.length() - 1)
                        i--;
                    flag = 0;
                }
                flag++;
            }*/
                //System.out.println(list.toString());
                //测试是否可以真确显示
            /*StringBuilder stringBuilder = new StringBuilder();
            for(String str:list){
                stringBuilder.append(str).append(" ");
            }
            StringBuilder sb= new StringBuilder(output.getText());
            System.out.println(stringBuilder.toString());
            int i=sb.indexOf("</html>");
            System.out.println(i);
            sb.insert(i,stringBuilder.toString());
            output.setText(sb.toString());*/
                //进行运算
                StringBuilder sb = new StringBuilder(output.getText());
                int i = sb.indexOf("</html>");
                sb.insert(i, operation.operation(list));
                output.setText(sb.toString());

                StringBuilder sbi = new StringBuilder(sign.getText());
                int j = sbi.indexOf("</html>");
                sbi.insert(j,operation.hasSign());
                sign.setText(sbi.toString());
                //将字符串拼接显示
                //output.setText();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "error",JOptionPane.ERROR_MESSAGE);
        }
    }

    void ifHasOutputAndSign(){
        String st= output.getText();
        String s = st.substring(st.indexOf("<html>")+6,st.indexOf("</html>"));
        if(!s.isEmpty()){
            input.setText("<html></html>");
            output.setText("<html></html>");
            sign.setText("<html></html>");
        }
    }
}
