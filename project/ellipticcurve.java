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
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList; 
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
    public class ellipticcurve
    { 
        Integer a ; 
        Integer b ; 
        Integer p;
        ellipticcurve()
        {
            a=0;
            b=0;
            p=0;
        }
        ellipticcurve(Integer x,Integer y ,Integer z){
        a=x ; 
        b=y ; 
        p=z ; 
    }
    public Integer get_x()
    {
        return a;
    }
    public void set_x(Integer a1)
    {
        a=a1;
    }
    public Integer get_y()
    {
        return b;
    }
    public void set_y(Integer b1)
    {
        b=b1;
    }
    public Integer get_p()
    {
        return p;
    }
    public void set_p(Integer p1)
    {
        p=p1;
    }
    public void modif(Integer x,Integer y ,Integer z)
    {
        a=x ; 
        b=y ; 
        p=z ; 
    }
    boolean good(Integer x ,Integer y)
    { 
        /*Integer c=(((((((x%p)(x%p))%p)(x%p))%p+((a%p)(x%p))%p)%p)+(b%p))%p; 
        Integer d=((y%p)(y%p))%p;*/
        Integer c= ((x*x*x)+(a*x)+b)%p;
        Integer d=(y*y)%p; 
        return (c-d)%p==0 ; 

    }
    Vector<Integer> constructpointsx(){ 
    Vector<Integer> abs =new Vector<Integer>(); 
 

    for(Integer x=0 ; x<p; x++){ 
    for(Integer y=0; y<p; y++){ 
    if(good(y,x)){ abs.add(x);  }} 
    }
    return abs;
   
    }
    Vector<Integer> constructpointsy(){ 
 
    Vector<Integer> cor =new Vector<Integer>();

    for(Integer x=0 ; x<p; x++){ 
    for(Integer y=0 ; y<p; y++){ 
    if(good(y,x)){ cor.add(y);  }} 
    }
    return cor;
    }
int power(int a,int b){ 
int result=1; 
while(b>0){ 
if(b%2==1)result*=(a%p);result%=p;  
a*=(a%p) ;a%=p; 
b/=2; } 
return result; }
public int divide(int a,int b){  
return (a*power(b,p-2))%p ; } 
public int sommex(int x ,int y,int x1 ,int y1){ 
int s,s1 ;  
if(x!=x1){ s=divide(y-y1,x-x1);  
} 
else { 
s=divide(3*x*x+a,2*y); 
}  
s1=(s*s-x-x1)%p;
if (s1<0)
{
    s1=s1+p;
}
return s1;  } 
public int sommey(int x,int y,int x1,int y1){ 
int s,s1 ;  
if(x!=x1){ s=divide(y-y1,x-x1);  
} 
else{ 
s=divide(3*x*x+a,2*y); 
}
s1=(s*(x1-sommex(x,y,x1,y1))-y1)%p;
if (s1<0)
{
    s1=s1+p;
}
return s1;  
} 
int multiplyy(int k, int x,int y){ int resultx=x ; 
int resulty=y;
int l=0,m=0;  
while(k>1){ 
l=sommey(x,y,resultx,resulty); 
m=sommex(x,y,resultx,resulty); 
resultx=m;
resulty=l;
k--;  } 
return l; }
int multiplyx(int k, int x,int y){ int resultx=x ; 
int resulty=y;  
int l=0,m=0;  
while(k>1){ 
l=sommey(x,y,resultx,resulty); 
m=sommex(x,y,resultx,resulty); 
resultx=m;
resulty=l;
k--;  }
return m;}
    }

 
