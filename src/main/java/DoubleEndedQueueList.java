import java.util.Comparator;
import java.util.Objects;

public class DoubleEndedQueueList<T> implements DoubleEndedQueue<T> {


    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoubleEndedQueueList() {
        first = null;
        last = null;
        size = 0;
    }

    public DoubleEndedQueueList(DoubleEndedQueueList lista) {
        first = null;
        last = null;
        size = 0;

        while (size <= lista.size()) {
            this.append(new DequeNode(lista.getAt(size).getItem(), null, null));
        }
    }


    @Override
    public void append(DequeNode node) {
        if (first == null) {
            first = node;
            last = node;
            node.setPrevious(null);

        } else {
            node.setPrevious(last);
            last.setNext(node);
            last = node;
        }

        node.setNext(null);
        size++;
    }

    @Override
    public void appendLeft(DequeNode node) {
        if (first == null) {
            first = node;
            last = node;

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
        if (first != null) {
            if (first.getNext() == null) {
                //Si solo hay 1 elemento
                first = null;
                last = null;
            } else {
                first = first.getNext();
                first.setPrevious(null);
            }
            size--;
        } else {
            throw new RuntimeException("The list is empty");
        }
    }

    @Override
    public void deleteLast() {
        if (first != null) {
            if (first.getNext() == null) {
                //Si solo hay 1 elemento
                first = null;
                last = null;
            } else {
                last = last.getPrevious();
                last.setNext(null);
            }
            size--;
        } else {
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
        if (position < 0) {
            throw new RuntimeException("The position is negative");
        }
        DequeNode res = first;
        int cont = 0;
        while (cont<position) {
            res = res.getNext();
            cont++;
        }
        return res;
    }

    @Override
    public DequeNode<T> find(T item) {
        DequeNode temp = first;
        DequeNode result = null;

        while (temp != null) {
            if (item.equals(temp.getItem())) {
                result = temp;
            }
            temp = temp.getNext();
        }
        return result;
    }

    @Override
    public void delete(DequeNode<T> node) {
        if (node == null) {
            throw new RuntimeException("Node not valid");
        } else if (findNode(node) == null) {
            throw new RuntimeException("Node not in list");
        } else {
            if (first.equals(node)) {
                deleteFirst();
            } else if (last.equals(node)) {
                deleteLast();
            } else {
                node.getPrevious().setNext(node.getNext());
                node.getNext().setPrevious(node.getPrevious());
                size--;
            }
        }
    }

    private DequeNode<T> findNode(DequeNode<T> node) {
        DequeNode actualNode = first;

        while (actualNode != null && !actualNode.equals(node)) {
            actualNode = actualNode.getNext();
        }

        return actualNode;
    }

    @Override
    public void sort(Comparator<T> comparator) {
        if (first != null) {
            for (int i = this.size() -1; i> 0; i--) {
                for (int j = 0; j < i; j++) {
                    int k = j + 1;
                    if (comparator.compare(this.getAt(j).getItem(), this.getAt(k).getItem()) > 0) {
                        cambiarNodos(this.getAt(j), this.getAt(k));
                    }
                }
            }
        }
    }


    private void cambiarNodos(DequeNode<T> previous, DequeNode<T> next) {
        if (previous.isFirstNode()){
            first = next;
        } else {
            previous.getPrevious().setNext(next);
        }

        if (next.isLastNode()){
            last = previous;
        } else {
            next.getNext().setPrevious(previous);
        }

        next.setPrevious(previous.getPrevious());
        previous.setNext(next.getNext());

        next.setNext(previous);
        previous.setPrevious(next);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleEndedQueueList<?> that = (DoubleEndedQueueList<?>) o;
        DequeNode node1 = first;
        DequeNode node2 = that.first;
        return size == that.size && Objects.equals(first, that.first) && Objects.equals(last, that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, size);
    }

}
