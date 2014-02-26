import java.util.ArrayList;
import java.util.Iterator;

import rp13.search.interfaces.Agenda;
import rp13.search.interfaces.SortedAgenda;


public class AStarStack<T extends Comparable<T>> implements SortedAgenda<T> {
	
	private ArrayList<T> frontier;
	
	public AStarStack()
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
		T temp = frontier.get(0);
		frontier.remove(0);
		for (int i = 1; i < frontier.size(); i++) {
			frontier.add(i - 1, frontier.get(i));
			frontier.remove(i);
		}
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

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	
	
}
