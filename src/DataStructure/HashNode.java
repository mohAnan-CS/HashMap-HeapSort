package DataStructure;

import project.Baby;

public class HashNode {

    private Baby data;
    private int status = 2; // 0 = full , 1 = delete , 2 = empty
    private int key;

    public HashNode(Baby data, int key, int status) {
        this.data = data;
        this.status = status;
        this.key = key;
    }

    public HashNode() {

    }

    public Baby getData() {
        return data;
    }

    public void setData(Baby data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "HashNode{" +
                "data=" + data +
                ", status=" + status +
                ", key=" + key +
                '}';
    }
}
