package cartasoci;
/**
 * 
 * Basic class of a Fidelity Card Owner
 * 
 * @author Alberto Mulazzani
 *
 */
public class User {
	
	private String name;
	private String surname;
	private String email;
	final private IFidCard carta = new FidCard();
	private int id;
	
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
	
	public void setID(final int id){
		this.id = id;
	}
	
	public void setName(final String name){
		this.name = name;
	}
	
	public void setSurname(final String surname){
		this.surname = surname;
	}
	
	public void setEmail (final String email){
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
	
	public int getID(){
		return this.id;
	}
	
	public Integer getPoints(){
		return this.carta.getPoints();
	}
	
	public void addPoints(final int points){
		this.carta.addPoints(points);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((carta == null) ? 0 : carta.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final User other = (User) obj;
		if (id != other.id) {
			return false;
		}
		if (carta == null) {
			if (other.carta != null) {
				return false;
			}
		} else if (!carta.equals(other.carta)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (surname == null) {
			if (other.surname != null) {
				return false;
			}
		} else if (!surname.equals(other.surname)) {
			return false;
		}
		return true;
	}

}
