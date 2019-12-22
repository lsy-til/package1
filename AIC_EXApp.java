package class_08_aic;
import java.io.*;
import java.util.*;

public class AIC_EXApp {
    public static void main(String[] args) throws IOException  {
    	Scanner input=new Scanner(System.in);
		String account;
		String password;
		do {
			System.out.println("�������˺ź����룬�м��ÿո���:");
			account=input.next();
			password=input.next();
			if(!(account.equals("admin"))) {
				System.out.println("�˺�������������������˺ź�����");
			}else if(!(password.equals("admin"))) {
				System.out.println("����������������������˺ź�����");
			}
		}while(!(account.equals("admin")&&password.equals("admin")));
		System.out.println("�ɹ���½������");
    	
        IRW rw = ConsoleRW.getInstance();
        Receiver receiver = new Receiver(rw, getStudents());
        rw.writeln("��ӭ����ѧ������ϵͳ��");
        
        int operation = receiver.getOperation();
        while (operation != 0) {
            receiver.run(operation);
            operation = receiver.getOperation();
        }
        rw.writeln("-----------�˳�ϵͳ----------");
    }

    private static List<Student> getStudents() throws IOException{
    	List<Student> students = new ArrayList<Student>();
    	FileReader reader = new FileReader("students.txt");
    	BufferedReader br = new BufferedReader(reader);
    	String str = null;
    	while((str = br.readLine())!=null){
    		String[] s = str.split(",");
    		students.add(new Student(s[0],s[1]));
    	}
		return students;
	}
}