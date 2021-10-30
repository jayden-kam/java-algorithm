package jayden.learn.ds;

public class HashMap {

    private final LinkedList[] hashMap;

    public HashMap(int size) {
        this.hashMap = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            this.hashMap[i] = new LinkedList();
        }
    }

    public void delete(String key) {
        int index = hash(key);
        LinkedList list = this.hashMap[index];
        Node node = list.getHead();
        while (node != null) {
            String[] keyVal = (String[]) node.getData();
            if (keyVal[0].equals(key)) {
                list.remove(keyVal);
                return;
            }
            node = node.getNext();
        }
    }

    public String retrieve(String key) {
        int index = hash(key);
        LinkedList list = this.hashMap[index];
        Node node = list.getHead();
        while (node != null) {
            String[] keyVal = (String[]) node.getData();
            if (keyVal[0].equals(key)) {
                return keyVal[1];
            }
            node = node.getNext();
        }
        return null;
    }

    public void assign(String key, String value) {
        int index = hash(key);
        LinkedList list = this.hashMap[index];
        String[] data = {key, value};
        Node node = list.getHead();
        if (node == null) {
            list.addToHead(data);
            return;
        }
        while (node != null) {
            String[] keyVal = (String[]) node.getData();
            if (keyVal[0].equals(key)) {
                keyVal[1] = value;
                node.setData(keyVal);
                break;
            }
            if (node.getNext() == null) {
                node.setNext(new Node(data));
                break;
            }
            node = node.getNext();
        }
    }

    private int hash(String key) {
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashCode += Character.codePointAt(key, i);
        }
        return hashCode % this.hashMap.length;
    }
}
