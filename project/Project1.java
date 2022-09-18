import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.math.BigInteger; 
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.event.*;  
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.MouseInfo;
import java.util.ArrayList; 
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Project1 extends JFrame implements MouseListener
{
    JSpinner s1,s2,s3,s4;
    SpinnerModel model1,model2,model3,model4;   
    ellipticcurve ec = new ellipticcurve();
    courbe ccc= new courbe(ec);
    JLabel[] arr1=new JLabel[400];
    JRadioButton rBtn2,rBtn1,rBtn3,rBtn4;
    JLabel l9,l8,l11,u3,u4,u5;
    int x1=-10,x2=-10,y1=-10,y2=-10,val;
    String value1,ss1,ss4;
    int vali,int1,int4,int7,int8,int9,x,y,x22,y22;
    JFrame f=new JFrame();
    ellipticcurve ec2,ec3;
    JPanel contentPane = (JPanel) getContentPane();
    int currentCard = 1;
    JPanel cardPanel = new JPanel();
    CardLayout cl=new CardLayout();
    boolean hell=false;
    JScrollPane jjj3=new JScrollPane(ccc,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    public Project1()
    { 
        super( "Eliptic Curve Cryptographie" );
        ccc.addMouseListener(this);
        this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        // Construction et injection de la barre d'outils
        contentPane.add( this.createToolBar(), BorderLayout.NORTH );
        contentPane.add(this.createhelp(),BorderLayout.WEST);
        contentPane.add(this.createalgo(),BorderLayout.EAST);
        cardPanel.setLayout(cl);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        cardPanel.add(jjj3, "1");
        cardPanel.add(this.createhell(), "2");
        contentPane.add(cardPanel,BorderLayout.CENTER);       
        this.setSize(1200,500);
        this.setLocationRelativeTo( null );
     // Construction et injection de la barre de menu
        this.setJMenuBar( this.createMenuBar() );
    }
        private JPanel createhell()
    {
        JPanel hellBar  = new JPanel (new GridLayout(0,2));
        hellBar.setBackground(new Color(220,220,220));
        Font  f4  = new Font(Font.DIALOG_INPUT,  Font.BOLD, 15);
        Font  f3  = new Font(Font.DIALOG_INPUT,  Font.BOLD, 12);
        JLabel u1= new JLabel("Elliptic curve:                                                                                ");
        u1.setFont(f3);
        u3=new JLabel("a=      ");
        u3.setFont(f3);
        u4=new JLabel("b=      ");
        u4.setFont(f3);
        u5=new JLabel("p=      ");
        JButton i1=new JButton("");
        i1.setPreferredSize(new Dimension(0,30));
        u5.setFont(f3);
        JLabel u6=new JLabel("");
        JLabel u7=new JLabel("Generator G:                                                                                   ");
        u7.setFont(f3);
        JLabel u8=new JLabel("(");
        JTextField i4=new JTextField("");
        i4.setPreferredSize(new Dimension(35,30));
        JLabel u9=new JLabel(",");
        JTextField i5=new JTextField("");
        i5.setPreferredSize(new Dimension(35,30));
        JLabel u10=new JLabel(")         ");
        JPanel q1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        q1.setBackground(new Color(220,220,220));
        JPanel q2=new JPanel(new FlowLayout(FlowLayout.LEFT));
        q2.setBackground(new Color(220,220,220));
        JLabel yy1=new JLabel("________ALICE__________________________________________");
        yy1.setFont(f4);    
        yy1.setForeground(new Color(150,0,0));
        JButton yy2=new JButton("secret key:                                   ");
        yy2.setFont(f4);
        yy2.setBackground(Color.RED);
        yy2.setOpaque(true);
        JLabel yy4=new JLabel("a = ");
        JTextField yy3=new JTextField();
        JButton yy5=new JButton("Create shared Keys:                                        ");
        yy5.setBackground(Color.RED);
        yy5.setOpaque(true);
        yy5.setFont(f4);
        yy3.setPreferredSize(new Dimension(200,30));
        JLabel yy6=new JLabel("A = ");
        JTextField yy7=new JTextField();
        yy7.setPreferredSize(new Dimension(200,30));
        JButton yy8=new JButton("Generate common Key:                         "); 
        yy8.setFont(f4);
        yy8.setBackground(Color.RED);
        yy8.setOpaque(true);
        JLabel yy9=new JLabel("S = ");
        JTextField yy10=new JTextField();
        yy10.setPreferredSize(new Dimension(200,30));
        JLabel yy11=new JLabel("                                                                                                                  ");
        JLabel yy13=new JLabel("                                                                                 ");
        JButton yy12=new JButton("New");
        yy12.setPreferredSize(new Dimension(250,30));
        yy12.setFont(f4);
        yy2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                yy2.setBackground(Color.GREEN);
                yy2.setOpaque(true);
                ss1=yy3.getText();
                int1=Integer.parseInt(ss1);
                yy3.setText("xxxxxxxxxxxxxx");
            }
        });
        yy5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String a;
                int7=(int)s3.getValue(); 
                int8=(int)s4.getValue(); 
                a=(String)s1.getValue();
                int9=Integer.parseInt(a);
                ec2=new ellipticcurve(int7,int8,int9); 
                x=ec2.multiplyx(int1,Integer.parseInt(i4.getText()),Integer.parseInt(i5.getText())) ; 
                y=ec2.multiplyy(int1,Integer.parseInt(i4.getText()),Integer.parseInt(i5.getText())) ;
                yy7.setText("("+Integer.toString(x)+" , "+Integer.toString(y)+")");
                yy5.setBackground(Color.GREEN);
                yy5.setOpaque(true); 
            }
        });
        yy8.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int x3=ec2.multiplyx(int4,x,y);   
                int y3=ec2.multiplyy(int4,x,y);    
                String s3="("+Integer.toString(x3)+" , "+Integer.toString(y3)+")";   
                yy10.setText(s3);
                yy8.setBackground(Color.GREEN);
                yy8.setOpaque(true);  
            }
        });
        q1.add(u1);
        q1.add(u3);
        q1.add(u4);
        q1.add(u5);
        q1.add(i1);
        q1.add(yy1);
        q1.add(yy2);
        q1.add(yy4);
        q1.add(yy3);
        q1.add(yy5);
        q1.add(yy6);
        q1.add(yy7);
        q1.add(yy8);
        q1.add(yy9);
        q1.add(yy10);
        q1.add(yy11);
        q1.add(yy13);
        q1.add(yy12);
        JLabel y1=new JLabel("__________BOB__________________________________________");
        y1.setFont(f4);
        y1.setForeground(new Color(150,0,0));
        JButton y2=new JButton("secret key:                                     "); 
        y2.setFont(f4);
        y2.setBackground(Color.RED);
        y2.setOpaque(true);
        JLabel y4=new JLabel("b = ");
        JTextField y3=new JTextField();
        y3.setPreferredSize(new Dimension(200,30));
        JButton y5=new JButton("Create shared Keys:                                       ");
        y5.setBackground(Color.RED);
        y5.setOpaque(true);
        y5.setFont(f4);
        JLabel y6=new JLabel("B = ");
        JTextField y7=new JTextField();
        y7.setPreferredSize(new Dimension(200,30));
        JButton y8=new JButton("Generate common Key:                                    "); 
        y8.setFont(f4);
        y8.setBackground(Color.RED);
        y8.setOpaque(true);
        JLabel y9=new JLabel("S = ");
        JTextField y10=new JTextField();
        y10.setPreferredSize(new Dimension(200,30));
        y2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                y2.setBackground(Color.GREEN);
                y2.setOpaque(true);
                ss4=y3.getText();
                int4=Integer.parseInt(ss4);
                y3.setText("xxxxxxxxxxxxxx");
            }
        });
        y5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String a;
                int7=(int)s3.getValue(); 
                int8=(int)s4.getValue(); 
                a=(String)s1.getValue();
                int9=Integer.parseInt(a);
                ec3=new ellipticcurve(int7,int8,int9); 
                x22=ec2.multiplyx(int4,Integer.parseInt(i4.getText()),Integer.parseInt(i5.getText())) ; 
                y22=ec2.multiplyy(int4,Integer.parseInt(i4.getText()),Integer.parseInt(i5.getText())) ;
                y7.setText("("+Integer.toString(x22)+" , "+Integer.toString(y22)+")"); 
                y5.setBackground(Color.GREEN);
                y5.setOpaque(true);
            }
        });
        y8.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int x4=ec2.multiplyx(int1,x22,y22);   
                int y4=ec2.multiplyy(int1,x22,y22);    
                String s3="("+Integer.toString(x4)+" , "+Integer.toString(y4)+")";   
                y10.setText(s3);
                y8.setBackground(Color.GREEN);
                y8.setOpaque(true);  
            }
        });
        yy12.addActionListener(new ActionListener()
        {
              public void actionPerformed(ActionEvent e)
            {
                u3.setText("a=     ");
                u4.setText("b=     ");
                u5.setText("p=     ");
                i4.setText("");
                i5.setText("");
                yy3.setText("");
                yy7.setText("");
                yy10.setText("");
                y3.setText("");
                y7.setText("");
                y10.setText("");
                yy2.setBackground(Color.RED);
                yy5.setBackground(Color.RED);
                yy8.setBackground(Color.RED);
                y2.setBackground(Color.RED);
                y5.setBackground(Color.RED);
                y8.setBackground(Color.RED);
            }
        });
        q2.add(u6);
        q2.add(u7);
        q2.add(u8);
        q2.add(i4);
        q2.add(u9);
        q2.add(i5);
        q2.add(u10);
        q2.add(y1);
        q2.add(y2);
        q2.add(y4);
        q2.add(y3);
        q2.add(y5);
        q2.add(y6);
        q2.add(y7);
        q2.add(y8);
        q2.add(y9);
        q2.add(y10);
        hellBar.add(q1);
        hellBar.add(q2);
        return hellBar;
    }
    private JPanel createhelp()
    {
        JPanel helpBar  = new JPanel ();
        helpBar.setPreferredSize(new Dimension(300, 150));
        JMenuBar mm = new JMenuBar();
        mm.setPreferredSize(new Dimension(300,30 ));
        helpBar.setBackground(Color.WHITE);

        JButton btnLeft = new JButton( "Help" );
        JButton jj = new JButton( "Guide" );
        JButton algo=new JButton("Visuals");
        mm.add(btnLeft);
        mm.add(jj);
        mm.add(algo);
        helpBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        helpBar.add(mm);
        Font  f4  = new Font(Font.DIALOG_INPUT,  Font.BOLD, 13);
        JLabel ll,ll1,ll2,ll3,ll4,ll5,ll6,ll7,ll8,ll9,ll10,ll11,ll12,ll13,ll14,ll15,ll16,ll17,ll18;
        ll =new JLabel("Elliptic Curve Calculation");
        ll.setFont(f4);
        ll.setForeground(new Color(150,0,0));
        helpBar.add(ll);
        ll1 =new JLabel("fill in the curve attributes.");
        helpBar.add(ll1);
        ll2 =new JLabel("It's then possible to perform calculation on the curve ");
        helpBar.add(ll2);
        ll3 =new JLabel("(addition of two points scalar multiplication of a point).");
        helpBar.add(ll3);
        ll4 =new JLabel("");
        ll4.setForeground(new Color(0,0,150));
        helpBar.add(ll4);
        ll5 =new JLabel("");
        helpBar.add(ll5);
        ll6 =new JLabel("");
        helpBar.add(ll6);
        ll7 =new JLabel("");
        helpBar.add(ll7);
        ll8 =new JLabel("");
        helpBar.add(ll8);
        ll9 =new JLabel("");
        helpBar.add(ll9);
        ll10 =new JLabel("");
        helpBar.add(ll10);
        ll11 =new JLabel("");
        helpBar.add(ll11);
        ll12 =new JLabel("");
        helpBar.add(ll12);
        ll13 =new JLabel("");
        helpBar.add(ll13);
        ll14 =new JLabel("");
        helpBar.add(ll14);
        ll15 =new JLabel("");
        helpBar.add(ll15);
        ll16 =new JLabel("");
        helpBar.add(ll16);
        ll17 =new JLabel("");
        helpBar.add(ll17);
        ll18 =new JLabel("");
        helpBar.add(ll18);
        JButton jj4 = new JButton( "" );
        jj4.setPreferredSize(new Dimension(0,0));
        JButton jj1 = new JButton( "" );
        jj1.setPreferredSize(new Dimension(0,0));
        helpBar.add(jj4);
        helpBar.add(jj1);
        jj.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {   
                
                if (hell==true)
                {
                jj4.setPreferredSize(new Dimension(0,0));
                jj1.setPreferredSize(new Dimension(0,0));
                ll.setText("Step1:                                           ");
                ll1.setText("Choose the public parameters for the key exchange.    ");
                ll2.setText("Select an elliptic curve and a corresponding generator.");
                ll3.setText("");
                ll4.setText("");
                ll5.setText("Step2:                                           ");
                ll5.setFont(f4);
                ll5.setForeground(new Color(150,0,0));
                ll6.setText("Alice and Bob now need to create their secret keys.");
                ll7.setText("fill in a secret Key then press at secret key.");
                ll8.setText("Step3:                                            ");
                ll8.setFont(f4);
                ll8.setForeground(new Color(150,0,0));
                ll9.setText("The shared keys will now be created.To create them");
                ll10.setText("click the create sahred key buttons of Alice and Bob.");
                ll11.setText("The shared keys are the generator (G) multiplied by ");
                ll12.setText("the secret key (d): Q = d * G.");
                ll13.setText("Step4:                                           ");
                ll13.setFont(f4);
                ll13.setForeground(new Color(150,0,0));
                ll14.setText("The only thing left for Alice and Bob is to calculate");
                ll15.setText("their common session key by multiplying the shared key");
                ll16.setText("of each other with their own secret key.               ");
                ll17.setText("Key = sA * QB and key = sB * QA.                       ");   
                }
                else
                {
                jj4.setPreferredSize(new Dimension(0,0));
                jj1.setPreferredSize(new Dimension(0,0));
                ll.setText("Elliptic Curve Calculation");
                ll1.setText("fill in the curve attributes.");
                ll2.setText("It's then possible to perform calculation on the curve ");
                ll3.setText("(addition of two points scalar multiplication of a point).");
                ll4.setText("");
                }
            }
        });
        btnLeft.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {   

                if(hell==true)
                {
                jj4.setPreferredSize(new Dimension(0,0));
                jj1.setPreferredSize(new Dimension(0,0));
                ll.setText("ECDH demonstration:                         ");
                ll1.setText("This visualization demonstrates the Diffie-Hellman key");
                ll2.setText("exchange using elliptic curves.                   ");
                ll5.setText("");
                ll6.setText("");
                ll7.setText("");
                ll8.setText(""); 
                ll9.setText("");
                ll10.setText("");
                ll11.setText("");
                ll12.setText("");
                ll13.setText("");
                ll14.setText("");
                ll15.setText("");
                ll16.setText("");
                ll17.setText("");
                }
                else
                {
                jj4.setPreferredSize(new Dimension(0,0));
                jj1.setPreferredSize(new Dimension(0,0));
                ll.setText("Elliptic Curve Calculations tutoriel:");
                ll1.setText("This visualization demonstrates the calculations that ");
                ll2.setText("can be performed on elliptic curves                   ");
                ll3.setText("");
                ll4.setText("More results: ");
                }

            }
        });
        algo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {   

                ll.setText("");
                ll1.setText("");
                ll2.setText("");
                ll3.setText("");
                ll4.setText("                            "); 
                ll5.setText("");
                ll6.setText("");
                ll7.setText("");
                ll8.setText(""); 
                ll9.setText("");
                ll10.setText("");
                ll11.setText("");
                ll12.setText("");
                ll13.setText("");
                ll14.setText("");
                ll15.setText("");
                ll16.setText("");
                ll17.setText("");
                jj4.setText("Elliptic Curve");
                jj4.setPreferredSize(new Dimension(290,30));
                jj1.setText("Diffie-Hellmen");
                jj1.setPreferredSize(new Dimension(290,30));

            }
        });
        jj4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                cl.first(cardPanel);
                currentCard = 1;
                hell=false;
            }
        });
        jj1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                cl.last(cardPanel);
                currentCard =2;
                hell=true;
                jj4.setPreferredSize(new Dimension(0,0));
                jj1.setPreferredSize(new Dimension(0,0));
                ll.setText("Step1:                                           ");
                ll1.setText("Choose the public parameters for the key exchange.    ");
                ll2.setText("Select an elliptic curve and a corresponding generator.");
                ll3.setText("");
                ll4.setText("");
                ll5.setText("Step2:                                           ");
                ll5.setFont(f4);
                ll5.setForeground(new Color(150,0,0));
                ll6.setText("Alice and Bob now need to create their secret keys.");
                ll7.setText("fill in a secret Key then press at secret key.");
                ll8.setText("Step3:                                            ");
                ll8.setFont(f4);
                ll8.setForeground(new Color(150,0,0));
                ll9.setText("The shared keys will now be created.To create them");
                ll10.setText("click the create sahred key buttons of Alice and Bob.");
                ll11.setText("The shared keys are the generator (G) multiplied by ");
                ll12.setText("the secret key (d): Q = d * G.");
                ll13.setText("Step4:                                           ");
                ll13.setFont(f4);
                ll13.setForeground(new Color(150,0,0));
                ll14.setText("The only thing left for Alice and Bob is to calculate");
                ll15.setText("their common session key by multiplying the shared key");
                ll16.setText("of each other with their own secret key.               ");
                ll17.setText("Key = sA * QB and key = sB * QA.                       ");
            }
        });
 
        return helpBar;
    }

    
    private JPanel createalgo()
        {
        String[] arr={"3","5","7","11","13","17","19","23","29","31","37","41","43","47","53","59","61","67","71","73","79","83","89","97","101","103","109","113","127","131","137","139","149","151","163","167","173","179","181","191","193","197","199","211"};
        JPanel algoBar  = new JPanel (new GridLayout(0,2));
        algoBar.setPreferredSize(new Dimension(400, 150));
        algoBar.setBackground(new Color(150,150,150));
        Font  f4  = new Font(Font.DIALOG_INPUT,  Font.BOLD, 20);
        Font f3=new Font(Font.DIALOG_INPUT,Font.BOLD,15);
        Font f2=new Font(Font.DIALOG_INPUT,Font.BOLD,12);     
        JPanel pp=new JPanel(new BorderLayout());
        JPanel rr=new JPanel();
        JLabel ee =new JLabel("Points(0)");
        ee.setFont(f3);
        ee.setForeground(new Color(150,0,0));
        rr.add(ee);
        JPanel pp1=new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        for (int i=0;i<200;i++)
        {
            arr1[i]=new JLabel("");
            arr1[i].setFont(f2);
            pp1.add(arr1[i]);
        }    
        pp.add(rr,BorderLayout.NORTH);
        pp1.setPreferredSize(new Dimension(200,350));
        JScrollPane jjj=new JScrollPane(pp1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pp.add(jjj);
        JPanel ww1 = new JPanel(new FlowLayout(FlowLayout.LEFT,25,10));
        
        JLabel ff=new JLabel("Settings"); 
        ww1.add(ff);
        JPanel l1=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel ff2=new JLabel("a = ");
        model1= new SpinnerListModel(arr);
        s1=new JSpinner(model1);
        model3= new SpinnerNumberModel(0,0,1000,1);
        s3=new JSpinner(model3);   
        s3.setBounds(100,50,100,30);
        System.out.println(vali);
        s3.setPreferredSize(new Dimension(50,25));
        l1.add(ff2);
        l1.add(s3);
        ww1.add(l1);
        JPanel l2=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel ff3=new JLabel("b = ");
        model4= new SpinnerNumberModel(0,0,1000,1);
        s4=new JSpinner(model4);
        s4.setBounds(100,50,100,30);
        s4.setPreferredSize(new Dimension(50,25));
        l2.add(ff3);
        l2.add(s4);
        ww1.add(l2);
        JPanel l3=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel ff5=new JLabel("p = ");
        s1.setBounds(100,50,100,30);
        s1.setPreferredSize(new Dimension(50,25));
        l3.add(ff5);
        l3.add(s1);
        ww1.add(l3);
        JButton hh=new JButton("apply");
        hh.setPreferredSize(new Dimension(90,30));
        ww1.add(hh);
        JLabel l4=new JLabel("Calculations");
        l4.setFont(f4);
        ww1.add(l4);
        JLabel l5=new JLabel("Please choose P or Q via the ");
        ww1.add(l5);
        JLabel l6=new JLabel("radio  buttons, and then from  ");
        ww1.add(l6);
        JLabel l7=new JLabel("with your mouse the graphic     .");
        ww1.add(l7);
        ButtonGroup buttonGroup = new ButtonGroup();
        rBtn1 = new JRadioButton("P");
        rBtn2  = new JRadioButton("Q");
        buttonGroup.add(rBtn1);
        buttonGroup.add(rBtn2);
        ww1.add(rBtn1);
        ww1.add(rBtn2);
        JLabel l10=new JLabel("RESULTS"); 
        l10.setFont(f4);
        l9=new JLabel("P=                     ");
        l9.setFont(f3);
        l8=new JLabel("Q=                     ");
        l8.setFont(f3);
        l11=new JLabel("R=                     ");
        JButton l12=new JButton("SUM");
        JButton l16=new JButton("MUL");
        JLabel l13=new JLabel("do you want to calculate the     ");
        JLabel l14=new JLabel("multiplication of P by a scalar k:");
        ButtonGroup buttonGroup1 = new ButtonGroup();
        rBtn3 = new JRadioButton("YES");
        rBtn4  = new JRadioButton("NO");
        buttonGroup1.add(rBtn3);
        buttonGroup1.add(rBtn4);
        JPanel l15=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel ff6=new JLabel("       K = ");
        model2= new SpinnerNumberModel(1,1,100,1);
        s2=new JSpinner(model2);
        s2.setBounds(100,50,100,30);
        s2.setPreferredSize(new Dimension(50,25));
        l15.add(ff6);
        l15.add(s2);
        l11.setFont(f3);
        ww1.add(l13);
        ww1.add(l14);
        ww1.add(l15);
        ww1.add(rBtn3);
        ww1.add(rBtn4);
        ww1.add(l10);
        ww1.add(l9);
        ww1.add(l8); 
        ww1.add(l11);
        ww1.add(l12);
        ww1.add(l16);
        ww1.setPreferredSize(new Dimension(200,700)); 
        JScrollPane jjj1=new JScrollPane(ww1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        rBtn3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                l8.setText("K= ");
            }
        });
        l16.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (rBtn3.isSelected())
                {
                int i=0;
                int a;
                a=(int)s2.getValue();
                l8.setText("K=  "+s2.getValue());
                l11.setText("M= k*P = "+ec.multiplyx(a,x1,y1)+"|"+ec.multiplyy(a,x1,y1)+"     ");
                ccc.x4=ec.multiplyx(a,x1,y1);
                ccc.y4=ec.multiplyy(a,x1,y1);
                int m=ec.multiplyx(a-1,x1,y1);
                int m1=ec.multiplyy(a-1,x1,y1);
                ccc.ok1=false;
                ccc.ok2=false;
                ccc.ok3=true;
                if (m==x1 && m1!=y1)
                {
                    JOptionPane.showMessageDialog(f,"The line through the points "+(a-1)+"P and P does not intersect the elliptic curve a third time.Point M is the point of infinty");
                    l11.setText("M= k*P = "+"inf     " );
                }
                else  
                {
                ccc.repaint();
                for (int j=0;j<ccc.get_S();j++)
                {
                arr1[j].setBackground(new Color(150,150,150));
                arr1[j].setOpaque(false);
                }
                arr1[ccc.h].setBackground(Color.RED);
                arr1[ccc.h].setOpaque(true);
                while(ccc.get_X(i)!=ccc.x4 || ccc.get_Y(i)!=ccc.y4)
                {
                    i++;
                }
                arr1[i].setBackground(new Color(204,0,204));
                arr1[i].setOpaque(true);
                }
            }}
        });
        rBtn4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                l8.setText("Q= "+x2+"|"+y2+"               ");
            }
        });
        hh.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {   
                String a;
                a=(String)s1.getValue();
                ccc.ok=false;
                ccc.ok1=false;
                ccc.ok2=false;
                ccc.ok3=false;
                ccc.ok4=false;
                l11.setText("R=                     ");
                l8.setText("Q=                     ");
                l9.setText("P=                      ");

                if((int)s3.getValue()>=Integer.parseInt(a))
                {
                s3.setValue(Integer.parseInt(a)-1);
                }
                if((int)s4.getValue()>=Integer.parseInt(a))
                {
                s4.setValue(Integer.parseInt(a)-1);
                }
                ccc.draw7((int)s3.getValue(),(int)s4.getValue(),Integer.parseInt(a));
                ec.set_x((int)s3.getValue());
                ec.set_y((int)s4.getValue());
                ec.set_p(Integer.parseInt(a));
                ee.setText("Points("+ccc.get_S()+")");
                for (int i=0;i<ccc.get_S();i++)
                {
                    arr1[i].setOpaque(false);
                    arr1[i].setText(ccc.get_X(i)+"|"+ccc.get_Y(i)+" ");

                }
                for (int i=ccc.get_S();i<200;i++)
                {
                    arr1[i].setText("");
                }
                pp1.setPreferredSize(new Dimension(200,350));
                if (ccc.get_S()>44)
                {
                    pp1.setPreferredSize(new Dimension(200,600));
                }
                if (ccc.get_S()>77)
                {
                    pp1.setPreferredSize(new Dimension(200,1800));
                }
                u3.setText("a= "+s3.getValue()+"  ");
                u4.setText("b= "+s4.getValue()+"  ");
                u5.setText("p= "+s1.getValue()+"  ");
            }
        });
        l12.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (x1==x2 && y1!=y2)
                {
                    JOptionPane.showMessageDialog(f,"The line through the points P and Q does not intersect the elliptic curve a third time.Point S is the point of infinty" );
                }
                else 
                {
                int i=0;
                l11.setText("S= P+Q = "+ec.sommex(x1,y1,x2,y2)+"|"+ec.sommey(x1,y1,x2,y2)+"       ");
                ccc.x3=ec.sommex(x1,y1,x2,y2);
                ccc.y3=ec.sommey(x1,y1,x2,y2);
                ccc.ok2=true;
                ccc.ok3=false;
                ccc.repaint();
                while(ccc.get_X(i)!=ccc.x3 || ccc.get_Y(i)!=ccc.y3)
                {
                    i++;
                }
                arr1[i].setBackground(new Color(0,160,0));
                arr1[i].setOpaque(true);
            }  }
        });   
        ff.setFont(f4);
        algoBar.add(pp);
        algoBar.add(jjj1);
        return algoBar;
    }


    /* Methode de construction de la barre de menu */
    private JMenuBar createMenuBar() 
    {  

        // La barre de menu à proprement parler
        JMenuBar menuBar = new JMenuBar();
   
        // Définition du menu déroulant "File" et de son contenu
        JMenu mnuFile = new JMenu( "File" );
        mnuFile.setMnemonic( 'F' );

        JMenuItem mnuNewFile = new JMenuItem( "New File" );
        mnuNewFile.setIcon( new ImageIcon( "new.png" ) );
        mnuNewFile.setMnemonic( 'N' );
        mnuNewFile.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK) );
        mnuNewFile.addActionListener( this::mnuNewListener );
        mnuFile.add(mnuNewFile);

        mnuFile.addSeparator();

        JMenuItem mnuOpenFile = new JMenuItem( "Open File ..." );
        mnuOpenFile.setIcon( new ImageIcon( "open.png" ) );
        mnuOpenFile.setMnemonic( 'O' );
        mnuOpenFile.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK) );
        mnuFile.add(mnuOpenFile);

        JMenuItem mnuSaveFile = new JMenuItem( "Save File ..." );
        mnuSaveFile.setIcon( new ImageIcon( "save.png" ) );
        mnuSaveFile.setMnemonic( 'S' );
        mnuSaveFile.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK) );
        mnuFile.add(mnuSaveFile);

        JMenuItem mnuSaveFileAs = new JMenuItem( "Save File As ..." );
        mnuSaveFileAs.setIcon( new ImageIcon( "save_as.png" ) );
        mnuSaveFileAs.setMnemonic( 'A' );
        mnuFile.add(mnuSaveFileAs);

        mnuFile.addSeparator();

        JMenuItem mnuExit = new JMenuItem( "Exit" );
        mnuExit.setIcon( new ImageIcon( "exit.png" ) );
        mnuExit.setMnemonic( 'x' );
        mnuExit.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK) );
        mnuFile.add(mnuExit);
        
        menuBar.add(mnuFile);
        
        // Définition du menu déroulant "Edit" et de son contenu
        JMenu mnuEdit = new JMenu( "Edit" );
        mnuEdit.setMnemonic( 'E' );
        
        JMenuItem mnuUndo = new JMenuItem( "Undo" );
        mnuUndo.setIcon( new ImageIcon( "undo.png" ) );
        mnuUndo.setMnemonic( 'U' );
        mnuUndo.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK) );
        mnuEdit.add(mnuUndo);
        
        JMenuItem mnuRedo = new JMenuItem( "Redo" );
        mnuRedo.setIcon( new ImageIcon( "redo.png" ) );
        mnuRedo.setMnemonic( 'R' );
        mnuRedo.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK) );
        mnuEdit.add(mnuRedo);
        
        mnuEdit.addSeparator();
        
        JMenuItem mnuCopy = new JMenuItem( "Copy" );
        mnuCopy.setIcon( new ImageIcon( "copy.png" ) );
        mnuCopy.setMnemonic( 'C' );
        mnuCopy.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK) );
        mnuEdit.add(mnuCopy);
        
        JMenuItem mnuCut = new JMenuItem( "Cut" );
        mnuCut.setIcon( new ImageIcon( "cut.png" ) );
        mnuCut.setMnemonic( 't' );
        mnuCut.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK) );
        mnuEdit.add(mnuCut);
        
        JMenuItem mnuPaste = new JMenuItem( "Paste" );
        mnuPaste.setIcon( new ImageIcon( "paste.png" ) );
        mnuPaste.setMnemonic( 'P' );
        mnuPaste.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK) );
        mnuEdit.add(mnuPaste);

        menuBar.add(mnuEdit);

        // Définition du menu déroulant "Help" et de son contenu
        JMenu mnuHelp = new JMenu( "Help" );
        mnuHelp.setMnemonic( 'H' );
        
        menuBar.add( mnuHelp );
        
        return menuBar;
    }
     /* Méthode de construction de la barre d'outils */
    private JToolBar createToolBar()
    {

        // La barre d'outils à proprement parler
        JToolBar toolBar = new JToolBar();

        JButton btnNew = new JButton( new ImageIcon( "new.png") );
        btnNew.setToolTipText( "New File (CTRL+N)" );
        btnNew.addActionListener( this::btnNewListener );
        toolBar.add( btnNew );

        JButton btnSave = new JButton( new ImageIcon( "save.png" ) );
        btnSave.setToolTipText( "Save (CTRL+S)" );
        toolBar.add( btnSave );

        JButton btnSaveAs = new JButton( new ImageIcon( "save_as.png" ) );
        btnSaveAs.setToolTipText( "Save As..." );
        toolBar.add( btnSaveAs );

        toolBar.addSeparator();

        JButton btnCopy = new JButton( new ImageIcon( "copy.png") );
        btnCopy.setToolTipText( "Copy (CTRL+C)" );
        toolBar.add( btnCopy );

        JButton btnCut = new JButton( new ImageIcon( "cut.png") );
        btnCut.setToolTipText( "Cut (CTRL+X)" );
        toolBar.add( btnCut );

        JButton btnPaste = new JButton( new ImageIcon( "paste.png") );
        btnPaste.setToolTipText( "Paste (CTRL+V)" );
        toolBar.add( btnPaste );

        toolBar.addSeparator();

        JButton btnExit = new JButton( new ImageIcon( "exit.png") );
        btnExit.setToolTipText( "Exit (ALT+F4)" );
        toolBar.add( btnExit );
        return toolBar;
    
    }

    public void mnuNewListener( ActionEvent event ) 
    {
        JOptionPane.showMessageDialog( this, "Button clicked !" );
    }

    private void btnNewListener( ActionEvent event )
    {
        JOptionPane.showMessageDialog( this, "Button clicked !" );
    }
        @Override
    public void mouseClicked(MouseEvent e) {
        // Invoked when the mouse button has been clicked (pressed and released) on a component
        //System.out.println("You clicked the mouse");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Invoked when a mouse button has been pressed on a component
        int x;
        int y;
        x=e.getX();
        y=e.getY();
        if (rBtn1.isSelected())
        {
        for (int j=0;j<ccc.get_S();j++)
        {
        for (int i=0;i<ccc.get_S();i++)
        {
            if (x<ccc.topixelx(ccc.get_X(i))+15 && ccc.topixelx(ccc.get_X(i))-15<x && y<ccc.topixely(ccc.get_Y(i))+15 && ccc.topixely(ccc.get_Y(i))-15<y)
            {
            arr1[j].setBackground(new Color(150,150,150));
            arr1[j].setOpaque(false);
            }
        }
        if (ccc.h1>0)
        {
        arr1[ccc.h1].setBackground(Color.CYAN);      
        arr1[ccc.h1].setOpaque(true);
        }
    }
        for (int i=0;i<ccc.get_S();i++)
        {
        if (x2==ccc.get_X(i) && y2==ccc.get_Y(i) && x<ccc.topixelx(ccc.get_X(i))+15 && ccc.topixelx(ccc.get_X(i))-15<x && y<ccc.topixely(ccc.get_Y(i))+15 && ccc.topixely(ccc.get_Y(i))-15<y)
        {
            ccc.ok1=false;
            ccc.ok=false;
            ccc.ok4=true;
            ccc.x5=ccc.get_X(i);
            ccc.y5=ccc.get_Y(i);      
            arr1[ccc.h1].setOpaque(false);
            arr1[i].setBackground(Color.RED);
            arr1[i].setOpaque(true);
            l9.setText("P= "+ccc.get_X(i)+"|"+ccc.get_Y(i)+"               ");
            l11.setText("R=                ");
            ccc.repaint();
            x1=ccc.get_X(i);
            y1=ccc.get_Y(i);
        }
        else if (x<ccc.topixelx(ccc.get_X(i))+15 && ccc.topixelx(ccc.get_X(i))-15<x && y<ccc.topixely(ccc.get_Y(i))+15 && ccc.topixely(ccc.get_Y(i))-15<y)
        {
            arr1[i].setBackground(new Color(150,150,150));
            arr1[i].setOpaque(false);
            ccc.ok=true;
            if (x2>-5)
            {
            ccc.ok1=true;
            }
            ccc.ok4=false;
            ccc.ok3=false;
            ccc.ok2=false;
            arr1[i].setBackground(Color.RED);
            arr1[i].setOpaque(true);
            ccc.h=i;
            ccc.repaint();
            l11.setText("R=                  ");
            l9.setText("P= "+ccc.get_X(i)+"|"+ccc.get_Y(i)+"               ");
            x1=ccc.get_X(i);
            y1=ccc.get_Y(i);
        }
    }
    }
    if (rBtn2.isSelected())
        {
        for (int j=0;j<ccc.get_S();j++)
        {
        for (int i=0;i<ccc.get_S();i++)
        {
            if (x<ccc.topixelx(ccc.get_X(i))+15 && ccc.topixelx(ccc.get_X(i))-15<x && y<ccc.topixely(ccc.get_Y(i))+15 && ccc.topixely(ccc.get_Y(i))-15<y)
            {
            arr1[j].setBackground(new Color(150,150,150));
            arr1[j].setOpaque(false);
            }

        }
        if (ccc.h>0)
        {
        arr1[ccc.h].setBackground(Color.RED);      
        arr1[ccc.h].setOpaque(true);
        }
    }          
        for (int i=0;i<ccc.get_S();i++)
        {
        if (x1==ccc.get_X(i) && y1==ccc.get_Y(i) && x<ccc.topixelx(ccc.get_X(i))+15 && ccc.topixelx(ccc.get_X(i))-15<x && y<ccc.topixely(ccc.get_Y(i))+15 && ccc.topixely(ccc.get_Y(i))-15<y)
        {
            ccc.ok=false;
            ccc.ok1=false;
            ccc.ok3=false;
            ccc.ok2=false;
            ccc.ok4=true;
            arr1[ccc.h].setOpaque(false);
            arr1[i].setBackground(Color.RED);
            arr1[i].setOpaque(true);
            ccc.x5=ccc.get_X(i);
            ccc.y5=ccc.get_Y(i);
            l11.setText("R=                  ");
            l8.setText("Q= "+ccc.get_X(i)+"|"+ccc.get_Y(i)+"               ");
            ccc.repaint();
            x2=ccc.get_X(i);
            y2=ccc.get_Y(i);
        }
        else if (x<ccc.topixelx(ccc.get_X(i))+15 && ccc.topixelx(ccc.get_X(i))-15<x && y<ccc.topixely(ccc.get_Y(i))+15 && ccc.topixely(ccc.get_Y(i))-15<y)
        {
            arr1[i].setBackground(new Color(150,150,150));
            arr1[i].setOpaque(false);
            if (x1>-5)
            {
            ccc.ok=true;
            }
            ccc.ok1=true;
            ccc.ok4=false;
            ccc.ok3=false;
            ccc.ok2=false;
            arr1[i].setBackground(Color.CYAN);
            arr1[i].setOpaque(true);
            ccc.h1=i;
            ccc.repaint();
            l11.setText("R=               ");
            l8.setText("Q= "+ccc.get_X(i)+"|"+ccc.get_Y(i)+"               ");
            x2=ccc.get_X(i);
            y2=ccc.get_Y(i);
        }
    }
    }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Invoked when a mouse button has been released on a component
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Invoked when the mouse enters a component

        }
 
    @Override
    public void mouseExited(MouseEvent e) {
        // Invoked when the mouse exits a component
    }
    
    
    public static void main( String[] args ) throws Exception 
    {

        UIManager.setLookAndFeel( new NimbusLookAndFeel() ); 
        Project1 frame = new Project1();       
        frame.setVisible( true );
        
    }
}       
