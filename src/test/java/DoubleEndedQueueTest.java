import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    
}