package JAPI.ERS;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Students {

	private String name;
	private String City;
	private int age;
	private int id;
	
	
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
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Students [name=" + name + ", City=" + City + ", age=" + age + "]";
	}

	
	
}
