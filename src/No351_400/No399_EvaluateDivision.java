package No351_400;

import java.util.*;

public class No399_EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        for(int index = 0; index < equations.size(); index++){
            List<String> equation = equations.get(index);
            String dividend = equation.get(0), divisor = equation.get(1);
            double quotient = values[index];

            if(!graph.containsKey(dividend)){
                graph.put(dividend, new HashMap<String, Double>());
            }

            if(!graph.containsKey(divisor)){
                graph.put(divisor, new HashMap<String, Double>());
            }

            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }

        double[] results = new double[queries.size()];

        for(int index = 0; index < queries.size(); index++){
            List<String> query = queries.get(index);
            String dividend = query.get(0);
            String divisor = query.get(1);

            if(!graph.containsKey(dividend) || !graph.containsKey(divisor)){
                results[index] = -1.0;
            }else if(dividend == divisor){
                results[index] = 1.0;
            }else{
                HashSet<String> visited = new HashSet<>();
                results[index] = backtrackEvaluate(graph, dividend, divisor, 1, visited);
            }
        }
        return results;
    }

    private double backtrackEvaluate(HashMap<String, HashMap<String, Double>> graph, String currNode,
                                     String targetNode, double accProduct, Set<String> visited){
        visited.add(currNode);
        double res = -1.0;

        Map<String, Double> neighbors = graph.get(currNode);
        if(neighbors.containsKey(targetNode)){
            res = accProduct * neighbors.get(targetNode);
        }else{
            for(Map.Entry<String, Double> pair: neighbors.entrySet()){
                String nextNode = pair.getKey();
                if(visited.contains(nextNode)){
                    continue;
                }else{
                    res = backtrackEvaluate(graph, nextNode, targetNode, accProduct * pair.getValue(),
                            visited);
                    if(res != -1.0){
                        break;
                    }
                }
            }
        }

        visited.remove(currNode);
        return res;
    }
}
