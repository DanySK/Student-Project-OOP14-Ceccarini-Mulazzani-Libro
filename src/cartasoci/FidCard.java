package cartasoci;
/**
 * 
 * 
 * @author Alberto Mulazzani
 *
 */
public class FidCard implements IFidCard {
	
	private Integer points;
	
	public FidCard(){
		this.points = 0;
	}

	@Override
	public void addPoints(int points) {
		this.points += points;

	}

	@Override
	public Integer getPoints() {
	
		return this.points;
	}


}
