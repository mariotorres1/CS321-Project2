import java.util.Random;

/**
 * Generates a new process based on probability
 * @author Mario Torres
 */
public class ProcessGenerator implements ProcessGeneratorInterface {
	private double probability;
	private long seed;
	private Random rand;
	
	/**
	 * Constructor with probability of process being created
	 * @param probabilityInput - probability of generating process
	 */
	public ProcessGenerator(double probabilityInput) {
		this.probability = probabilityInput;
		rand = new Random();
	}
	
	/**
	 * Constructor with probability of process being created and seed to keep randomness the same, good for testing
	 * @param probabilityInput - probability of generating process
	 * @param seed - seed number to keep same randomness
	 */
	public ProcessGenerator(double probabilityInput, long seed) {
		this.probability = probabilityInput;
		this.seed = seed;
		rand = new Random(this.seed);
	}
	
	/**
	 * compares random number with probability
	 * returns true if process should be queried
	 */
	public boolean query() {
		double toQuery = rand.nextDouble();
		if (toQuery <= probability ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Generates new process
	 */
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
		int priority = rand.nextInt(maxLevel) + 1;
		int processTime = rand.nextInt(maxProcessTime) + 1;
		return new Process(priority, processTime, currentTime);
	}

}
