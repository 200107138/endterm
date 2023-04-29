import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int v = scanner.nextInt();
        int k = scanner.nextInt();
        WeightedEdgeDigraph G = new WeightedEdgeDigraph(1000);

        for(int i = 0; i< m; i++){
            int xi = scanner.nextInt();

            int yi = scanner.nextInt();

            int ti = scanner.nextInt();

            G.addEdge(new DirectedEdge(yi, xi, ti));
            G.addEdge(new DirectedEdge(xi, yi, ti));
        }
        int weight = 0;
        BellmanFordSP sp = new BellmanFordSP(G, s);
        List<DirectedEdge> edges = new ArrayList<>();
        for(DirectedEdge e : sp.pathTo(v)){
            if(e.weight> weight){
                weight = e.weight();
            }
            edges.add(e);
        }


        System.out.println(weight-k);
    }
}