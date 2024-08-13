package ProcessSchedulingAlgo;
import java.util.*;

public class SJF extends Scheduler {
	public SJF(List<Job> jobs) {
        super(jobs);
    }

    @Override
    public void schedule() {
        jobs.sort(Comparator.comparingInt(Job::getArrivalTime).thenComparingInt(Job::getBurstTime));
        int currentTime = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(Job::getBurstTime));
        ganttChart = new ArrayList<>();

        int i = 0;
        while (i < jobs.size() || !pq.isEmpty()) {
            while (i < jobs.size() && jobs.get(i).getArrivalTime() <= currentTime) {
                pq.add(jobs.get(i));
                i++;
            }

            if (!pq.isEmpty()) {
                Job job = pq.poll();
                job.setCompletionTime(currentTime + job.getBurstTime());
                job.setTurnAroundTime(job.getCompletionTime() - job.getArrivalTime());
                job.setWaitingTime( job.getTurnAroundTime()- job.getBurstTime());
                currentTime += job.getBurstTime();
                ganttChart.add(new int[]{job.getId(), currentTime});
            } else {
            	if (i < jobs.size()) {
                    currentTime = jobs.get(i).getArrivalTime();
                }
            }
        }
    }
}
