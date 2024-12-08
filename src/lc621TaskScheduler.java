import java.util.*;
public class lc621TaskScheduler {
    static class Solution {
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
        s.testTask();
    }
}

