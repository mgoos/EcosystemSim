package elements;

public class FloorTiles {

	private boolean overgrown = false;

	private int x;

	private int y;

	private int age;

	private String name;

	public FloorTiles(int x, int y) {

		setX(x);
		setY(y);
		setName(x + "-" + y);
		setAge(1);

	}

	public boolean isOvergrown() {
		return overgrown;
	}

	public void setOvergrown(boolean overgrown) {
		this.overgrown = overgrown;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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

}
