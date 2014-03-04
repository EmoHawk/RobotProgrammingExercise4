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
	private static List<ActionStatePair<PuzzleMove,EightPuzzle>> doneBefore;
	private static Queue<ActionStatePair<PuzzleMove, EightPuzzle>> agenda;
	private static EqualityGoalTest<EightPuzzle> goalTest;
	private static ActionStatePair<PuzzleMove,EightPuzzle> node;
	protected static boolean donePrev = false;
	
	public static void run()
	{
		ActionStatePair<PuzzleMove, EightPuzzle> goal = UninformedSearch();
		System.out.println(goal.toString());
	}
	
	private static ActionStatePair<PuzzleMove,EightPuzzle> UninformedSearch() {
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
				for (ActionStatePair<PuzzleMove, EightPuzzle> successor : successors) {
					boolean foundBefore = false;
					for (ActionStatePair<PuzzleMove, EightPuzzle> item : doneBefore) {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		state = EightPuzzle.randomEightPuzzle(8);
		sf = new EightPuzzleSuccessorFunction();
		successors = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
		doneBefore = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
		agenda = new Queue<ActionStatePair<PuzzleMove, EightPuzzle>>();
		goalTest = new EqualityGoalTest<EightPuzzle>(EightPuzzle.orderedEightPuzzle());
		agenda.push(new ActionStatePair<PuzzleMove, EightPuzzle>(null, state));

			run();
			
	}
	

}
