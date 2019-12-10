import java.util.ArrayList;
import java.util.List;

public class Deck {

    private ArrayList<Storage> decks = new ArrayList<>();

    public Deck(){ }

    void addStorage(Storage storage){
        decks.add(storage);
    }

    Storage getFirstStorage(){
        return decks.get(0);
    }

    Storage getLastStorage(){
        return decks.get(decks.size()-1);
    }

    Storage getStorageAtIndex(int index){
        return decks.get(index);
    }

    void removeStorageAtIndex(int index){
        decks.remove(index);
    }

    void removeFirstStorage(){
        decks.remove(0);
    }

    void removeLastStorage(){
        decks.remove(decks.size()-1);
    }
}