package immutable;
import java.util.ArrayList;
import java.util.List;

public abstract class Map {
    public interface Entry{

        //Returns the key of the key/value pair.
        String getKey();

        //Returns the value of the key/value pair.
        Integer getValue();
    }

    //This factory method does not actually create any new objects. It just returns the empty-node.
    public static Map create(){
        return EmptyNode.instance;
    }

    //Returns the size of the map — i.e., the number of entries in the map
    public abstract int size();

    //Returns the depth of the map — i.e., the longest path from the root to any child of the tree
    public abstract int depth();

    //Returns true if the map is empty, false if it is not
    public abstract boolean empty();

    //Returns a new map that has the same key/value pairs as this one except that it also has the specified key/value.
    // If this key was already in the map this replaces its current value with the one provided.
    public abstract Map setValue(String key, Integer value);

    //Returns the value associated with the given key, or null if the given key is not in the map.
    public abstract Integer getValue(String key);

    //Returns a list of all entries in the map. The recommended implementation for this method is to create an object that is-a List and then call the addEntries method above.
    public List<Entry> entries(){
        //Note that List is an interface — i.e., an abstract class. Therefore, you cannot directly create an instance of List.
        //Instead, you will have to create an instance of something that implements List. I recommend ArrayList.
        List<Entry> newList = new ArrayList<>(size());
        addEntries(newList);
        return newList;
    }

    protected abstract void addEntries(List<Entry> list);
    // This protected method is the recommended way to implement the entries() method above.
    // It adds all the entries for the map to a pre-existing List.
    // The entries should be added in increasing order according to their keys.

}
