import java.util.ArrayList;
import java.util.Iterator;

public class ReverseGLLIterator<E> implements Iterator<E> {
	private final ArrayList<E> revCurrent;
	private int index;
	
	public ReverseGLLIterator(GenericList.Node<E> head) {
		this.revCurrent = new ArrayList<>();
		GenericList.Node<E> cur = head;
		while(cur != null) {
			revCurrent.add(cur.getData());
			cur = cur.getNext();
		}
		this.index = revCurrent.size() - 1;
	}
	public boolean hasNext() {
		return index >= 0;
	}
	
	public E next() {
		if (index < 0) {
			return null;
		}
		return revCurrent.get(index--);
	}
}
