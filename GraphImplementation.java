import java.util.*;


public class GraphImplementation implements Graph
{
    int[][] matrix;
    int size;
    List<Integer> sortedList;

    public GraphImplementation(int vertices) {
        size = vertices;
        matrix = new int[size][size];
        sortedList = new ArrayList<>();
    }

    public void addEdge(int x, int y) throws Exception {
        matrix[x][y]++;
    }

    public List<Integer> topologicalSort() {
        int[] n = new int[size];
        for (int j=0; j<size; j++) {
            for (int i=0; i<size; i++) {
                if (matrix[i][j] == 1) {
                    n[j]++;
                }
            }
        }

        while (sortedList.size() != size) {
            for (int i=0; i<n.length; i++) {
                if (n[i] == 0) {
                    sortedList.add(i);
                    n[i] = -1;
                    for (int j=0; j<size; j++) {
                        if (matrix[i][j] != 0) {
                            n[j]--;
                        }
                    }
                }
            }
        }

        return sortedList;

    }

    public List<Integer> neighbors(int vertex) throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<size; i++) {
            if (matrix[vertex][i] == 1) {
                list.add(i);
            }
        }
        return list;
    }
}