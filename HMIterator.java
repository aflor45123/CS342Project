import java.util.Iterator;
import java.util.ArrayList;

public class HMIterator<T> implements Iterator<T> {
	private final ArrayList<GenericQueue<T>> map;
	private int queueIndex = 0;
	private GenericList.Node<T> currentNode = null;
	
	public HMIterator(ArrayList<GenericQueue<T>> map) {
		this.map = map;
		advanceToNextMap();
	}
	private void advanceToNextMap() {
		while ((currentNode == null) && queueIndex < map.size()) {
			GenericQueue<T> queue = map.get(queueIndex++);
			if (queue ==null) {
				currentNode = queue.getHead();
			}else {
				currentNode = queue.getHead();
			}
		}
	}
	
	@Override
	public boolean hasNext() {
		if (currentNode != null) {
			return true;
		}
		advanceToNextMap();
		return currentNode != null;
	}

	@Override
	public T next() {
		if(!hasNext()) {
			return null;
		}
		T value = currentNode.getData();
		currentNode = currentNode.getNext();
		if (currentNode == null) {
			advanceToNextMap();
		}
		return value;
	}
	
}
