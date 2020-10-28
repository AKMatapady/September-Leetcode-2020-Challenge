class Solution {
    
    private class Node {
        String key;
        double val;

        public Node(String k, double v) {
            key = k;
            val = v;
        }
    }
    
    private double dfs(String s, String d, Set<String> visited, Map<String, List<Node>> g) {
        if (!(g.containsKey(s) && g.containsKey(d))) 
            return -1.0;
        if (s.equals(d)) 
            return 1.0;
        visited.add(s);
        for (Node node : g.get(s)) 
        {
            if (!visited.contains(node.key)) 
            {
                double ans = dfs(node.key, d, visited, g);
                if (ans != -1.0)
                    return ans * node.val;
            }
        }
        return -1;
    }
    
	private Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> g = new HashMap();
        for (int i = 0; i < values.length; i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            g.computeIfAbsent(src, k -> new ArrayList()).add(new Node(dest, values[i])); 
            g.computeIfAbsent(dest, k -> new ArrayList()).add(new Node(src, 1 / values[i]));
        }
        return g;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> g = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++)
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), g);
        return result;
        
    }
}