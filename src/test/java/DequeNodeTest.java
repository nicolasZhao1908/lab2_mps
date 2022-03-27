import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest<T> {
    private DequeNode first;

    @BeforeEach
    public void setup(){
        Integer item = 0;
        first = new DequeNode<>(item,null,null);
    }
    @AfterEach
    public void finish(){
        first = null;
    }

    @Test
    public void shouldHaveUpdatedNextIfSetNewNext(){
        Integer item = 0;
        DequeNode <Integer> second = new DequeNode<>(item, null, first);

        DequeNode oldNext = first.getNext();
        first.setNext(second);
        DequeNode newNext = first.getNext();

        assertThat(oldNext).isNotEqualTo(newNext);
    }

    @Test
    public void shouldHaveUpdatedNextIfSetNewPrevious(){
        Integer item = 0;
        DequeNode <Integer> second = new DequeNode<>(item, null, null);

        DequeNode oldPrevious = second.getPrevious();
        second.setPrevious(first);
        DequeNode newPrevious = second.getPrevious();

        assertThat(oldPrevious).isNotEqualTo(newPrevious);
    }

    @Test
    public void testNewItemSetIsNotNull(){
        Integer newItem = 1;
        first.setItem(newItem);
        assertThat(first.getItem()).isNotNull();
    }

    @Test
    public void testNewItemSetIsUpdated(){
        Integer newItem = 1;

        Integer oldItem = (Integer) first.getItem();
        first.setItem(newItem);
        newItem = (Integer) first.getItem();

        assertThat(newItem).isNotEqualTo(oldItem);
    }

    @Test
    public void isNotATerminalNode() {

        //first is not a terminal node
        DequeNode prev = new DequeNode(1, first, null);
        first.setPrevious(prev);

        DequeNode next = new DequeNode(1, null, first);
        first.setNext(next);

        assertThat(first.isNotATerminalNode()).isTrue();
    }

    @Test
    public void oneNodeIsATerminalNodeAndFirstNode() {
        //first is the only node
        assertThat(first.isFirstNode()).isTrue();

    }

    @Test
    public void lastNodeIsIsATerminalNodeAndLastNode() {
        //first is not a terminal node
        DequeNode prev = new DequeNode(1, first, null);

        //first is the last node
        first.setPrevious(prev);
        assertThat(first.isLastNode()).isTrue();
    }

    @Test
    public void shouldEqualHashCodeBeSymmetricReflexive(){
        DequeNode expectedValue, actualValue;
        expectedValue = first;
        actualValue = new DequeNode<>(0,null,null);
        assertThat(actualValue.equals(expectedValue)).isTrue();
        assertThat(actualValue.hashCode()).isEqualTo(expectedValue.hashCode());
    }
}