package game;

public enum Direction {
	
	UP(0), DN(1), LT(2), RT(3);
	
	private int num;
	
	Direction(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}

}
