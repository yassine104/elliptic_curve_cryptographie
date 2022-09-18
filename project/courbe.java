import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.math.BigInteger; 
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList; 
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
    
    class courbe extends JComponent
    { 
        private static final long serialVersionUID=1222;
        private Vector<Integer> X; 
        private Vector<Integer> Y; 
        private Integer p;
        public boolean ok,ok1,ok2,ok3,ok4=false; 
        public int h,h1,x3,y3,x4,y4,x5,y5=0;
        Font  f4  = new Font(Font.DIALOG_INPUT,  Font.BOLD, 15);
        public String msg1="P";
        String msg2="Q";
        String msg3="S";
        String msg4="M";
        String msg5="=";

        public courbe(ellipticcurve ecc){ 
        super(); 
        Y=ecc.constructpointsx(); 
        X=ecc.constructpointsy();
        p=ecc.p; 
    }
    public Integer get_X(int i)
    {
        return X.get(i);
    }
    public Integer get_Y(int i)
    {
        return Y.get(i);
    }
    public Integer get_S()
    {
        return X.size();
    }

    protected void paintComponent(Graphics g)
    { 
        super.paintComponent(g); 
        g.setColor(Color.WHITE); 
        g.fillRect(0,0,getWidth(),getHeight()); 
        g.setColor(Color.RED); 
        g.drawLine(0,getHeight()-2,getWidth(),getHeight()-2);
        g.drawLine(3,0,3,getHeight());  

        g.setColor(Color.GRAY);
        for(int i=1; i<p;i++){ 
        g.drawLine(0,topixely(i),topixelx(p),topixely(i)); } 
        for(int i=1; i<p;i++){ 
        g.drawLine(topixelx(i),topixely(0),topixelx(i),topixely(p));  } 
        g.setColor(Color.BLACK);
        for(int i=0;i<=p;i++){String str=Integer.toString(i);  g.drawString(str,topixelx(i),topixely(0)-3); 
   } 
        for(int i=0; i<=p; i++){String str=Integer.toString(i);  g.drawString(str,topixelx(0)+5,topixely(i));  }
        for(int i=0; i<X.size();i++){  
        g.setColor(Color.BLUE);
        g.fillRect(topixelx(X.get(i)),topixely(Y.get(i))-4,4,4);           

}
        if (ok==true)
        {
        g.setColor(Color.RED);
        g.fillRect(topixelx(X.get(h)),topixely(Y.get(h))-4,4,4);
        g.setFont(f4);
        g.drawString(msg1,topixelx(X.get(h))+5,topixely(Y.get(h))-10);
        }
        if (ok1==true)
        {
        g.setColor(Color.CYAN);
        g.fillRect(topixelx(X.get(h1)),topixely(Y.get(h1))-4,4,4);
        g.setFont(f4);
        g.drawString(msg2,topixelx(X.get(h1))+5,topixely(Y.get(h1))-10);
        }
        if (ok2==true)
        {
        g.setColor(new Color(0,160,0));
        g.fillRect(topixelx(x3),topixely(y3)-4,4,4);
        g.setFont(f4);
        g.drawString(msg3,topixelx(x3)+5,topixely(y3)-10);
        }
        if (ok3==true)
        {
        g.setColor(new Color(204,0,204));
        g.fillRect(topixelx(x4),topixely(y4)-4,4,4);
        g.setFont(f4);
        g.drawString(msg4,topixelx(x4)+5,topixely(y4)-10);
        }  
        if (ok4==true)
        {
        g.setColor(Color.RED);
        g.fillRect(topixelx(x5),topixely(y5)-4,4,4);     
        g.setFont(f4);
        g.setColor(Color.RED);
        g.drawString(msg1,topixelx(x5)+5,topixely(y5)-10);
        g.setColor(Color.BLACK);
        g.drawString(msg5,topixelx(x5)+15,topixely(y5)-10);
        g.setColor(Color.RED);
        g.drawString(msg2,topixelx(x5)+25,topixely(y5)-10);
        }     
    
  }
    public void draw7(int a1,int b1,int c1)
    {
        ellipticcurve ecc1= new ellipticcurve(a1,b1,c1);
        Y=ecc1.constructpointsx(); 
        X=ecc1.constructpointsy();
        p=ecc1.p; 
        repaint();
    }
    public int size_R(int a1,int b1,int c1)
    { 
        ellipticcurve ecc1= new ellipticcurve(a1,b1,c1);
        X=ecc1.constructpointsx();
        return X.size();
    }


public int topixely(double x){ 
return (int)(((p-x)/p)*getHeight()); }
public int topixelx(double x){ 
return (int)((x/p)*getWidth()); 
}}