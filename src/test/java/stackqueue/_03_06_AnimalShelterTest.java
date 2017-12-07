package stackqueue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _03_06_AnimalShelterTest {

    private _03_06_AnimalShelter s = new _03_06_AnimalShelter();

    @Test
    public void withOrdinaryQueue() {
        s.enqueueCat(5);
        s.enqueueDog(4);
        s.enqueueCat(6);
        s.enqueueCat(7);

        assertEquals(5, s.dequeueAny());
        assertEquals(4, s.dequeueAny());
        assertEquals(6, s.dequeueAny());
        assertEquals(7, s.dequeueAny());
    }

    @Test
    public void withCatDogOledest() {
        s.enqueueCat(5);
        s.enqueueCat(3);
        s.enqueueDog(6);
        s.enqueueDog(2);
        s.enqueueCat(1);

        assertEquals(6, s.dequeueDog());
        assertEquals(5, s.dequeueAny());
        assertEquals(3, s.dequeueAny());
        assertEquals(1, s.dequeueCat());
        assertEquals(2, s.dequeueDog());
    }
}