import java.util.Scanner;

public class Graphs {
    public static class Graph{
        int[][]graph;
        public Graph(int n , int m){
            Scanner scanner = new Scanner(System.in);
            this.graph = new int[n][n];
            System.out.println("enter edges between vertices");
            for(int i=0;i<m;i++){
                System.out.println("enter the src:");
                int src = scanner.nextInt();
                System.out.println("enter the destination:");
                int dest = scanner.nextInt();
                graph[src][dest] = 1;
                graph[dest][src] = 1;
            }
        }

    }
    public static void main(String[]args){
        int n;
        int m;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter number of vertices:");
        n = scanner.nextInt();
        System.out.println("enter number of edges:");
        m = scanner.nextInt();
        Graph graph = new Graph(n,m);



    }
}
