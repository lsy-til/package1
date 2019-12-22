package class_08_aic;

import java.util.List;

public class ParaForAdd extends ParaForCommand {

	private String name;
	private String studentId;
	private int isAdd;

	public ParaForAdd(List<Student> students, String name, String studentId, int isAdd) {
		super(students);
		this.name = name;
		this.studentId = studentId;
		this.isAdd = isAdd;
	}

	public String getName() {
		return this.name;
	}

	public String getStudentId() {
		return studentId;
	}

	public int isAdd() {
		return isAdd;
	}

}
