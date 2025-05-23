import java.util.*;
public class lc621TaskScheduler {
    static class Solution {

        public int leastInterval(char[] tasks, int n) {
            Map<Integer, Integer> task_count = new HashMap<>();
            Queue<Integer[]> task_c = new LinkedList<>();

            int time = 0;
            Queue<Integer[]> task_q = new PriorityQueue<>((a,b)->a[0]-b[0]);

            int tasks_remaining = tasks.length;
            for (char t: tasks) {

                int t_i = (int) t;
                task_count.put(t_i, task_count.getOrDefault(t_i, 0)+1);

            }
            for (int t: task_count.keySet()){
                int t_count = task_count.get(t);
                task_q.add(new Integer[] {-1*t_count, t});
            }

            while(tasks_remaining>0){
                if (time>=n*tasks.length*2){
                    return -1;
                }

                while (task_c.size()>0){
                    if (task_c.peek()[0]<=time) {
                        Integer[] task_tuple = task_c.poll();
                        int t = task_tuple[1];
                        int t_count = task_count.get(t);
                        task_tuple[0] = -1 * t_count;
                        task_q.add(task_tuple);
                    } else {
                        break;
                    }
                }
                if (task_q.size()==0){
                    time++;
                    continue;
                }


                Integer[] task_tuple = task_q.poll();
                int t =  task_tuple[1];
                int t_count = task_count.get(t);


                if (t_count>0){
                    //process job
                    t_count--;
                    task_count.put(t, t_count);
                    tasks_remaining-=1;
                    task_tuple[0] = time+n+1;
                    task_tuple[1] = t;
                    if (t_count>0){
                        task_c.add(task_tuple);
                    }
                }
                time+=1;

            }
            return time;


        }
    }
    static class Solution_Class {
        static class Task implements Comparable {
            private static Map<Character, Task> taskMap = new HashMap<>();
            private static List<Task> taskList = new ArrayList<>();
            private int cooling = 0;
            private int copies = 2;
            private char name;

            Task(char name) {
                this.name = name;
            }

            char getName() {
                return name;
            }

            void addCopy() {
                copies += 1;
            }

            int getCopies() {
                return copies;
            }

            void decCopies() {
                copies--;
            }

            void incCopies() {
                copies++;
            }

            int getCooling() {
                return cooling;
            }

            void setCooling(int c) {
                cooling = c;
            }

            void cool() {
                if (cooling > 0) {
                    cooling--;

                    System.out.println(name + " c to " + cooling);
                } else {
                    System.out.println(name + " cool");
                }

            }

            static void persistTask(char name) {
                if (!taskMap.containsKey(name)) {
                    taskMap.put(name, new Task(name));
                    taskList.add(taskMap.get(name));
                } else {
                    Task t = taskMap.get(name);
                    t.incCopies();
                }
            }

            static Task getTask(char name) {
                return taskMap.get(name);
            }

            static void removeTask(char name) {
                Task t = taskMap.get(name);
                taskList.remove(t);
                taskMap.remove(name);
            }


            static void coolTasks() {
                for (Task t : Task.taskList) {
                    t.cool();
                }
            }

            @Override /// capitalize
            public int compareTo(Object other) {
                return Integer.compare(this.cooling, ((Task) other).getCooling());
            }

        }

        public int leastInterval(char[] tasks, int n) {
            PriorityQueue<Task> TQ = new PriorityQueue<>(26);
            for (char t : tasks) {
                Task.persistTask(t);
                TQ.add(Task.getTask(t));
            }
            int i = 0;
            while (TQ.size() > 0) {
                Task t = TQ.poll();
                System.out.println(i + " " + t.getName() + " c " + t.getCooling());
                if (t.getCooling() > 0) {
                    i += 1;
                    TQ.add(t);

                    Task.coolTasks();
                    continue;
                }
                if (t.getCopies() == 0) {
                    Task.removeTask(t.getName());


                    continue;
                }
                i += 1;
                t.decCopies();
                t.setCooling(n + 1);
                TQ.add(t);
                Task.coolTasks();


            }


            return i;

        }
        public void testTask(){
            Task.persistTask('A');
            Task.persistTask('B');
            Task A = Task.getTask('A');
            Task B = Task.getTask('B');
            A.setCooling(2);
            B.setCooling(2);
            System.out.println(A.compareTo(B));
            A.setCooling(2);
            B.setCooling(1);
            System.out.println(A.compareTo(B));
            A.setCooling(2);
            B.setCooling(3);
            System.out.println(A.compareTo(B));


        }
    }


    public  static void main(String[] args){
        Solution s = new Solution();
        //s.testTask();
        char[] t1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n=2;
        System.out.println(s.leastInterval(t1,n));
    }
}

