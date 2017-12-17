package Objects;


public class Player extends State implements Interactables {
		private String newDirection = "Stop";
		private String oldDirection = "Stop";

		private String rotationDir = "Stop" ;
	 	// private int Health = 0;
	 	private int Spirit = 0;
	 	private int Ammo = 0;
		private int Score = 0;
	 	private int IR = 0;
	 	private int JD = 0;
	 	private int IL = 0;
	 	private int JL = 0;
		private int IndexY = 22;
		private int IndexX = 22;

	 	private Boolean Existance = false;
		
		@Override
		public int getScore() {
			// TODO Auto-generated method stub
			//System.out.println(Score);
			//super.getScore();
		return Score;
		}
	 
	 	@Override
	 	public int getAmmo() {
	 		// TODO Auto-generated method stub
	 		super.getAmmo();
	 		return Ammo;
	 	}
	 
	 	/*
	 	 * @Override public int getHealth() { // TODO Auto-generated method stub
	 	 * return super.getHealth(); }
	 	 */
	 	@Override
	 	public int getIR() {
			return ((IndexY+21) / 22);
	
	 
	 	}
	 	@Override
	 	public String getRotationDir() {
	 	// TODO Auto-generated method stub
	 	return rotationDir;
	 	}
	 
	 	@Override
	 	public int getJD() {
			return ((IndexX+21) / 22);
	
	 	}
	 
	 	@Override
	 	public int getIL() {
			return IndexY/ 22;
	 
	 	}
	 
	 	@Override
	 	public int getJL() {
			return  (IndexX) / 22;
	
	 
	 	}
	 
	 	@Override
	 	public int getindexX() {
	 		return IndexX;
	 
	 	}
	 
	 	@Override
	 	public int getindexY() {
	 		return IndexY;
	 
	 	}
	 
	 	@Override
	 	public String getNewDirection() {
	 		// TODO Auto-generated method stub
	 		super.getNewDirection();
	 		return newDirection;
	 	}
	 
	 	@Override
	 	public String getOldDirection() {
	 		// TODO Auto-generated method stub
	 		super.getOldDirection();
	 		return oldDirection;
	 	}
	 
	 	@Override
	 	public int getSpirit() {
	 		// TODO Auto-generated method stub
	 		super.getSpirit();
	 		return Spirit;
	 	}
	 	@Override
	 	public int getISmall(){
			return IndexY % 22;		
	
	 	}
	 	@Override
	 	public int getJSmall(){
			return IndexX % 22;		
			
	 	}
	 	@Override
	 	public boolean isExisted() {
	 		super.isExisted();
	 		return Existance;
	 		// TODO Auto-generated method stub
	 	}
	 
	 	@Override
	 	public void setAmmo(int x) {
	 		super.setAmmo(x);
	 		Ammo = x;
	 
	 	}
		@Override
		public void setScore(int y) {
			// TODO Auto-generated method stub
			super.setScore(y);
			Score=y;
		}
	 	/*
	 	 * @Override public void setHealth(int x) { // TODO Auto-generated method
	 	 * stub super.setHealth(x); Health=x; }
	 	 */
	 
	 	@Override
	 	public void setNewDirection(String x) {
	 		// TODO Auto-generated method stub
	 		super.setNewDirection(x);
	 		newDirection = x;
	 	}
@Override
	 	public void setRotationDir(String x) {
	 	// TODO Auto-generated method stub
	 	super.setRotationDir(x);
	 	 rotationDir=x;
	 	}
	 
	 	@Override
	 	public void setOldDirection(String x) {
	 		// TODO Auto-generated method stub
	 		super.setOldDirection(x);
	 		oldDirection = x;
	 	}
	 
	 	@Override
	 	public void setSpirit(int x) {
	 		// TODO Auto-generated method stub
	 		super.setSpirit(x);
	 		Spirit = x;
	 	}
	 
	 	@Override
	 	public void setindexX(int x) {
	 		// TODO Auto-generated method stub
	 		super.setindexX(x);
	 		IndexX = x;
	 	}
	 
	 	@Override
	 	public void setindexY(int y) {
	 		// TODO Auto-generated method stub
	 		super.setindexY(y);
	 		IndexY = y;
	 	}
	 
	 }


