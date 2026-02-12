import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://neetcode.io/problems/course-schedule/question
 */
public class CoursesAllowed {
    Set<Integer> visitedSet = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=1 || prerequisites.length<=1){
            return true;
        }
        //Initialize variables
        Set<Integer> crsSet = new HashSet<>();
        PrereqList graphImpl = new PrereqList(numCourses);
        
        //Initialze graph
        for(int i=0; i<prerequisites.length; i++){
            if(prerequisites[i][0]==prerequisites[i][1]){
                return false;
            }
            graphImpl.addEdge(prerequisites[i][0], prerequisites[i][1]);
            crsSet.add(prerequisites[i][0]);
        }
        for(Integer crs : crsSet){
            if(findCycle(graphImpl, crs)){
                return false;
            }
        }

        return true;
    }

    private Boolean findCycle(PrereqList list, int course){
        if(visitedSet.contains(course)){
            System.out.println("Cycle found -- Course: "+course);
            return true;
        }
        visitedSet.add(course);
        for(Integer prereq: list.getAdjItr(course)){
            System.out.println("Course: "+course +" Prereq: "+prereq);
            if(findCycle(list, prereq)){
                return true;
            }
        }
        //Remove the course if no cycle is detected for it.
        visitedSet.remove(course);
        return false;
    }

    // Directed graph, so only keep track of course -> prereq and not both directions
    class PrereqList{
        List<Integer>[] graph;

        PrereqList(int V){
            graph = (List<Integer>[]) new ArrayList[V];
            for(int i = 0; i<V; i++){
                graph[i] = new ArrayList<>();
            }
        }

        public void addEdge(int v, int w){
            graph[v].add(w);
            //graph[w].add(v);
        }

        public List<Integer> getAdj(int v){
            return graph[v];
        }

        public Iterable<Integer> getAdjItr(int v){
            return graph[v];
        }

        public Integer size(){
            return graph.length;
        }
    }
}
