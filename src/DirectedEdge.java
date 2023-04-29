public class DirectedEdge {
    int from;
    int to;
    int weight;

    public DirectedEdge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    public int to(){
        return to;
    }
    public int from(){
        return from;
    }
    public int weight(){
        return weight;
    }
}
