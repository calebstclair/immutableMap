package immutable;
import java.util.List;

public class EmptyNode extends Map {
    public static final EmptyNode instance = new EmptyNode();
    //This is the empty-node — the only instance of EmptyNode in the whole program. Make sure you initialize it.

    private EmptyNode(){

    }
    //Should be private. Nobody else should be creating instances of this class.

    public int size(){
        return 0;
    }
    //The empty-node always has a size of zero.

    public int depth(){return 0;}
    //The empty-node always has a depth of zero.

    public boolean empty(){
        return true;
    }
    //The empty-node is always empty.

    public Map setValue(String key, Integer value){
        return new Node(key, value, instance, instance);
    }
    //Since the node is empty, we simply only need to create a new (regular) node with the given key and value. The new node's children will both be the empty-node.

    public Integer getValue(String key){
        return null;
    }

    protected void addEntries(List<Entry> list) {

    }
}
