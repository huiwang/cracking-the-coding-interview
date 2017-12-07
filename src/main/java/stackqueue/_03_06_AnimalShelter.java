package stackqueue;

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


    void enqueueDog(int num) {
        throw new UnsupportedOperationException();
    }

    void enqueueCat(int num) {
        throw new UnsupportedOperationException();
    }

    int dequeueAny() {
        throw new UnsupportedOperationException();
    }

    int dequeueDog() {
        throw new UnsupportedOperationException();
    }

    int dequeueCat() {
        throw new UnsupportedOperationException();
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
