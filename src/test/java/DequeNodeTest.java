import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest {

    private DequeNode dequeNode;

    @Test
    public void shouldComputeRaisAnExceptionIfTheItemIsNull(){
        assertThrows(RuntimeException.class, () -> new DequeNode<>(null, null, null) );
    }

}