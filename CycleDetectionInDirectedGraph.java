class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		List<Edge> edges = Arrays.asList(
                new Edge(0,1), new Edge(0,2),new Edge(1,3),new Edge(2,3)
                );
        Graph g = new Graph(edges, 3);
        System.out.println(g.cycleDetectionInDirectedGraph(1));
	}
}
class Graph{
    List<List<Integer>> g = new ArrayList<>();
    int v;
    Graph(List<Edge> edgeList, int v){
        this.v = v;
        for(int i=0 ; i<=v ; i++)
            g.add(i, new ArrayList<>());
            
        for(Edge e : edgeList){
            g.get(e.src).add(e.des);
        }
    }
    public boolean cycleDetectionInDirectedGraph(int source){
        Stack<Pair> stack = new Stack<>();
        boolean[] visited = new boolean[v+1];
        boolean[] currStack = new boolean[v+1];
        stack.push(new Pair(source, 0));
        currStack[source] = true;
        visited[source] = true;
        while(!stack.isEmpty()){
            Pair curr = stack.peek();
            if(curr.index >= g.get(curr.node).size()){
                stack.pop();
                currStack[curr.node] = false;
                continue;
            }
            int node = g.get(curr.node).get(curr.index);
            stack.pop();
            stack.push(new Pair(curr.node, curr.index+1));
            if(!visited[node]){
                stack.push(new Pair(node, 0));
                visited[node] = true;
                currStack[node] = true;
            }
            else{
                if(currStack[node] == true){
                    return true;
                }
            }
        }
        return false;
    }
    
}
class Pair{
    int node, index;
    Pair(int node, int index){
        this.node = node;
        this.index = index;
    }
}
class Edge{
    int src, des;
    Edge(int src, int des){
        this.src = src;
        this.des = des;
    }
}
