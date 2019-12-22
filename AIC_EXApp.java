package class_08_aic;
import java.io.*;
import java.util.*;

public class AIC_EXApp {
    public static void main(String[] args) throws IOException  {
    	Scanner input=new Scanner(System.in);
		String account;
		String password;
		do {
			System.out.println("请输入账号和密码，中间用空格间隔:");
			account=input.next();
			password=input.next();
			if(!(account.equals("admin"))) {
				System.out.println("账号输入错误！请重新输入账号和密码");
			}else if(!(password.equals("admin"))) {
				System.out.println("密码输入错误！请重新输入账号和密码");
			}
		}while(!(account.equals("admin")&&password.equals("admin")));
		System.out.println("成功登陆！！！");
    	
        IRW rw = ConsoleRW.getInstance();
        Receiver receiver = new Receiver(rw, getStudents());
        rw.writeln("欢迎来到学生管理系统。");
        
        int operation = receiver.getOperation();
        while (operation != 0) {
            receiver.run(operation);
            operation = receiver.getOperation();
        }
        rw.writeln("-----------退出系统----------");
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