import java.util.Comparator;
public class DoubleEndedQueueList<T> implements DoubleEndedQueue<T>{


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
        if (position >= size)
            throw new RuntimeException("The position is out of bounds");
        if (position < 0){
            throw new RuntimeException("The position is negative");
        }
        DequeNode res = first;
        for (int actualIndex = 0; actualIndex < position; actualIndex++){
            res = first.getNext();
        }
        return res;
    }

    @Override
    public DequeNode<T> find(T item) {
        DequeNode temp = first;
        DequeNode result = null;

        while (temp != null){
            if (item.equals(temp)){
                result = temp;
            }
            temp = temp.getNext();
        }
        return result;
    }

    @Override
    public void delete(DequeNode<T> node) {
        if(node == null) {
            throw new RuntimeException("Node not valid");
        }else if(this.findNode(node) == null){
            throw new RuntimeException("Node not in list");
        }else{
            if(first.equals(node)){
                deleteFirst();
            }else if(last.equals(node)){
                deleteLast();
            }else{
                node.getPrevious().setNext(node.getNext());
                node.getNext().setPrevious(node.getPrevious());
                node = null;
            }
        }
    }

    private DequeNode<T> findNode (DequeNode<T> node){
        DequeNode prev = first;
        DequeNode current = null;

        if (first!=null){
            current = this.first.getNext();
        }

        while(current != null && !current.equals(node)){
            prev = current;
            current = current.getNext();
        }

        return current;
    }

    @Override
    public void sort(Comparator<DequeNode<T>> comparator) {
        DequeNode<T> previus = first;
        DequeNode<T> next = null;
        boolean sorted = false;

        if (first != null){
            next = previus.getNext();
        }
        while (!sorted){
            while (next!=null){
                if (comparator.compare(previus,next) > 0){
                    previus.getPrevious().setNext(next);
                    next.getNext().setPrevious(previus);

                    next.setPrevious(previus.getPrevious());
                    previus.setNext(next.getNext());

                    next.setNext(previus);
                    previus.setPrevious(next);

                    sorted = false;
                }
                previus = next;
                next = next.getNext();
            }
        }

    }
}
