package PacManGit;

import java.util.LinkedList;

import Objects.Ammo;

public class AmmoPool {
	  private final static int SIZE =6; 
	  private LinkedList<Ammo> Ammos;
	  private int Counter =6;

	  public AmmoPool() {
		  Ammos = new LinkedList<>();
		  for(int i=0;i<SIZE;i++){
			  Ammos.add(new Ammo(i));
		  }
		  
	  }

	
	protected Ammo create() {
		// TODO Auto-generated method stub
		Ammo x = Ammos.getLast();
		Counter--;
		Ammos.removeLast();
		return x;
	}


	public void expire(Ammo o) {
		// TODO Auto-generated method stub
		if (o != null&&Counter<=6){
			Ammos.add(Counter, o);
			Counter++;
		}
		
	}

}
