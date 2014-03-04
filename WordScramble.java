import java.util.Random;


public class WordScramble {

	private String word;
	private String goalWord;
	
	public WordScramble(String word)
	{
		this.word = word;
		goalWord = word;
	}
	
	public String getWord()
	{
		return word;
	}
	
	public String swap(int charOne, int charTwo)
	{
		if(isValidMove(charOne, charTwo))
		{
			StringBuffer temp = new StringBuffer(word);
			temp.setCharAt(charOne, word.charAt(charTwo));
			temp.setCharAt(charTwo, word.charAt(charOne));
			word = temp.toString();
			
		}
		return word;
	}
	
	public boolean isValidMove(int move1, int move2)
	{
		return move1 > 0 && move1 < word.length() && move2 > 0 && move2 < word.length() ;
	}
	
	public String toString()
	{
		return word;
	}
	
	public int getHammingDistance(String compareWord)
	{
		int returnValue= 0;
		for(int i = 0; i < word.length(); i++)
		{
			if(word.charAt(i) != compareWord.charAt(i))
			{
				returnValue++;
			}
		}
		return returnValue;
	}
	
	public int getNoTurns()
	{
		
		int turns = 0;
		
		for(int i = 0; i < word.length(); i++)
		{
			for(int j = 0; j < word.length(); j++)
			{
				if(word.charAt(i) == goalWord.charAt(j))
				{
					if(i > j)
					{
						turns += i - j;
					}
					else
					{
						turns += j - i;
					}
				}
					
			}
			
		}
		
		return turns;
		
	}
	
	
	public static WordScramble scramble(String word, int moves)
	{
		WordScramble scramble = new WordScramble(word);
		Random gen = new Random();
		
		for(int i = 0; i <= moves; i++)
		{
			scramble.swap( gen.nextInt(word.length()), gen.nextInt(word.length()) );
		}
		return scramble;
	}
	
	
}
