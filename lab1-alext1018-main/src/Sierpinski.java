import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Sierpinski extends JFrame implements ChangeListener  {
    static JFrame frame;
     static JSlider slider;
     static JLabel lable;
     Graphics g;
     private int width, height;
     private int x = 200;
     private int limit = 15;

	 public static void main(String[] args)
	    {
		 frame = new JFrame("Alex Tang");
		 frame.setSize(800, 800);
		 slider = new JSlider(1,5);
	      slider.setMajorTickSpacing(1);
	      slider.setPaintTrack(true);
	        slider.setPaintTicks(true);
	        slider.setPaintLabels(true);
	      frame.add(slider);
	      frame.setVisible(true);
	    }
	 public void paint(Graphics g) {
	        super.paint(g);
	        width  = getWidth();
	        height = getHeight();
	        g.setColor(Color.BLACK);

	        int w = (width/2)-(x/2);
	        int h = (height/2)-(x/2);
	        g.fillRect(w, h, x, x);
	        if(limit > 0) {
	        	drawRect(g, 5,50, this.getWidth(), this.getHeight()-50,1);
	        }
	    }
		  public static void drawRect(Graphics g,int x,int  y,int  width,int height,int count) {
				if(count<0) { 
					return;
				}
				count--;
		    for(int i=0;i<800;i++)
		    {
		    	Color color =new Color(i,i,i);
		    	g.setColor(color);
		    	g.drawRect(x, y, width, height);
				g.fillRect(x+width/3+i/3, y+ height/3+i/3, width/3-i, height/3-i);
		    }
				
				drawRect(g, x, y, width/3, height/3,count);
				drawRect(g, x+width/3, y, width/3, height/3,count);
				drawRect(g, x+2*width/3, y, width/3, height/3,count);
				drawRect(g, x, y+height/3, width/3, height/3,count);
				drawRect(g, x, y+2*height/3, width/3, height/3,count);
				drawRect(g, x+2*width/3, y+2*height/3, width/3, height/3,count);
				drawRect(g, x+width/3, y+2*height/3, width/3, height/3,count);
				drawRect(g, x+2*width/3, y+height/3, width/3, height/3,count);
			}
	@Override
	
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		slider = (JSlider)e.getSource(); 
		            int i = (int)slider.getValue();
		            if(i==1) {
		            	drawRect(g, 5, 50, this.getWidth(), this.getHeight()-50,0);
		        }    
		            if(i==2) {
		            	drawRect(g, 5, 50, this.getWidth(), this.getHeight()-50,1);		     
		        }    
		            if(i==3) {
		            	drawRect(g, 5, 50, this.getWidth(), this.getHeight()-50,2);            	
		        }    
		            if(i==4) {
		            	drawRect(g, 5, 50, this.getWidth(), this.getHeight()-50,3);	            	
		        }    
		            if(i==5) {
		            	drawRect(g, 5, 50, this.getWidth(), this.getHeight()-50,4);		            	
		        }    	    	
        }    
	}
	
