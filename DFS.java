class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		List<Edge> edges = Arrays.asList(
                new Edge(1,1), new Edge(1,2), new Edge(2,3), new Edge(3,5) ,new Edge(5,6), new Edge(4,5),
                new Edge(0,4), new Edge(3,4)
                );
        Graph g = new Graph(edges, 10);
        g.DFS(1);
	}
}
class Graph{
    List<List<Integer>> g = new ArrayList<>();
    Graph(List<Edge> edgeList, int v){
        for(int i=0 ; i<v ; i++)
            g.add(i, new ArrayList<>());
            
        for(Edge e : edgeList){
            g.get(e.src).add(e.des);
            g.get(e.des).add(e.src);
        }
    }
    public void DFS(int source){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[g.size()];
        stack.push(source);
        visited[source] = true;
        while(!stack.isEmpty()){
            int current = stack.pop();
            System.out.print(current+", ");
            for(int node : g.get(current)){
                if(!visited[node]){
                    stack.push(node);
                    visited[node] = true;
                }
            }
        }
    }
    
}
class Pair{
    int node, distance;
    Pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}
class Edge{
    int src, des;
    Edge(int src, int des){
        this.src = src;
        this.des = des;
    }
}
