package PacManGit;

import Objects.Ammo;
import Objects.AmmoGift;
import Objects.FullBomb;
import Objects.HalfBomb;
import Objects.Health;
import Objects.Interactables;
import Objects.PathFree;
import Objects.Spirit;
import Objects.Stones;
import Objects.Tree;

public class ConvertIterator {
	private final static char SBOMS = 'b';
	private final static char BBOMS = 'B';
	private final static char TREE = 'T';
	private final static char HEALTH = 'H';
	private final static char AMMO = 'A';
	private final static char SPIRIT = 'U';
	private final static char STONES = '#';
	private final static int XSIZE = 31;
	private final static int YSIZE = 31;
	

	
	
	public Interactables[][] convert (char [][] x){
		Interactables [][] c = new Interactables [XSIZE][YSIZE];
		for(int i=0;i<x.length;i++){
			for(int j=0;j<x[0].length;j++){
				if(x[i][j]==SBOMS){
					c[i][j]=new HalfBomb();
				}else if (x[i][j]==BBOMS){
					c[i][j]=new FullBomb();
				}else if (x[i][j]==TREE){
					c[i][j]=new Tree();		
				}else if (x[i][j]==HEALTH){
					c[i][j]=new Health();
				}else if (x[i][j]==AMMO){
					c[i][j]=new AmmoGift();
				}else if (x[i][j]==SPIRIT){
					c[i][j]=new Spirit();
				}else if (x[i][j]==STONES){
					c[i][j]=new Stones();
				}else{
					c[i][j]=new PathFree();
				}
				
			}
		}
		return c;
		
	}
	

}
