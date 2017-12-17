package Objects;

public class Health extends State implements Interactables{
	private boolean Existance = false;
@Override
public void setExistance(boolean e) {
	// TODO Auto-generated method stub
	super.setExistance(e);
	Existance = e ;
}

	@Override
	public boolean isExisted() {
		// TODO Auto-generated method stub
		return false;
	}
}
