import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Game 
{
	String words[] = {"anil","arya","hema","sravani","ram","deepa","vidya","murali","abhi","dinesh"};
	static final Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	public void starGame() 
	{
		int score = 0;
		for(int i=0;i<words.length;i++) 
		{
			String showWord = "";
			int len = words[i].length(),loop = len/2;
			Set<Integer> set = new  TreeSet<>();
			while(loop-->0) {
				int n = random.nextInt(len);
				if(n<0) n*=-1;
				set.add(n);
			}
			Object[] star1 = set.toArray();
			int star_ind = 0;
			
			for(int j=0;j<words[i].length();j++) 
			{
				if(star_ind < star1.length) {
					Object ob = j;
					if(ob == star1[star_ind]) {
						showWord += "*";
						star_ind++;
						continue;
					}
				}
				showWord += words[i].charAt(j);
			}
			System.out.println(showWord+"\nguess..");
			String guess = scanner.next().toLowerCase();
			if(guess.equals(words[i])) score++;
		}
		System.out.println("your score is : "+score);
	}
	
	private String jumbleWord(String str) {
		Set<Integer> set = new LinkedHashSet<>();
		while(set.size()<str.length()) {
			int n = random.nextInt(str.length());
			if(n<0) n*=-1;
			set.add(n);
		}
		String res = "";
		for(int i: set) {
			res += str.charAt(i);
		}
		return res;
	}
	
	public void jumbledWordsGame() {
		int score = 0;
		for(int eachWord=0;eachWord<words.length;eachWord++) {
			String wordShow = jumbleWord(words[eachWord]);
			System.out.println(wordShow);
			System.out.print("guess word :");
			String guess = scanner.next();
			if(guess.equals(words[eachWord])) score++;
		}
		System.out.println("Your score is : "+score);
	}
}
public class WordGame {
	static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		Game g = new Game();
		int choice =0;
		do {
			System.out.print("1.Stargame\n2.Jumbled game\n");
			choice = scanner.nextInt();
			switch(choice) {
			case 1: g.starGame();
					break;
			case 2: g.jumbledWordsGame();
					break;
			default:System.out.print("Invalid choice...");
		}
		}while(!(choice==1||choice==2));
		
	}
}
