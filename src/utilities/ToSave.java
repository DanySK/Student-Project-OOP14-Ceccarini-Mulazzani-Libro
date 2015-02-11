package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cartasoci.User;
import model.Libro;

public class ToSave {
	
	private List<Libro> magaz = new ArrayList<>();
	private List<Libro> ordini = new ArrayList<>();
	private Map<Integer, User> cards = new HashMap<>();
	
	private ToSave(){
		
	}
	
	public ToSave getIstance(){
	
		return this;
	}
	

}
