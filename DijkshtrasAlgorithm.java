class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		List<Edge> edges = Arrays.asList(
                new Edge(0,1,1),new Edge(1,2,1),new Edge(2,3,12),new Edge(0,3,7),new Edge(0,2,4)
                ,new Edge(3,4,3),new Edge(2,4,10)
                );
        Graph g = new Graph(edges, 4);
        System.out.println(g.dijkshtrasAlgorithm(0));
	}
}
class Graph{
    List<List<Node>> g = new ArrayList<>();
    int v;
    Graph(List<Edge> edgeList, int v){
        this.v = v;
        for(int i=0 ; i<=v ; i++)
            g.add(i, new ArrayList<>());
            
        for(Edge e : edgeList){
            g.get(e.src).add(new Node(e.des, e.wt));
        }
    }
    public int dijkshtrasAlgorithm(int source){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] visited = new int[v+1];
        for(int i=0 ; i<visited.length ; i++){
            visited[i] = Integer.MAX_VALUE;
        }
        map.put(source, 0);
        visited[source] = 0;
        while(!map.isEmpty()){
            int currNode = map.firstKey();
            int currDistance = map.get(currNode);
            map.remove(currNode);
            for(Node node : g.get(currNode)){
                if(visited[node.val] == Integer.MAX_VALUE || 
                map.containsKey(node.val) && currDistance+node.wt < map.get(node.val))
                    map.put(node.val, currDistance+node.wt);
                visited[node.val] = map.get(node.val);
            }
        }
        for(int i=0 ; i<v+1 ; i++)
            System.out.print(visited[i] + " ");
        System.out.println();
        return visited[v];
    }
}
class Node{
    int val, wt;
    Node(int val, int wt){
        this.val = val;
        this.wt = wt;
    }
}
class Edge{
    int src, des, wt;
    Edge(int src, int des, int wt){
        this.src = src;
        this.des = des;
        this.wt = wt;
    }
}
