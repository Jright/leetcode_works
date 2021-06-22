package No601_650;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class No636_ExclusiveTimeofFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<Log> stack = new ArrayDeque<>();

        for (String string : logs) {
            String[] itemArr = string.split(":");

            Log log = new Log(Integer.parseInt(itemArr[0]), itemArr[1].equals("start"), Integer.parseInt(itemArr[2]));
            if (log.isStart) {
                stack.push(log);
            } else {
                Log top = stack.pop();
                res[log.id] += log.timestamp - top.timestamp + 1;
                if(!stack.isEmpty()){
                    res[stack.peek().id] -= log.timestamp - top.timestamp + 1;
                }
            }
        }
        return res;
    }

    static class Log {
        public int id;
        public boolean isStart;
        public int timestamp;

        public Log(int id, boolean isStart, int timestamp) {
            this.id = id;
            this.isStart = isStart;
            this.timestamp = timestamp;
        }
    }

}
