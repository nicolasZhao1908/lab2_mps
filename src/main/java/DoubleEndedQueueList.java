public class DoubleEndedQueueList implements DoubleEndedQueue{

    private DequeNode first;
    private DequeNode last;
    int size;

    public DoubleEndedQueueList (){
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void append(DequeNode node) {
        if (first == null){
            first = node;
            last = node;
            node.setPrevious(null);

        } else {
            last.setNext(node);
            node.setPrevious(last);
            last = node;
        }

        node.setNext(null);
        size ++;
    }

    @Override
    public void appendLeft(DequeNode node) {
        if (first == null){
            first = node;
            last = node;
            node.setPrevious(null);

        } else {
            first.setPrevious(node);
            node.setNext(first);
            first = node;
        }
        node.setPrevious(null);
        size++;
    }

    @Override
    public void deleteFirst() {
        if (first!=null){
            if (first.getNext() == null) {
                //Si solo hay 1 elemento
                first = null;
                last = null;
            } else {
                first = first.getNext();
            }
            size--;
        }
    }

    @Override
    public void deleteLast() {
        if (first!=null){
            if (first.getNext() == null) {
                //Si solo hay 1 elemento
                first = null;
                last = null;
            } else {
                last = last.getPrevious();
            }
            size--;
        }
    }

    @Override
    public DequeNode peekFirst() {
        return first;
    }

    @Override
    public DequeNode peekLast() {
        return last;
    }

    @Override
    public int size() {
        return size;
    }
}
