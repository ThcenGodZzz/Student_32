package student.entity;

public class Student {
	private String name;
	private int sno;
	private int age;
	private String dept;
	
	public Student(int sno) {
		this.sno = sno;
	}
	
	public Student() {
		
	}
	public Student(String name, int age, String dept) {
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	public Student(String name, int sno, int age, String dept) {
		this.name = name;
		this.sno = sno;
		this.age = age;
		this.dept = dept;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String toString() {
		return this.getSno()+"-"+this.getName()+"-"+this.getAge()+"-"+this.getDept();
		
	}
}
