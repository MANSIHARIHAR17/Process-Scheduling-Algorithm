package ProcessSchedulingAlgo;
import java.util.*;
public class FCFS extends Scheduler{
	 public FCFS(List<Job> jobs) {
	        super(jobs);
	    }

	    @Override
	    public void schedule() {
	        ganttChart = new ArrayList<>();
	        
	        Collections.sort(jobs, Comparator.comparing(Job::getArrivalTime));
	        
	        //setting completion time
	        jobs.get(0).setCompletionTime(jobs.get(0).getArrivalTime()+jobs.get(0).getBurstTime());
	        for(int i = 1;i<jobs.size();i++) {
	        	if(jobs.get(i-1).getCompletionTime() < jobs.get(i).getArrivalTime()) {
	        		int diff =jobs.get(i).getArrivalTime()-jobs.get(i-1).getCompletionTime() ;
	        		jobs.get(i).setCompletionTime(jobs.get(i-1).getCompletionTime()+jobs.get(i).getBurstTime()+diff);
	        	}
	        	else {
	        		jobs.get(i).setCompletionTime(jobs.get(i-1).getCompletionTime()+jobs.get(i).getBurstTime());
	        	}
	        }
	        
	        //setting tat and wt
	        for (Job job : jobs) {
	            job.setTurnAroundTime(job.getCompletionTime() - job.getArrivalTime());
	            job.setWaitingTime( job.getTurnAroundTime()- job.getBurstTime());
	           
	            ganttChart.add(new int[]{job.getId()});
	        }
	    }

}

