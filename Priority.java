package ProcessSchedulingAlgo;
import java.util.*;

public class Priority extends Scheduler {
	public Priority(List<Job> jobs) {
        super(jobs);
    }

    @Override
    public void schedule() {
        jobs.sort(Comparator.comparingInt(Job::getArrivalTime).thenComparingInt(Job::getPriority));
        int currentTime = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(Job::getPriority));
        ganttChart = new ArrayList<>();

        int i = 0;
        while (i < jobs.size() || !pq.isEmpty()) {
            while (i < jobs.size() && jobs.get(i).getArrivalTime() <= currentTime) {
                pq.add(jobs.get(i));
                i++;
            }

            if (!pq.isEmpty()) {
            	 Job job = pq.poll();
                 job.setWaitingTime(currentTime - job.getArrivalTime());
                 currentTime += job.getBurstTime();
                 job.setTurnAroundTime(currentTime - job.getArrivalTime());
                 job.setCompletionTime(currentTime);
                 ganttChart.add(new int[]{job.getId(), currentTime});
             } else {
                 // If no job is available to process, move time forward to the next job arrival
                 if (i < jobs.size()) {
                     currentTime = jobs.get(i).getArrivalTime();
                 }
             }
        }
    }

}
