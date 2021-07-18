package ru.ncedu.zigal0.voice;

import java.util.ArrayList;

public class SoundsAnimalDemo {
    public static void main(String[] args) {
        ArrayList<Voice> animals = new ArrayList<>();
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Cow());
        for (Voice animal : animals) {
            animal.voice();
        }
    }
}
