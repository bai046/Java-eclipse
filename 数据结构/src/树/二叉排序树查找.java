package 树;

//图形演示——二叉排序树查找
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.util.Arrays;
import java.util.LinkedList;
import javax.swing.text.*;
import javax.swing.JSlider;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
public class 二叉排序树查找 {
private JFrame jFrame = null;
private JPanel jContentPane = null;
private JLabel jLabel15 = null;
private JLabel jLabel151 = null;
private JLabel jLabel152 = null;
private JLabel jLabel153 = null;
private JLabel jLabel154 = null;
private JLabel jLabel155 = null;
private JLabel jLabel156 = null;
private JLabel jLabel17 = null;
private JTextField jTextField = null;
private JButton jButton = null;
private JScrollPane jScrollPane = null;
private JList jList = null;
private JLabel jLabel18 = null;
private JLabel jLabel[] = new JLabel[15];
private int s[] = {3, 4, 1, 6, 5, 11, 31, 12, 9, 10, 2, 13, 32, 15, 14};
private long time = 500L;
private DefaultListModel lItemsForList1;
private JLabel jLabel157 = null;
private JLabel jLabel158 = null;
private JLabel jLabel159 = null;
private JLabel jLabel1510 = null;
private JLabel jLabel1511 = null;
private JLabel jLabel1512 = null;
private JLabel jLabel1513 = null;
private JButton jButton1 = null;
private JPanel jPanel = null;
private JLabel jLabel1 = null;
private JSlider jSlider = null;
private JLabel jLabel2 = null;

//界面设计框架的实现
private JFrame getJFrame() {
    if (jFrame == null) {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(new Rectangle(0, 0, 800, 800));
        jFrame.setContentPane(getJContentPane());
        jFrame.setTitle("Application");
    }
    return jFrame;
}
//初始化面板
private JPanel getJContentPane() {
    if (jContentPane == null) {
        for (int i = 0; i < jLabel.length; i++) {
            jLabel[i] = new JLabel();
        }
        jLabel18 = new JLabel();
        jLabel18.setBounds(new Rectangle(517, 23, 86, 32));
        jLabel18.setText("对照列表如有右所示");
        jLabel17 = new JLabel();
        jLabel17.setBounds(new Rectangle(87, 25, 97, 37));
        jLabel17.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel17.setText("请输入您要查找的数值：");
        jLabel1513 = new JLabel();
        jLabel1513.setBounds(new Rectangle(664, 366, 37, 31));
        jLabel1513.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1513.setFont(new Font("Dialog", Font.ITALIC, 18));
        jLabel1513.setText("＼");
        jLabel1512 = new JLabel();
        jLabel1512.setBounds(new Rectangle(584, 367, 46, 33));
        jLabel1512.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1512.setFont(new Font("Dialog", Font.ITALIC, 18));
        jLabel1512.setText("／");
        jLabel1511 = new JLabel();
        jLabel1511.setBounds(new Rectangle(476, 365, 41, 36));
        jLabel1511.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1511.setFont(new Font("Dialog", Font.ITALIC, 18));
        jLabel1511.setText("＼");
        jLabel1510 = new JLabel();
        jLabel1510.setBounds(new Rectangle(402, 370, 39, 28));
        jLabel1510.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1510.setFont(new Font("Dialog", Font.ITALIC, 18));
        jLabel1510.setText("／");
        jLabel159 = new JLabel();
        jLabel159.setBounds(new Rectangle(284, 374, 58, 28));
        jLabel159.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel159.setFont(new Font("Dialog", Font.ITALIC, 18));
        jLabel159.setText("＼");
        jLabel158 = new JLabel();
        jLabel158.setBounds(new Rectangle(218, 374, 49, 27));
        jLabel158.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel158.setFont(new Font("Dialog", Font.ITALIC, 18));
        jLabel158.setText("／");
        jLabel157 = new JLabel();
        jLabel157.setBounds(new Rectangle(136, 368, 41, 33));
        jLabel157.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel157.setFont(new Font("Dialog", Font.ITALIC, 18));
        jLabel157.setText("＼");
        jLabel156 = new JLabel();
        jLabel156.setBounds(new Rectangle(48, 372, 49, 30));
        jLabel156.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel156.setFont(new Font("Dialog", Font.ITALIC, 18));
        jLabel156.setText("／");
        jLabel155 = new JLabel();
        jLabel155.setBounds(new Rectangle(559, 269, 58, 40));
        jLabel155.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel155.setFont(new Font("Dialog", Font.ITALIC, 18));
        jLabel155.setText("＼");
        jLabel154 = new JLabel();
        jLabel154.setBounds(new Rectangle(454, 270, 48, 34));
        jLabel154.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel154.setFont(new Font("Dialog", Font.ITALIC, 18));
        jLabel154.setText("／");
        jLabel153 = new JLabel();
        jLabel153.setBounds(new Rectangle(212, 284, 64, 24));
        jLabel153.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel153.setFont(new Font("Dialog", Font.ITALIC, 18));
        jLabel153.setText("＼");
        jLabel152 = new JLabel();
        jLabel152.setBounds(new Rectangle(120, 284, 65, 22));
        jLabel152.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel152.setFont(new Font("Dialog", Font.ITALIC, 18));
        jLabel152.setText("／");
        jLabel151 = new JLabel();
        jLabel151.setBounds(new Rectangle(439, 174, 50, 44));
        jLabel151.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel151.setFont(new Font("Dialog", Font.ITALIC, 18));
        jLabel151.setText("＼");
        jLabel15 = new JLabel();
        jLabel15.setBounds(new Rectangle(228, 175, 47, 29));
        jLabel15.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel15.setFont(new Font("Dialog", Font.ITALIC, 18));
        jLabel15.setText("／");
        jLabel[14].setBounds(new Rectangle(676, 401, 76, 44));
        jLabel[14].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[14].setText("O");
        jLabel[14].setFont(new Font("Dialog", Font.BOLD, 18));
        jLabel[13].setBounds(new Rectangle(550, 402, 76, 44));
        jLabel[13].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[13].setText("N");
        jLabel[13].setFont(new Font("Dialog", Font.BOLD, 18));
        jLabel[12].setBounds(new Rectangle(466, 401, 76, 44));
        jLabel[12].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[12].setText("M");
        jLabel[12].setFont(new Font("Dialog", Font.BOLD, 18));
        jLabel[11].setBounds(new Rectangle(374, 401, 76, 44));
        jLabel[11].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[11].setText("L");
        jLabel[11].setFont(new Font("Dialog", Font.BOLD, 18));
        jLabel[10].setBounds(new Rectangle(297, 401, 76, 44));
        jLabel[10].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[10].setText("K");
        jLabel[10].setFont(new Font("Dialog", Font.BOLD, 18));
        jLabel[9].setBounds(new Rectangle(197, 401, 76, 44));
        jLabel[9].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[9].setText("J");
        jLabel[9].setFont(new Font("Dialog", Font.BOLD, 18));
        jLabel[8].setBounds(new Rectangle(123, 401, 76, 44));
        jLabel[8].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[8].setText("I");
        jLabel[8].setFont(new Font("Dialog", Font.BOLD, 18));
        jLabel[7].setBounds(new Rectangle(20, 401, 76, 44));
        jLabel[7].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[7].setText("H");
        jLabel[7].setFont(new Font("Dialog", Font.BOLD, 18));
        jLabel[6].setBounds(new Rectangle(602, 318, 76, 44));
        jLabel[6].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[6].setText("G");
        jLabel[6].setFont(new Font("Dialog", Font.BOLD, 18));
        jLabel[5].setBounds(new Rectangle(417, 318, 76, 44));
        jLabel[5].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[5].setText("F");
        jLabel[2].setBounds(new Rectangle(504, 216, 76, 44));
        jLabel[2].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[2].setText("C");
        jLabel[2].setFont(new Font("Dialog", Font.BOLD, 18));
        jLabel[4].setBounds(new Rectangle(248, 317, 76, 44));
        jLabel[4].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[4].setText("E");
        jLabel[4].setFont(new Font("Dialog", Font.BOLD, 18));
        jLabel[3].setBounds(new Rectangle(82, 318, 76, 44));
        jLabel[3].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[3].setText("D");
        jLabel[3].setFont(new Font("Dialog", Font.BOLD, 18));
        jLabel[1].setBounds(new Rectangle(170, 216, 76, 44));
        jLabel[1].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[1].setText("B");
        jLabel[1].setFont(new Font("Dialog", Font.BOLD, 18));
        jLabel[0].setBounds(new Rectangle(320, 110, 76, 44));
        jLabel[0].setHorizontalAlignment(SwingConstants.CENTER);
        jLabel[0].setText("A");
        jLabel[0].setFont(new Font("Dialog", Font.BOLD, 18));
        jContentPane = new JPanel();
        jContentPane.setLayout(null);
        jContentPane.add(jLabel[0], null);
        jContentPane.add(jLabel[1], null);
        jContentPane.add(jLabel[2], null);
        jContentPane.add(jLabel[3], null);
        jContentPane.add(jLabel[4], null);
        jContentPane.add(jLabel[5], null);
        jContentPane.add(jLabel[6], null);
        jContentPane.add(jLabel[7], null);
        jContentPane.add(jLabel[8], null);
        jContentPane.add(jLabel[9], null);
        jContentPane.add(jLabel[10], null);
        jContentPane.add(jLabel[11], null);
        jContentPane.add(jLabel[12], null);
        jContentPane.add(jLabel[13], null);
        jContentPane.add(jLabel[14], null);
        jContentPane.add(jLabel15, null);
        jContentPane.add(jLabel151, null);
        jContentPane.add(jLabel152, null);
        jContentPane.add(jLabel153, null);
        jContentPane.add(jLabel154, null);
        jContentPane.add(jLabel155, null);
        jContentPane.add(jLabel156, null);
        jContentPane.add(jLabel157, null);
        jContentPane.add(jLabel158, null);
        jContentPane.add(jLabel159, null);
        jContentPane.add(jLabel1510, null);
        jContentPane.add(jLabel1511, null);
        jContentPane.add(jLabel1512, null);
        jContentPane.add(jLabel1513, null);
        jContentPane.add(jLabel17, null);
        jContentPane.add(getJTextField(), null);
        jContentPane.add(getJButton(), null);
        jContentPane.add(getJScrollPane(), null);
        jContentPane.add(jLabel18, null);
        jContentPane.add(getJButton1(), null);
        jContentPane.add(getJPanel(), null);
    }
    return jContentPane;
}

class DigitDocument extends PlainDocument {

    private static final long serialVersionUID = 1L;

    @Override
    public void insertString(int offset, String s, AttributeSet a) {
        char c = s.charAt(0);
        if (c <= '9' && c >= '0') {
            try {
                super.insertString(offset, s, a);
            } catch (BadLocationException e) {
                JOptionPane.showMessageDialog(null,
                        "错误:" + e.getMessage());
            }
        }
    }
}
//初始化文本框
private JTextField getJTextField() {
    if (jTextField == null) {
        jTextField = new JTextField();
        DigitDocument document = new DigitDocument();
        jTextField.setDocument(document);
        jTextField.setBounds(new Rectangle(193, 26, 165, 39));
        jTextField.setFont(new Font("Dialog", Font.BOLD, 18));//字体为粗体，大小为18
    }
    return jTextField;
}
//"查找"初始化及事件响应
private JButton getJButton() {
    if (jButton == null) {
        jButton = new JButton();
        jButton.setBounds(new Rectangle(376, 25, 112, 36));
        jButton.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 18));
//字体以罗马字体为基准
        jButton.setText("查找");
        jButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent e) {
                //初始化
                for (int i = 0; i < jLabel.length; i++) {
                    jLabel[i].setForeground(Color.pink);
                }
                int tom[] = new int[15];
                String temp = null;
                for (int j = 0; j < tom.length; j++) {
                    temp = (String) lItemsForList1.get(j);
                    tom[j] = Integer.parseInt(temp.substring(6, temp.length()));
                }
                String find = jTextField.getText();
                if (!find.equals("")) {
                    MyThread thread = new MyThread(tom);
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        });
    }
    return jButton;
}
//滚动条
private JScrollPane getJScrollPane() {
    if (jScrollPane == null) {
        jScrollPane = new JScrollPane();
        jScrollPane.setBounds(new Rectangle(627, 17, 149, 254));
        jScrollPane.setViewportView(getJList());
    }
    return jScrollPane;
}
//数据及字母对应列表
private JList getJList() {
    if (jList == null) {
        lItemsForList1 = new DefaultListModel();
        jList = new JList();
        String list[] = new String[15];
        Arrays.sort(s);
        int k = 7;
        list[0] = jLabel[k].getText() + " --- " + s[0];
        list[1] = jLabel[k / 2].getText() + " --- " + s[1];
        list[2] = jLabel[k + 1].getText() + " --- " + s[2];
        k = k / 2;
        //k=3
        list[3] = jLabel[k / 2].getText() + " --- " + s[3];
        list[4] = jLabel[(k + 1) * 2 + 1].getText() + " --- " + s[4];
        k++;
        //k=4
        //从0开始，所以多加1
        list[5] = jLabel[k].getText() + " --- " + s[5];
        list[6] = jLabel[k * 2 + 2].getText() + " --- " + s[6];
        k = (k - 1) / 2;
        //k=1;
        list[7] = jLabel[k / 2].getText() + " --- " + s[7];
        //下面是右子树
        k = 14;
        list[8] = jLabel[k].getText() + " --- " + s[14];
        list[9] = jLabel[k / 2 - 1].getText() + " --- " + s[13];
        list[10] = jLabel[k - 1].getText() + " --- " + s[12];
        k = k / 2 - 1;
        //k=6
        list[11] = jLabel[k / 2 - 1].getText() + " --- " + s[11];
        list[12] = jLabel[(k - 1) * 2 + 2].getText() + " --- " + s[10];
        k--;
        //k=5
        list[13] = jLabel[k].getText() + " --- " + s[9];
        list[14] = jLabel[k * 2 + 1].getText() + " --- " + s[8];
        Arrays.sort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.println("a");
            lItemsForList1.addElement(list[i]);
        }
        jList.setModel(lItemsForList1);
    }
    return jList;
}
//"产生随机数"按钮
private JButton getJButton1() {
    if (jButton1 == null) {
        jButton1 = new JButton();
        jButton1.setBounds(new Rectangle(376, 66, 142, 40));
        jButton1.setText("产生随机数");
        jButton1.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 18));
        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent e) {
                LinkedList<Integer> list = new LinkedList<Integer>();
                int temp = 0;
                for (int i = 0; i < jLabel.length; i++) {
                    temp = (int) (Math.random() * 100);
                    while (list.contains(temp)) {
                        temp = (int) (Math.random() * 100);
                    }
                    list.add(temp);
                    s[i] = temp;
                    //label1[i].setText(String.valueOf(array[i]));
                }
                arrange();
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
            }
        });
    }
    return jButton1;
}
//数组
public void arrange() {
    lItemsForList1 = new DefaultListModel();
    jList = getJList();
    String list[] = new String[15];
    Arrays.sort(s);
    int k = 7;
    list[0] = jLabel[k].getText() + " --- " + s[0];
    list[1] = jLabel[k / 2].getText() + " --- " + s[1];
    list[2] = jLabel[k + 1].getText() + " --- " + s[2];
    k = k / 2;
    //k=3
    list[3] = jLabel[k / 2].getText() + " --- " + s[3];
    list[4] = jLabel[(k + 1) * 2 + 1].getText() + " --- " + s[4];
    k++;
    //k=4
    //从0开始，所以多加1
    list[5] = jLabel[k].getText() + " --- " + s[5];
    list[6] = jLabel[k * 2 + 2].getText() + " --- " + s[6];
    k = (k - 1) / 2;
    //k=1;
    list[7] = jLabel[k / 2].getText() + " --- " + s[7];
    //下面是右子树
    k = 14;
    list[8] = jLabel[k].getText() + " --- " + s[14];
    list[9] = jLabel[k / 2 - 1].getText() + " --- " + s[13];
    list[10] = jLabel[k - 1].getText() + " --- " + s[12];     
    k = k / 2 - 1;
    //k=6
    list[11] = jLabel[k / 2 - 1].getText() + " --- " + s[11];
    list[12] = jLabel[(k - 1) * 2 + 2].getText() + " --- " + s[10];
    k--;
    //k=5
    list[13] = jLabel[k].getText() + " --- " + s[9];
    list[14] = jLabel[k * 2 + 1].getText() + " --- " + s[8];
    Arrays.sort(list);
    for (int i = 0; i < list.length; i++) {
        lItemsForList1.addElement(list[i]);
    }
    jList.setModel(lItemsForList1);
}
//速度调节器
private JPanel getJPanel() {
    if (jPanel == null) {
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridx = 2;
        gridBagConstraints2.gridy = 0;
        jLabel2 = new JLabel();
        jLabel2.setText("慢           ");
        jLabel2.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 14));
//字体以罗马字体为基准
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.gridx = 1;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jLabel1 = new JLabel();
        jLabel1.setText("            快");
        jLabel1.setFont(new Font("Dialog", Font.BOLD, 14));  //字体为黑体字，大小为14
        jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());
        jPanel.setBounds(new Rectangle(46, 487, 357, 57));
        jPanel.setBorder(BorderFactory.createTitledBorder(null,
        "\u901f\u5ea6\u8c03\u8282",
        TitledBorder.DEFAULT_JUSTIFICATION,
        TitledBorder.DEFAULT_POSITION,
        new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
jPanel.add(jLabel1, gridBagConstraints);
jPanel.add(getJSlider(), gridBagConstraints1);
jPanel.add(jLabel2, gridBagConstraints2);
}
return jPanel;
}
//滑动条响应
private JSlider getJSlider() {
    if (jSlider == null) {
        jSlider = new JSlider();
        jSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent e) {
                time = jSlider.getValue() * 10;
            }
        });
    }
    return jSlider;
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {//多线程
        @Override
        public void run() {
            二叉排序树查找 application = new 二叉排序树查找();
            application.getJFrame().setVisible(true);
        }
    });
}
//继承线程
class MyThread extends Thread {

    private int s[];

    public MyThread(int[] tom) {
        this.s = tom;
    }

    @Override//覆盖run()方法
    public void run() {
        String find = jTextField.getText();
        if (!find.equals("")) {
            int h = Integer.parseInt(find);//将字符串改为整数
            int i = 0;
            while (h != s[i]) {
                jLabel[i].setForeground(Color.cyan);
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e1) {
                }
                jLabel[i].setForeground(Color.yellow);
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e1) {
                }
                jLabel[i].setForeground(Color.BLUE);
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e1) {
                }
                jLabel[i].setForeground(Color.cyan);
                if (h > s[i]) {
                    //从0开始
                    i = i * 2 + 2;
                } else if (h < s[i]) {
                    i = i * 2 + 1;
                }
                if (i >= s.length) {
                    break;
                }
            }
            if (i < s.length && h == s[i]) {
                jLabel[i].setForeground(Color.cyan);  //查到的数字颜色为蓝绿色
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e1) {
                }
                jLabel[i].setForeground(Color.green);
                jLabel[i].setForeground(Color.orange);
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e1) {
                }
                jLabel[i].setForeground(Color.yellow);
                jLabel[i].setForeground(Color.white);
                JOptionPane.showMessageDialog(jLabel[i], ""
                        + "恭喜哦！您要查找的数值找到了。");
            } else {
                JOptionPane.showMessageDialog(null,
                        "抱歉哦！没有找到您要查找的数值。");
            }
        }
    }
}
}


