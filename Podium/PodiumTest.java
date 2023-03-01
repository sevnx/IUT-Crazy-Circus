package podium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PodiumTest {
    @Test
    public void testAddAtTop(){
        Podium podium = new Podium();
        podium.addAtTop(Animal.BEAR);
        assertEquals(Animal.BEAR, podium.getTop());
    }

    @Test
    public void testRemoveAtTop(){
        Podium podium = new Podium();
        podium.addAtTop(Animal.BEAR);
        podium.removeAtTop();
        assertTrue(podium.isEmpty());
    }

    @Test
    public void testRemoveAtBottom(){
        Podium podium = new Podium();
        podium.addAtTop(Animal.BEAR);
        podium.removeAtBottom();
        assertTrue(podium.isEmpty());
    }

    @Test
    public void testEqualsWithSelf(){
        Podium podium = new Podium(new ArrayList<>(Arrays.asList(Animal.values())));
        assertEquals(podium, podium);
    }

    @Test
    public void testEqualsWithCopy(){
        Podium podium = new Podium(new ArrayList<>(Arrays.asList(Animal.values())));
        Podium podium2 = new Podium(podium);
        assertEquals(podium, podium2);
    }

    @Test
    public void testNotEquals(){
        Podium podium = new Podium(new ArrayList<>(Arrays.asList(Animal.values())));
        Podium podium2 = new Podium(new ArrayList<>());
        podium2.addAtTop(Animal.BEAR);
        assertNotEquals(podium, podium2);
    }

    @Test
    public void testEqualsWithManualAddAndMultipleAnimals(){
        Podium podium = new Podium();
        Podium podium2 = new Podium();
        podium.addAtTop(Animal.BEAR);
        podium.addAtTop(Animal.ELEPHANT);
        podium.addAtTop(Animal.LION);
        podium2.addAtTop(Animal.BEAR);
        podium2.addAtTop(Animal.ELEPHANT);
        podium.removeAtTop();
        assertEquals(podium, podium2);
    }
}