package cartasoci;

public class User {
	
	private String name;
	private String surname;
	private String email;
	private IFidCard carta = new FidCard();
	
	public User(final String name){
		this.name = name;
	}
	
	public User(final String name,final String surname){
		this(name);
		this.surname = surname;
	}
	
	public User(final String name,final String surname,final String email){
		this(name,surname);
		this.email = email;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getSurname(){
		return this.surname;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public Integer getPoints(){
		return this.carta.getPoints();
	}
	
	public void addPoints(int points){
		this.carta.addPoints(points);
	}
	
	public double getDiscounts(){
		return this.carta.getDiscounts();
	}
	
	
	
	
	
	
	

}
