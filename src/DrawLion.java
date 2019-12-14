import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GraphicsFillEx.MyPanel;

public class DrawLion extends JFrame {
	private MyPanel panel = new MyPanel();
	public DrawLion() {
		setTitle("¶óÀÌ¾ð ±×¸®±â");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(500, 500);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			//ÇüÅÂ
			g.setColor(Color.orange);
			g.fillArc(115,115,270,270,0,360);
			g.setColor(Color.orange);
			g.fillArc(130,110,70,70,0,360);	
			g.setColor(Color.orange);
			g.fillArc(300,110,70,70,0,360);	
			//´«
			g.setColor(Color.black);
			g.fillArc(193,220,20,20,0,360);	
			g.setColor(Color.black);
			g.fillArc(297,220,20,20,0,360);	
			//´«½ç
			Graphics2D g2=(Graphics2D)g;
		    g2.setStroke(new BasicStroke(9,BasicStroke.CAP_ROUND,0));
		    g2.draw(new Line2D.Double(167,200,225,200));
		    g2.setStroke(new BasicStroke(9,BasicStroke.CAP_ROUND,0));	 
		    g2.draw(new Line2D.Double(283,200,335,200));
			/*g.setColor(Color.black);
			g.drawLine(170, 200, 225, 200); 
			g.setColor(Color.black); 
			g.drawLine(280, 200, 335, 200);
			*/
			//ÀÔ
			g.setColor(Color.white);
			g.fillArc(215,270,43,40,0,360);
			g.setColor(Color.white);
			g.fillArc(245,270,43,40,0,360);
			g.setColor(Color.black);
			g.fillArc(245,264,20,20,0,360);	
			
			
		}
		
	}
	public static void main(String[] args) {
		new DrawLion();
	}
}
