import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class DequeNodeTest<T> {

    private DequeNode dequeNode;

    @Test
    public void shouldConstructorHaveItemNotNullRaisAnExceptionIfTheItemIsNull(){
        assertThat(new DequeNode<>(null, null, null).getItem() != null );
    }

    @Test
    public void shouldConstructorHaveDifferentPrevAndPostIfSizeBiggerThanOne(){
        dequeNode = new DequeNode<Integer>(3, null,new DequeNode<>(3,dequeNode,null));
        assertThat(dequeNode.isFirstNode());
        assertThat(!dequeNode.getNext().equals(dequeNode.getPrevious()));
    }

}