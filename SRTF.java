package ProcessSchedulingAlgo;
import java.util.*;

public class SRTF extends Scheduler {
	 public SRTF(List<Job> jobs) {
	        super(jobs);
	    }

	    @Override
	    public void schedule() {
	        int currentTime = 0;
	        int completed = 0;
	        int[] remainingBurstTime = new int[jobs.size()];
	        ganttChart = new ArrayList<>();

	        for (int i = 0; i < jobs.size(); i++) {
	            remainingBurstTime[i] = jobs.get(i).getBurstTime();
	        }

	        while (completed != jobs.size()) {
	            int minBurstTime = Integer.MAX_VALUE;
	            int shortest = -1;
	            boolean found = false;

	            // Find the job with the shortest remaining burst time
	            for (int i = 0; i < jobs.size(); i++) {
	                if (jobs.get(i).getArrivalTime() <= currentTime && remainingBurstTime[i] > 0 && remainingBurstTime[i] < minBurstTime) {
	                    minBurstTime = remainingBurstTime[i];
	                    shortest = i;
	                    found = true;
	                }
	            }

	            // If no job is found, increment current time
	            if (!found) {
	                currentTime++;
	                continue;
	            }

	            // Process the found job
	            remainingBurstTime[shortest]--;
	            ganttChart.add(new int[]{jobs.get(shortest).getId(), currentTime + 1});

	            // If job is completed, update its times
	            if (remainingBurstTime[shortest] == 0) {
	                completed++;
	                int finishTime = currentTime + 1;
	                jobs.get(shortest).setCompletionTime(finishTime);
	                jobs.get(shortest).setTurnAroundTime(finishTime - jobs.get(shortest).getArrivalTime());
	                jobs.get(shortest).setWaitingTime(jobs.get(shortest).getTurnAroundTime() - jobs.get(shortest).getBurstTime());
	            }

	            currentTime++;
	        }
	    }

}
