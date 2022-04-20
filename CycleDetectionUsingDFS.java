class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		List<Edge> edges = Arrays.asList(
                new Edge(0,1), new Edge(1,2)
                );
        Graph g = new Graph(edges, 7);
        System.out.println(g.cycleDetection(1));
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
            g.get(e.des).add(e.src);
        }
    }
    public boolean cycleDetection(int source){
        Stack<Pair> stack = new Stack<>();
        boolean[] visited = new boolean[v+1];
        int[] parent = new int[v+1];
        stack.push(new Pair(source, 0));
        visited[source] = true;
        parent[source] = source;
        while(!stack.isEmpty()){
            Pair curr = stack.peek();
            if(curr.index >= g.get(curr.node).size()){
                stack.pop();
                continue;
            }
            int node = g.get(curr.node).get(curr.index);
            stack.pop();
            stack.push(new Pair(curr.node, curr.index+1));
            if(!visited[node]){
                stack.push(new Pair(node, 0));
                parent[node] = curr.node;
                visited[node] = true;
            }
            else{
                if(parent[curr.node] != node){
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
