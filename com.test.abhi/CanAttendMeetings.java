import java.util.Collections;
import java.util.List;
/**
 * Given an array of meeting time interval objects consisting of start and end times 
 * [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), determine if a person could add 
 * all meetings to their schedule without any conflicts.

Note: (0,8),(8,10) is not considered a conflict at 8

https://neetcode.io/problems/meeting-schedule?list=blind75
 */
public class CanAttendMeetings {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b)->Integer.compare(a.start, b.start));

        Integer currEnd = 0;
        for(Interval inter : intervals){
            if(currEnd <= inter.start){
                currEnd = inter.end;
            } else {
                return false;
            }
        }

        return true;
    }

    public class Interval {
        public int start, end;
        public Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }
}
