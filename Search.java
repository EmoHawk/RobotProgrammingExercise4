import rp13.search.interfaces.Agenda;
import rp13.search.interfaces.SortedAgenda;
import rp13.search.util.ActionStatePair;
import rp13.search.util.EqualityGoalTest;
import rp13.search.problem.puzzle.EightPuzzle;

public class Search<ActionStatePair> {
	
	private Agenda<ActionStatePair> agenda;
	private ActionStatePair startNode;
	private ActionStatePair<Integer, EightPuzzle> node;
	private EqualityGoalTest goalTest;
	
	public Search(int agendaType, ActionStatePair startNode, EqualityGoalTest goalTest)
	{
		if(agendaType == 1)
		{
			agenda = new Queue<ActionStatePair>();
		}
		else if(agendaType == 2)
		{
			agenda = new AStarStack<ActionStatePair>();
		}
		else
		{
			agenda = new Stack<ActionStatePair>();
		}
		this.startNode = startNode;
		this.goalTest = goalTest;
	}
	
	public ActionStatePair SearchForMove()
	{
		agenda.push(startNode);
		while(!agenda.isEmpty())
		{
			node = agenda.pop();
			if(goalTest.isGoal(node.getState()))
			{
				return node;
			}
			else
			{
				//generate successors
				// ...
				for(SearchNode node : successors)
				{
					agenda.push(node);
				}
			}
		}	
	}
}
