import java.util.Random;


public  class RandomPlayer extends Player  {
	private Random generator;
	public RandomPlayer(String name) {
		super(name);
		generator = new Random();
	}
	public int[] getMove(int[] pileSizes) {
		int[] move= {0,0};
		boolean flag = false;
		move[0] = generator.nextInt(pileSizes.length);
		while(!flag) {
		if(pileSizes[move[0]]>0) {
			move= new int[] { move[0],generator.nextInt(pileSizes[move[0]])+1};
			flag=true;
		}
		move[1] = generator.nextInt(pileSizes[move[0]])+1;
		
			}
		
		
		
		return move;
	}
}
