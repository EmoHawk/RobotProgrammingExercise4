import java.util.ArrayList;
import java.util.List;

import rp13.search.interfaces.SuccessorFunction;
import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.problem.puzzle.EightPuzzleSuccessorFunction;
import rp13.search.util.ActionStatePair;
import rp13.search.util.EqualityGoalTest;

public class BFSearch<ActionT, StateT> {

	//EightPuzzle Variables
	private StateT state;
	private SuccessorFunction sf;
	private List<ActionStatePair<ActionT,StateT>> successors;
	private List<ActionStatePair<ActionT,StateT>> doneBefore;
	private Queue<ActionStatePair<ActionT, StateT>> agenda;
	
	private EqualityGoalTest<StateT> goalTest;
	private ActionStatePair<ActionT,StateT> node;
	protected boolean donePrev = false;
	
	/*public static void run()
	{
		//ActionStatePair<PuzzleMove, EightPuzzle> goal = UninformedSearch();
		ActionStatePair<ActionT, StateT> goal = InformedSearch();
		System.out.println(goal.toString());
	}*/
	
	/*private ActionStatePair<ActionT, StateT> InformedSearch() {
		// TODO Auto-generated method stub
		
		while(!agenda.isEmpty()) {
			node = agenda.pop();
			System.out.println(node.getState().toString());
			doneBefore.add(node);
			if(goalTest.isGoal(node.getState())) {
				System.out.println("GOAL");
				return node;
			}
			else {
				//generate successors
				// ...
				sf.getSuccessors(node.getState(), successors);
				for (ActionStatePair<ActionT, StateT> successor : successors) {
					boolean foundBefore = false;
					for (ActionStatePair<ActionT, StateT> item : doneBefore) {
						String check = item.getState().toString();
						String check2 = successor.getState().toString();
						if(check.equals(check2))
						{
							foundBefore = true;
						}
						
					}
					if(!foundBefore)
					{
						agenda.push(successor);
						
					}
				}
				successors.clear();
				sortAgenda();
			}
		}
		return node;
	}	
	
	private static void sortAgenda()
	{
		ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>> tempArray = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
		
		while(!agenda.isEmpty())
		{
			tempArray.add(agenda.pop());
		}
		//System.out.println("Array: " + tempArray.toString());
		
		int n = tempArray.size();
		int newn = 0;
		do
		{
			newn = 0;
			for(int i = 1; i < n - 1; i++)
			{
				int compare1 = tempArray.get(i - 1).getState().getNoTurns() + tempArray.get(i - 1).getState().getHammingDistance();
				int compare2 = tempArray.get(i).getState().getNoTurns() + tempArray.get(i).getState().getHammingDistance();
				if(compare1 > compare2)
				{
					ActionStatePair<PuzzleMove, EightPuzzle> tempItem = new ActionStatePair<PuzzleMove, EightPuzzle>(tempArray.get(i).getAction(), tempArray.get(i).getState());
					tempArray.set(i, tempArray.get(i - 1));
					tempArray.set(i - 1, tempItem);
					newn = i;
				}
			}
			n = newn;
		} while (n != 0);
		
		for (ActionStatePair<PuzzleMove, EightPuzzle> actionStatePair : tempArray) {
			agenda.push(actionStatePair);
		}
		
	}*/
	
	public BFSearch(StateT stateT, SuccessorFunction sfT) {
		// TODO Auto-generated method stub
		state = stateT;
		sf = sfT;
		
		successors = new ArrayList<ActionStatePair<ActionT, StateT>>();
		doneBefore = new ArrayList<ActionStatePair<ActionT, StateT>>();
		agenda = new Queue<ActionStatePair<ActionT, StateT>>();		
	}		
	
	public ActionStatePair<ActionT, StateT> run()
	{
		while(!agenda.isEmpty()) {
			node = agenda.pop();
			System.out.println(node.getState().toString());
			doneBefore.add(node);
			if(goalTest.isGoal(node.getState())) {
				System.out.println("GOAL");
				return node;
			}
			else {
				//generate successors
				// ...
				sf.getSuccessors(node.getState(), successors);
				for (ActionStatePair<ActionT,StateT> successor : successors) {
					boolean foundBefore = false;
					for (ActionStatePair<ActionT,StateT> item : doneBefore) {
						String check = item.getState().toString();
						String check2 = successor.getState().toString();
						if(check.equals(check2))
						{
							foundBefore = true;
						}
						
					}
					if(!foundBefore)
					{
						agenda.push(successor);
					}
				}
				successors.clear();
			}
		}
		return node;
	}

	/**		
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* For EightPuzzle
		state = EightPuzzle.randomEightPuzzle();
		sf = new EightPuzzleSuccessorFunction();
		successors = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
		doneBefore = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
		agenda = new Stack<ActionStatePair<PuzzleMove, EightPuzzle>>();
		goalTest = new EqualityGoalTest<EightPuzzle>(EightPuzzle.orderedEightPuzzle());
		agenda.push(new ActionStatePair<PuzzleMove, EightPuzzle>(null, state));
		
		
		wordState = WordScramble.scramble("hello", 5);
		wordSF = new WordScrambleSuccessor();
		wordSuccessors = new ArrayList<ActionStatePair<Switch, WordScramble>>();
		wordDoneBefore = new ArrayList<ActionStatePair<Switch, WordScramble>>();
		wordAgenda = new Stack<ActionStatePair<PuzzleMove, EightPuzzle>>();
		goalTest = new EqualityGoalTest<EightPuzzle>(EightPuzzle.orderedEightPuzzle());
		agenda.push(new ActionStatePair<PuzzleMove, EightPuzzle>(null, state));

			run();
			
	}*/
	

}
