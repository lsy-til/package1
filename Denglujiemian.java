package class_08_aic;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Button;

public class Denglujiemian extends AIC_EXApp{
 
    private JFrame frame;
    private JPasswordField passwordField;
    private JTextField textField;
 
	/**
     * Launch the application.����Ӧ�ó���
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Denglujiemian window = new Denglujiemian();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
 
    /**
     * Create the application.����Ӧ�ó���
     */
    public Denglujiemian() {
        initialize();
         
    }
    /**
     * Judge the pwd and username�ж�������û���
     */
    public void judge() {
         
    }
 
    /**
     * Initialize the contents of the frame.��ʼ���������
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(600, 450, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        //frame.setResizable(false);
 
        Label label_2 = new Label("ѧ����Ϣ����ϵͳ");//login
        label_2.setBounds(145, 31, 139, 23);
        label_2.setBackground(Color.GRAY);
        frame.getContentPane().add(label_2);
        //frame.setResizable(false);
         
        JButton btnNewButton = new JButton("\u767B\u5F55");//��¼
        btnNewButton.setBounds(168, 198, 93, 23);
        btnNewButton.setBackground(Color.GRAY);
        btnNewButton.addActionListener(new ActionListener() {
            int i = 3;
            public void actionPerformed(ActionEvent arg0) {
                String usr=textField.getText();
                String pwd=passwordField.getText();
                 
                while(i!=0) {
                    i--;
                    if(usr.equals("")&pwd.equals("")) {
                        JOptionPane.showMessageDialog(null,  "��½�ɹ�����ӭ˧������С��ͬѧ~");
                        //�������һ����      ͼ�λ�����
                        JFrame frame = new JFrame("ѧ����Ϣ����ϵͳ");

                		frame.setBounds(500, 300, 600, 420);
                		
                		Label  L=new Label("��ã�      | ",Label.CENTER);
                		L.setFont(new Font("΢��",Font.PLAIN,15));
                		
                		Label  L1=new Label("��ӭʹ�ñ�ϵͳ",Label.CENTER);
                		L1.setFont(new Font("΢��",Font.PLAIN,15));
                		Button b = new Button("�༭");
                		frame.add(L);
                		frame.add(L1);
                		frame.add(b);
                		
                		frame.setLayout(new FlowLayout());
                		frame.setResizable(false);
                		frame.addWindowListener(new WindowAdapter() {

                			public void WindowClosing(WindowEvent e) {
                				System.exit(0);
                			}
                		});
                		frame.setVisible(true);
                		b.addMouseListener(new MouseAdapter() {
                			public void mouseClicked(MouseEvent e) {
                				System.exit(0);
                			}
                	    });
                		//over
                        break;
                     }
                    else {
                        JOptionPane.showMessageDialog(null, "�˻�����������㻹��"+(i)+"�λ���");
                        break;
                    }
                }
            
                if(i==0) {
                    System.exit(0);
                }
            }
        });
        frame.getContentPane().add(btnNewButton);
         
        Label label = new Label("\u5B66\u53F7\uFF1A");//ѧ��
        label.setBounds(140, 73, 34, 23);
        frame.getContentPane().add(label);
         
        Label label_1 = new Label("\u5BC6\u7801\uFF1A");//����
        label_1.setBounds(140, 121, 34, 23);
        frame.getContentPane().add(label_1);
         
        passwordField = new JPasswordField();
        passwordField.setBounds(182, 123, 79, 21);
        frame.getContentPane().add(passwordField);
 
        textField = new JTextField();
        textField.setBounds(182, 73, 79, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
         
    }
     
}

