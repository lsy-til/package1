package class_08_aic;
import java.util.List;
public class Show extends Command {
    public static final int num = 1;
    private static Command instance = new Show();

    private Show() {
        super(num, "��ʾ����");
    }
    public static Command getInstance() {
        return instance;
    }
    public String run(ParaForCommand p) {
    	List<Student> students = p.getStudents();
        StringBuffer res = new StringBuffer();
        res.append("���\t����\tѧ��" + "\r\n");
        for (int i = 0; i < students.size(); i++) {
            res.append(i + 1 + "\t" + students.get(i).toString() + "\r\n");
        }
        return res.toString();
    }
}