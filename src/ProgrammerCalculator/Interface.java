package ProgrammerCalculator;

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

    //当前计算器位数
    public static int bit = 16;

    //是否已进行运算(用于判断用户输入时是否覆盖输入)
    public static boolean hasOutput = false;

    //工具类
    private final Operation operation = new Operation();

    //屏幕输入栏和最顶端标志栏
    private final JLabel input = new JLabel("<html></html>");
    //初始为16进制
    private final JLabel sign = new JLabel("<html>HEX</html>");
    //按钮
    private final JButton DEC = new JButton("DEC");
    private final JButton HEX = new JButton("HEX");
    private final JButton OCT = new JButton("OCT");
    private final JButton OFF = new JButton("OFF");
    private final JButton ONC = new JButton("ON/C");
    private final JButton STO = new JButton("STO");
    private final JButton RCT = new JButton("RCT");
    private final JButton SUM = new JButton("SUM");
    private final JButton LeftParenthesis = new JButton("(");
    private final JButton RightParenthesis = new JButton(")");
    private final JButton SHF = new JButton("SHF");
    private final JButton d = new JButton("d");
    private final JButton E = new JButton("E");
    private final JButton F = new JButton("F");
    private final JButton K = new JButton("K");
    private final JButton sC = new JButton("1'sc");
    private final JButton A = new JButton("A");
    private final JButton b = new JButton("b");
    private final JButton c = new JButton("c");
    private final JButton except = new JButton("÷");
    private final JButton OR = new JButton("OR");
    private final JButton b7 = new JButton("7");
    private final JButton b8 = new JButton("8");
    private final JButton b9 = new JButton("9");
    private final JButton multiply = new JButton("×");
    private final JButton AND = new JButton("AND");
    private final JButton b4 = new JButton("4");
    private final JButton b5 = new JButton("5");
    private final JButton b6 = new JButton("6");
    private final JButton reduce = new JButton("-");
    private final JButton XOR = new JButton("XOR");
    private final JButton b1 = new JButton("1");
    private final JButton b2 = new JButton("2");
    private final JButton b3 = new JButton("3");
    private final JButton add = new JButton("+");
    private final JButton CE = new JButton("CE");
    private final JButton b0 = new JButton("0");
    private final JButton point = new JButton(".");
    private final JButton addAndReduce = new JButton("+/-");
    private final JButton equal = new JButton("=");

    Interface(){
        //中间容器
        //p1为标志栏和输入栏的中间容器
        JPanel p1 = new JPanel();
        //p2为按钮中间容器
        JPanel p2 = new JPanel();

        //设置边界框
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        p1.setBorder(blackLine);
        p2.setBorder(blackLine);

        //设置高度
        p1.setPreferredSize(new Dimension(0,200));
        p2.setPreferredSize(new Dimension(0,200));

        //设置输入输出宽度，以便换行
        input.setSize(200,0);
        sign.setSize(200,0);

        //为按钮添加点击事件
        DEC.addActionListener(this);
        HEX.addActionListener(this);
        OCT.addActionListener(this);
        OFF.addActionListener(this);
        ONC.addActionListener(this);
        STO.addActionListener(this);
        RCT.addActionListener(this);
        SUM.addActionListener(this);
        LeftParenthesis.addActionListener(this);
        RightParenthesis.addActionListener(this);
        SHF.addActionListener(this);
        d.addActionListener(this);
        E.addActionListener(this);
        F.addActionListener(this);
        K.addActionListener(this);
        sC.addActionListener(this);
        A.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        except.addActionListener(this);
        OR.addActionListener(this);
        //comp.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        multiply.addActionListener(this);
        AND.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        reduce.addActionListener(this);
        XOR.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        add.addActionListener(this);
        CE.addActionListener(this);
        b0.addActionListener(this);
        point.addActionListener(this);
        addAndReduce.addActionListener(this);
        equal.addActionListener(this);

        /**
         * 按钮布局逻辑：共有8*5=40个按钮，故申请一个8*5的网格布局即相当于
         * GridLayout gridLayout = new GridLayout(8,5);
         */
        //在第三个中间容器中设置为8行一列的网格布局
        GridLayout gridLayout = new GridLayout(8,1);

        //网格布局中的8个中间容器
        JPanel pg1 = new JPanel();
        JPanel pg2 = new JPanel();
        JPanel pg3 = new JPanel();
        JPanel pg4 = new JPanel();
        JPanel pg5 = new JPanel();
        JPanel pg6 = new JPanel();
        JPanel pg7 = new JPanel();
        JPanel pg8 = new JPanel();

        //对8个中间容器设置为1行5列的网格布局
        pg1.setLayout(new GridLayout(1,5));
        pg2.setLayout(new GridLayout(1,5));
        pg3.setLayout(new GridLayout(1,5));
        pg4.setLayout(new GridLayout(1,5));
        pg5.setLayout(new GridLayout(1,5));
        pg6.setLayout(new GridLayout(1,5));
        pg7.setLayout(new GridLayout(1,5));
        pg8.setLayout(new GridLayout(1,5));

        //将按钮添加至第一个中间容器
        pg1.add(DEC);
        pg1.add(HEX);
        pg1.add(OCT);
        pg1.add(OFF);
        pg1.add(ONC);

        //将按钮添加至第二个中间容器
        pg2.add(STO);
        pg2.add(RCT);
        pg2.add(SUM);
        pg2.add(LeftParenthesis);
        pg2.add(RightParenthesis);

        //将按钮添加至第三个中间容器
        pg3.add(SHF);
        pg3.add(d);
        pg3.add(E);
        pg3.add(F);
        pg3.add(K);

        //将按钮添加至第四个中间容器
        pg4.add(sC);
        pg4.add(A);
        pg4.add(b);
        pg4.add(c);
        pg4.add(except);

        //将按钮添加至第五个中间容器
        pg5.add(OR);
        pg5.add(b7);
        pg5.add(b8);
        pg5.add(b9);
        pg5.add(multiply);

        //将按钮添加至第六个中间容器
        pg6.add(AND);
        pg6.add(b4);
        pg6.add(b5);
        pg6.add(b6);
        pg6.add(reduce);

        //将按钮添加至第七个中间容器
        pg7.add(XOR);
        pg7.add(b1);
        pg7.add(b2);
        pg7.add(b3);
        pg7.add(add);

        //将按钮添加至第八个中间容器
        pg8.add(CE);
        pg8.add(b0);
        pg8.add(point);
        pg8.add(addAndReduce);
        pg8.add(equal);

        //将这些全部添加至第三个容器
        p2.setLayout(gridLayout);
        p2.add(pg1);
        p2.add(pg2);
        p2.add(pg3);
        p2.add(pg4);
        p2.add(pg5);
        p2.add(pg6);
        p2.add(pg7);
        p2.add(pg8);

        //对第一个中间容器设置为垂直box布局，并将标志栏和输入栏放入其中
        Box box1 = Box.createVerticalBox();
        box1.add(sign);
        //设置一个50高度的不可见支撑
        box1.add(Box.createVerticalStrut(50));
        box1.add(input);
        p1.setLayout(new BorderLayout());
        p1.add(box1);

        //设置主面板布局格式
        JFrame jFrame = new JFrame("二进制计算器");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        //将中间容器p1放在最上方
        jPanel.add(p1,BorderLayout.NORTH);
        //将中间容器p2放在中间
        jPanel.add(p2,BorderLayout.CENTER);
        jFrame.add(jPanel);

        //设置界面大小
        jFrame.setSize(500,650);
        //设置不可最大化
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        //设置可见
        jFrame.setVisible(true);
        jFrame.requestFocus();
        jFrame.validate();
        //设置点击"×"健时什么也不做
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //设置关闭提示信息
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "确认退出?", "确认", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(result == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });
    }

    /**
     * 监听点击事件，对于不同的点击按钮进行不同的操作
     * @param actionEvent
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            if (actionEvent.getSource().equals(b0)) {
                //判断是否有输入，若有输入这将输入框置空
                ifHasOutputAndSign();
                //获取输入框中的文字
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                //插入后字符串为"<html>0</html>"
                s.insert(i, "0");
                input.setText(s.toString());
                System.out.println(sign.getText());
            } else if (actionEvent.getSource().equals(b1)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "1");
                input.setText(s.toString());
                //System.out.println(s.toString());
            } else if (actionEvent.getSource().equals(b2)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "2");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(b3)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "3");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(b4)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "4");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(b5)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "5");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(b6)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "6");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(b7)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "7");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(b8)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "8");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(b9)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "9");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(A)) {
                if(bit==10){
                    throw new RuntimeException("当前为10进制，非法输入");
                }
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "a");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(b)) {
                if(bit==10){
                    throw new RuntimeException("当前为10进制，非法输入");
                }
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "b");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(c)) {
                if(bit==10){
                    throw new RuntimeException("当前为10进制，非法输入");
                }
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "c");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(d)) {
                if(bit==10){
                    throw new RuntimeException("当前为10进制，非法输入");
                }
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "d");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(E)) {
                if(bit==10){
                    throw new RuntimeException("当前为10进制，非法输入");
                }
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "E");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(F)) {
                if(bit==10){
                    throw new RuntimeException("当前为10进制，非法输入");
                }
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, "F");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(add)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i,  " + ");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(reduce)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, " - ");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(multiply)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, " * ");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(except)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, " / ");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(AND)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, " AND ");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(OR)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, " OR ");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(XOR)) {
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, " XOR ");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(sC)) {
                /**
                 * 反码操作，点击按钮即时计算
                 */
                String st = input.getText();
                String s = st.substring(st.indexOf("<html>") + 6, st.indexOf("</html>"));
                StringBuilder sb = new StringBuilder("<html></html>");
                int i = sb.indexOf("</html>");
                sb.insert(i, operation.sc(s));
                input.setText(sb.toString());
            } else if (actionEvent.getSource().equals(addAndReduce)) {
                /**
                 * 补码操作，点击按钮即时计算
                 */
                String st = input.getText();
                String s = st.substring(st.indexOf("<html>") + 6, st.indexOf("</html>"));
                StringBuilder sb = new StringBuilder("<html></html>");
                int i = sb.indexOf("</html>");
                sb.insert(i, operation.addAndReduce(s));
                input.setText(sb.toString());
            } else if (actionEvent.getSource().equals(SHF)) {
                /**
                 * 移位操作
                 */
                ifHasOutputAndSign();
                StringBuilder s = new StringBuilder(input.getText());
                int i = s.indexOf("</html>");
                s.insert(i, " SHF ");
                input.setText(s.toString());
            } else if (actionEvent.getSource().equals(HEX)) {
                /**
                 * 16进制转换，点击按钮将10进制转换为16进制，并将标志栏的DEC修改为HEX，即时计算
                 */
                sign.setText("<html>HEX</html>");
                bit = 16;
                String st = input.getText();
                if(!st.equals("<html></html>")) {
                    String s = st.substring(st.indexOf("<html>") + 6, st.indexOf("</html>"));
                    StringBuilder sb = new StringBuilder("<html></html>");
                    int i = sb.indexOf("</html>");
                    sb.insert(i, operation.hex(s));
                    input.setText(sb.toString());
                }
            } else if (actionEvent.getSource().equals(DEC)) {
                /**
                 * 10进制转换，点击按钮将16进制转换为10进制，并将标志栏的HEX修改为DEC，即时计算
                 */
                sign.setText("<html>DEC</html>");
                bit = 10;
                String st = input.getText();
                if(!st.equals("<html></html>")) {
                    String s = st.substring(st.indexOf("<html>") + 6, st.indexOf("</html>"));
                    StringBuilder sb = new StringBuilder("<html></html>");
                    int i = sb.indexOf("</html>");
                    sb.insert(i, operation.dec(s));
                    input.setText(sb.toString());
                }
            } else if (actionEvent.getSource().equals(ONC)) {
                input.setText("<html></html>");
            } else if (actionEvent.getSource().equals(equal)) {
                //储存输入的数
                String st = input.getText();
                String s = st.substring(st.indexOf("<html>") + 6, st.indexOf("</html>"));
                System.out.println(s);

                //按空格切割为list
                List<String> list = new ArrayList<>(Arrays.asList(s.split(" ")));
                while (list.contains("")) {
                    list.remove("");
                }
                //进行运算
                StringBuilder sb = new StringBuilder("<html></html>");
                int i = sb.indexOf("</html>");
                sb.insert(i, operation.operation(list));
                input.setText(sb.toString());
                //将是否进行计算标志置为true
                hasOutput = true;
            }
        }catch (Exception e){
            /**
             * 捕获计算中的所有异常，若要添加可使用
             * throw new RuntimeException(message);
             * message 为需要提示的信息，如被除数不能为0
             */
            JOptionPane.showMessageDialog(null, e.getMessage(), "error",JOptionPane.ERROR_MESSAGE);
        }
    }

    //判断是否有输出，若有输出，则将输入置空
    void ifHasOutputAndSign(){
        if(hasOutput){
            input.setText("<html></html>");
            hasOutput=false;
        }
    }
}
