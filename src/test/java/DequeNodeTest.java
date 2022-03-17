import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest<T> {
    private DequeNode dequeNode;
    
    @AfterEach
    public void finish(){
        dequeNode = null;
    }

    @Test
    public void shouldHaveUpdatedNextIfSetNewNext(){
        Integer item = 0;
        dequeNode = new DequeNode<>(item,null,null);
        DequeNode<T> oldValue;
        oldValue = dequeNode.getNext();
        DequeNode<T> newValue;
        newValue = new DequeNode(item,null,null);
        dequeNode.setNext(newValue);

        assertNotEquals(oldValue,newValue);
    }

    @Test
    public void shouldHaveUpdatedNextIfSetNewPrevious(){
        Integer item = 0;
        dequeNode = new DequeNode<>(item,null,null);
        DequeNode<T> oldValue;
        oldValue = dequeNode.getPrevious();
        DequeNode<T> newValue;
        newValue = new DequeNode(item,null,null);
        dequeNode.setPrevious(newValue);

        assertNotEquals(oldValue,newValue);
    }

    @Test
    public void shouldComputeRaisAnExceptionIfTheItemIsNull(){
        assertThrows(RuntimeException.class, () -> new DequeNode<>(null, null, null) );
    }

    //Not finished
    @Test
    public void testNewItemSettedIsNotNull(){

        DequeNode<Integer> d = new DequeNode<>(null,null,null);

        Integer newItem = null;
    }

    @Test
    public void testNewItemSettedIsUpdated(){
        Integer newItem = 1;

        DequeNode<Integer> d = new DequeNode<>(null,null,null);
        d.setItem(newItem);
        assertTrue(newItem.equals(d.getItem()));

        d = new DequeNode<>(1,null,null);
        d.setItem(newItem);
        assertTrue(newItem.equals(d.getItem()));

        d = new DequeNode<>(2,null,null);
        d.setItem(newItem);
        assertTrue(newItem.equals(d.getItem()));
    }
}