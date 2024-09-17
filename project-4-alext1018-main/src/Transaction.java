
public class Transaction implements Comparable<Transaction>{
	private int blockNumber;
	private int index;
	private int gasLimit;
	private long gasPrice;
	private String fromAdr;
	private String toAdr;
	/**
	 * constructor
	 * @param number block number
	 * @param index block number index
	 * @param gasLimit gas limit
	 * @param gasPrice gas price
	 * @param fromAdr from address in the file 
	 * @param toAdr to address in the file 
	 */
	public Transaction(int number, int index, int gasLimit, long gasPrice, String fromAdr, String toAdr){
		this.blockNumber=number;
		this.index=index;
		this.gasLimit=gasLimit;
		this.gasPrice=gasPrice;
		this.fromAdr=fromAdr;
		this.toAdr=toAdr;
	}
	/**
	 * accessor
	 * @return block number
	 */
	public int getBlockNumber() {
		return this.blockNumber;
	}
	/**
	 * accessor
	 * @return block index
	 */
	public int getIndex() {
		return this.index;
	}
	/**
	 * accessor
	 * @return gas limit
	 */
	public int getGasLimit() {
		return this.gasLimit;
	}
	/**
	 * accessor
	 * @return gas price
	 */
	public long getGasPrice() {
		return this.gasPrice;
	}
	/**
	 * accessor
	 * @return from address
	 */
	public String getFromAddress() {
		return this.fromAdr;
	}
	/**
	 * accessor
	 * @return to address
	 */
	public String getToAddress() {
		return this.toAdr;
	}
	/**
	 * get the message print out
	 */
	public String toString() {
		String s = ("Transaction " + index + " for Block " + blockNumber);
		return s;
	}
	@Override
	public int compareTo(Transaction t) {
		if (this.getIndex()<t.getIndex()){
			return -1;
		}
		if (this.getIndex()>t.getIndex()){
			return 1;
		}
		return 0;
	}
	/**
	 * calculate the transaction cost 
	 * @return total transaction cost in ETH
	 */
	public double transactionCost() {
		double cost;
		cost=(getGasLimit()*getGasPrice())/1e18;
		return cost;
	}
}
