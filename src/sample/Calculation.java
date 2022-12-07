package sample;

import DataStructure.Hash;

import java.util.ArrayList;

public class Calculation {

    public static void main(String[] args) {



        /*

        ArrayList arr = new ArrayList();
        arr.add(new FileRead("mosafdsadf" , 2012));
        arr.add(new FileRead("mosafdsadf" , 2012));
        arr.add(new FileRead("mosafdsadf" , 2012));
        arr.add(new FileRead("mosafdsadf" , 2012));
        arr.add(new FileRead("mosafdsadf" , 2012));
        arr.add(new FileRead("mosafdsadf" , 2012));


        for (int i = 0 ; i < arr.size() ; i++){
            System.out.println(arr.get(i));
        }

        Baby obj = new Baby("Moh" , 'm' , new Heap<>(4));
        Baby obj1 = new Baby("oba" , 'f' , new Heap<>(4));
        Baby obj2 = new Baby("bas" , 'm' , new Heap<>(4));
        Baby obj3 = new Baby("ibr" , 'f' , new Heap<>(4));

        Hash hash = new Hash(10);
        hash.insert(getAscii(obj.getName().concat(String.valueOf(obj.getGender()))) , obj);
        hash.insert(getAscii(obj1.getName().concat(String.valueOf(obj1.getGender()))) , obj1);
        hash.insert(getAscii(obj2.getName().concat(String.valueOf(obj2.getGender()))) , obj2);
        hash.insert(getAscii(obj3.getName().concat(String.valueOf(obj3.getGender()))) , obj3);

        System.out.println(isNameFound(hash,"Moh" , 'm' ));

         */

    }


    public int getMod(int num1, int num2) {

        int mod = num1 % num2;
        return mod;
    }

    public boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n / 2; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }


}
