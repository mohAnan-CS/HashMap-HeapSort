package DataStructure;

import javafx.beans.property.SimpleStringProperty;
import project.FreqYear;

import java.io.File;
import java.util.Arrays;

public class Heap<T extends Comparable<T>> {


    public static void main(String[] main) {

        Heap heap = new Heap(5);
        heap.insert(new FreqYear(7, 2001));
        heap.insert(new FreqYear(5, 2002));
        heap.insert(new FreqYear(7, 2003));

        String str = heap.HeapSort(heap);
        System.out.println(str);


    }


    private T[] HeapTable;
    public int size;


    private static final int ROOT = 1;


    public Heap(int maxSize) {


        this.size = 0;
        HeapTable = (T[]) new Comparable[maxSize + 1];

    }

    public String HeapSort(Heap heap) {

        if (heap.size == 0) {
            String heapStr = "[]";
            return heapStr;
        } else if (heap.size == 1) {

            String heapStr = "[";
            heapStr = heapStr + heap.remove() + "]";
            return heapStr;

        } else {
            String heapStr = "[ ";

            while (size != 2)
                heapStr = heapStr + " " + heap.remove();

            if (((FreqYear) HeapTable[size]).getFreq() < ((FreqYear) HeapTable[size - 1]).getFreq()) {

                heapStr = heapStr + " " + heap.remove();
            } else {

                swap(size, size - 1);
                heapStr = heapStr + " " + heap.remove();

            }

            heapStr = heapStr + " " + heap.remove() + " ]";


            return heapStr;
        }

    }

    public int findFreq(int year) {

        int freq = 0;
        for (int i = 1; i < size + 1; i++) {

            if (((FreqYear) HeapTable[i]).getYear() == year) {
                freq = ((FreqYear) HeapTable[i]).getFreq();
                System.out.println("first if ");
                return freq;
            }
        }
        System.out.println(HeapTable[1]);
        if (((FreqYear) HeapTable[1]).getYear() == year) {
            System.out.println("second if");
            freq = ((FreqYear) HeapTable[1]).getFreq();
            return freq;
        }

        return 0;
    }


    public T remove() {
        T removedElement = HeapTable[ROOT];
        HeapTable[ROOT] = HeapTable[size--];
        sink(ROOT, size);
        HeapTable[size + 1] = null;
        return removedElement;
    }

    private void sink(int pos, int lastPos) {
        // left pos*2 =j
        // right pos*2+1 =j+1
        if (pos * 2 <= lastPos && (pos * 2) + 1 <= lastPos) // is not Leaf
            if (childIsGreat(pos, pos * 2) || childIsGreat(pos, (pos * 2) + 1)) {
                if (childIsGreat(pos * 2, (pos * 2) + 1)) {
                    swap(pos, (pos * 2) + 1);
                    sink((pos * 2) + 1, lastPos);
                } else {
                    swap(pos, pos * 2);
                    sink(pos * 2, lastPos);
                }
            }
    }

    public Heap<T> cloneHeap() {
        Heap heap = new Heap(size);
        for (int i = 1; i < size + 1; i++) {

            heap.insert(HeapTable[i]);
        }
        return heap;
    }

    public int numberInYear(int year) {
        for (int i = 1; i < size + 1; i++) {
            if (((FreqYear) HeapTable[i]).getYear() == year)
                return ((FreqYear) HeapTable[i]).getFreq();
        }

        return 0;
    }

    public void insert(T element) {

        checkCapacity();
        HeapTable[++size] = element;
        swim();

    }

    public void swim() {

        int curr = size;
        //System.out.println("curr = " + curr + " / size = " + size + "////length = " + HeapTable.length );

        while (curr > 1 && childIsGreat(curr / 2, curr)) {
            //System.out.println("curr = " + curr + " / size = " + size + "////length = " + HeapTable.length );
            swap(curr / 2, curr);
            curr = curr / 2;

        }


    }

    public boolean childIsGreat(int parent, int child) {

        //System.out.println(HeapTable[child] + "       " + (HeapTable[parent]));
        if (HeapTable[child].compareTo(HeapTable[parent]) < 0) {
            return false;
        } else {
            return true;
        }
    }

    public int getMaxFreq() {
        return ((FreqYear) HeapTable[1]).getFreq();
    }

    public void swap(int parent, int curr) {

        T temp;
        temp = HeapTable[parent];
        HeapTable[parent] = HeapTable[curr];
        HeapTable[curr] = temp;


    }


    public void print() {

        System.out.print("[ ");

        for (int i = 1; i < size; i++)
            System.out.print(HeapTable[i] + " , ");

        System.out.print(HeapTable[size] + " ]");
        System.out.println();

    }

    public FreqYear findOldYear(int year) {

        if (HeapTable != null) {

            for (int i = 1; i < size; i++) {

                System.out.println("Length = " + HeapTable.length);

                //int yearOld = ((FreqYear) HeapTable[i]).getYear();
                //FreqYear obj = (FreqYear) HeapTable[i];
                int yearNew = ((FreqYear) HeapTable[i]).getYear();
                FreqYear obj = ((FreqYear) HeapTable[i]);
                if (year == yearNew) {
                    return obj;
                }

            }
        }

        return new FreqYear(0, 0);

    }

    public String getHeap() {

        String heapStr = "";
        for (int i = 1; i <= size; i++) {
            heapStr = heapStr + HeapTable[i];
            //System.out.println(heapStr);
        }
        //System.out.println("heap = " +heapStr);
        return heapStr;


    }

    public void checkCapacity() {

        int sizeHeap = HeapTable.length - 1;
        if (size == sizeHeap) {
            sizeHeap = (sizeHeap * 2) + 3;
            HeapTable = Arrays.copyOf(HeapTable, sizeHeap);
        }

    }


}
