import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;

/**
 * Use LinkedList to build a animal shelter. Users can adopt dogs or cats or not a specific kind. But, it has to be chronological order.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2019-01-01 11:58 PM
 */

abstract class Animal {
    private long timestamp;
    protected String name;

    public Animal(String n) {
        name = n;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isOdderThan(Animal a) {
        return this.timestamp < a.timestamp;
    }
}

class Dog extends Animal {
    public Dog(String n) {
        super(n);
    }
}

class Cat extends Animal {
    public Cat(String n) {
        super(n);
    }
}
public class AnimalShelter {

    LinkedList<Dog> dogs = new LinkedList();
    LinkedList<Cat> cats = new LinkedList();
    long ts = 0;

    public void enqueue(Animal a) {
        a.setTimestamp(ts++);
        if (a instanceof Dog) {
            dogs.offer((Dog) a);
        }
        if (a instanceof Cat) {
            cats.offer((Cat) a);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCats();
        }else if (cats.isEmpty()) {
            return dequeueDogs();
        }else {
            Dog tmpD = dogs.peek();
            Cat tmpC = cats.peek();
            if (tmpD.isOdderThan(tmpC)) {
                return dequeueDogs();
            }else {
                return dequeueCats();
            }
        }
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }

    @Test
    public void test() {
        AnimalShelter as = new AnimalShelter();
        as.enqueue(new Dog("d1"));
        as.enqueue(new Dog("d2"));
        as.enqueue(new Cat("c1"));
        as.enqueue(new Dog("d3"));

        assertEquals(as.dequeueAny().name + as.dequeueCats().name + as.dequeueDogs().name + as.dequeueDogs().name, "d1c1d2d3");
    }
}
