package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 林夕
 * Date 2021/4/14 18:20
 */
public class Interface implements ActionListener {

    private final JFrame jFrame = new JFrame("二进制计算器");

    //屏幕
    private JLabel output = new JLabel("<html></html>");
    private final JLabel input = new JLabel("<html></html>");
    //按钮
    private JButton zero = new JButton("0");
    private JButton one = new JButton("1");
    private JButton add = new JButton("+");
    private JButton reduce = new JButton("-");
    private JButton and = new JButton("AND");
    private JButton or = new JButton("OR");
    private JButton xor = new JButton("XOR");
    private JButton not = new JButton("NOT");
    private JButton equal = new JButton("=");
    private JButton clear = new JButton("CLR");

    Interface(){
        //中间容器
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        //定义按钮字体
        Font buttonFont = new Font("黑体", Font.PLAIN, 20);

        //设置输入输出宽度，以便换行
        input.setSize(200,0);
        output.setSize(200,0);

        //输入输出前的文字
        JLabel label1 = new JLabel("output:");
        JLabel label2 = new JLabel(" input:");
        //设置文字字体
        label1.setFont(new java.awt.Font("黑体", Font.BOLD,36));//设置字体为黑体，字体大小为12，1代表样式(1是粗体，0是平常的
        label2.setFont(new java.awt.Font("黑体", Font.BOLD,36));//设置字体为黑体，字体大小为12，1代表样式(1是粗体，0是平常的

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

        /**
         * 在第一个中间容器中定义盒式布局，将文字与{@link output}水平排布
         */
        Box box1 = Box.createHorizontalBox();
        box1.add(label1);
        box1.add(Box.createHorizontalStrut(100));
        box1.add(output);
        p1.setLayout(new BorderLayout());
        p1.add(box1);

        /**
         * 在第二个中间容器中定义盒式布局，将文字与{@link input}水平排布
         */
        Box box2 = Box.createHorizontalBox();
        box2.add(label2);
        box2.add(Box.createHorizontalStrut(100));
        box2.add(input);
        p2.setLayout(new BorderLayout());
        p2.add(box2);

        //在第三个中间容器中设置为一行3列的网格布局
        GridLayout gridLayout = new GridLayout(1,3);

        //网格布局中的三个中间容器
        JPanel pg1 = new JPanel();
        JPanel pg2 = new JPanel();
        JPanel pg3 = new JPanel();

        //对第一二个中间容器设置为4行1列的网格布局，对第三个中间容器设置为2行1列的网格布局
        pg1.setLayout(new GridLayout(4,1));
        pg2.setLayout(new GridLayout(4,1));
        pg3.setLayout(new GridLayout(2,1));

        //将按钮添加至第一个中间容器
        pg1.add(zero);
        pg1.add(add);
        pg1.add(and);
        pg1.add(or);

        //将按钮添加至第二个中间容器
        pg2.add(one);
        pg2.add(reduce);
        pg2.add(not);
        pg2.add(xor);

        //将按钮添加至第三个中间容器
        pg3.add(clear);
        pg3.add(equal);

        //将这些全部添加至第三个容器
        p3.setLayout(gridLayout);
        p3.add(pg1);
        p3.add(pg2);
        p3.add(pg3);

        //设置主面板布局格式为3行一列布局
        jFrame.setLayout(new GridLayout(3,1));
        //将3个中间容器添加进去
        jFrame.add(p1);
        jFrame.add(p2);
        jFrame.add(p3);

        //设置界面大小
        jFrame.setSize(500,500);
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
        if(actionEvent.getSource().equals(zero)){
            StringBuilder s= new StringBuilder(input.getText());
            int i=s.indexOf("</html>");
            s.insert(i,"0");
            input.setText(s.toString());
        }
        else if(actionEvent.getSource().equals(one)){
            StringBuilder s= new StringBuilder(input.getText());
            int i=s.indexOf("</html>");
            s.insert(i,"1");
            input.setText(s.toString());
        }
        else if(actionEvent.getSource().equals(add)){
            StringBuilder s= new StringBuilder(input.getText());
            int i=s.indexOf("</html>");
            s.insert(i,"+");
            input.setText(s.toString());
        }
        else if(actionEvent.getSource().equals(reduce)){
            StringBuilder s= new StringBuilder(input.getText());
            int i=s.indexOf("</html>");
            s.insert(i,"-");
            input.setText(s.toString());
        }
        else if(actionEvent.getSource().equals(and)){
            StringBuilder s= new StringBuilder(input.getText());
            int i=s.indexOf("</html>");
            s.insert(i," AND ");
            input.setText(s.toString());
        }
        else if(actionEvent.getSource().equals(or)){
            StringBuilder s= new StringBuilder(input.getText());
            int i=s.indexOf("</html>");
            s.insert(i," OR ");
            input.setText(s.toString());
        }
        else if(actionEvent.getSource().equals(xor)){
            StringBuilder s= new StringBuilder(input.getText());
            int i=s.indexOf("</html>");
            s.insert(i," XOR ");
            input.setText(s.toString());
        }
        else if(actionEvent.getSource().equals(not)){
            StringBuilder s= new StringBuilder(input.getText());
            int i=s.indexOf("</html>");
            s.insert(i," NOT ");
            input.setText(s.toString());
        }
        else if(actionEvent.getSource().equals(clear)){
            input.setText("<html></html>");
            output.setText("<html></html>");
        }
        else if(actionEvent.getSource().equals(equal)){
            //储存输入的二进制数
            List<String> list = new ArrayList<>();
            String st= input.getText();
            String s = st.substring(st.indexOf("<html>")+6,st.indexOf("</html>"));
            System.out.println(s);
            //通过flag来判断是否为指定位数的二进制数
            int flag = 0;
            for(int i=0;i<s.length();i++) {
                if (s.charAt(i) != '0' && s.charAt(i) != '1'||i==s.length()-1) {
                    list.add(s.substring(i - flag, i));
                    flag = 0;
                }
                flag++;
            }
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
            Operation operation = new Operation();
            StringBuilder sb= new StringBuilder(output.getText());
            int i=sb.indexOf("</html>");
            sb.insert(i,operation.operation(list));
            output.setText(sb.toString());
            //将字符串拼接显示
            //output.setText();
        }
    }
}
