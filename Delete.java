package class_08_aic;

import java.util.*;

public class Delete extends Command {
    public static final int num = 2;
    private static Command instance = new Delete();

    private Delete() {
        super(num, "ɾ������");
    }
    public static Command getInstance() {
        return instance;
    }
	public String run(ParaForCommand para) {
		ParaForDelete paraD = (ParaForDelete)para;
		int itemId = paraD.getItemId();
    	int isOk = paraD.getIsOk();
    	List<Student> students = paraD.getStudents();
    	String res = null;
		if(itemId >=1 && itemId <= students.size()){
    		if(isOk == 1){
    			students.remove(itemId-1);
    			res = "1����¼��ɾ����";
    		}else if(isOk == 0){
    			res = "0����¼��ɾ����";
    		}
    	}else{
    		res = "��������Ч���֣�0-"+students.size()+")��";
    	}
		return res;
	}
}
