import java.util.List;
import rp13.search.interfaces.SuccessorFunction;
import rp13.search.util.ActionStatePair;

public class WordScrambleSuccessor implements SuccessorFunction<Switch, WordScramble> 
{
	
@Override
public void getSuccessors(WordScramble _state, List<ActionStatePair<Switch, WordScramble>> _successors) 
{
	for (int i = 0; i < _state.getWord().length(); i++) 
	{
		for(int j = i + 1; j < _state.getWord().length(); j++)
		{
			
			if (_state.isValidMove(i, j)) 
			{

				// create a copy of the input state as we don't want to change
				// it
				WordScramble successor = new WordScramble(_state.toString());
				// apply the move
				successor.swap(i, j);
				// store the move and action together in a pair and add to
				// successor list
				Switch switched = new Switch(i, j);
				_successors.add(new ActionStatePair<Switch, WordScramble>(switched, successor));
			}
			
		}
	}
	
}

}
