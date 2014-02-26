import java.util.ArrayList;
import java.util.Iterator;

import rp13.search.interfaces.Agenda;



public class Stack<T> implements Agenda<T> {
	
	private ArrayList<T> frontier;
	
	public Stack()
	{
		frontier = new ArrayList<T>();
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return frontier.iterator();
	}

	@Override
	public void push(T _item) {
		// TODO Auto-generated method stub
		frontier.add(_item);
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		T temp = frontier.get(frontier.size() - 1);
		frontier.remove(frontier.size() - 1);
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return frontier.isEmpty();
		
	}

	@Override
	public boolean contains(T _item) {
		// TODO Auto-generated method stub
		boolean returnValue = false;
		for (int i = 0; i < frontier.size(); i++) {
			if(frontier.get(i).equals(_item))
			{
				returnValue = true;
			}
		}
		return returnValue;
	}

	
	
}
