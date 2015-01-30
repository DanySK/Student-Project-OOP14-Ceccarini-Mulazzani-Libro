package cartasoci;

import java.util.HashMap;
import java.util.Map;

public class FidelityCards implements IFidelityCards{
	
	private Map<Integer , User> cards = new HashMap<>();
	private int next;
	
	public FidelityCards(){
		this.next = 0;
	}
	
	
	public void removePerson(){
		
	}

	@Override
	public User searchID(Integer id) {
		if (cards.containsKey(id)){
			
		}
		return null;
		
	}

	@Override
	public User searchName(String name) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPerson(Integer id, User user) throws NullPointerException {
		// TODO Auto-generated method stub
		
	}
	
	public int getNextId(){
		
		return this.next;
	}
	
	
	

}
