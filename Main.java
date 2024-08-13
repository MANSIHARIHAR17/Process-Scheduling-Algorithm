package ProcessSchedulingAlgo;
import java.util.*;
public class Main {

	public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n;
        List<Job>jobs = new ArrayList<>();
        List<Job>jobsPriority  =new ArrayList<>();
        
//		List<Job> jobs = Arrays.asList(
//                new Job(1, 6, 0),
//                new Job(2, 8, 1),
//                new Job(3, 7, 2),
//                new Job(4, 3, 3)
//        );
//
//        List<Job> jobsPriority = Arrays.asList(
//                new Job(1, 6, 0, 2),
//                new Job(2, 8, 1, 1),
//                new Job(3, 7, 2, 3),
//                new Job(4, 3, 3, 2)
//        );
        
        int ans = 1;
		do {
	    System.out.println("****MENU****\n1.First Come First Serve(FCFS) Algorithm"
	    		+ " \n2.Shortest Job Time First(SJF) Algorithm"
	    		+ "\n3.Priority Scheduling Algorithm"
	    		+ "\n4.Round Robin(RR) Algorithm"
	    		+ "\n5.Shortest Remaining Time First(SRTF) Algorithm\n");
		System.out.print("Enter your choice:");
		int ch = sc.nextInt();
		switch(ch) {
			case 1:System.out.println("-----------------FCFS Algorithm-----------------");
				System.out.println("Enter number of process:");
				n = sc.nextInt();
				for(int i=0;i<n;i++) {
					System.out.println("Enter process Number:");
					int p = sc.nextInt();
					System.out.println("Enter process Arrival time:");
					int at = sc.nextInt();
					System.out.println("Enter process Burst time:");
					int bt = sc.nextInt();
					System.out.println();
					jobs.add(new Job(p,at,bt));
				}
				
			 	Scheduler fcfs = new FCFS(jobs);
		        fcfs.schedule();
		        System.out.println("FCFS Scheduling:");
		        fcfs.printJobStatistics();
		        fcfs.printGanttChart();
		        fcfs.analyzeResults();
		        System.out.println();
				break;
				
			case 2:System.out.println("-----------------SJF Algorithm-----------------");
				System.out.println("Enter number of process:");
				n = sc.nextInt();
				for(int i=0;i<n;i++) {
					System.out.println("Enter process Number:");
					int p = sc.nextInt();
					System.out.println("Enter process Arrival time:");
					int at = sc.nextInt();
					System.out.println("Enter process Burst time:");
					int bt = sc.nextInt();
					System.out.println();
					jobs.add(new Job(p,at,bt));
				}
				
				Scheduler sjf = new SJF(jobs);
		        sjf.schedule();
		        System.out.println("SJF Scheduling:");
		        sjf.printJobStatistics();
		        sjf.printGanttChart();
		        sjf.analyzeResults();
		        System.out.println();
				break;
				
			case 3:System.out.println("-----------------PRIORITY Algorithm-----------------");
				System.out.println("Enter number of process:");
				n = sc.nextInt();
				for(int i=0;i<n;i++) {
					
					System.out.println("Enter process Number:");
					int p = sc.nextInt();
					System.out.println("Enter process Arrival time:");
					int at = sc.nextInt();
					System.out.println("Enter process Burst time:");
					int bt = sc.nextInt();
					System.out.println("Enter process priority:");
					int priority = sc.nextInt();
					System.out.println();
					jobsPriority.add(new Job(p,at,bt,priority));
				}
				
				Scheduler priority = new Priority(jobsPriority);
		        priority.schedule();
		        System.out.println("Priority Scheduling:");
		        priority.printJobStatistics();
		        priority.printGanttChart();
		        priority.analyzeResults();
		        System.out.println();
				break;
				
			case 4:System.out.println("-----------------Round Robin Algorithm-----------------");
				System.out.println("Enter number of process:");
				n = sc.nextInt();
				for(int i=0;i<n;i++) {
					System.out.println("Enter process Number:");
					int p = sc.nextInt();
					System.out.println("Enter process Arrival time:");
					int at = sc.nextInt();
					System.out.println("Enter process Burst time:");
					int bt = sc.nextInt();
					System.out.println();
					jobs.add(new Job(p,at,bt));
				}
				System.out.println("Enter quantum time");
				int time = sc.nextInt();
				Scheduler rr = new RoundRobin(jobs, time);
		        rr.schedule();
		        System.out.println("Round Robin Scheduling:");
		        rr.printJobStatistics();
		        rr.printGanttChart();
		        rr.analyzeResults();
		        System.out.println();
				break;
				
			case 5:System.out.println("-----------------SRTF Algorithm-----------------");
				System.out.println("Enter number of process:");
				n = sc.nextInt();
				for(int i=0;i<n;i++) {
					System.out.println("Enter process Number:");
					int p = sc.nextInt();
					System.out.println("Enter process Arrival time:");
					int at = sc.nextInt();
					System.out.println("Enter process Burst time:");
					int bt = sc.nextInt();
					System.out.println();
					jobs.add(new Job(p,at,bt));
				}
				Scheduler srtf = new SRTF(jobs);
		        srtf.schedule();
		        System.out.println("SRTF Scheduling:");
		        srtf.printJobStatistics();
		        srtf.printGanttChart();
		        srtf.analyzeResults();
				break;
				
			default:System.out.println("Invalid choice!!!");
		}
		System.out.println("Do you want to continue? (yes-1/no-0)");
			ans=sc.nextInt();
			System.out.println("------------------------------------------------");
		}
		while(ans!=0);
	}
}



