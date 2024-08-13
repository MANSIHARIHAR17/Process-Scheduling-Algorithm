package ProcessSchedulingAlgo;

public class Job {
	 private int id;
	    private int burstTime;
	    private int arrivalTime;
	    private int waitingTime;
	    private int turnAroundTime;
	    private int completionTime;
	    private int priority; // For priority scheduling

	    public Job(int id, int arrivalTime, int  burstTime) {
	        this.id = id;
	        this.burstTime = burstTime;
	        this.arrivalTime = arrivalTime;
	    }

	    public Job(int id,  int arrivalTime, int  burstTime, int priority) {
	        this(id,arrivalTime,burstTime);
	        this.priority = priority;
	    }

	    public int getId() {
	        return id;
	    }

	    public int getBurstTime() {
	        return burstTime;
	    }

	    public int getArrivalTime() {
	        return arrivalTime;
	    }
	    public int getCompletionTime() {
	    	return completionTime;
	    }

	    public void setCompletionTime(int completingTime) {
	        this.completionTime = completingTime;
	    }
	    
	    public int getWaitingTime() {
	        return waitingTime;
	    }

	    public void setWaitingTime(int waitingTime) {
	        this.waitingTime = waitingTime;
	    }

	    public int getTurnAroundTime() {
	        return turnAroundTime;
	    }

	    public void setTurnAroundTime(int turnAroundTime) {
	        this.turnAroundTime = turnAroundTime;
	    }

	    public int getPriority() {
	        return priority;
	    }

	    public void setPriority(int priority) {
	        this.priority = priority;
	    }

}
