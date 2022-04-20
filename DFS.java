class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		List<Edge> edges = Arrays.asList(
                new Edge(1,1), new Edge(1,2), new Edge(2,3), new Edge(3,5) ,new Edge(5,6), new Edge(4,5),
                new Edge(0,4), new Edge(3,4)
                );
        Graph g = new Graph(edges, 6);
        g.DFS(1);
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
    public void DFS(int source){
        Stack<Pair> stack = new Stack<>();
        boolean[] visited = new boolean[v+1];
        stack.push(new Pair(source, 0));
        System.out.print(source+", ");
        visited[source] = true;
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
                System.out.print(node+", ");
                stack.push(new Pair(node, 0));
                visited[node] = true;
            }
        }
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
