package cartasoci;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.MissingUserException;
import exceptions.UserAlreadyExisting;

public class TestCartaSoci {

	@Test
	public void test() {
		FidelityCards cards = new FidelityCards();
		User user = new User ("Mario", "Rossi", "m@m");
		String fields [] = {"","Bianchi",""}; 
		
		assertEquals (cards.getMap().size(), 0);
		
		try {
			cards.addPerson(user);
		} catch (NullPointerException | UserAlreadyExisting e) {
			fail ();
		} 
		
		assertEquals (cards.getMap().size(), 1);
		assertTrue (cards.getMap().containsValue(user));
		
		cards.modifyPerson(user, fields);
		
		assertTrue (user.getSurname().equals("Bianchi"));
		
		try {
			cards.removePerson(1);
		} catch (MissingUserException e) {
			fail();
		}
		
		
		
	}

}
