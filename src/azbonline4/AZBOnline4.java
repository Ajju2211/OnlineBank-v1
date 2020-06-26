
package azbonline4;
//package AZBOnline4;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.*;
import java.lang.*;
import java.util.*;
 import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import java.awt.*;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;   
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;
import java.net.URLConnection;
import java.awt.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.util.Date;



class BankMenu  implements ActionListener
{
  static JFrame f=new JFrame();
  static JLabel l1 = new JLabel("Bank Menu:");  
   static JButton btn1 = new JButton("Create Account");  
      static JButton btn2 = new JButton("Login Account");
      static JButton btn3 = new JButton("Admin Login");
      static JButton btn4 = new JButton("Change Admin");
            static JButton btn5 = new JButton("Exit");   
            static JLabel adinfo=new JLabel("Help");
            static JLabel upinfo=new JLabel("Updates");
  public BankMenu()
  {
    
  }
  
public static void run()
{
BankMenu lm=new BankMenu();
            f.setSize(700,360);  
            f.setLayout(null);  
      
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            f.setTitle("AZBanking Online Gateway");  
            f.addWindowListener(new java.awt.event.WindowAdapter(){

  public void windowClosing(java.awt.event.WindowEvent e){

    
    AZBOnline4.cleanup();

  }

      });


            adinfo.setForeground(Color.BLUE.darker());
            upinfo.setForeground(Color.BLUE.darker());
            adinfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            upinfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            adinfo.addMouseListener(new MouseAdapter(){
               public void mouseEntered(MouseEvent me)
              {
                adinfo.setText("<html><a href=''>Contact admin</a></html>");
              }
              public void mouseExcited(MouseEvent me)
              {
                adinfo.setText("Help");
              }
              public void mouseClicked(MouseEvent me)
              {
                 try {
         
        Desktop.getDesktop().browse(new URI("https://drv.tw/~azapps.world@gmail.com/gd/azbBin/BankData/adminprofileview.html"));
         
    } catch (IOException | URISyntaxException e1) {
        //e1.printStackTrace();
        
    }
              }
            });
            upinfo.addMouseListener(new MouseAdapter(){
              public void mouseEntered(MouseEvent me)
              {
                upinfo.setText("<html><a href=''>Visit for Updates</a></html>");
              }
              public void mouseExcited(MouseEvent me)
              {
                upinfo.setText("Updates");
              }

              public void mouseClicked(MouseEvent me)
              {
                 try {
         
        Desktop.getDesktop().browse(new URI("https://drv.tw/~azapps.world@gmail.com/gd/azbBin/BankData/Updates.html"));
         
    } catch (IOException | URISyntaxException e1) {
        e1.printStackTrace();
    }
              }
            });
          
            l1.setForeground(Color.blue);  
            l1.setFont(new Font("Robinson", Font.BOLD, 24));  
           
            l1.setBounds(290, 30, 200, 30);  
           btn1.setBounds(170, 80, 150, 30);  
       btn2.setBounds(350, 80, 150, 30);  
       btn3.setBounds(170, 150, 150, 30);  
       btn4.setBounds(350, 150, 150, 30);  
       btn5.setBounds(290, 210, 100, 30);  
       adinfo.setBounds(5,5,100,15);
       upinfo.setBounds(107,5,120,15);
            f.add(l1);  
            f.add(btn1);  
      f.add(adinfo);
      f.add(upinfo);
      f.add(btn2);  
      f.add(btn3);  
      f.add(btn4);  
      f.add(btn5);  
      btn1.addActionListener(lm);
      btn2.addActionListener(lm);
      btn3.addActionListener(lm);
      btn4.addActionListener(lm);
      btn5.addActionListener(lm);
      Color c1=Color.decode("#b6b7ae");//#4c4e5a  #b6b7ae
            f.getContentPane().setBackground(c1);
      f.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
  BankMenu m=new BankMenu();
  String s=e.getActionCommand();
  if(s.equals("Create Account"))
  {
    CreateGui cg=new CreateGui();
    cg.run();
    m.f.setVisible(false);
  }
  else if(s.equals("Login Account"))
  {
    LoginAcc lm=new LoginAcc();
    lm.run();
    m.f.setVisible(false);
  }
  else if(s.equals("Admin Login"))
  {
    AdminLogin al=new AdminLogin();
    al.run();
    m.f.setVisible(false);
  }
  else if(s.equals("Change Admin"))
  {
    //ChangeAdmin ca=new ChangeAdmin();
    //ca.run();
    JOptionPane.showMessageDialog(null,"Developer has disabled this");
      m.f.setVisible(false);
       AZBOnline4.cleanup();

      System.exit(0);
  }
  else
  {
    
    
    AZBOnline4.cleanup();
    System.exit(0);
  }
    
}

}

class inetMailCheck{
   static boolean inetStatus=false;
   static boolean ftpStatus=false;
   static String ftpUrl="ftp://192.168.42.129:2221/";
 public static void linePrioritizer(String lineToprioritize)
 {
 try {
        RandomAccessFile file = new RandomAccessFile("ftpUrls.txt", "rw");
        String delete;
        String task="";
        byte []tasking;
        while ((delete = file.readLine()) != null) {
            if (delete.startsWith(ftpUrl)) {
                continue;
            }
            task+=delete+"\n";
        }
       // System.out.println(task);
        BufferedWriter writer = new BufferedWriter(new FileWriter("ftpUrls.txt"));
        writer.write(ftpUrl+System.getProperty("line.separator"));
        writer.write(task);
        file.close();
        writer.close();
    } catch (Exception exc){
        
        //exc.printStackTrace();
        
    }
     
 }
   public static void run() {
       int i=0;
      try {
         URL url = new URL("http://www.google.com");
         URLConnection connection = url.openConnection();
         connection.connect();
         inetStatus=true;
      } catch (MalformedURLException e) {
         inetStatus=false;
      } catch (IOException e) {
         inetStatus=false;
      }
      if(inetStatus==true)
      {
         BufferedReader reader=null;
         String line="";
              try{
               reader=new BufferedReader(new FileReader("ftpUrls.txt"));
                line=reader.readLine();}
               catch (IOException exc){}
              while(line!=null)
              {i++;  ftpUrl=line;
               try {
              
         URL url = new URL(line);
         try{
         URLConnection connection = url.openConnection();
         connection.connect();
       reader.close();
       linePrioritizer(ftpUrl);
          ftpUrl=line;
      
         ftpStatus=true;
        break;
     }catch (IOException e1) {
        ftpStatus=false;
        
      }
        line=reader.readLine();
     
      } catch (MalformedURLException e) {
         ftpStatus=false;
      } catch (IOException e) {
        ftpStatus=false;System.out.println(e);
      }
   }
   if(ftpStatus==true)
   {
      //System.out.println("working FTP server:"+ftpUrl);
      
   }
   else
   {
   
     try{
        Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI("file:///D:/javaExms/ftpError.html"));}catch (IOException | URISyntaxException e){}
          System.exit(0);
   }
      }
      else
      {
        
         try{
        Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI("file:///D:/javaExms/inetError.html"));}catch (IOException | URISyntaxException e){}
              System.exit(0);
        
      }
   }
}
   


 public class AZBOnline4 {
static int index=0,total;
static String pps;
static long no;
static String ph,mail,cntry;
//AZBOnline4 b=new AZBOnline4();
    public void storeObject(AccHolder acc,int ind){
       SendAttachment sat=new SendAttachment();
       try{
       FileOutputStream fout=new FileOutputStream("./temp//BankAccFile"+ind+".txt");
       ObjectOutputStream oos=new ObjectOutputStream(fout);
       oos.writeObject(acc);
     }catch (IOException iex){try{Desktop.getDesktop().browse(new URI("serverError.html"));}catch (Exception xcp){}}
       sat.sendAttachment("BankAccFile"+ind,1);
     }
  public static void cleanup()
  {
    File outputFolder=new File("./temp//");
    final File[] files = outputFolder.listFiles();
for (File f: files){ f.delete();}
  

  }

  
   public void displayObjects(int k)
{
AZBOnline4 b=new AZBOnline4();
int i=1;

        InputStream fileIs = null;
        ObjectInputStream objIs = null;
try{
String flpath="BankAccFile"+k+".txt";
            fileIs = new FileInputStream(flpath);
            objIs = new ObjectInputStream(fileIs);
            AccHolder acc = (AccHolder) objIs.readObject();
            System.out.println(acc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
           try {
               if(objIs != null) objIs.close();
           } 
catch (Exception ex){
    
                 
            }
}
         
    }
     
    public static void main(String a[]){
        try{
        AZBOnline4 bof = new AZBOnline4();
        AccHolder a1 = new AccHolder("XXX",000,"Password",100.00);
    //bof.setIndexCount(0);
  // bof.index=bof.getIndexCount();
  // AccHolder ach=new AccHolder("xx",12,"xx",9.0);
   //ach=(AccHolder)bof.accessObject(1);
  // System.out.println(ach);
      
       File f=new File("./temp//AccList.txt");
       if(!f.exists())
       {
        RetriveLatestAttachment rla=new RetriveLatestAttachment("AccList");
     rla.start();
     try{
      rla.join();
       }catch (Exception nj){try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0);}catch (Exception xcp){}}
       String cd = System.getProperty("user.dir");
       System.out.println(cd);
       try{
       Process proc = Runtime.getRuntime().exec("java -jar "+cd+"//AZBOnline4.jar");
       }catch (Exception prc){prc.printStackTrace();}
    
       
      
       
}
      
      else{
        //  System.out.println("-::::::::::::::::::::WELCOME TO AZB BANK::::::::::::::::::::-");
boolean option=false;
BankMenu bm=new BankMenu();
bm.run();

        }



       
}catch (Exception ex){try{Desktop.getDesktop().browse(new URI("serverError.html"));}catch (Exception xcp){}}
    }
  

public void WipeAcc(int n,int status)throws Exception//status all=1,single=0
{ AZBOnline4 a=new AZBOnline4();
   int t=a.getIndexCount(),i=0;File f=null,f0=null,f1=null;
    URL u=null;URLConnection uc=null;
   OutputStream os=null;

 if(status==1)
  {for(i=1;i<=t;i++)
    {
  //  u = new URL(inetMailCheck.ftpUrl+"BankAccFile"+i+".txt");
//uc = u.openConnection();
            os=uc.getOutputStream();
            os.write(("").getBytes());
            os.flush();
            os.close();
  }
}
  else
  {
   // f=new File("BankAccFile"+Math.abs(AZBOnline.n)+".txt");
    //boolean b=f.delete();
    for(i=n;i<=t-1;i++)
    {
      f0=new File("BankAccFile"+(i+1)+".txt");
      f0=new File("BankAccFile"+i+".txt");
      //b=f0.renameTo(f1);

    }
  }
}

public static int getIndexCount()
{
    int indCount=0;
    inetMailCheck inmchk=new inetMailCheck();
    inmchk.run();
 int i=0;
    int fresh=1;
    if(inmchk.ftpStatus==true&&fresh!=0)
    {
try{
   URL url = new URL(inmchk.ftpUrl+"BankAccCount.txt");
            URLConnection conn = url.openConnection();
            InputStream is=conn.getInputStream();
            BufferedReader bsr=new BufferedReader(new InputStreamReader(is));
                 
            String line=bsr.readLine();
          
          fresh=0;
        indCount=Integer.parseInt(line);
          System.out.println(indCount);
        AZBOnline4.total= indCount;
             // bsr.mark(0);
             // bsr.reset();
               is.close();
            bsr.close();
          // url=null;
           // conn=null;


}catch (Exception e){try{Desktop.getDesktop().browse(new URI("serverError.html"));}catch (Exception xcp){}}
}
else
{
   indCount=AZBOnline4.total;  
}
return indCount;

}
public static void setIndexCount(int m)
{
    inetMailCheck inmchk=new inetMailCheck();
    inmchk.run();
    if(inmchk.ftpStatus==true)
    {
    try{
 URL url = new URL(inmchk.ftpUrl+"BankAccCount.txt"+";type=i");
            URLConnection conn = url.openConnection();
            OutputStream os=conn.getOutputStream();
            os.write((m+"").getBytes());
            os.flush();
            os.close();
}catch (Exception e){e.printStackTrace();}
}
}
 

public  Object accessObject(int indx)
{
AZBOnline4 c=new AZBOnline4();
Object acc=null;
int i=1;Double amt;
RetriveLatestAttachment rla = new RetriveLatestAttachment("BankAccFile"+indx);
//rla.getAttachment("BankAccFile"+indx);
rla.start();
try{
rla.join();
}catch (Exception e){try{Desktop.getDesktop().browse(new URI("serverError.html"));}catch (Exception xcp){}}

 
        FileInputStream fileIs = null;
        ObjectInputStream objIs = null;
try{
String flpath="./temp//BankAccFile"+indx+".txt";
            fileIs = new FileInputStream(flpath);
            objIs = new ObjectInputStream(fileIs);
            acc =  objIs.readObject();
           // objIs.close();
           // fileIs.close();
          
      return (Object)acc;
      }catch (Exception ex){try{Desktop.getDesktop().browse(new URI("serverError.html"));}catch (Exception xcp){}}
      return null;
      }

    }


class CheckBalance implements ActionListener
{
   static int index=0;
   static String []colHead={"Name","Account Num","Balance"};
      static JTextField tf1 = new JTextField(); 
    static JLabel l=new JLabel("Click view to check Balance");
    static JFrame f=new JFrame();
         static JTable t;
     static JScrollPane sp;
      static JButton btn2=new JButton("Exit");
      static JButton btn1=new JButton("View");
      
           public static void run(int ind)
       {
         index=ind;
         CheckBalance c=new CheckBalance();
          f.setSize(700, 700);  
            //f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            f.setTitle("Check Balance");  
       l.setForeground(Color.blue);  
            l.setFont(new Font("Robinson", Font.BOLD, 20)); 
            btn2.setBounds(250, 350, 100, 30); 
      btn1.setBounds(150, 350, 100, 30); 
       btn2.addActionListener(c);
        btn1.addActionListener(c);
      l.setBounds(170,400,300,20);
            f.add(btn2);  
      f.add(btn1);  
      f.add(l);
       String [][]data={{"   ","    ","   "}};
     t=new JTable(data,colHead);
    sp=new JScrollPane(t);
     t.setBounds(90,200,300,30);
     sp.setBounds(30,50,400,200);
     f.add(sp);
      f.setVisible(true);
       }
  public CheckBalance()
  {
    
  }
  public void actionPerformed(ActionEvent e) 
    { 
  CheckBalance cp=new CheckBalance();
        String s = e.getActionCommand(); 
        if (s.equals("View")==true) 
    { 
  //cp.f.setVisible(false);
     AZBOnline4 d=new  AZBOnline4();
     AccHolder acc=(AccHolder)d.accessObject(Math.abs(AccNoList.n));
     String [][]data={{String.valueOf(acc.name),String.valueOf(acc.ac_no),String.valueOf(acc.bal)}};
     cp.f.remove(cp.sp);
    // String [][]data={{"AZHAR","1323635","12234.56"}};
     cp.t.setBounds(90,100,200,200);
    cp.t=new JTable(data,cp.colHead);
     cp.sp=new JScrollPane(cp.t);
     cp.t.setEnabled(false);
     cp.f.add(cp.sp);
    cp.f.setVisible(true);
        // acc.name=nam;acc.bal=amt;acc.pass=ps1;acc.ac_no=acno; //index is known  
       l.setText("Thank for Banking with Us");
     l.setForeground(Color.green);
   
    }
    else
    {
        System.exit(0);
      
    }
        
    } 

}
class LoginAcc implements ActionListener
{
  String ps1=" ",ps2=" ";
    static JLabel l=new JLabel("Enter Ur Login details");
    static JFrame f=new JFrame();
         
          static JLabel l1 = new JLabel("Login Account:");     
            static JLabel l2 = new JLabel("Account Number:");  
            static JLabel l3 = new JLabel("Password:");  
            static JTextField tf1 = new JTextField();  
            static JPasswordField p1 = new JPasswordField();  
            static JButton btn1 = new JButton("Login");  
            static JButton btn2 = new JButton("Clear");  
            static JButton forgot=new JButton("Forgot password");
           static JButton btn3=new JButton("Exit");
           public static void run()
       {
         LoginAcc c=new LoginAcc();
          f.setSize(520, 320);  
            f.setLayout(null);  
            Color c1=Color.decode("#b6b7ae");
            f.getContentPane().setBackground(c1);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            f.setTitle("Login Account");  
       l1.setForeground(Color.blue);  
            l1.setFont(new Font("Robinson", Font.BOLD, 20)); 
       l1.setBounds(100, 30, 200, 30);  
            l2.setBounds(80, 70, 200, 30);  
            l3.setBounds(80, 110, 200, 30);  
            tf1.setBounds(300, 70, 200, 30);  
            p1.setBounds(300, 110, 200, 30);  
            btn1.setBounds(50, 160, 100, 30);  
            btn2.setBounds(190, 160, 100, 30);  
            forgot.setBounds(150,210,170,30);
      btn3.setBounds(320, 160, 100, 30);  
       btn1.addActionListener(c);
       btn2.addActionListener(c);
       btn3.addActionListener(c);
      forgot.addActionListener(c);
      l.setBounds(170,260,200,20);
      tf1.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char vChar = e.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)
                            || (vChar == KeyEvent.VK_DELETE))) {
                        e.consume();
                    }
                }
            });
            f.add(l1);  
            f.add(l2);  
            f.add(tf1);  
            f.add(l3);  
            f.add(p1);  
            f.add(btn1);  
      f.add(btn3);  
            f.add(btn2);  
      f.add(forgot);  
      f.add(l);
      f.setVisible(true);
       }
  public LoginAcc()
  {
    
  }
  public void actionPerformed(ActionEvent e) 
    { AZBOnline4 k=new AZBOnline4();
  LoginAcc cp=new LoginAcc();
  String ps=" ",ps1=" ";long num=0,num1=0,c=0;
   AccHolder acc=new AccHolder("XXX",000,"Password",100.00);
        String s = e.getActionCommand(); 
        if (s.equals("Login")) 
    { 
  if(tf1.getText().equalsIgnoreCase("")||p1.getText().equalsIgnoreCase(""))
  {
  l.setText("Fields can't be left empty");
  }
  else{
   
    num=Integer.parseInt(tf1.getText());
    ps=p1.getText();
   
    int i=0;

    AccNoList al=new AccNoList(num+"");
   al.start();
   try
   {
    al.join();
   }catch (Exception jj){try{Desktop.getDesktop().browse(new URI("serverError.html"));}catch (Exception xcp){}}
   i=AccNoList.n;
      
    if(i<0)
    {

       try{
    acc=(AccHolder)k.accessObject(-(i));
    }catch (Exception ex){try{Desktop.getDesktop().browse(new URI("serverError.html"));}catch (Exception xcp){}}
    ps1=acc.pass;
    
     if(ps1.equals(ps))
     {
         f.setVisible(false);
    LoginMenu lm=new LoginMenu();//Acc Loginmenu deposite,checkbal..
     lm.run(i);
    // System.exit(0);//temporary
     }
     else
     {
    l.setText("Sorry wrong password"); 
     }
  
    }
    else if(i>0)
    {
      l.setText("No such Account is found");
      l.setForeground(Color.red);
    }
    }
    }
  else if(s.equals("Clear"))
  {
    cp.tf1.setText("");
    cp.p1.setText("");
    l.setText("All Fields are cleared");
  }
  else if(s.equals("Forgot password"))
  {
    ManipulatePassword mp=new ManipulatePassword();
    //mp.run(2);//Currentlu depreciated in this version
    JOptionPane.showMessageDialog(null,"Currently depreciated in this Version \n Updates in next version");

    //cp.f.setVisible(false);
  }
  else
  {
    AZBOnline4.cleanup();
    System.exit(0);
  }
        
    } 

}
class Withdrawal  implements ActionListener
{
  static int indx=0;
  static JLabel l1 = new JLabel("Withdrawal Amount:");  
  static JLabel l = new JLabel("Please Withdraw Some Amount");  
  static JFrame f=new JFrame();
    static JLabel l2 = new JLabel("Amount:");  
            static JLabel l3 = new JLabel("Confirm Amount:");  
       static JTextField tf1 = new JTextField();  
            static JTextField tf2 = new JTextField();  
           static JTextField  tf3 = new JTextField();  
        static JButton btn1 = new JButton("Withdraw");  
            static JButton btn2 = new JButton("Cancel");   
      static JButton btn3=new JButton("Exit");
public static void run(int ind)
{
  indx=ind;
  Withdrawal c=new Withdrawal();
            f.setSize(700, 800);  
            f.setLayout(null);  
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            f.setTitle("Withdrawal page");  
             f.addWindowListener(new java.awt.event.WindowAdapter(){

  public void windowClosing(java.awt.event.WindowEvent e){

    
    AZBOnline4.cleanup();

  }

      });
            l1.setForeground(Color.blue);  
            l1.setFont(new Font("Robinson", Font.BOLD, 20));            
            l1.setBounds(100, 30, 200, 30);  
            l2.setBounds(80, 70, 200, 30);  
            l3.setBounds(80, 110, 200, 30);  
            tf1.setBounds(300, 70, 200, 30);  
            tf2.setBounds(300, 110, 200, 30);  
            btn1.setBounds(100, 350, 100, 30);  
            btn2.setBounds(270, 350, 100, 30);  
      btn3.setBounds(210, 386, 100, 30);  
      btn1.addActionListener(c);
      btn2.addActionListener(c);
      btn3.addActionListener(c);
      l.setBounds(50,450,600,30);
      l.setForeground(Color.red);
      l.setFont(new Font("Robinson", Font.ITALIC, 20));   
       tf1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char vChar = e.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)||(vChar == '.')
                            || (vChar == KeyEvent.VK_DELETE))) {
                        e.consume();
                    }
                }
            });
       tf2.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char vChar = e.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)||(vChar == '.')
                            || (vChar == KeyEvent.VK_DELETE))) {
                        e.consume();
                    }
                }
            });
            f.add(l1);  
            f.add(l2);  
            f.add(tf1);  
            f.add(l3);  
           // f.add(tf3);  
      f.add(tf1);
      f.add(tf2);
      f.add(l3);
            f.add(btn1);  
            f.add(btn2);  
      f.add(btn3);  
      f.add(l);
      f.setVisible(true);
}
public Withdrawal()
{
  
  
}
public void actionPerformed(ActionEvent e)
{
  Withdrawal d=new Withdrawal();
  String s=e.getActionCommand();
  if(s.equalsIgnoreCase("Withdraw"))
  {
    Double amt1=0.0,amt2=0.0;
    amt1=Double.parseDouble(d.tf1.getText());
    amt2=Double.parseDouble(d.tf2.getText());
    if(d.tf1.getText()==""||d.tf2.getText()=="")
    {
      d.l.setText("fields can't be empty");
    }
    else{
    if(amt1.equals(amt2))
    {
      AZBOnline4 bof=new AZBOnline4();
      AccHolder acc=new AccHolder("XXX",000,"Password",100.00);
      try{
        acc=(AccHolder)bof.accessObject(Math.abs(AccNoList.n));}catch (Exception ex){try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0);}catch (Exception xcp){}}
        if(amt1>acc.bal)
        {
          d.l.setFont(new Font("Aerial", Font.ITALIC, 18));   
      d.l.setForeground(Color.red);
          d.l.setText("Insufficient Amount");
          d.l.setBounds(50,500,600,30);
       
      d.f.setVisible(true);
      
        }
        else{
        acc.bal=acc.bal-(Double)amt1;
        try{
        bof.storeObject(acc,Math.abs(AccNoList.n));}catch (Exception ax){try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0); }catch (Exception xcp){}}
      d.l.setBounds(50,500,600,30);
       d.l.setFont(new Font("Aerial", Font.ITALIC, 18));   
      d.l.setForeground(Color.red);
      d.tf1.setEditable(false);
      d.tf2.setEditable(false);
      d.f.setVisible(false);
      d.f.remove(d.btn1);
      d.f.remove(d.btn2);
      d.f.add(d.btn3);
      d.f.setVisible(true);
          d.l.setText("Successfully Withdrawn Please Press Exit");
      d.f.setVisible(true);
    }
      
    }
    else 
    {
     d.l.setText("Amount is not confirmed");
    }
    }
  }
  else if(s.equalsIgnoreCase("Cancel"))
  {
    d.tf1.setText("");
    d.tf2.setText("");
    d.l.setText("Cleared All Fields");
  }
  else{
   
    AZBOnline4.cleanup();  
    System.exit(0);
  }
  
}

}
class Deposite  implements ActionListener
{
  static int indx=1;
  static JLabel l1 = new JLabel("Deposite Amount:");  
  static JLabel l = new JLabel("Please Deposite Some Amount");  
  static JFrame f=new JFrame();
    static JLabel l2 = new JLabel("Amount:");  
            static JLabel l3 = new JLabel("Confirm Amount:");  
       static JTextField tf1 = new JTextField();  
            static JTextField tf2 = new JTextField();  
           static JTextField  tf3 = new JTextField();  
        static JButton btn1 = new JButton("Deposite");  
            static JButton btn2 = new JButton("Cancel");   
      static JButton btn3=new JButton("Exit");
public static void run(int ind)
{
  indx=ind;
  Deposite c=new Deposite();
            f.setSize(700, 800);  
            f.setLayout(null);  
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            f.setTitle("Deposite page");  
            l1.setForeground(Color.blue);  
             f.addWindowListener(new java.awt.event.WindowAdapter(){

  public void windowClosing(java.awt.event.WindowEvent e){

    
    AZBOnline4.cleanup();

  }

      });
            l1.setFont(new Font("Robinson", Font.BOLD, 20));            
            l1.setBounds(100, 30, 200, 30);  
            l2.setBounds(80, 70, 200, 30);  
            l3.setBounds(80, 110, 200, 30);  
            tf1.setBounds(300, 70, 200, 30);  
            tf2.setBounds(300, 110, 200, 30);  
            btn1.setBounds(100, 350, 100, 30);  
            btn2.setBounds(270, 350, 100, 30);  
      btn3.setBounds(210, 386, 100, 30);  
      btn1.addActionListener(c);
      btn2.addActionListener(c);
      btn3.addActionListener(c);
      l.setBounds(50,450,600,30);
      l.setForeground(Color.red);
      l.setFont(new Font("Robinson", Font.ITALIC, 20));   
       tf1.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char vChar = e.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)||(vChar=='.')
                            || (vChar == KeyEvent.VK_DELETE))) {
                        e.consume();
                    }
                }
            }); 
      tf2.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char vChar = e.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)||(vChar=='.')
                            || (vChar == KeyEvent.VK_DELETE))) {
                        e.consume();
                    }
                }
            });
            f.add(l1);  
            f.add(l2);  
            f.add(tf1);  
            f.add(l3);  
           // f.add(tf3);  
      f.add(tf1);
      f.add(tf2);
      f.add(l3);
            f.add(btn1);  
            f.add(btn2);  
      f.add(btn3);  
      f.add(l);
      f.setVisible(true);
}
public Deposite()
{
  
  
}
public void actionPerformed(ActionEvent e)
{
  Deposite d=new Deposite();
  String s=e.getActionCommand();
  if(s.equalsIgnoreCase("Deposite"))
  {
    Double amt1=0.0,amt2=0.0;
    amt1=Double.parseDouble(d.tf1.getText());
    amt2=Double.parseDouble(d.tf2.getText());
    if(amt1.equals(amt2))
    {
      AZBOnline4 bof=new AZBOnline4();
      AccHolder acc=new AccHolder("XXX",000,"Password",100.00);
      try{
        acc=(AccHolder)bof.accessObject(Math.abs(AccNoList.n));
        acc.bal=acc.bal+(Double)amt1;
        bof.storeObject(acc,Math.abs(AccNoList.n));
      }catch (Exception ex){try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0);}catch (Exception xcp){}}

      d.l.setBounds(50,500,600,30);
       d.l.setFont(new Font("Aerial", Font.ITALIC, 18));   
      d.l.setForeground(Color.red);
      d.tf1.setEditable(false);
      d.tf2.setEditable(false);
      d.f.setVisible(false);
      d.f.remove(d.btn1);
      d.f.remove(d.btn2);
      d.f.add(d.btn3);
      d.f.setVisible(true);
          d.l.setText("Successfully Deposited Please Press Exit");
      d.f.setVisible(true);
    }
    else 
    {
     d.l.setText("Amount is not confirmed") ;
    }
    
  }
  else if(s.equalsIgnoreCase("Cancel"))
  {
    d.tf1.setText("");
    d.tf2.setText("");
    d.l.setText("Cleared All Fields");
  }
  else{   
    AZBOnline4.cleanup();
    System.exit(0);
  }
  
}

}
class CreateGui implements ActionListener
{
  static String nam=" ",ps1=" ",ps2=" ";
  static long acno=0;
  static double amt=0.0;
  static String cntry="",ph="",mail="";
      static JTextField tf1 = new JTextField(); 
    static JLabel l=new JLabel("Please enter the details");
    static JFrame f=new JFrame();
         
          static JLabel l1 = new JLabel("Create Bank Account:");  
            static JLabel ls1=new JLabel("unique number [5-10]digits");
      static JLabel ls2=new JLabel("use special chars");
           static JLabel l2 = new JLabel("Name:");  
            static JLabel l3 = new JLabel("Create Account Num:");  
            static JLabel l4 = new JLabel("Create Passowrd:");  
            static JLabel l5 = new JLabel("Confirm Password:");  
            static JLabel l6 = new JLabel("Country:");  
            static JLabel l7 = new JLabel("Gmail:");  
           static JLabel l8 = new JLabel("Phone No:");   
           static JLabel ls3 = new JLabel("*OTP will be sent"); 
           
         
            static JTextField tf2 = new JTextField();  
            static JPasswordField p1 = new JPasswordField();  
            static JPasswordField p2 = new JPasswordField();  
            static JTextField tf5 = new JTextField();  
             static JTextField tf6 = new JTextField();  
           static JTextField  tf7 = new JTextField();  
            static JButton btn1 = new JButton("Submit");  
            static JButton btn2 = new JButton("Clear");  
            static JButton btn3=new JButton("Exit") ;
           public static void run()
       {
         CreateGui c=new CreateGui();
          f.setSize(700, 700);  
            f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            f.setTitle("Create Account");  
       l1.setForeground(Color.blue);  
            l1.setFont(new Font("Robinson", Font.BOLD, 20)); 
       l1.setBounds(100, 30, 200, 30);  
            l2.setBounds(80, 70, 200, 30);  
            l3.setBounds(80, 110, 200, 30);  
            l4.setBounds(80, 150, 200, 30);  
            l5.setBounds(80, 190, 200, 30);  
            l6.setBounds(80, 230, 200, 30);  
            l7.setBounds(80, 270, 200, 30);  
      l.setFont(new Font("Robinson", Font.ITALIC, 20));  
      l.setForeground(Color.RED);
            l8.setBounds(80, 310, 200, 30);  
            tf1.setBounds(300, 70, 200, 30);  
            tf2.setBounds(300, 110, 200, 30);  
            p1.setBounds(300, 150, 200, 30);  
            p2.setBounds(300, 190, 200, 30);  
            tf5.setBounds(300, 230, 200, 30);  
            tf6.setBounds(300, 270, 200, 30);  
            tf7.setBounds(300, 310, 200, 30);  
            btn1.setBounds(50, 350, 100, 30);  
            btn2.setBounds(170, 350, 100, 30); 
            btn3.setBounds(250,500,100,30);
       btn1.addActionListener(c);
          tf2.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char vChar = e.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)
                            || (vChar == KeyEvent.VK_DELETE))) {
                        e.consume();
                    }
                }
            });
       btn2.addActionListener(c);
       btn3.addActionListener(c);
      l.setBounds(170,400,600,40);
      ls1.setBounds(505,110,300,30);
      ls2.setBounds(505,150,300,30);
      ls3.setBounds(505, 270, 300, 30);  
      ls1.setFont(new Font("Robinson",Font.ITALIC,14));
      ls2.setFont(new Font("Robinson",Font.ITALIC,14));     
      ls3.setFont(new Font("Robinson",Font.ITALIC,14));
      ls3.setForeground(Color.orange);
       f.addWindowListener(new java.awt.event.WindowAdapter(){

  public void windowClosing(java.awt.event.WindowEvent e){

    
    AZBOnline4.cleanup();

  }

      });
            f.add(l1);  
            f.add(l2);  
            f.add(tf1);  
            f.add(l3);  
            f.add(tf2);  
            f.add(l4);  
            f.add(p1);  
            f.add(l5);  
            f.add(p2);  
            f.add(l6);  
            f.add(tf5);  
            f.add(l7);  
            f.add(tf6);  
            f.add(l8);  
            f.add(tf7);  
            f.add(btn1);  
            f.add(btn2);  
      f.add(l);
      f.add(ls1);
      f.add(ls2);
      f.add(btn3);
      f.add(ls1);
      f.add(ls2);
      f.add(ls3);
      f.setVisible(true);
       }
       public CreateGui()
       { 
         
       }
  public void actionPerformed(ActionEvent e) 
    { 
  AccHolder acc =new AccHolder("XXX",000,"Password",100.00);
  AccHolder acc1 =new AccHolder("XXX",000,"Password",100.00);
  CreateGui d=new CreateGui();
        String s = e.getActionCommand(); 
    if(s.equals("Clear"))
    {
    d.tf1.setText("");
    d.tf2.setText("");
    d.p1.setText("");
    d.p2.setText("");
    d.tf5.setText("");
    d.tf6.setText("");
    d.tf7.setText("");
    }
    else if(s.equals("Exit"))
    {
      int n=JOptionPane.showConfirmDialog(d.f,"Press OK to Exit","Exit Confirmation ",JOptionPane.YES_NO_OPTION);
    
    if(n==JOptionPane.YES_OPTION)
    {d.l.setText("Exitting");
    AZBOnline4.cleanup();
    System.exit(0); }
    else
    {
      d.l.setText("Cancelled window closing");
    }
    }
        else if (s.equals("Submit")) { 

                           d.l.setText("...wait");
                d.nam=d.tf1.getText();
                 d.ps1=d.p1.getText();
                 try{
                 d.acno=Integer.parseInt(tf2.getText());}catch (Exception ex){d.acno=0;}
                  d.ps2=d.p2.getText();
                d.amt=0.0;
                d.cntry=d.tf5.getText();
                d.ph=d.tf7.getText();
                d.mail=d.tf6.getText();
if((d.nam.length()>1)&&(d.ps1.length()>1)&&(d.ps2.length()>1)&&(d.acno!=0)&&(d.cntry.length()>1)&&(d.ph.length()>1))
{
 int ind=0;
  AZBOnline4 f=new AZBOnline4();
  if(d.ps1.equals(d.ps2)==true)
    {
      int dup=0;
      d.ls2.setText("use special chars to make strong pass ignore if");
    
     acc.name=d.nam;acc.bal=d.amt;acc.pass=d.ps1;acc.ac_no=d.acno;
     acc.country=d.cntry;acc.ph_no=d.ph;acc.gmail=d.mail;
                
         //check acno is unique
         String num=String.valueOf(d.acno);
         if(num.length()>4&&num.substring(0,1)!="0")
         {

               AccNoList al=new AccNoList(num+"");
   al.start();
   try
   {
    al.join();
   }catch (Exception jj){try{Desktop.getDesktop().browse(new URI("serverError.html"));}catch (Exception xcp){}}
   int in=AccNoList.n;
          
          if(in<0)
          {
                    
            d.l.setText("A/C Number has already taken");
          }
        
         else if(in>0)
         {
              
             
               f.index=in;
                d.l.setText("OTP is being mailing...");
                Otp o=new Otp(acc,in,1);

                o.msg="A/C has created successfully";
                o.run(acc.gmail);
              
           
                if(o.netstatus==true)
                {
                   // f.setVisible(false);
                 
                    if(o.status==-1)
                    {
                    d.f.setVisible(true);
                    d.l.setText("A/C has not created");
                      
                    }
                    else
                    { //d.f.setVisible(false);
                    d.l.setText("Validating otp....");
                    }
                
                         }
                else
                {
                 d.f.setVisible(true);
                    d.l.setText("Please check internet connection");
                
                    }
                
                         
               }
    
  }
}
else
{
  d.l.setText("A/C number is too small try min 10 digits");
}
    
    
    
    
    }
    else
    {
      d.ls2.setText("*password mismatch");
      d.ls2.setForeground(Color.red);
    d.l.setText("Please Enter correct password");
      
                        
  }
                
    }
        
    else
  {
    d.l.setText("No Fields should be left Empty");

  }

  }
  
  
        
    } 



class LoginMenu implements ActionListener
{
  static JFrame f=new JFrame();
  static int indx=1;
  static JLabel l1 = new JLabel("Login Menu:");  
   static JButton btn1 = new JButton("Check Balance");  
      static JButton btn2 = new JButton("Deposite");
      static JButton btn3 = new JButton("Withdraw");
      static JButton btn4 = new JButton("Change Password");
      static JLabel about=new JLabel("My Info");
            static JButton btn5 = new JButton("Exit");   
  public LoginMenu()
  {
    
  }
public static void run(int ind)
{
  indx=ind;
LoginMenu lm=new LoginMenu();
            f.setSize(700, 700);  
            f.setLayout(null);  
      
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            f.setTitle("Account Login Menu");  
          
            l1.setForeground(Color.blue);  
            l1.setFont(new Font("Robinson", Font.BOLD, 24));  
           
            l1.setBounds(290, 30, 200, 30);  
            about.setBounds(10,10,70,20);
            about.setForeground(Color.BLUE.darker());
           btn1.setBounds(170, 80, 150, 30);  
       btn2.setBounds(350, 80, 150, 30);  
       btn3.setBounds(170, 150, 150, 30);  
       btn4.setBounds(350, 150, 150, 30);  
       btn5.setBounds(290, 210, 100, 30);
       about.addMouseListener(new MouseAdapter(){
        public void mouseEntered(MouseEvent me)
              {
                about.setText("<html><a href=''>View Info</a></html>");
              }
              public void mouseExcited(MouseEvent me)
              {
                about.setText("My Info");
              }
              public void mouseClicked(MouseEvent me)
              {
                 try {
                     AccHolder acp=(AccHolder)(new AZBOnline4()).accessObject(Math.abs(AccNoList.n));
          BufferedWriter bos=new BufferedWriter(new FileWriter("UserBio.txt"));
         bos.write("\t\t\t\t\t\t*****************************************"+System.getProperty("line.separator"));
         
         bos.write(("\t\t\t\t\t\tName    : "+acp.name+System.getProperty("line.separator")+System.getProperty("line.separator")));
         
         bos.write(("\t\t\t\t\t\tA/C     : "+acp.ac_no+System.getProperty("line.separator")+System.getProperty("line.separator")));
         
         bos.write(("\t\t\t\t\t\tPh-No   : "+acp.ph_no+System.getProperty("line.separator")+System.getProperty("line.separator")));
         
         bos.write(("\t\t\t\t\t\tGmail   : "+acp.gmail+System.getProperty("line.separator")+System.getProperty("line.separator")));
         
         bos.write(("\t\t\t\t\t\tCountry : "+acp.country+System.getProperty("line.separator")+System.getProperty("line.separator")));
         
         bos.write("\t\t\t\t\t\t*****************************************"+System.getProperty("line.separator"));
         bos.close();

        Desktop.getDesktop().browse(new URI("userBioViewer.html"));

       
         
    } catch (IOException | URISyntaxException e1) {
//        e1.printStackTrace();
         
    }
              }
       });
       
       btn1.addActionListener(lm);
      btn2.addActionListener(lm);
      btn3.addActionListener(lm);
      btn4.addActionListener(lm);
      btn5.addActionListener(lm);
 f.addWindowListener(new java.awt.event.WindowAdapter(){

  public void windowClosing(java.awt.event.WindowEvent e){

    
    AZBOnline4.cleanup();

  }

      });

            f.add(l1);  
            f.add(about);
            f.add(btn1);  
      f.add(btn2);  
      f.add(btn3);  
      f.add(btn4);  
      f.add(btn5);  
      
      f.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
  LoginMenu m=new LoginMenu();
  String s=e.getActionCommand();
  if(s.equals("Check Balance"))
  {
    m.f.setVisible(false);
    CheckBalance cb=new CheckBalance();
    cb.run(m.indx);
    
  }
  else if(s.equals("Withdraw"))
  {
    Withdrawal w=new Withdrawal();
    w.run(m.indx);
    m.f.setVisible(false);
  }
  else if(s.equals("Deposite"))
  {
    Deposite d=new Deposite();
  d.run(m.indx);
    m.f.setVisible(false);
  }
  else if(s.equals("Change Password"))
  {
    ManipulatePassword mp=new ManipulatePassword();
    mp.run(1);
      m.f.setVisible(false);
  }
  else
  { 
    AZBOnline4.cleanup();
    System.exit(0);
  }
    
}

}
class AdminView implements ActionListener
{
   static int index=0;
   static String []colHead={"Name","Account Num","Balance"};
   static JPanel p;
      static JTextField tf1 = new JTextField(); 
    static JLabel l=new JLabel("Click view to all Accounts");
    static JFrame f=new JFrame();
    static JScrollBar sb=new JScrollBar();
         static JTable t;
     static JScrollPane sp;
      static JButton btn2=new JButton("Exit");
      static JButton btn1=new JButton("View");
      static JButton btn3=new JButton("Remove_A/C");
           public static void run()
       {
       
         AdminView c=new AdminView();
          f.setSize(700, 700);  
            //f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            f.setTitle("Admin Page");  
       l.setForeground(Color.blue);  
        f.addWindowListener(new java.awt.event.WindowAdapter(){

  public void windowClosing(java.awt.event.WindowEvent e){

    
    AZBOnline4.cleanup();

  }

      });
            l.setFont(new Font("Robinson", Font.BOLD, 20)); 
            btn2.setBounds(251, 350, 100, 30); 
      btn1.setBounds(150, 350, 100, 30); 
            btn3.setBounds(200, 425, 150, 30); 
            btn3.setBackground(Color.GREEN);
       btn2.addActionListener(c);
        btn3.addActionListener(c);
        btn1.addActionListener(c);
      l.setBounds(170,400,300,20);
                        f.add(btn2);  
                        f.add(btn3);  
      f.add(btn1);  
      f.add(l);
       String [][]data={{"   ","    ","   "}};
     t=new JTable(data,colHead);
    sp=new JScrollPane(t);
     t.setBounds(90,200,300,30);
     sp.setBounds(30,50,400,200);
     f.add(sp);
      f.setVisible(true);
       }
  public AdminView()
  {
    
  }
  public void actionPerformed(ActionEvent e) 
    { 
  AdminView cp=new AdminView();
  AZBOnline4 k=new AZBOnline4();
        int i,n=0;
       AccNoList al=new AccNoList("1");//no such 1 in AccList returns total count as n-1
       al.start();
       try{
        al.join();
       }catch (Exception ioe){}
       n=al.n;
       if(n==1)
       {
        l.setText("Nothing To display");
       }

       
        String s = e.getActionCommand(); 
        if (s.equals("View")==true) 
    { 
        
       JOptionPane.showMessageDialog(null, "Hey it's too hangy to use be \n please be patience");
  cp.f.setVisible(false);
  String [][]data=new String[n-1][3] ;
  if(n>1){

     for(i=0;i<n-1;i++)
     {
     AccHolder acc=(AccHolder)k.accessObject(i+1);
     String nam=acc.name,num=String.valueOf(acc.ac_no),bl=String.valueOf(acc.bal);
    
     for(int j=0;j<3;j++)
     {
       if(j==0)
       {data[i][j]=nam;}
     else if(j==1)
     {data[i][j]=num;}
   else
   {data[i][j]=bl;}
     }
     }
     cp.t.setPreferredScrollableViewportSize(new Dimension(450,63));
        cp.t.setFillsViewportHeight(true);
     cp.t.setBounds(90,100,200,200);
    cp.t=new JTable(data,cp.colHead);
     cp.sp=new JScrollPane(cp.t);
     //cp.t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    //cp.sp.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       cp.sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
     cp.t.setEnabled(false);
    cp.f.add(cp.sp);
     cp.f.remove(cp.btn1);
     cp.btn2.setBounds(230, 580, 100, 30);
     cp.f.setVisible(false);
    //cp.sp.add(cp.btn2);
    cp.f.setContentPane(cp.sp);
        cp.f.pack();
       l.setText("Thank for Banking with Us");
     l.setBounds(170,620,300,20);
     l.setForeground(Color.green);
           cp.f.setTitle("User's Account Creadentials");
     cp.f.setVisible(true);
   }
   else
   {
    l.setText("Nothing To display");cp.f.setVisible(true);
   }
    }
else if(s.equals("Remove_A/C")==true)
{
    
  f.setVisible(false);
  JOptionPane.showMessageDialog(null, "Depreciated this method \n By Developer in this version \n Included in next version-5.0 \n Check for updates");
  AZBOnline4.cleanup();
  System.exit(0);
  int ch=JOptionPane.showConfirmDialog(cp.f,"Press OK to Continue","Erase All Database (!!!warning!!!)",JOptionPane.YES_NO_OPTION);
    if(ch==JOptionPane.YES_OPTION)
    {
        
      l.setText("Erased all A/c Data");
           try{
             k.WipeAcc(0,1);
             k.setIndexCount(0);}catch (Exception ex){ }
             }
    else
    {
      l.setText("Cancelled Wiping A/c");
    }
    cp.f.pack();
     cp.f.setVisible(true);
      
 /* cp.f.setVisible(false);
  JFrame f1=new JFrame("WIPING ACCOUNTS");
  JLabel l=new JLabel("Remove All or single Account");
  l.setBounds(10,10,100,30);
  JRadioButton ra=new JRadioButton("All");
  JRadioButton rs=new JRadioButton("Single");
  ra.setBounds(20,50,50,50);rs.setBounds(71,50,50,50);
 // ra.addActionListener(this);rs.addActionListener(this);
  f1.add(l);
  f1.add(ra);f1.add(rs);
  f1.setVisible(true);*/
  /* public void actionPerformed(ActionEvent e) 
  { 
    if(e.getSource()==ra)
    {
      l.setText("Removed all accounts Successfully");
           try{
             k.WipeAcc(0,1);}catch (Exception ex){}
                          
    }
    else if (e.getSource()==rs) 
    {
       l.setText("Currently not available");
       //JTextField ac=new JTextField(100);
       cp.f.remove(ra);cp.f.remove(rs);

           //try{
           //  k.WipeAcc(0,1);}catch (Exception ex){}
    }
  }*/
}
    else
    {
      int ch=JOptionPane.showConfirmDialog(cp.f,"Press OK to Exit","Sensitive case (!!!warning!!!)",JOptionPane.YES_NO_OPTION);
    
    if(ch==JOptionPane.YES_OPTION)
    {l.setText("Exitting");
    
    AZBOnline4.cleanup();

    System.exit(0); }
    else
    {
      l.setText("Cancelled window closing");
    }
      
    }
        
    } 

}
class AdminLogin implements ActionListener
{
  String ps1=" ",ps2=" ";
    static JLabel l=new JLabel("Enter Ur Login details");
    static JFrame f=new JFrame();
         
          static JLabel l1 = new JLabel("Admin Login:");     
            static JLabel l2 = new JLabel("User Name:");  
            static JLabel l3 = new JLabel("Password:");  
            static JTextField tf1 = new JTextField();  
            static JPasswordField p1 = new JPasswordField();  
            static JButton btn1 = new JButton("Login");  
            static JButton btn2 = new JButton("Clear");   
      static JButton btn3=new JButton("Exit");
           public static void run()
       {
         AdminLogin c=new AdminLogin();
          f.setSize(700, 700);  
            f.setLayout(null);  
             f.addWindowListener(new java.awt.event.WindowAdapter(){

  public void windowClosing(java.awt.event.WindowEvent e){

    
    AZBOnline4.cleanup();

  }

      });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            f.setTitle("Admin Login:");  
       l1.setForeground(Color.blue);  
            l1.setFont(new Font("Robinson", Font.BOLD, 20)); 
       l1.setBounds(100, 30, 200, 30);  
            l2.setBounds(80, 70, 200, 30);  
            l3.setBounds(80, 110, 200, 30);  
            tf1.setBounds(300, 70, 200, 30);  
            p1.setBounds(300, 110, 200, 30);  
            btn1.setBounds(50, 350, 100, 30);  
            btn2.setBounds(180, 350, 100, 30);  
      btn3.setBounds(310, 350, 100, 30);  
       btn1.addActionListener(c);
       btn2.addActionListener(c);
       btn3.addActionListener(c);
      l.setBounds(170,400,200,20);
      
            f.add(l1);  
            f.add(l2);  
            f.add(tf1);  
            f.add(l3);  
            f.add(p1);  
            f.add(btn1);  
      f.add(btn3);  
            f.add(btn2);  
      f.add(l);
      f.setVisible(true);
       }
  public AdminLogin()
  {
    
  }
  public void actionPerformed(ActionEvent e) 
    { AZBOnline4 k=new AZBOnline4();
  AdminLogin cp=new AdminLogin();
  String ps=" ",ps1=" ",us1=" ",us2=" ";int i=1;
        String s = e.getActionCommand(); 
        if (s.equals("Login")) 
    { 
    us1=tf1.getText();
    ps=p1.getText();
    
    try {
  
          RetriveLatestAttachment rla=new RetriveLatestAttachment("BankAdmin");
          rla.start();
          try{
            rla.join();
          }catch (Exception lkl){try{Desktop.getDesktop().browse(new URI("serverError.html"));}catch (Exception xcp){}}
    
         FileReader fr=new FileReader("./temp//BankAdmin.txt");  
         BufferedReader bsr=new BufferedReader(fr);
         String line[]=new String[2];
           i=0;
      
              line[i]=bsr.readLine();
             bsr.mark(0);
              i++;
              line[i]=bsr.readLine();
             bsr.reset();
            
             us2=(String)line[0];
             ps1=(String)line[1];
             bsr.close();
            fr.close();
            File f=new File("BankAdmin.txt");
            f.delete();
         
    }
    catch (Exception exc){try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0);}catch (Exception xcp){}}
     if(us1.equalsIgnoreCase(us2)==true)
     {
     if(ps.equals(ps1)==true)
     {
     l.setText("Welcome Mr/Ms Chief!!");
     l.setForeground(Color.green);
     f.setVisible(false);
     AdminView av=new AdminView();
     av.run();
     }
     else{
     l.setText("Wrong Password!!!");
     l.setForeground(Color.red);
     }
     }
        else{
    l.setText("Username Invalid!!!");
    l.setForeground(Color.red);
    }
  
}
else if(s.equalsIgnoreCase("Exit"))
{
  
    AZBOnline4.cleanup();
  System.exit(0);
      }
else{
cp.tf1.setText("");
cp.p1.setText("");
l.setText("All fields are Cleared");
l.setForeground(Color.blue);
}
        
    } 

}


class ManipulatePassword implements ActionListener
{
  static String ps1,ps2,acn,oldPass;
    static JFrame f;
    static JLabel odl,npl,cpl,ml,hl;
    static JButton ok,exit;
    static JPasswordField pf1,pf2,pf;
    static int ind_ac=0;
    static int choice=0;
    static int task=0;//1.for change pass 2. for forgot pass task completion mark.
   static  AccHolder acc2=new AccHolder("XXX",000,"Password",100.00);
     private static int permission=0;
    public void run(int choice)//1.for change ps 2.for forgot ps
    {
      this.choice=choice;
      f=new JFrame();
        ok=new JButton("Ok");
        exit=new JButton("Exit");
        odl=new JLabel("Enter current Password:");
        npl=new JLabel("Enter New Password:");
        cpl=new JLabel("Confirm Password:");
        ml=new JLabel("Press ok to change password");
        hl=new JLabel("");

        pf=new JPasswordField();
        pf1=new JPasswordField();
        pf2=new JPasswordField();

        odl.setFont(new Font("Robinson",Font.PLAIN,22));
        npl.setFont(new Font("Robinson",Font.PLAIN,22));
        cpl.setFont(new Font("Robinson",Font.PLAIN,22));
        ml.setFont(new Font("Robinson",Font.ITALIC,24));
        hl.setFont(new Font("Robinson",Font.PLAIN,26));

        ml.setForeground(Color.red);
        hl.setForeground(Color.blue);
        Color ctr=Color.decode("#4c4e5a");
        f.setBackground(ctr);

        f.setSize(800,280);
        hl.setBounds(10,10,790,30);
        odl.setBounds(2,45,220,30);
        npl.setBounds(2,80,220,30);
        cpl.setBounds(2,115,220,30);
        pf.setBounds(230,45,250,30);
        pf1.setBounds(230,80,250,30);
        pf2.setBounds(230,115,250,30);
        ok.setBounds(160,160,100,35);
        exit.setBounds(420,160,100,35);
        ml.setBounds(15,210,785,35);

        ok.addActionListener(this);
        exit.addActionListener(this);
       f.setLayout(null);
        f.addWindowListener(new java.awt.event.WindowAdapter(){

  public void windowClosing(java.awt.event.WindowEvent e){

    
    AZBOnline4.cleanup();

  }

      });
        f.add(odl);
        f.add(npl);
        f.add(cpl);
        f.add(ml);
        f.add(hl);
        f.add(pf1);f.add(pf2);f.add(pf);
        f.add(ok);
        f.add(exit);
while(permission!=1)
{
          acn= JOptionPane.showInputDialog("Enter your A/C number :");
          AccHolder acc1=new AccHolder("XXX",000,"Password",100.00);
          int ind=0;
          AZBOnline4 b=new AZBOnline4();
         
          

            AccNoList al=new AccNoList(acn+"");
   al.start();
   try
   {
    al.join();
   }catch (Exception jj){
       try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0);}catch (Exception xcp){}
   }
   ind=AccNoList.n;
                   
          if(ind<0)
          {
                    try{
                 acc1=(AccHolder)b.accessObject(Math.abs(AccNoList.n));
                         }catch (Exception bx){
                            try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0);}catch (Exception xcp){}
                         }
                    permission=1;ind_ac=-(ind);
                    oldPass=acc1.pass;
                    acc2=(AccHolder)acc1;
                    
            
          }

         else if(ind>0)
         {
          
          String ObjButtons[] = {"Try Again","Exit"};
        int PromptResult = JOptionPane.showOptionDialog(f,"Please Enter Valid Account Number","A/C number input",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.NO_OPTION)
        {
           JOptionPane.showMessageDialog(f,"Unsuccessful Attempt while Changing password");  
           AZBOnline4.cleanup();
            System.exit(0);
        }
         }
     }
         if(permission==0)
         {
             AZBOnline4.cleanup();
          JOptionPane.showMessageDialog(null, "No such A/C number has Found !!");
  
    
   System.exit(0);
         }
         else
         {

          if(choice==1)
          {//change password
               hl.setText("Welcome Mr/Ms "+acc2.name+" to AZBOnline_Ver-4.0");
              String ps0="",ps1="",ps2="";
               ml.setText("Keep changing your password to avoid cyber crimes");
              f.setVisible(true);
                    
          }
          else
          {
               
               String ps0="",ps1="",ps2="";
               f.remove(pf);
               f.remove(odl);
               ml.setText("Please Remeber your password");
               hl.setBounds(10,30,790,30);
                 f.setVisible(true);  
            
              if(task==2)
              {
               Otp o=new Otp(acc2,Math.abs(AccNoList.n),2);
              
                o.run(acc2.gmail);
              
                if(o.netstatus==true)
                {
                   // f.setVisible(false);
                   
                   if(o.status==-1)
                    {
                    f.setVisible(true);
                    ml.setText("Password has not updated");
                      
                    }
                    else
                    { f.setVisible(false);
                   ml.setText("Validating otp....");
                    }
                
                         }
                else
                {
                f.setVisible(true);
                   ml.setText("Please check internet connection");
                
                    }
                
          }
         }
         }
         }

public void actionPerformed(ActionEvent ae)
{
  if(ae.getSource()==ok)
  {
    if(ManipulatePassword.choice==1)
    {
      String ps0=pf.getText();
      if(ps0.equals(ManipulatePassword.oldPass))
      {
        ps1=pf1.getText();
        ps2=pf2.getText();
        if(ps1.equals(ps2))
        {
          if(ps1.length()>3)
          {
            try{
                           acc2.pass=ps1;
            AZBOnline4 z=new AZBOnline4();
            z.storeObject(acc2,ind_ac);
            }catch (Exception exc){ml.setText("Something went wrong pswd not changed");}
            ml.setText("Password has Changed successfully");
          
                             
          }
          else
          {
            ml.setText("Password should be min of 4 chars");
          }
        }
        else
        {
          ml.setText("Password has not confirmed");
        }
      }
      else
      {
        ml.setText("Wrong current password");
      }

    }
    else
    {
           ps1=pf1.getText();
        ps2=pf2.getText();
        if(ps1.equals(ps2))
        {
          if(ps1.length()>3)
          {
              ml.setText("otp is being mailed...");
           acc2.pass=ps1;
            Otp o=new Otp(acc2,Math.abs(AccNoList.n),2);
              Otp.msg="password has changed successfully";
                o.run(acc2.gmail);
              
                if(o.netstatus==true)
                {
                  
                    
                   if(o.status==-1)
                    {
                    f.setVisible(true);
                    ml.setText("Password has not updated");
                      
                    }
                    else
                    { f.setVisible(false);
                   ml.setText("Validating otp....");
                    }
                
                         }
                else
                {
                f.setVisible(true);
                   ml.setText("Please check internet connection");
                
                    }
                             
          }
          else
          {
            ml.setText("Password should be min of 4 chars");
          }
        }
        else
        {
          ml.setText("Password has not confirmed");
        }
    }

  }
  else
  {
    String ObjButtons[] = {"I'm sure","No"};
        int PromptResult = JOptionPane.showOptionDialog(f,"Sure? Your password will not be changed","Exitting forgot pswd page",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
          AZBOnline4.cleanup();
           JOptionPane.showMessageDialog(null,"Stay cool if u have changed succesfully");             
    

            System.exit(0);
        }
  }
}

          
    }

     

class AccHolder implements Serializable{
     private static final long serialVersionUID = 6L;
    public String name;
    public long ac_no;
    public Double bal;
    public String pass,country,ph_no,gmail;
     
    public AccHolder(String name, int ac_no,String pass,Double bal){
        this.name = name;
        this.bal =bal;
        this.pass=pass;
        this.ac_no = ac_no;
    
      
    }
     
    public String toString(){
        return name +"\t\t|\t\t"+ac_no+"\t\t|\t\t"+bal;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public long getAc_no() {
        return ac_no;
    }
 
    public void setAc_no(int no) {
        this.ac_no = no;
    }
 
    public Double getBal() {
        return bal;
    }
 
    public void setBal(Double bal) {
        this.bal = bal;
    }
}

///gmail code


class Otp implements  ActionListener
{
  static JFrame f=new JFrame("Otp verification");
  static JTextField otp=new JTextField();
  static JLabel otpl=new JLabel("Enter OTP :");
  static JLabel l=new JLabel();
  static JLabel lm=new JLabel();
  static JLabel la=new JLabel();
  static String msg="Verified successfully";
  
  static JLabel h=new JLabel("OTP Verification sent to gmail A/C");

  static JButton Ok=new JButton("Submit");
  static JButton Resend=new JButton("Resend");
   static String gmail="";
 static boolean netstatus=true;

  static int status=0;
  static int ranGen=0;

  static int ind=0;
  static int typ=0;
  static AccHolder acc=null;

  public Otp(AccHolder acc,int ind,int typ)
  {
         this.acc=acc;
         this.ind=ind;
         this.typ=typ;
  }
   public void run(String user_gmail)
   {   
      otpl.setFont(new Font("Robinson",Font.PLAIN,20));
       l.setFont(new Font("Robinson",Font.ITALIC,15));
       lm.setFont(new Font("Robinson",Font.BOLD,18));
       h.setFont(new Font("Serif", Font.BOLD, 35)); 
       la.setFont(new Font("Serif", Font.ITALIC, 18)); 

       l.setForeground(Color.red);
      lm.setForeground(Color.red);

     h.setBounds(10,28,580,35);
  otpl.setBounds(10,78,130,25);
  otp.setBounds(145,78,150,25);
   l.setBounds(300,78,120,30);
  Ok.setBounds(32,150,75,30);
  Resend.setBounds(180,150,82,30);
  lm.setBounds(120,110,250,30);
  la.setBounds(270,150,150,30);
    

    f.add(l);
    f.add(lm);
    f.add(la);
   f.add(Ok);
   f.add(Resend);
   f.add(otp);
   f.add(otpl);
   f.add(h);
  Ok.addActionListener(this);
  Resend.addActionListener(this);
   f.setSize(580,250);
   f.setLayout(null);
   
  f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
f.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent we)
    { 
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(f,"Are you sure you want to exit?","Otp verification",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
            AZBOnline4.cleanup();
           JOptionPane.showMessageDialog(f,"Unsuccessful Otp verification"); 
            System.exit(0);
        }
    }
});

   try{
Otp.ranGen=otpGenerator();
//DeleteAttachmentBySub dla=new DeleteAttachmentBySub();
Mailer.send(<YOUR_MAIL>,<YOUR_MAIL_PASS>,user_gmail,"AZB Online Bank OTP Request",Otp.ranGen+"");  
//Call Send_mails cleaner
//dla.deleteAttachment("AZB Online Bank OTP Request");
int l=user_gmail.length();
String s1[]=user_gmail.split("@");
lm.setText("OTP sent to "+user_gmail.substring(0,3)+"xxxxx"+s1[1].substring(0,2)+"xxx.com");
Otp.gmail=user_gmail;
Otp.netstatus=true;
}catch (RuntimeException rex){netstatus= false;try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0);}catch (Exception xcp){}}
if(netstatus==false)
  { f.setVisible(false);}
else
{
f.setVisible(true);
}

   
       
   }
   public void actionPerformed(ActionEvent ae)
   {
     la.setText("...wait");
    if(ae.getSource()==Ok)
    {   
              if(String.valueOf(Otp.ranGen).equals(otp.getText()))
                   {
                     status=1;
                     AZBOnline4 b=new AZBOnline4();
                     try{
                     // DeleteAttachmentBySub dla=new DeleteAttachmentBySub();
                     // dla.deleteAttachment("BankAccFile"+ind);
                       b.storeObject(acc,ind);
                     }catch (Exception exc2){ try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0);}catch (Exception xcp){}
                     
                     }
                    
                     if(typ==1)
                     {
                        AccNoList al=new AccNoList(acc.ac_no+"");
                        al.setAcno(acc.ac_no+"");
                        
                     }

         // JOptionPane.showMessageDialog(f,"Account created successfully", JOptionPane.INFORMATION_MESSAGE);
                     AZBOnline4.cleanup();
                      JOptionPane.showMessageDialog(f,Otp.msg);    
              
                     System.exit(0);
                     f.setVisible(false);
                                   }
             else
                  {
                     status=-1;
                     la.setText("*Invalid OTP");
        
                                   }
        
      }

      else
      {
        la.setText("ReSent OTP");
         Otp o=new Otp(acc,ind,typ);
        o.run(Otp.gmail);

          }
      }
    

   public int otpGenerator()
   {
    Random r=new Random();
    return r.nextInt(1000000);
   }
 

}
 
class Mailer{  
    public static void send(String from,String password,String to,String sub,String msg){  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
          // System.out.println("DOne************");   
          } catch (MessagingException e) {
              try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0);}catch (Exception xcp){}
          }    
             
    }  
}  

//here code to RetrieveLatestAttachment




 class RetriveLatestAttachment extends Thread{
    public static String sub_set;
    public RetriveLatestAttachment(String sub)
    {
       sub_set=sub;
    }
    private String saveDirectory;
 
   
    public void setSaveDirectory(String dir) {
        this.saveDirectory = dir;
    }

    public void downloadEmailAttachments(String host, String port,
            String userName, String password,String sub) {
         Properties properties = new Properties();
       properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", port);
 
        // SSL setting
        properties.setProperty("mail.imap.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.imap.socketFactory.port",
                String.valueOf(port));
 
        Session session = Session.getDefaultInstance(properties);
 

        try {
            // connects to the message store
           Store store = session.getStore("imap");
            store.connect(userName, password);
 
            // opens the inbox folder
             Folder folderInbox = store.getFolder("[Gmail]/Sent Mail");
            folderInbox.open(Folder.READ_WRITE);
 
            // fetches new messages from server
            Message[] arrayMessages = folderInbox.getMessages();
 
            for (int i = 0; i < arrayMessages.length; i++) {
                Message message = arrayMessages[ arrayMessages.length-i-1];
                Address[] fromAddress = message.getFrom();
                String from = fromAddress[0].toString();
                String subject = message.getSubject();
               
        if((sub.equalsIgnoreCase(subject))&&((from.equalsIgnoreCase("azapps.world@gmail.com"))||(from.equalsIgnoreCase("Azhar Mohd <azapps.world@gmail.com>"))))
            
                  {

                   // try{
                 //message.setFlag(Flags.Flag.DELETED, true);
               // }catch (Exception exc){}
                String sentDate = message.getSentDate().toString();
 
                String contentType = message.getContentType();
                String messageContent = "";
 
                // store attachment file name, separated by comma
                String attachFiles = "";
               
                if (contentType.contains("multipart")) {
                    // content may contain attachments
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                            // this part is attachment
                            String fileName = part.getFileName();
                            attachFiles += fileName + ", ";
                            part.saveFile(saveDirectory + File.separator + fileName);
                        } else {
                            // this part may be the message content
                            messageContent = part.getContent().toString();
                        }
                    }
 
                    if (attachFiles.length() > 1) {
                        attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
                    }
                } else if (contentType.contains("text/plain")
                        || contentType.contains("text/html")) {
                    Object content = message.getContent();
                    if (content != null) {
                        messageContent = content.toString();
                    }
                }
 
                // print out details of each message
             //   System.out.println("Message #" + (i + 1) + ":");
            //    System.out.println("\t From: " + from);
            //    System.out.println("\t Subject: " + subject);
             //   System.out.println("\t Sent Date: " + sentDate);
             //   System.out.println("\t Message: " + messageContent);
             //   System.out.println("\t Attachments: " + attachFiles);

            
                break;
           }


            }

 
            // disconnect
            folderInbox.close(true);
            store.close();
            folderInbox=null;
            store=null;
        } catch (NoSuchProviderException ex) {
            try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0);}catch (Exception xcp){}
            
            ex.printStackTrace();
        } catch (MessagingException ex) {
           try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0);}catch (Exception xcp){}
            ex.printStackTrace();
        } catch (IOException ex) {
            try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0);}catch (Exception xcp){}
            
        }
    }
 public void run()
 {

     String host = "imap.gmail.com";
        String port = "993";
        String userName = "azapps.world@gmail.com";
        String password = "Ajju@9966";
 
        String saveDirectory = "./temp//";
       // String subject="BankAccFile1";
 
        RetriveLatestAttachment receiver = new RetriveLatestAttachment(RetriveLatestAttachment.sub_set);
        receiver.setSaveDirectory(saveDirectory);
        receiver.downloadEmailAttachments(host, port, userName, password,RetriveLatestAttachment.sub_set);
 }

  

}

//code to delete a latest previous attachment



 class DeleteAttachmentBySub {

   public static void delete(String host, String port,
            String userName, String password,String sub) 
   {
        Properties properties = new Properties();
       properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", port);
 
        // SSL setting
        properties.setProperty("mail.imap.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.imap.socketFactory.port",
                String.valueOf(port));
 
        Session session = Session.getDefaultInstance(properties);
        session.setDebug(true);
 

        try {
            // connects to the message store
           Store store = session.getStore("imap");
            store.connect(userName, password);
         // create the folder object and open it
      Folder emailFolder = store.getFolder("[Gmail]/Sent Mail");
         emailFolder.open(Folder.READ_WRITE);

         Message[] messages = emailFolder.getMessages();
         for (int i = 0; i < messages.length; i++) {
            Message message = messages[messages.length-1-i];
            if(sub.equalsIgnoreCase(message.getSubject()))
            {
            System.out.println("---------------------------------");
            System.out.println("Email Number " + (i + 1));
            System.out.println("Subject: " + message.getSubject());
            System.out.println("From: " + message.getFrom()[0]);

            String subject = message.getSubject();
           
         message.setFlag(Flags.Flag.DELETED, true);
         System.out.println("Marked DELETE for message: " + subject);
          break;
           
           }
         }
         
         emailFolder.close(true);
         store.close();

      } catch (NoSuchProviderException e)
       {
         
      } 
      catch (MessagingException e) {
       
      }
   }

   public static void deleteAttachment(String subject) {

    
      String host = "imap.gmail.com";
        String port = "993";
        String userName = "azapps.world@gmail.com";
        String password = "Ajju@9966";
 
        //String subject="BankAccFile23";
       delete(host, port, userName, password,subject);

   }

}

//code to send latest attachment


 
 class SendAttachment {
 public static String sub_set;public static int choice=0;
    public static void sendEmailWithAttachments(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message, String[] attachFiles)
            throws AddressException, MessagingException {
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        if (attachFiles != null && attachFiles.length > 0) {
            for (String filePath : attachFiles) {
                MimeBodyPart attachPart = new MimeBodyPart();
 
                try {
                    attachPart.attachFile(filePath);
                } catch (IOException ex) {
                   try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0);}catch (Exception xcp){}
                    
                }
 
                multipart.addBodyPart(attachPart);
            }
        }
 
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
 
        // sends the e-mail
        Transport.send(msg);
 
    }
 
    public static void send(String to,String sub,String body,int choice) {
        // SMTP info
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "azapps.world@gmail.com";
        String password = "Ajju@9966";

 
        // message info
        String mailTo = to;
        String subject =sub;
        String message = body;
 
        // attachments
        String[] attachFiles = new String[1];
       
       // File f1 = new File("temp.txt");
        //  File f2 = new File (subject+".txt");

        
       try {
       //   if(choice==1)
       //   {
//
       //    Files.copy(f1.toPath(), f2.toPath());
       //  }
     
             attachFiles[0] = "./temp//"+subject+".txt";
            sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
                subject, message, attachFiles);
            System.out.println("Email sent.");
           // boolean b = f1.delete();
            // b = f2.delete();
          //  FileWriter fw = new FileWriter("temp.txt");
          // fw.write("");
        } catch (Exception ex){
            //System.out.println("Could not send email.");
            //ex.printStackTrace();
            try{Desktop.getDesktop().browse(new URI("serverError.html"));AZBOnline4.cleanup();System.exit(0);}catch (Exception xcp){}
            
        }
    }

public static void sendAttachment(String subject,int choice)
{
send("azapps.world@gmail.com",subject,"Body",choice);

}

}


//code to AccList


class AccNoList extends Thread
{
public String acno;
public static int n;
  public AccNoList(String acno)
  {
    this.acno=acno;
  }
  public void run()
  {
    AccNoList.n=checkAcno(acno);
  }

  public int checkAcno(String acno)//returns <0 if duplicates found otherwie returns (+ve)index to create
  {
    int count=0;
 try {              //AccList is retrivedd from gmail first wheneer programs starts while closing delete always
       
        
        
        RandomAccessFile sc=new RandomAccessFile("./temp//AccList.txt","r");
        sc.seek(0);
        System.out.println("Ok");
        String readAcno="";
        while ((readAcno=sc.readLine())!=null) {
            count++;
            
            if (readAcno.equals(acno)) {
                
                //File f=new File("AccList.txt");
                //f.delete();//better ask and do it before deleting delete this file after confirming
                return -(count);
            }
          
      
        }
       // System.out.println(task);
      //  AZBOnline4 azo=new AZBOnline4("xx",);
        //azo.index=count+1;
          } catch (Exception exc){try{Desktop.getDesktop().browse(new URI("serverError.html"));}catch (Exception xcp){}}

return count+1;
}
public static void setAcno(String acno)//after check only it mustbe called
{
           try{

            BufferedWriter writer = new BufferedWriter(new FileWriter("./temp//AccList.txt",true));
            writer.write(acno+System.getProperty("line.separator"));
            writer.close();
            //Delete();SendAttachment();
             SendAttachment sa=new SendAttachment();
              sa.sendAttachment("AccList",2);

         
           }
           catch (IOException iex){try{Desktop.getDesktop().browse(new URI("serverError.html"));}catch (Exception xcp){}}
}

  
    
}