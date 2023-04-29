import java.util.ArrayList;
import java.util.List;

public class WeightedEdgeDigraph {
    int V;
    int E;
    List<List<DirectedEdge>> adj;
    public WeightedEdgeDigraph(int V){
        this.V = V;
        adj = new ArrayList<>(V);
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
    }
    public int V(){
        return V;
    }
    public Iterable<DirectedEdge> adj(int v){
        return adj.get(v);
    }
    public void addEdge(DirectedEdge e){
        int v = e.from();
        int w = e.to();
        adj.get(v).add(e);
        adj.get(w).add(e);
    }
}
