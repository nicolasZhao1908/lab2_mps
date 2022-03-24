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

    @Test
    public void shouldUpdateReferencesWhenAppendingOneNode(){
        DequeNode node1 = new DequeNode(1,null,null);
        doubleEndedQueueList.append(node1);
        assertThat(node1.getNext()).isNull();
        assertThat(node1.getPrevious()).isNull();
    }
    @Test
    public void shouldAddOneToSizeAndUpdateReferencesWhenAppendingOneNode() {
        DequeNode node1 = new DequeNode(1,null,null);
        int initialSize = doubleEndedQueueList.size();
        doubleEndedQueueList.append(node1);

        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize+1);
    }

    @Test
    public void shouldUpdateReferencesWhenAppendingWhenAppendingTwoNodes(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        doubleEndedQueueList.append(node1);
        doubleEndedQueueList.append(node2);

        assertThat(node1.getNext()).isEqualTo(node2);
        assertThat(node1.getPrevious()).isNull();
        assertThat(node2.getPrevious()).isEqualTo(node1);
        assertThat(node2.getNext()).isNull();
    }
    @Test
    public void shouldAddTwoToSizeWhenAppendingTwoNodes(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        int initialSize = doubleEndedQueueList.size();
        doubleEndedQueueList.append(node1);
        doubleEndedQueueList.append(node2);

        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize+2);
    }

    @Test
    public void shouldUpdateReferencesWhenAppendingThreeNodes(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        DequeNode node3 = new DequeNode(3,null,null);

        doubleEndedQueueList.append(node1);
        doubleEndedQueueList.append(node2);
        doubleEndedQueueList.append(node3);

        assertThat(node2.getNext()).isEqualTo(node3);
        assertThat(node3.getPrevious()).isEqualTo(node2);
        assertThat(node3.getNext()).isNull();
    }
    @Test
    public void shouldAddThreeToSizeWhenAppendingThreeNodes() {
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        DequeNode node3 = new DequeNode(3,null,null);
        int initialSize = doubleEndedQueueList.size();

        doubleEndedQueueList.append(node1);
        doubleEndedQueueList.append(node2);
        doubleEndedQueueList.append(node3);

        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize+3);
    }
    @Test
    public void shouldUpdateReferencesWhenAppendingLeftOneNode(){
        DequeNode node1 = new DequeNode(1,null,null);

        doubleEndedQueueList.appendLeft(node1);
        assertThat(node1.getNext()).isNull();
        assertThat(node1.getPrevious()).isNull();
    }
    @Test
    public void shouldAddOneToSizeWhenAppendingLeftOneNode(){
        DequeNode node1 = new DequeNode(1,null,null);
        int initialSize = doubleEndedQueueList.size();

        doubleEndedQueueList.appendLeft(node1);
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize+1);
    }
    @Test
    public void shouldUpdateReferencesWhenAppendingLeftTwoNodes(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        doubleEndedQueueList.appendLeft(node1);
        doubleEndedQueueList.appendLeft(node2);
        assertThat(node1.getNext()).isNull();
        assertThat(node1.getPrevious()).isEqualTo(node2);
        assertThat(node2.getPrevious()).isNull();
        assertThat(node2.getNext()).isEqualTo(node1);
    }
    @Test
    public void shouldAddTwoToSizeWhenAppendingLeftTwoNodes (){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        int initialSize = doubleEndedQueueList.size();

        doubleEndedQueueList.appendLeft(node1);
        doubleEndedQueueList.appendLeft(node2);
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize+2);

    }
    @Test
    public void shouldUpdateReferencesWhenAppendingLeftThreeNodes(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        DequeNode node3 = new DequeNode(3,null,null);
        doubleEndedQueueList.appendLeft(node1);
        doubleEndedQueueList.appendLeft(node2);
        doubleEndedQueueList.appendLeft(node3);
        assertThat(node2.getPrevious()).isEqualTo(node3);
        assertThat(node3.getPrevious()).isNull();
        assertThat(node3.getNext()).isEqualTo(node2);
    }

    @Test
    public void shouldAddThreeToSizeWhenAppendingLeftThreeNodes () {
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        DequeNode node3 = new DequeNode(3,null,null);
        int initialSize = doubleEndedQueueList.size();

        doubleEndedQueueList.appendLeft(node1);
        doubleEndedQueueList.appendLeft(node2);
        doubleEndedQueueList.appendLeft(node3);

        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize+3);

    }
    
    @Test
    public void shouldUpdateReferencesWhenDeletingLastThreeNodes(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        DequeNode node3 = new DequeNode(3,null,null);
        doubleEndedQueueList.append(node1);
        doubleEndedQueueList.append(node2);
        doubleEndedQueueList.append(node3);

        doubleEndedQueueList.deleteLast();
        assertThat(node1.getNext()).isEqualTo(node2);
        assertThat(node1.getPrevious()).isNull();
        assertThat(node2.getPrevious()).isEqualTo(node1);
        assertThat(node2.getNext()).isNull();

        doubleEndedQueueList.deleteLast();
        assertThat(node1.getNext()).isNull();
        assertThat(node1.getPrevious()).isNull();

        doubleEndedQueueList.deleteLast();
    }
    @Test
    public void shouldSubtractThreeToSizeWhenDeletingLastThreeNodes(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        DequeNode node3 = new DequeNode(3,null,null);
        doubleEndedQueueList.append(node1);
        doubleEndedQueueList.append(node2);
        doubleEndedQueueList.append(node3);
        int initialSize = doubleEndedQueueList.size();

        doubleEndedQueueList.deleteLast();
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize-1);

        doubleEndedQueueList.deleteLast();
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize-2);

        doubleEndedQueueList.deleteLast();
        assertThat(doubleEndedQueueList.size()).isEqualTo(0);
    }

    
    //Test de que DeleteFirst actualiza las referencias y el size
    @Test
    public void shouldUpdateReferencesWhenDeletingFirstThreeNodes(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        DequeNode node3 = new DequeNode(3,null,null);
        doubleEndedQueueList.append(node1);
        doubleEndedQueueList.append(node2);
        doubleEndedQueueList.append(node3);

        doubleEndedQueueList.deleteFirst();

        assertThat(node2.getNext()).isEqualTo(node3);
        assertThat(node2.getPrevious()).isNull();
        assertThat(node3.getPrevious()).isEqualTo(node2);
        assertThat(node3.getNext()).isNull();

        doubleEndedQueueList.deleteFirst();
        assertThat(node3.getNext()).isNull();
        assertThat(node3.getPrevious()).isNull();

        doubleEndedQueueList.deleteFirst();
    }
    @Test
    public void shouldSubtractThreeToSizeWhenDeletingFirstThreeNodes(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null,null);
        DequeNode node3 = new DequeNode(3,null,null);
        doubleEndedQueueList.append(node1);
        doubleEndedQueueList.append(node2);
        doubleEndedQueueList.append(node3);
        int initialSize = doubleEndedQueueList.size();

        doubleEndedQueueList.deleteFirst();
        assertThat(doubleEndedQueueList.size()).isEqualTo(initialSize-1);

        doubleEndedQueueList.deleteFirst();
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
    public void shouldSubtractOneToListSizeWhenDeletingANode(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null, null);
        DequeNode node3 = new DequeNode(3,null, null);

        doubleEndedQueueList.append(node1);
        doubleEndedQueueList.append(node2);
        doubleEndedQueueList.append(node3);

        int actualValue, expectedValue;
        expectedValue = doubleEndedQueueList.size()-1;
        doubleEndedQueueList.delete(node2);
        actualValue = doubleEndedQueueList.size();

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @Test
    public void shouldUpdateReferencesWhenDeletingANode(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null, null);
        DequeNode node3 = new DequeNode(3,null, null);

        doubleEndedQueueList.append(node1);
        doubleEndedQueueList.append(node2);
        doubleEndedQueueList.append(node3);

        DequeNode actualValue, expectedValue;
        doubleEndedQueueList.delete(node2);

        expectedValue = node3;
        actualValue = node1.getNext();
        assertThat(actualValue).isEqualTo(expectedValue);

        expectedValue = node1;
        actualValue = node3.getPrevious();
        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @Test
    public void shouldListSubtractANodeWhenDeletingANode(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null, null);
        DequeNode node3 = new DequeNode(3,null, null);

        DoubleEndedQueue actualList = new DoubleEndedQueueList();

        actualList.append(node1);
        actualList.append(node2);
        actualList.append(node3);

        actualList.delete(node2);

        DoubleEndedQueueList expectedList = new DoubleEndedQueueList<>();
        expectedList.append(node1);
        expectedList.append(node3);

        int listSize;
        if (expectedList.size()> actualList.size())
            listSize = expectedList.size();
        else
            listSize = actualList.size();

        DequeNode expectedNode = expectedList.peekFirst();
        DequeNode actualNode = actualList.peekFirst();
        assertThat(actualNode).isEqualTo(expectedNode);

        for (int actualIndex = 1; actualIndex < listSize; actualIndex++){
            expectedNode = expectedNode.getNext();
            actualNode = actualNode.getNext();
            assertThat(actualNode).isEqualTo(expectedNode);
        }
    }
    @Test
    public void shouldListSubtractFirstNodeWhenDeletingFirstNode(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null, null);
        DequeNode node3 = new DequeNode(3,null, null);

        DoubleEndedQueue actualList = new DoubleEndedQueueList();

        actualList.append(node1);
        actualList.append(node2);
        actualList.append(node3);

        actualList.delete(node1);

        DoubleEndedQueueList expectedList = new DoubleEndedQueueList<>();
        expectedList.append(node2);
        expectedList.append(node3);

        int listSize;
        if (expectedList.size()> actualList.size())
            listSize = expectedList.size();
        else
            listSize = actualList.size();

        DequeNode expectedNode = expectedList.peekFirst();
        DequeNode actualNode = actualList.peekFirst();
        assertThat(actualNode).isEqualTo(expectedNode);

        for (int actualIndex = 1; actualIndex < listSize; actualIndex++){
            expectedNode = expectedNode.getNext();
            actualNode = actualNode.getNext();
            assertThat(actualNode).isEqualTo(expectedNode);
        }
    }

    @Test
    public void shouldListSubtractLastNodeWhenDeletingLastNode(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null, null);
        DequeNode node3 = new DequeNode(3,null, null);

        DoubleEndedQueue actualList = new DoubleEndedQueueList();

        actualList.append(node1);
        actualList.append(node2);
        actualList.append(node3);

        actualList.delete(node3);

        DoubleEndedQueueList expectedList = new DoubleEndedQueueList<>();
        expectedList.append(node1);
        expectedList.append(node2);

        int listSize;
        if (expectedList.size()> actualList.size())
            listSize = expectedList.size();
        else
            listSize = actualList.size();

        DequeNode expectedNode = expectedList.peekFirst();
        DequeNode actualNode = actualList.peekFirst();
        assertThat(actualNode).isEqualTo(expectedNode);

        for (int actualIndex = 1; actualIndex < listSize; actualIndex++){
            expectedNode = expectedNode.getNext();
            actualNode = actualNode.getNext();
            assertThat(actualNode).isEqualTo(expectedNode);
        }
    }
    @Test
    public void shouldFindANodeThatThereIsInList(){
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null, null);
        DequeNode node3 = new DequeNode(3,null, null);

        DoubleEndedQueue actualList = new DoubleEndedQueueList();

        actualList.append(node1);
        actualList.append(node2);
        actualList.append(node3);
        DequeNode aux = actualList.getAt(0);

        assertThat(actualList.find(aux.getItem())).isNotNull();
    }

    @Test
    public void shouldDeleteTheFirstNode(){
        DoubleEndedQueueList<Integer> list = new DoubleEndedQueueList<>();
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null, null);
        DequeNode node3 = new DequeNode(3,null, null);
        DequeNode node4 = new DequeNode(4,null, null);

        list.append(node1);
        list.append(node2);
        list.append(node3);
        list.append(node4);

        DoubleEndedQueueList<Integer> expectedValue = new DoubleEndedQueueList<>();
        expectedValue.append(node2);
        expectedValue.append(node3);
        expectedValue.append(node4);

        list.delete(node1);

        assertEquals(expectedValue,list);
    }

    @Test
    public void shouldDeleteTheLastNode(){
        DoubleEndedQueueList<Integer> list = new DoubleEndedQueueList<>();
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null, null);
        DequeNode node3 = new DequeNode(3,null, null);
        DequeNode node4 = new DequeNode(4,null, null);

        list.append(node1);
        list.append(node2);
        list.append(node3);
        list.append(node4);

        DoubleEndedQueueList<Integer> expectedValue = new DoubleEndedQueueList<>();
        expectedValue.append(node1);
        expectedValue.append(node2);
        expectedValue.append(node3);

        list.delete(node4);

        assertEquals(expectedValue,list);
    }

    @Test
    public void shouldDeleteAnIntermediateNode(){
        DoubleEndedQueueList<Integer> list = new DoubleEndedQueueList<>();
        DequeNode node1 = new DequeNode(1,null,null);
        DequeNode node2 = new DequeNode(2,null, null);
        DequeNode node3 = new DequeNode(3,null, null);
        DequeNode node4 = new DequeNode(4,null, null);

        list.append(node1);
        list.append(node2);
        list.append(node3);
        list.append(node4);

        DoubleEndedQueueList<Integer> expectedValue = new DoubleEndedQueueList<>();
        expectedValue.append(node1);
        expectedValue.append(node2);
        expectedValue.append(node4);

        list.delete(node3);

        assertEquals(expectedValue,list);
    }





}