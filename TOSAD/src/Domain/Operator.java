package Domain;

public class Operator {
	
	// kijkt naar de functie inbetween of de waarde tussen waardeA en waardeB ligt.
	public boolean inBetween(int waardeA, int waardeB, int waardeTeChecken){
		boolean b = false;
		if( waardeB > waardeA ? waardeTeChecken > waardeA && waardeTeChecken < waardeB : waardeTeChecken > waardeB && waardeTeChecken < waardeA){
			b = true;
		}
		
		return b;
	}
	
	public boolean inRange(int waardeA,int waardeB){
		boolean b = false;
		if ( inRange(waardeA, waardeB)){
			b = true;
		}
		return b;
	}
	
	public boolean biggerThen(int waardeA, int waardeB, String type){
		boolean b = false;
		if(type.equalsIgnoreCase("<")){
			if(waardeA < waardeB){
				return true;
			}
		} else if (type.equalsIgnoreCase("<=")){
			if(waardeA < waardeB){
				return true;
			} 
		}
		return b;
	}
	// kijkt of de waardeA kleiner is dan waardeB, daarnaast kijkt hij naar het type of het <= of < is.
	public boolean lowerThen(int waardeA, int waardeB, String type){
		boolean b = false;
		if(type.equalsIgnoreCase("<")){
			if(waardeA < waardeB){
				return true;
			}
		} else if (type.equalsIgnoreCase("<=")){
			if(waardeA < waardeB){
				return true;
			} 
		}
		return b;
	}
	public boolean equalsTo(){
		boolean b = false;
		
		return b;
	}

}
