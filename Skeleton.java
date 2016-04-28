public class Skeleton implements Entity {
	private int health = 15;
	private int damage = 2;
	private Room r;
	
	@Override
	public int getHealth() {
		return health;
	}
	
	@Override
	public void damageEntity(int a) {
		damage -= a;
	}
	
	@Override
	public void setRoom(Room r) {
		this.r = r;
	}
	
	@Override
	public int attackEnemy(int a) {
		return a - damage;
	}
}