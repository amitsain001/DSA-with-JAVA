import java.util.*;

public class JobSeqProb {

    static class Job {
        int id;
        int profit;
        int deadline;

        public Job (int i, int p, int d ) {

            id = i;
            profit = p;
            deadline = d;

        }
    }

    public static void main ( String args[] ) {

        int jobsinfo[][] = { {4,20}, {1,10}, {1,40}, {1,30} };

        ArrayList<Job> jobs = new ArrayList<>();

        for ( int i=0; i < jobsinfo.length; i++ ) {
            jobs.add(new Job(i, jobsinfo[i][1], jobsinfo[i][0] ));
        }

        // Sorting Of Objects // Descending Order Sorting Of Profits

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();

        int time = 0;
        
        for ( int i=0; i < jobs.size(); i++ ){

            Job curr = jobs.get(i);

            if ( curr.deadline > time ) {
                seq.add(curr.id);
                time++;
            }

        }

        // Print Seq.

        System.out.println("Max jobs = "+seq.size());

        for ( int i=0; i<seq.size(); i++ ) {
            System.out.print(seq.get(i)+" ");
        }

        System.out.println();
    } 
}
