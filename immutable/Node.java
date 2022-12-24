package immutable;
import java.util.List;

class Node extends Map implements Map.Entry {

    final private String _key;
    final private Integer _value;
    final private Map _leftNode, _rightNode;

    public Node(String key, Integer value, Map left, Map right){
        //Constructor initializes the fields. Note that the fields should never be changed.
        _key = key;
        _value = value;
        _leftNode = left;
        _rightNode = right;
    }

    public int size(){
        int count = 0;
        if (!(_leftNode.empty())){
            count += _leftNode.size();
        }
        if (!(_rightNode.empty())){
            count += _rightNode.size();
        }
        return count + 1;
    }

    public  int depth(){
        int maxOfLeft = 1, maxOfRight = 1;

        if (!(_leftNode.empty())){
            maxOfLeft = _leftNode.depth() + 1;
        }
        if (!(_rightNode.empty())){
            maxOfRight = _rightNode.depth() + 1;
        }
        return Math.max(maxOfRight, maxOfLeft);
    }

    public boolean empty(){
        return false;
    }

    public Map setValue(String key, Integer value){
        if (key.compareTo(_key) < 0){ //Less than
            return new Node(_key, _value, _leftNode.setValue(key, value), _rightNode);
        }
        else if (key.compareTo(_key) > 0){ //Greater than
            return new Node(_key, _value, _leftNode, _rightNode.setValue(key, value));
        }
        return new Node(_key, value, _leftNode, _rightNode); //Default case
    }

    public Integer getValue(String key){
        if (key.compareTo(_key) < 0){ //Less than
            return _leftNode.getValue(key);
        }
        else if (key.compareTo(_key) > 0){ //Greater than
            return _rightNode.getValue(key);
        }
        else if (key.compareTo(_key) == 0){
            return getValue();
        }
        return null; //Default case
    }

    protected void addEntries(List<Map.Entry> list){
        if (!(_leftNode.empty())){
            _leftNode.addEntries(list);
            }

        list.add(this);

        if (!(_rightNode.empty())){
            _rightNode.addEntries(list);
        }
        }

    @Override
    public String getKey() {
        return _key;
    }

    @Override
    public Integer getValue() {
        return _value;
    }
}
