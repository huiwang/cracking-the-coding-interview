package stackqueue;

import java.util.LinkedList;

/**
 * An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
 * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like.
 * <p>
 * Create the data structures to maintain this system and implement operations such as
 * enqueue, dequeueAny, dequeueDog, and dequeueCat.
 * <p>
 * You may use the built-in Linked list data structure.
 */
class _03_06_AnimalShelter {

    private int counter = 0;
    private LinkedList<Animal> dogs = new LinkedList<>();
    private LinkedList<Animal> cats = new LinkedList<>();

    void enqueueDog(int num) {
        dogs.add(new Animal(num, counter++));
    }

    void enqueueCat(int num) {
        cats.add(new Animal(num, counter++));
    }

    int dequeueAny() {
        if (dogs.isEmpty()) {
            return cats.remove().num;
        } else if (cats.isEmpty()) {
            return dogs.remove().num;
        } else {
            if (dogs.peek().counter < cats.peek().counter) {
                return dogs.remove().num;
            } else {
                return cats.remove().num;
            }
        }
    }

    int dequeueDog() {
        return dogs.remove().num;
    }

    int dequeueCat() {
        return cats.remove().num;
    }

    static class Animal {
        int num;
        int counter;

        Animal(int num, int counter) {
            this.num = num;
            this.counter = counter;
        }
    }
}
