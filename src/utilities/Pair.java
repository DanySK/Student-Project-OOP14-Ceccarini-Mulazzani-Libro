package utilities;
/**
 * 
 * presa dalla soluzione di un esercizio fatto in laboratorio
 *
 */
public class Pair<X,Y>{
    
    public X first;
    public Y second;
    
    public Pair(final X first,final Y second){
    	this.first = first;
    	this.second = second;
    }
    
    public X getFirst(){
    	return this.first;
    }
    
    public Y getSecond(){
    	return this.second;
    }
    
    public void setFirst(final X first) {
		this.first = first;
	}

	public void setSecond(final Y second) {
		this.second = second;
	}

	public String toString(){
    	return "<"+this.first+","+this.second+">";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
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
		final Pair <X,Y> other = (Pair <X,Y>) obj;
		if (first == null) {
			if (other.first != null) {
				return false;
			}
		} else if (!first.equals(other.first)) {
			return false;
		}
		if (second == null) {
			if (other.second != null) {
				return false;
			}
		} else if (!second.equals(other.second)) {
			return false;
		}
		return true;
	}
	
	
} 
