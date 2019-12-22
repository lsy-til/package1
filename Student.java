package class_08_aic;
public class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String toString() {
        return id + "\t" + name;
    }
	public String getName() {
		return this.name;
	}
	public String getStudentId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}