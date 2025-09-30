import java.util.Iterator;

public class GLLIterator<E> implements Iterator<E>{
	private GenericList.Node<E> current;
	
	public GLLIterator(GenericList.Node<E> head) {
		this.current = head;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public E next() {
		if (current == null) {
			return null;
		}
		E value = current.getData();
		current = current.getNext();
		return value;
	}
}
