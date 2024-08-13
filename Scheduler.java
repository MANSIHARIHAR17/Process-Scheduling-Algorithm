package ProcessSchedulingAlgo;
import java.util.*;

public abstract class Scheduler {
	protected List<Job> jobs;
    protected List<int[]> ganttChart;

    public Scheduler(List<Job> jobs) {
        this.jobs = jobs;
    }

    public abstract void schedule();

    public void printJobStatistics() {
        System.out.println("Job ID | Arrival Time | Burst Time | Completion Time |  Turnaround Time | Waiting Time | Priority");
        for (Job job : jobs) {
            System.out.printf("%6d | %12d | %10d | %15d | %15d | %12d | %8d%n",
                    job.getId(), job.getArrivalTime(), job.getBurstTime() ,job.getCompletionTime(),job.getTurnAroundTime(),job.getWaitingTime(),  job.getPriority());
        }
    }

    public void printGanttChart() {
        System.out.println("Gantt Chart:");
        for (int[] entry : ganttChart) {
            System.out.print(" | P" + entry[0] + " ");
        }
        System.out.println(" |");
//        for (int[] entry : ganttChart) {
//            System.out.print(entry[1] + "   ");
//        }
        System.out.println();
    }

    public void analyzeResults() {
        double totalWaitingTime = 0;
        double totalTurnAroundTime = 0;
        for (Job job : jobs) {
            totalWaitingTime += job.getWaitingTime();
            totalTurnAroundTime += job.getTurnAroundTime();
        }
        double avgWaitingTime = totalWaitingTime / jobs.size();
        double avgTurnAroundTime = totalTurnAroundTime / jobs.size();
        System.out.printf("Average Waiting Time: %.2f%n", avgWaitingTime);
        System.out.printf("Average Turnaround Time: %.2f%n", avgTurnAroundTime);
    }

}
