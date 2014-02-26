import java.util.ArrayList;
import java.util.List;

import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.problem.puzzle.EightPuzzleSuccessorFunction;
import rp13.search.util.ActionStatePair;
import rp13.search.util.EqualityGoalTest;

public class UninformedTest {

	private static EightPuzzle state;
	private static EightPuzzleSuccessorFunction sf;
	private static List<ActionStatePair<PuzzleMove,EightPuzzle>> successors;
	private static Queue<ActionStatePair<PuzzleMove,EightPuzzle>> agenda;
	private static EqualityGoalTest<EightPuzzle> goalTest;
	private static ActionStatePair<PuzzleMove,EightPuzzle> node;
	
	public static void run()
	{
		UninformedSearch();
	}
	
	private static ActionStatePair<PuzzleMove,EightPuzzle> UninformedSearch() {
		// TODO Auto-generated method stub
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
				sf.getSuccessors(state, successors);
				for(ActionStatePair<PuzzleMove, EightPuzzle> node : successors)
				{
					//System.out.println(state);
					agenda.push(node);
				}
			}
		}
		return node;	
	}		

	/**		
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		state = EightPuzzle.randomEightPuzzle();
		sf = new EightPuzzleSuccessorFunction();
		successors = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
		agenda = new Queue<ActionStatePair<PuzzleMove, EightPuzzle>>();
		goalTest = new EqualityGoalTest<EightPuzzle>(EightPuzzle.orderedEightPuzzle());
		agenda.push(new ActionStatePair<PuzzleMove, EightPuzzle>(null, state));
		//node = new ActionStatePair<PuzzleMove, EightPuzzle>(_action, _state);
		
			/*EightPuzzle state = EightPuzzle.orderedEightPuzzle();
			EightPuzzleSuccessorFunction sf = new EightPuzzleSuccessorFunction();
			System.out.println(state);
			
			
			
			List<ActionStatePair<PuzzleMove,EightPuzzle>> successors = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
			sf.getSuccessors(state, successors);
			
			UninformedSearch search = new UninformedSearch(,state);
			
			for (ActionStatePair<PuzzleMove, EightPuzzle> actionStatePair : successors) {
				System.out.println("Applied move " + actionStatePair.getAction() + " and got:");
				System.out.println(actionStatePair.getState());
				
				state = actionStatePair.getState();
				//sf.getSuccessors(state, successors);
				}*/
			run();
			
	}
	

}
