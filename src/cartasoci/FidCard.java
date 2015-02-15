package cartasoci;
/**
 * Basic class of a Fidelity Card itself
 * 
 * @author Alberto Mulazzani
 *
 */
public class FidCard implements IFidCard {
	
	private Integer points;
	
	public FidCard() {
		this.points = 0;
	}

	@Override
	public void addPoints(final int points) {
		this.points += points;

	}

	@Override
	public Integer getPoints() {
	
		return this.points;
	}


}
