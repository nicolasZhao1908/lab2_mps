import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        DequeNode node = new DequeNode(item,null,null);
        doubleEndedQueueList.append(node);
        assertThat(doubleEndedQueueList.peekLast()).isNotNull();
        doubleEndedQueueList.append(node);
        assertThat(doubleEndedQueueList.peekLast()).isNotNull();

        doubleEndedQueueList.appendLeft(node);
        assertThat(doubleEndedQueueList.peekFirst()).isNotNull();
    }
    @Test
    public void shouldHaveAddedOneToSizeIfAppendedANode(){
        Integer item = 1;
        DequeNode node = new DequeNode(item,null,null);
        int expectedValue, actualValue;
        expectedValue = doubleEndedQueueList.size()+1;
        doubleEndedQueueList.append(node);
        actualValue = doubleEndedQueueList.size();
        assertThat(actualValue == expectedValue).isTrue();
        expectedValue = doubleEndedQueueList.size()+1;
        doubleEndedQueueList.appendLeft(node);
        actualValue = doubleEndedQueueList.size();
        assertThat(actualValue == expectedValue).isTrue();
    }
    @Test
    public void shoulHaveReducedOneToSizeIfDeletedANode(){
        Integer item = 1;
        DequeNode node = new DequeNode(item,null,null);

        doubleEndedQueueList.appendLeft(node);
        int expectedValue, actualValue;
        expectedValue = doubleEndedQueueList.size()-1;
        doubleEndedQueueList.deleteFirst();
        actualValue = doubleEndedQueueList.size();
        assertThat(actualValue == expectedValue).isTrue();

        doubleEndedQueueList.appendLeft(node);
        expectedValue = doubleEndedQueueList.size()-1;
        doubleEndedQueueList.deleteLast();
        actualValue = doubleEndedQueueList.size();
        assertThat(actualValue == expectedValue).isTrue();

        doubleEndedQueueList.appendLeft(node);
        doubleEndedQueueList.appendLeft(node);
        expectedValue = doubleEndedQueueList.size()-1;
        doubleEndedQueueList.deleteFirst();
        actualValue = doubleEndedQueueList.size();
        assertThat(actualValue == expectedValue).isTrue();

        doubleEndedQueueList.appendLeft(node);
        expectedValue = doubleEndedQueueList.size()-1;
        doubleEndedQueueList.deleteLast();
        actualValue = doubleEndedQueueList.size();
        assertThat(actualValue == expectedValue).isTrue();
    }
    @Test
    public void shouldHaveRaisedAnExceptionIfDeleteANodeFromEmptyList(){
        assertThrows(RuntimeException.class,() -> doubleEndedQueueList.deleteFirst());
        assertThrows(RuntimeException.class,() -> doubleEndedQueueList.deleteLast());
    }

}