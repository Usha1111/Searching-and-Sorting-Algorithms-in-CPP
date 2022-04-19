class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(1, 2),
                new Edge(2, 3), new Edge(3, 5), new Edge(5, 6)
                , new Edge(4,5),new Edge(3, 4), new Edge(0, 4));
        Graph g = new Graph(edges, 10);
        g.BFS();
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
    public void BFS(){
	   Queue<Integer> queue = new LinkedList<>();
	   boolean[] visited = new boolean[g.size()];
	   queue.add(1);
	   visited[1] = true;
	   while(!queue.isEmpty()){
	       int current = queue.poll();
	       System.out.print(current+", ");
	       for(int val : g.get(current)){
	           if(!visited[val]){
	               queue.add(val);
	               visited[val] = true;
	           }
	       }
	   }
	   System.out.println();
	}
}

class Edge{
    int src, des;
    Edge(int src, int des){
        this.src = src;
        this.des = des;
    }
}
