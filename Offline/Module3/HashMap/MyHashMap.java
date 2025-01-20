import java.util.*;
public class MyHashMap<K, V> {

    class Node{
        K key;
        V value;
        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    int threshold;
    LinkedList<Node> [] arr;
    int size;
    int arrSize;

    MyHashMap(){
        this.arr = new LinkedList[4];
        this.threshold = 4;
        for(int i = 0; i < this.arr.length; i++){
            this.arr[i] = new LinkedList<>();
        }
        this.arrSize = 4;
        this.size = 0;
    }

    public V get(K key){
        int idx = this.getHashValue(key);
        LinkedList<Node> list = arr[idx];
        for(Node node : list){
            if(node.key == key){
                return node.value;
            }
        }
        return null;
    }


    public void reArrange(){
        LinkedList<Node> [] nArr = new LinkedList[2*arr.length];
        for(int i = 0; i < nArr.length; i++){
            nArr[i] = new LinkedList<>();
        }
        this.arrSize = 2*arr.length;
        for(int i  = 0; i < arr.length; i++){
            LinkedList<Node> list = arr[i];
            for(Node node: list){
                K key = node.key;
                int idx = this.getHashValue(key);
                LinkedList<Node> nli = nArr[idx];
                nli.add(node);
            }
        }

        this.arr = nArr;
    }

    public int getHashValue(K key){
        int hashing = Math.abs(key.hashCode());
        int finalHash = hashing%this.arrSize;
        return finalHash;
    }

    public void put(K key, V value){
        // generate hashcode for key
        int idx = this.getHashValue(key);
        LinkedList<Node> list = arr[idx];
        boolean isKeyAvailable = false;
        for(Node node : list){
            if(node.key == key){
                isKeyAvailable = true;
                node.value = value;
                break;
            }
        }

        if(isKeyAvailable == false){
            this.size++;
            Node nn = new Node(key, value);
            list.add(nn);
            int factor = this.size/arr.length;
            if(factor > threshold){
                // rearrange
                reArrange();
            }
        }
    }
    
}
