package 图像用户界面;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWind w=new MainWind();
		w.repaint();
		  
	}

}
class MainWind extends JFrame{
	public MainWind() {
		setTitle("图形用户界面演示程序");
		setSize(460,300);
		setLocation(100,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) {
		super.paint(g);
		Font ef=new Font("TimeRoman",Font.PLAIN,16);
		g.setFont(ef);//英文
		g.drawString("Hello World!", 20, 80);
		Font cf=new Font("楷体",Font.PLAIN,24);
		g.setFont(cf);//楷体
		g.drawString("你好，世界", 20, 120);
		g.setColor(Color.black);
		g.fillRect(20, 150, 100, 100);
		g.setColor(Color.RED);
		g.drawRect(20, 150, 100, 100);
	}
}