package project;

import DataStructure.Heap;

public class Runner {

    public static void main(String[] args) {

        FreqYear obj = new FreqYear(14, 2001);
        FreqYear obj1 = new FreqYear(16, 2018);


        Heap<FreqYear> heap = new Heap<>(1);
        heap.insert(obj);
        heap.insert(obj1);

        heap.print();
















        /*
        calculation obj = new calculation();
        System.out.println(obj.getMod(4,2));
        System.out.println(obj.isPrime(23));
        Hash hash = new Hash(10);
        System.out.println(hash.nextPrime(20));


         */




        /*
        Baby obj = new Baby("Mohammad" , 'M' , new Heap<Integer>(4));

        obj.getHeapFrequency().insert(50);
        obj.getHeapFrequency().insert(40);
        obj.getHeapFrequency().insert(30);

        System.out.println(obj);

         */


    }

}
