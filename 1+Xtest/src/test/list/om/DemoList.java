package test.list.om;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

@SuppressWarnings("rawtypes")
public class DemoList<S> implements Queue<Comparable<DemoList>> {
	S ss;
	
	public <T extends Comparable<?>> T toMap(T t, S s) {
//		Ass = new S();	//new 只能实例化已存在的类
		ss = s;
		return t;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		new DemoList<Integer>();
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Comparable<DemoList>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Comparable<DemoList>> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(Comparable<DemoList> e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(Comparable<DemoList> e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comparable<DemoList> remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparable<DemoList> poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparable<DemoList> element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparable<DemoList> peek() {
		// TODO Auto-generated method stub
		return null;
	}

}
