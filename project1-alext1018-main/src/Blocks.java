import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
* This class is about test the block number and miner address from "ethereumP1data.txt"
*@author Yuxuan Tang
*@version 1.0
*/
public class Blocks {
	private int number;
	private String miner;
	private  static ArrayList<Blocks> blocks= new ArrayList<Blocks>();
/**
 * This is constructor and return empty block
 */
	public Blocks() {
		toString();
	}
	/**
	 * This is constructor and return block number
	 * @param number is the block number
	 */
	public Blocks(int number) {
		this.number=number;
		toString();
	}
	/**
	 * This is constructor and return block number and miner address
	 * @param number is the block number
	 * @param miner is the address for the block number
	 */
	public Blocks(int number,String miner) {
		this.number=number;
		this.miner=miner;
		toString();
	}
	/**
	 * accessor
	 * @return the block number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * accessor
	 * @return the miner address
	 */
	public String getMiner() {
		return miner;
	}
	/**
	 * 
	 * @return the copy of blocks array list 
	 */
	public static ArrayList<Blocks> getBlocks(){
		ArrayList<Blocks> a = new ArrayList<Blocks>(blocks.size());
		for(int i =0;i<blocks.size();i++) {
			a.add(blocks.get(i));
		}
		return a;
	}
	/**
	 * This method use a nest for loop to calculate unique miner from address 
	 * in the data file and print out the frequency and miner address
	 * to console
	 */
	public static void calUniqMiners() {
		int[] times = new int[blocks.size()];
		ArrayList<Blocks> s  = Blocks.getBlocks();
		ArrayList<Blocks> newArray = new ArrayList<>();
		boolean flag = false;
		// to check miner address
		for(int i = 0;i < s.size();i++){
			for(int l = 0;l < newArray.size();l++){
				flag = false;
				if(((s.get(i)).getMiner()).equals((newArray.get(l)).getMiner())){
					flag = true;
				}
				if(flag){
					break;
				}
			}
			if(flag){
				continue;
			}
			for(int j = 0;j < s.size();j++){
				if(((s.get(i)).getMiner()).equals(s.get(j).getMiner())){
					times[i] += 1;
				}
			}

			newArray.add(s.get(i));
		}
		//empty block
		int Numofzero = 0;
		for(int i = 0;i < s.size();i++){
			if(times[i] == 0){
				Numofzero++;
			}
		}
		//delete empty block
		int[] t = new int[s.size() - Numofzero];
		int temp = 0;
		for(int i = 0;i < s.size();i++){
			if(times[i] != 0){
				t[temp] = times[i];
				temp++;
			}
		}
		// print out result
		System.out.println("Number of unique Miners: " + newArray.size());
		System.out.println();
		System.out.println("Each unique Miner and its frequency:");
		for(int k = 0;k < newArray.size();k++){
			System.out.println("Miner Address: " + newArray.get(k).getMiner());
			System.out.println("Miner Frequency: " + t[k]);
			System.out.println();
		}

	}
			
	/**
	 * this method is get the difference between two block number
	 * @param A is first block
	 * @param B is second block
	 * @return the difference between two block number
	 */
	public static int blockDiff(Blocks A, Blocks B) {
		return (A.getNumber() - B.getNumber());
	}

/**
 * this method 
 * @param num is the block number 
 * @return block number from arraylist
 */
	public static Blocks getBlockByNumber(int num) {
		for(int a =0;a<blocks.size();a++) {
			if(blocks.get(a).number==num) {
				return blocks.get(a);
			}
		}
			return null;
		}
	
	/**
	 * This is a toString method that return three different result for Block 
	 */
	public String toString() {
		String a = "Empty Block";
		String b = "Block Number: " + this.number;
		String c = "Block Number: " + this.number + " Miner Address: " + this.miner;
		if(number == 0&&miner == null) {
			return a;
		}
		if(number!=0&&miner==null) {
			return b;
		}
		else {
			return c;
		}
		
	}
	/**
	 * this is a readFile method, read the block number and miner address from file
	 * @param fileName is data file need to be read
	 * @throws IOException If an input or output exception happened
	 */
	public static void readFile(String fileName)  throws IOException{
		String[] column;
		String line;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		while((line= br.readLine())!=null){
			column = line.split(",");
			int number = Integer.parseInt(column[0]);
			String miner = column[9];
			Blocks block = new Blocks(number, miner);
			blocks.add(block);
		}
	}
	
}
