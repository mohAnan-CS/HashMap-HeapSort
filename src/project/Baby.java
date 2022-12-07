package project;

import DataStructure.Heap;

public class Baby {

    private String name;
    private char gender;
    private Heap<FreqYear> heapFrequency;

    public Baby(String name, char gender, Heap<FreqYear> heapFrequency) {

        this.name = name;
        this.gender = gender;
        this.heapFrequency = heapFrequency;

    }

    public Baby(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Heap<FreqYear> getHeapFrequency() {
        return heapFrequency;
    }

    public void setHeapFrequency(Heap<FreqYear> heapFrequency) {
        this.heapFrequency = heapFrequency;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ",gender= " + gender +
                ",heapFrequency=" + heapFrequency.getHeap() +
                "}";
    }
}
