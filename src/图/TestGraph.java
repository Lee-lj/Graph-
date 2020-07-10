package 图;

import java.util.Arrays;

public class TestGraph {

	public static void main(String[] args) {
		Vertex v1=new Vertex("A");
		Vertex v2=new Vertex("B");
		Vertex v3=new Vertex("C");
		Vertex v4=new Vertex("D");
		Vertex v5=new Vertex("E");
		
		Graph g=new Graph(5);
		
		//增加顶点
		g.add(v1);
		g.add(v2);
		g.add(v3);
		g.add(v4);
		g.add(v5);

		//增加边
		g.addEdge("A", "B");
		g.addEdge("A", "C");
		g.addEdge("B", "D");
		g.addEdge("B", "E");
		g.addEdge("B", "C");
		
		int[][] x=g.getAdjMat();
		for(int[] a:x) {
			System.out.println(Arrays.toString(a));
		}
		
		//深度优先遍历法
		g.des();
	}

}
