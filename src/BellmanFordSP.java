import java.util.Stack;

public class BellmanFordSP {
    double[] distTo;
    DirectedEdge[] edgeTo;
    public BellmanFordSP(WeightedEdgeDigraph G, int s){
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        for(int v = 0; v < G.V(); v++){
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0;
        for(int i = 0; i < G.V()-1; i++) {
            for (int v = 0; v < G.V(); v++) {
                for(DirectedEdge e : G.adj(v)){
                    relax(e);
                }
            }
        }
    }
    public int distTo(int v){
        return (int) distTo[v];
    }
    public void relax(DirectedEdge e){
        int w = e.to();
        int v = e.from();

        if(distTo[w] > distTo[v] + e.weight()){
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }
    public boolean hasPathTo(int v){
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int w){
        if(!hasPathTo(w)){
            return null;
        }
        Stack<DirectedEdge> stack = new Stack<>();

        for(DirectedEdge e = edgeTo[w]; e != null; e = edgeTo[e.from()]){
            stack.push(e);
        }
        return stack;
    }
}
