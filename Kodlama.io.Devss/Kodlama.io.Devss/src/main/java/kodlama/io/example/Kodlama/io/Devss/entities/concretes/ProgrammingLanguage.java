package kodlama.io.example.Kodlama.io.Devss.entities.concretes;

public class ProgrammingLanguage {

	private int id;
	private String Name;
	public ProgrammingLanguage(int id, String name) {
		super();
		this.id = id;
		Name = name;
	}
	public ProgrammingLanguage() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
}
