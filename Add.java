package class_08_aic;
import java.util.List;
public class Add extends Command {
    public static final int num = 3;
    private static Command instance = new Add();

    private Add() {
        super(num, "新增数据");
    }
    public static Command getInstance() {
        return instance;
    }
    public String run(ParaForCommand p) {
    	ParaForAdd para = (ParaForAdd)p;
    	String name = para.getName();
    	String studentId = para.getStudentId();
    	int isAdd = para.isAdd();
    	List<Student> students = para.getStudents();
    	String res = null;
    	
    	if(isAdd == 1){
    		students.add(new Student(studentId, name));
    		res = "新增成功"+"\r\n";
    	}else{
    		res = "放弃新增。"+"\r\n";
    	}
    	
        return res;
    }
}