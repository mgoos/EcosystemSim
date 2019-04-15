package elements;

public class Animal {

	static int numberOfCows;

	private String location;

	private String name;

	private int positionX;

	private int positionY;

	private int hunger;

	private int libido;

	private int age;

	private boolean chewing;

	private boolean lives;

	AnimalCollection anmColl = new AnimalCollection();

	public Animal(int x, int y) {
		setAge(0);
		setLibido(0);
		setHunger(100);
		setLives(true);
		setPositionX(x);
		setPositionY(y);
		setLocation(x + "-" + y);
		anmColl.addToAllTheAnimals(this);
		setName("Berta" + numberOfCows);
		numberOfCows++;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean StillLives() {
		return lives;
	}

	public void setLives(boolean lives) {
		this.lives = lives;
	}

	public int getLibido() {
		return libido;
	}

	public void setLibido(int libido) {
		this.libido = libido;
	}

	public boolean isChewing() {
		return chewing;
	}

	public void setChewing(boolean chewing) {
		this.chewing = chewing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}