package cartasoci;
/**
 * 
 * @author Alberto Mulazzani
 *
 */
public interface IFidCard {
	
	/**
	 * Adds points to a User's FidCard
	 * 
	 * @param points are the points to add
	 */
	public void addPoints(int points);
	
	/**
	 * Get the FidCard's point.
	 * 
	 * @return points of User
	 */
	public Integer getPoints();
	

}
