package org.example;

import java.util.Arrays;

class Animal {
    // Method in superclass
    void speak() {
        System.out.println("Animal speaks");
        //throw new IllegalArgumentException("Value for Animal speak in not compatible");
    }
}

class Dog extends Animal {
    // Overriding the speak method in the subclass

    void speak() {
        System.out.println("Dog barks");
    }
}

public class Overriding {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();

        // Calling the method from the superclass
        myAnimal.speak();

        // Calling the overridden method in the subclass
        myDog.speak();

        int[] a = {2,4,6,7,8,9};

        Arrays.stream(a).forEach(System.out::println);
    }
}