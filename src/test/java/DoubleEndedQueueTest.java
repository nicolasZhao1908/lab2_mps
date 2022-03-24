import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DoubleEndedQueueTest {

    DoubleEndedQueue doubleEndedQueueList;

    @BeforeEach
    public void setup() {
        doubleEndedQueueList = new DoubleEndedQueueList();
    }

    @AfterEach
    public void finish() {
        doubleEndedQueueList = null;
    }

    @Test
    public void testNewNodeAppendedIsNotNull(){
        Integer item = 1;
        DequeNode node1 = new DequeNode(item,null,null);
        DequeNode node2 = new DequeNode(item,null,null);

        doubleEndedQueueList.append(node1);
        assertThat(doubleEndedQueueList.peekLast()).isNotNull();

        doubleEndedQueueList.appendLeft(node2);
        assertThat(doubleEndedQueueList.peekFirst()).isNotNull();
    }

    //Test de que Append actualiza las referencias y el size
    @Test
    public void shouldAddOneToSizeAndUpdateReferencesWhenAppending () {
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        DequeNode node3 = new DequeNode(3,null,null);
        int initialSize = doubleEndedQueueList.size();

        doubleEndedQueueList.append(node1);
        assertThat(node1.getNext()).isNull();
        assertThat(node1.getPrevious()).isNull();
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize+1);

        doubleEndedQueueList.append(node2);
        assertThat(node1.getNext()).isEqualTo(node2);
        assertThat(node1.getPrevious()).isNull();
        assertThat(node2.getPrevious()).isEqualTo(node1);
        assertThat(node2.getNext()).isNull();
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize+2);

        doubleEndedQueueList.append(node3);
        assertThat(node2.getNext()).isEqualTo(node3);
        assertThat(node3.getPrevious()).isEqualTo(node2);
        assertThat(node3.getNext()).isNull();
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize+3);
    }

    //Test de que AppendLeft actualiza las referencias y el size
    @Test
    public void shouldAddOneToSizeAndUpdateReferencesWhenAppendingLeft () {
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        DequeNode node3 = new DequeNode(3,null,null);
        int initialSize = doubleEndedQueueList.size();

        doubleEndedQueueList.appendLeft(node1);
        assertThat(node1.getNext()).isNull();
        assertThat(node1.getPrevious()).isNull();
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize+1);


        doubleEndedQueueList.appendLeft(node2);
        assertThat(node1.getNext()).isNull();
        assertThat(node1.getPrevious()).isEqualTo(node2);
        assertThat(node2.getPrevious()).isNull();
        assertThat(node2.getNext()).isEqualTo(node1);
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize+2);


        doubleEndedQueueList.appendLeft(node3);
        assertThat(node2.getPrevious()).isEqualTo(node3);
        assertThat(node3.getPrevious()).isNull();
        assertThat(node3.getNext()).isEqualTo(node2);
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize+3);

    }


    //Test de que DeleteLast actualiza las referencias y el size
    @Test
    public void shouldSubtractOneToSizeAndUpdateReferencesWhenDeletingLast(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        DequeNode node3 = new DequeNode(3,null,null);
        doubleEndedQueueList.append(node1);
        doubleEndedQueueList.append(node2);
        doubleEndedQueueList.append(node3);
        int initialSize = doubleEndedQueueList.size();

        doubleEndedQueueList.deleteLast();

        assertThat(node1.getNext()).isEqualTo(node2);
        assertThat(node1.getPrevious()).isNull();
        assertThat(node2.getPrevious()).isEqualTo(node1);
        assertThat(node2.getNext()).isNull();
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize-1);


        doubleEndedQueueList.deleteLast();
        assertThat(node1.getNext()).isNull();
        assertThat(node1.getPrevious()).isNull();
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize-2);


        doubleEndedQueueList.deleteLast();
        assertThat(doubleEndedQueueList.size()).isEqualTo(0);
    }

    //Test de que DeleteFirst actualiza las referencias y el size
    @Test
    public void shouldSubtractOneToSizeAndUpdateReferencesWhenDeletingFirst(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        DequeNode node3 = new DequeNode(3,null,null);
        doubleEndedQueueList.append(node1);
        doubleEndedQueueList.append(node2);
        doubleEndedQueueList.append(node3);
        int initialSize = doubleEndedQueueList.size();

        doubleEndedQueueList.deleteFirst();

        assertThat(node2.getNext()).isEqualTo(node3);
        assertThat(node2.getPrevious()).isNull();
        assertThat(node3.getPrevious()).isEqualTo(node2);
        assertThat(node3.getNext()).isNull();
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize-1);

        doubleEndedQueueList.deleteFirst();
        assertThat(node3.getNext()).isNull();
        assertThat(node3.getPrevious()).isNull();
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize-2);

        doubleEndedQueueList.deleteFirst();
        assertThat(doubleEndedQueueList.size()).isEqualTo(0);
    }

    @Test
    public void shouldGetAtPositionOneReturnTheNodeAtPositionOne(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        doubleEndedQueueList.append(node1);
        doubleEndedQueueList.append(node2);
        DequeNode actualNode = doubleEndedQueueList.getAt(1);
        DequeNode expectedNode = node2;
        assertThat(actualNode).isEqualTo(expectedNode);
    }

    @Test
    public void shouldGetAtPositionZeroReturnTheNodeAtPositionZero(){
        DequeNode node1 = new DequeNode(1,null,null);
        doubleEndedQueueList.append(node1);
        DequeNode actualNode = doubleEndedQueueList.getAt(0);
        DequeNode expectedNode = node1;
        assertThat(actualNode).isEqualTo(expectedNode);
    }

    @Test
    public void shouldGetAtNegativePositionThrowAnException(){
        assertThrows(RuntimeException.class,()-> doubleEndedQueueList.getAt(-1));
    }
    @Test
    public void shouldGetAtPositionGreaterOrEqualThanSizeThrowAnException(){
        DequeNode node1 = new DequeNode(1,null,null);
        doubleEndedQueueList.append(node1);
        assertThrows(RuntimeException.class,()-> doubleEndedQueueList.getAt(1));
        assertThrows(RuntimeException.class,()-> doubleEndedQueueList.getAt(10));
    }

    @Test
    public void shouldRaiseExceptionWhenDeletingANodeFromEmptyList(){
        assertThrows(RuntimeException.class,() -> doubleEndedQueueList.deleteFirst());
        assertThrows(RuntimeException.class,() -> doubleEndedQueueList.deleteLast());
    }

    @Test
    public void shouldRaiseExceptionWhenDeletingAnEmptyNode(){
        assertThrows(RuntimeException.class, () -> doubleEndedQueueList.delete(null));
    }

    @Test
    public void shouldRaiseExceptionWhenDeletingANodeNotInTheList(){
        DoubleEndedQueueList<Integer> list = new DoubleEndedQueueList<>();
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null, null);
        DequeNode node3 = new DequeNode(3,null, null);
        DequeNode node4 = new DequeNode(4,null,null);

        list.append(node1);
        list.append(node2);
        list.append(node3);

        assertThrows(RuntimeException.class, () -> doubleEndedQueueList.delete(node4));
    }

    @Test
    public void shouldDeleteTheFirstNode(){
        DoubleEndedQueueList<Integer> list = new DoubleEndedQueueList<>();
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null, null);
        DequeNode node3 = new DequeNode(3,null, null);

        list.append(node1);
        list.append(node2);
        list.append(node3);

        DoubleEndedQueueList<Integer> expectedValue = list;

        list.delete(node1);

        assertThat(list).isEqualTo(expectedValue);

    }



}