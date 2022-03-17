import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest{

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