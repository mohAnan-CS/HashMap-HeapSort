package DataStructure;

import project.Baby;
import project.FreqYear;

public class Hash {

    public static void main(String[] args) {

        FreqYear o = new FreqYear(10, 2001);
        FreqYear o1 = new FreqYear(8, 2002);
        FreqYear o2 = new FreqYear(9, 2003);

        Heap<FreqYear> heap = new Heap<>(5);
        heap.insert(o);
        heap.insert(o1);
        heap.insert(o2);

        Hash hash = new Hash(10);
        hash.insert(23, new Baby("Mohammad", 'm', new Heap<>(10)));
        hash.insert(24, new Baby("Ali", 'm', heap));
        hash.insert(25, new Baby("Amjad", 'm', new Heap<>(10)));
        Baby obj = hash.updateFreq(23, "Ali", 'm');

        FreqYear o5 = new FreqYear(90, 1999);
        obj.getHeapFrequency().insert(o5);

        hash.printHashTable();


    }

    public HashNode[] table;
    private int currentSize;
    private int tableSize = 128;


    public Baby updateFreq(int key, String name, char gender) {

        int location = key % tableSize;
        int i = 1;
        while (table[location] != null) {
            if (table[location].getData().getName().equals(name) &&
                    String.valueOf(table[location].getData().getGender()).trim().equalsIgnoreCase(String.valueOf(gender))
                    && table[location].getStatus() != 1) {
                //table[location].setStatus(1);
                //System.out.println(table[location].toString());
                return table[location].getData();
            }
            location = (location + i * i) % tableSize;

        }
        return new Baby("", 'n', new Heap<>(1));

    }


    public Hash(int tableSize) {

        this.tableSize = tableSize;
        table = new HashNode[tableSize];

        for (int i = 0; i < table.length; i++)
            table[i] = null;

        currentSize = 1;

    }

    public void insert(int key, Baby babyObj) {

        int location = key % tableSize;

        //System.out.println("table size /2  = "+ tableSize/2);
        //System.out.println("current size = "+ currentSize);
        if (currentSize > tableSize / 2) {
            rehash();
            System.out.println("rehash");
        }


        if (table[location] != null) {

            int i = 1;
            while (true) {
                location = (location + i * i) % tableSize;
                //System.out.println("Location = " +location);
                if (table[location] == null) {

                    table[location] = new HashNode(babyObj, key, 0);
                    currentSize++;
                    break;
                }
                i++;
            }

        } else {
            table[location] = new HashNode(babyObj, key, 0);
            currentSize++;
        }


    }

    public boolean deleteNameRecord(int key, String name, char gender) {

        int location = key % tableSize;
        int i = 1;
        while (table[location] != null) {
            if (table[location].getData().getName().equals(name) &&
                    String.valueOf(table[location].getData().getGender()).trim().equalsIgnoreCase(String.valueOf(gender))
                    && table[location].getStatus() != 1) {
                table[location].setStatus(1);
                //System.out.println(table[location].toString());
                System.out.println("delete successfully ...");
                return true;
            }
            location = (location + i * i) % tableSize;

        }
        System.out.println("name not found !!");
        return false;

    }

    public int search(int key, String name, char gender) {

        int location = key % tableSize;
        int i = 1;
        while (table[location] != null) {
            if (table[location].getData().getName().equals(name) &&
                    String.valueOf(table[location].getData().getGender()).trim().equalsIgnoreCase(String.valueOf(gender))
                    && table[location].getStatus() != 1) {
                //table[location].setStatus(1);
                //System.out.println(table[location].toString());
                System.out.println("found .. ");
                return location;
            }
            location = (location + i * i) % tableSize;

        }
        System.out.println("not found !!");
        return -1;

    }

    public Baby getIndex(int index) {
        return table[index].getData();
    }

    public void rehash() {

        Hash newList;
        newList = new Hash(nextPrime(2 * table.length));

        for (int i = 0; i < table.length; i++)
            if ((table[i] != null) && (table[i].getStatus() == 0))
                newList.insert(table[i].getKey(), table[i].getData());

        table = newList.table;

        tableSize = newList.tableSize;

    }

    private boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n / 2; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    private int nextPrime(int n) {
        if (n % 2 == 0)
            n++;
        while (!isPrime(n)) {
            n += 2;
        }
        return n;
    }

    public void printHashTable() {

        for (int i = 0; i < table.length; i++) {

            if (table[i] == null)
                System.out.println("NULL");
            else if (table[i].getStatus() == 1)
                System.out.println("NULL , deleted");
            else
                System.out.println(i + " [ key = " + table[i].getKey() + " , data = " + table[i].getData() + " ]");

        }

    }

    public int getCurrentSize() {
        return currentSize;
    }

    public Baby getMaxNameInYear(int year) {
        int max = -1;
        Baby maxBaby = null;

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].getStatus() == 0) {
                int freqInCurrentYear = table[i].getData().getHeapFrequency().numberInYear(year);
                System.out.println(freqInCurrentYear + "     " + table[i].getData().getName());
                if (freqInCurrentYear > max) {
                    max = freqInCurrentYear;
                    maxBaby = table[i].getData();
                }
            }

        }


        return maxBaby;
    }

}
