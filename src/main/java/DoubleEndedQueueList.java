import java.util.Comparator;

public class DoubleEndedQueueList<T> implements DoubleEndedQueue{

    private DequeNode<T> first;
    private DequeNode<T> last;
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
                first.setPrevious(null);
            }
            size--;
        }else {
            throw new RuntimeException("The list is empty");
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
                last.setNext(null);
            }
            size--;
        }else{
            throw new RuntimeException("The list is empty");
        }
    }

    @Override
    public DequeNode<T> peekFirst() {
        return first;
    }

    @Override
    public DequeNode<T> peekLast() {
        return last;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public DequeNode<T> getAt(int position) {
        return null;
    }

    @Override
    public DequeNode<T> find(Object item) {
        int cont = 0;
        DequeNode temp = first;
        DequeNode result = null;

        while (temp != null && cont < size){
            if (item.equals(temp)){
                result = temp;
            }
            temp = temp.getNext();
        }
        return result;
    }

    @Override
    public void delete(DequeNode node) {

    }

    @Override
    public void sort(Comparator comparator) {

    }
}
