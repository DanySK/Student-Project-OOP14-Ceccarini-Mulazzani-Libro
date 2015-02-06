package utilities;

import java.io.IOException;

public class SaveClass {
	
//	private static IBookManagement library;
	//private static IOrdini orders ;
	
	//private static IFidelityCards cards;
	//private File file = new File("data.bin");
	
/*	
	@SuppressWarnings("static-access")
	public SaveClass(IBookManagement lib, IOrdini ord, IFidelityCards car, IStatistics stat, IEarnings ear){
		
		this.library = lib;
		this.orders = ord;
		this.cards = car;
		this.statistics = stat;
		this.earnings = ear;
		
	}*/
	
	public SaveClass(){
		
	}
	/*
	public static void setLib(IBookManagement lib ){
		library = lib;
	}
	
	public static void setOrd(IOrdini ord){
		orders = ord;
	}
	*/
	/*public static void setCards(IFidelityCards car){
		cards = car;
	}*/
	
	
	
	
	public static void saveAll() throws IOException{
		
	/*	FileOutputStream stream = new FileOutputStream("res/data.bin");
		ObjectOutputStream oos = new ObjectOutputStream(stream);
		//System.out.println(library);
		oos.writeObject(library);
		oos.writeObject(orders);
//		oos.writeObject(cards);
		oos.close();*/
		
	}
}
