import java.util.ArrayList;

import rp13.search.util.ActionStatePair;

public class SearchNode {
	
	private SearchNode nextMove;
	private ActionStatePair thisState;
	
	public SearchNode(ActionStatePair pair, SearchNode node)
	{
		this.thisState = pair;
		this.nextMove = node;
	}

	public SearchNode getNextMove() {
		return nextMove;
	}

	public ActionStatePair getThisState() {
		return thisState;
	}

	public ArrayList<ActionStatePair> getPath(SearchNode node)
	{
		ArrayList<ActionStatePair> path = new ArrayList<ActionStatePair>();
		//for all nodes
		//add thisState to array
		if(nextMove != null)
		{
			path.add(node.getThisState());
			path.addAll(getPath(this.getNextMove()));
		}
		
		return path;
	}
}
