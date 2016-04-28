public abstract interface Entity {
	int getHealth();
	void damageEntity(int a);
	int attackEnemy(int a);
	void setRoom(Room r);
}