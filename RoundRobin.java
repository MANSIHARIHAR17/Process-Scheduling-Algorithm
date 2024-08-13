package ProcessSchedulingAlgo;
import java.util.*;

public class RoundRobin extends Scheduler {
	private int timeQuantum;

    public RoundRobin(List<Job> jobs, int timeQuantum) {
        super(jobs);
        this.timeQuantum = timeQuantum;
    }

    @Override
    public void schedule() {
        int currentTime = 0;
        Queue<Job> queue = new LinkedList<>();
        int[] remainingBurstTime = new int[jobs.size()];
        ganttChart = new ArrayList<>();

        for (int i = 0; i < jobs.size(); i++) {
            remainingBurstTime[i] = jobs.get(i).getBurstTime();
        }

        int i = 0;
        while (i < jobs.size() || !queue.isEmpty()) {
            while (i < jobs.size() && jobs.get(i).getArrivalTime() <= currentTime) {
                queue.add(jobs.get(i));
                i++;
            }

            if (!queue.isEmpty()) {
                Job job = queue.poll();
                int jobIndex = jobs.indexOf(job);
                int burst = Math.min(timeQuantum, remainingBurstTime[jobIndex]);
                remainingBurstTime[jobIndex] -= burst;
                ganttChart.add(new int[]{job.getId(), currentTime + burst});
                currentTime += burst;
                
                while (i < jobs.size() && jobs.get(i).getArrivalTime() <= currentTime) {
                    queue.add(jobs.get(i));
                    i++;
                }
                if (remainingBurstTime[jobIndex] > 0) {
                    queue.add(job);
                } else {
                    job.setCompletionTime(currentTime);
                    job.setTurnAroundTime(currentTime - job.getArrivalTime());
                    job.setWaitingTime(job.getTurnAroundTime() - job.getBurstTime());
                }
            } else {
                if (i < jobs.size()) {
                    currentTime = jobs.get(i).getArrivalTime();
                }
            }
        }
    }

}
