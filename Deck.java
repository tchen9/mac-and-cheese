import java.util.ArrayList;

public interface Deck{

    public abstract ArrayList<Object> createDeck();
	/*for (int x = 2; x < 11; x++){
	    for (int y = 0; y < 4; y++){
		this.deck.add(x);
		//System.out.println(deck);
	    }
	}
	for (int z = 0; z < 4; z++){
	    this.deck.add("King");
	    this.deck.add("Queen");
	    this.deck.add("Jack");
	    this.deck.add("Ace");
	    }*/
    

    public abstract void shuffle( ArrayList al ) ;
	/*int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	   randomIndex = (int)( (i+1) * Math.random() );
	   al.set( i, al.set( randomIndex, al.get(i) ) );
	  } */
    
}
