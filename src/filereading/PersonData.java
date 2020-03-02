package filereading;


/**
 * @author jabirhussain
 *
 */
public class PersonData implements Comparable<PersonData>{
	
	private int id;
	private String name;
	private int age;
	private String sex;
	private int pclass;
	private int survived;
	private double fare;
	
	
	
	
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getPclass() {
		return pclass;
	}
	public void setPclass(int pclass) {
		this.pclass = pclass;
	}
	public int getSurvived() {
		return survived;
	}
	public void setSurvived(int survived) {
		this.survived = survived;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "PersonData [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", pclass=" + pclass
				+ ", survived=" + survived + ", fare=" + fare + "]";
	}
	public PersonData(int id, String name, int age, String sex, int pclass, int survived, double fare) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.pclass = pclass;
		this.survived = survived;
		this.fare = fare;
	}
	public PersonData() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(PersonData arg0) {
		// TODO Auto-generated method stub
		return (this.age - arg0.age);
	}
	
	
	
	
	

}
