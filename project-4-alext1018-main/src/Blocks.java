import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.TreeSet;
import java.text.SimpleDateFormat;


public class Blocks implements Comparable<Blocks> {
	private int number;				// Block number
	private String miner;			// Miner address
	private long timestamp; 		// Unix timestamp
	private int transactionCount;	// Transaction count
	private static ArrayList<Blocks> blocks = null;
	private StringBuilder returnString = new StringBuilder();
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("E, dd MMMM yyyy HH:mm:ss z");
	private Date date;				// date in the format of "dateFormat
	private ArrayList<Transaction> transactions;
	
	/**
	 * This is constructor and return empty block
	 */
	public Blocks() {
		returnString.append("Empty Block");
	}
	/**
	 * This is constructor and return block number
	 * @param number is the block number
	 */
	public Blocks(int number) {
		this.number = number;
		returnString.append("Block Number: " + number);
	}
	/**
	 * This is constructor and return block number and miner address
	 * @param number is the block number
	 * @param miner is the address for the block number
	 */
	public Blocks(int number, String miner) {
		this.number = number;
		this.miner = miner;
		returnString.append("Block Number: " + number + " Miner Address: " + miner);
	}
	/**
	 * This is constructor and return block number and miner address
	 * @param number is the block number
	 * @param miner is the address for the block number
	 * @param timestamp is time from file
	 * @param transactionCount is block number's transactions
	 */
	public Blocks(int number, String miner, long timestamp, int transactionCount) throws FileNotFoundException,IOException {
		this.number = number;
		this.miner = miner;
		this.timestamp = timestamp;
		this.transactionCount = transactionCount;
		readTransactions("ethereumtransactions1.csv");
		returnString.append("Block Number: " + number + " Miner Address: " + miner);
		
	}
	

	/**
	 * accessor
	 * @return the block number
	 */
	public int getNumber() {
		return this.number;
	}
	/**
	 * accessor
	 * @return the miner address
	 */
	public String getMiner() {
		return this.miner;
	}
	/**
	 * 
	 * @return the copy of transaction array list 
	 */
	public  ArrayList<Transaction> getTransactions() {
		return new ArrayList<Transaction>(transactions);
	}
	/**
	 * accessor
	 * @return the transactions number
	 */
	public int getTransactionCount() {
		return this.transactionCount;
	}
	/**
	 * 
	 * @return the copy of blocks array list 
	 */
	public static ArrayList<Blocks> getBlocks() {
		return new ArrayList<>(blocks);
	}
	/**
	 * this method read transaction from file and store them into a treeset
	 * @param filename is the file need to used
	 * @throws FileNotFoundException if an input or output exception happened
	 * @throws IOException if an input or output exception happened
	 */
	public void readTransactions(String filename) throws FileNotFoundException,IOException {
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		String[] column;
		TreeSet<Transaction> set = new TreeSet<>();
		while(sc.hasNextLine()){
			String line =sc.nextLine();
			column = line.trim().split(",");
			int number = Integer.parseInt(column[3]);
			int index = Integer.parseInt(column[4]);
			int gasLimit = Integer.parseInt(column[8]);
			long gasPrice = (long)Double.parseDouble(column[9]);
			String fromAdr = column[5];
			String toAdr = column[6];
			
			Transaction trans = new Transaction(number,index, gasLimit,gasPrice,fromAdr,toAdr);
			if(trans.getBlockNumber()==this.number) {
				set.add(trans);
			}
		}
		sc.close();
		transactions = new ArrayList<Transaction>(set);
		
}
	
	// given an ArrayList of Blocks, find each unique miner address and
	// the frequency of times it appears and print according to output
	public static void calUniqMiners() throws FileNotFoundException, IOException {	
		// if blocks ArrayList has not been read, do so now
		if (blocks == null)
		{
			readFile("ethereumP1data.txt");
		}
		
		// initialize ArrayLists to store addresses and frequencies
		ArrayList<String> uniqMiners = new ArrayList<String>();
		ArrayList<Integer> uniqMinersFreq = new ArrayList<Integer>();
		// holds each miner address
		String miner;
		// loop through all Blocks
		for (int i = 0; i < blocks.size(); ++i)
		{
			miner = blocks.get(i).getMiner();
			// enter if the miner is new
			if (!(uniqMiners.contains(miner)))
			{
				// add the miner and add the frequency of 1
				uniqMiners.add(miner);
				uniqMinersFreq.add(1);
			}
			// otherwise increment the frequency of that miner
			else
			{
				for (int j = 0; j < uniqMiners.size(); ++j)
				{
					if (uniqMiners.get(j).equals(miner))
					{
						uniqMinersFreq.set(j, uniqMinersFreq.get(j) + 1);
					}
				}
			}
		}

		// print according to output
		System.out.println("Number of unique Miners: " + uniqMiners.size() + "\n");
		System.out.println("Each unique Miner and its frequency:");
		for (int i = 0; i < uniqMiners.size(); ++i)
		{
			System.out.println("Miner Address: " + uniqMiners.get(i) + "\nMiner Frequency: " + uniqMinersFreq.get(i) + "\n");
		}
	}

	// calculate the difference in the block numbers of two blocks
	public static int blockDiff(Blocks minuend, Blocks subtrahend) {
		int diff = minuend.getNumber() - subtrahend.getNumber();

		return diff;
	}

	// given the Block number retrieve the Blocks object that corresponds to that number from blocks ArrayList and return it
	public static Blocks getBlockByNumber(int num) throws FileNotFoundException, IOException {
		
		if(blocks == null) {
			Blocks.readFile("ethereumP1data.txt");
		}
		
		for(int i = 0; i < blocks.size(); ++i) {
			if (blocks.get(i).getNumber() == num) {
				return blocks.get(i);
			}
		}

		return null;
	}
	/**
	 * return the print out
	 */
	public String toString() {
		return returnString.toString();
	}

	// reads a file of given filename and fills an ArrayList of Blocks
	public static ArrayList<Blocks> readFile(String filename) throws FileNotFoundException, IOException {
		// construct a file object for the file with the given name.
		File file = new File(filename);

		// construct a scanner to read the file.
		Scanner fileScanner = new Scanner(file);

		// blocks ArrayList to store Blocks objects
		ArrayList<Blocks> b = new ArrayList<Blocks>();

		// create the Array that will store each lines data so we can grab the required fields
		String[] fileData = null;

		// Store each line of the file into the ArrayList.
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();

			// split each line along the commas
			fileData = line.trim().split(",");

			// fileData[0] corresponds to block number, fileData[9] to miner address
			// fileData[16] corresponds to unix timestamp, fileData[17] corresponds to transaction count
			b.add(new Blocks(Integer.parseInt(fileData[0]), fileData[9], Integer.parseInt(fileData[16]), Integer.parseInt(fileData[17])));
		}

		fileScanner.close();

		blocks = new ArrayList<>(b);

		return b;
	}
	
	// sort the blocks ArrayList in ascending order based on block number
	public static void sortBlocksByNumber() throws FileNotFoundException, IOException {
		if (blocks==null) {
			readFile("ethereumP1.txt");
		}
		
		Collections.sort(blocks);
	}

	@Override
	public int compareTo(Blocks b) {
		Integer x = number;
		Integer y = b.getNumber();
		return x.compareTo(y);
	}
	
	// print the date with the correct format
	public String getDate() {
		// initialize date in milliseconds
		date = new Date(timestamp * 1000);
		dateFormat.setTimeZone(TimeZone.getTimeZone("CST"));
		return dateFormat.format(date);
	}
	
	// find the difference in time between two given Blocks in hours, minutes, and seconds
	public static void timeDiff(Blocks first, Blocks second) {
		//make sure given Blocks aren't null
		if ((first == null) || (second == null)) {
			System.out.println("A given Block is null.");
		}
		else {
			String hours = " hours, ";
			String minutes = " minutes, and ";
			String seconds = " seconds.";
			// use timestamps to find hours, minutes, seconds
			int diffInSeconds = (int) Math.abs(first.timestamp - second.timestamp);
			int diffInMinutes = diffInSeconds / 60;
			int diffInHours = diffInMinutes / 60;
			diffInSeconds = diffInSeconds % 60;
			diffInMinutes = diffInMinutes % 60;
			
			if (diffInHours == 1) {
				hours = " hour, ";
			}
			if (diffInMinutes == 1) {
				minutes = " minute, and ";
			}
			if (diffInSeconds == 1) {
				seconds = " second.";
			}
			

			System.out.println("The difference in time between Block " + first.getNumber() + " and Block " + second.getNumber() + " is "
					+ diffInHours + hours + diffInMinutes + minutes + diffInSeconds + seconds);
		}
	}
	
	// return the number of transactions between two Blocks not inclusive
	// return -1 if the Blocks are null/not in the blocks ArrayList
	// or if second is before first in the ArrayList
	public static int transactionDiff(Blocks first, Blocks second) throws FileNotFoundException, IOException {
		
		// if blocks ArrayList has not been read, do so now and sort it
		if (blocks == null)
		{
			readFile("ethereumP1data.txt");
			sortBlocksByNumber();
		}
		
		// make sure given Blocks aren't null
		if ((first == null) || (second == null)) {
			return -1;
		}
		
		int indexA = -1;		// index of first in blocks ArrayList
		int indexB = -1;		// index of second in blocks ArrayList
		int count = 0;			// number of transactions between the two Blocks
		
		
		// for loop to find indexA and indexB
		for (int i = 0; i < blocks.size(); ++i) {
			if (first.getNumber() == blocks.get(i).getNumber()) {
				indexA = i;
			}
			if (second.getNumber() == blocks.get(i).getNumber()) {
				indexB = i;
			}
		}
		
		// make sure first and second are elements of blocks
		if ((indexA < 0) || (indexB < 0)) {
			return -1;
		}
		// make sure first comes before second
		if (indexA >= indexB) {
			return -1;
		}
		
		// for loop to count the transactions
		for (int i = indexA+1; i < indexB; ++i) {
			count += blocks.get(i).getTransactionCount();
		}
		
		return count;
	}
	/**
	 * this method add every transaction from transaction list and calculate the average cost
	 * @return the average of transaction cost
	 */
	public double avgTransactionCost() {
		double sum =0.0;
		for(int i=0;i<transactions.size();i++) {
			sum+=transactions.get(i).transactionCost();
		}
		double avg = sum/transactions.size();
		return avg;	
	}
	/**
	 * this method create an ArrayList that stored the from address for each transaction 
	 * and then a nested for each to see if  ArrayList addresses matched the address of the transaction
	 */
	public void uniqFromTo() {
		System.out.println("Each transaction by from address for Block " + getNumber() + ":");
		System.out.println();
		ArrayList<String> array = new ArrayList<>();
		for(int i =0; i<transactions.size();i++) {
			if(!array.contains(transactions.get(i).getFromAddress())) {
				array.add(transactions.get(i).getFromAddress());
			}
		}
		for(int i = 0; i<array.size();i++) {
			double cost = 0.0;
			System.out.println("From " + array.get(i));
		for(int j =0; j<transactions.size();j++) {
			if(transactions.get(j).getFromAddress().equals(array.get(i))) {
				System.out.println(" -> " + transactions.get(j).getToAddress());
				cost += transactions.get(j).transactionCost();
			}
			
		}
		System.out.println("Total cost of transactions: " + String.format("%.8f",cost) + " ETH");
		System.out.println();
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
