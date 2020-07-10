package 图;

/**
 * Graph类代表图
 * @author Asus
 *
 */
public class Graph {

	private Vertex[] ver;//存储顶点的数组
	private int currentSize;//存入节点的下标，默认为0
	private int[][] adjMat;//这个二维数组就是邻接矩阵 
	private MyStack stack=new MyStack();//根据这个栈来进行深度优先遍历
	private int currentIndex;//记录当前遍历的顶点的下标,默认值为0
	
	public int[][] getAdjMat() {
		return adjMat;
	}

	public void setAdjMat(int[][] adjMat) {
		this.adjMat = adjMat;
	}

	public Graph(int size) {//此构造方法用来输入数组长度,创建数组,然后根据输入的长度确定邻接矩阵这个二维数组的长度,需要输入顶点的个数
		ver=new Vertex[size];
		adjMat=new int[size][size];
	}
	
	/**
	 * 向图中存入顶点
	 * @param v
	 */
	public void add(Vertex v) {
		ver[currentSize++]=v;
	}
	
	/**
	 * 给两个顶点之间添加边，输入两个顶点
	 * @param index1
	 * @param index2
	 */
	public void addEdge(String v1,String v2) {
		int index1 = 0;
		for(int i=0;i<ver.length;i++) {//通过挨个比较数组中的数据，获取要添加边的v1的下标，将下标传给index1
			if(ver[i].getValue().equals(v1)) {
				index1=i;
				break;
			}
		}
		int index2 = 0;
		for(int i=0;i<ver.length;i++) {//通过挨个比较数组中的数据，获取要添加边的v2的下标，将下标传给index2
			if(ver[i].getValue().equals(v2)) {
				index2=i;
				break;
			}
		}
		//将邻接矩阵的对应的位置置为1，加边成功
		adjMat[index1][index2]=1;
		adjMat[index2][index1]=1;
	}
	
	/**
	 * 深度优先搜索算法
	 */
	public void des() {
		//找到最开始的顶点
		ver[0].visited=true;//将下标为0的顶点标记为已访问
		//将小标为0的元素的下标压入栈
		stack.pushData(0);
		//打印该顶点的值
		System.out.println(ver[0].getValue());
		//遍历向后找邻接顶点，直到stack栈为空
		while(stack.havaData()) {
			for(int i=currentIndex+1;i<ver.length;i++) {
				if(adjMat[currentIndex][i]==1&&ver[i].visited==false) {//二位矩阵中的值如果为1，表示和下一个顶点相通,不能取已经访问了的顶点
					//将与本顶点相桶的顶点压入栈中(这里stack设为了int，ver的值为String，所以用下标代替这个数据)
					stack.pushData(i);
					//将存入的顶点设为已访问
					ver[i].visited=true;
					System.out.println(ver[i].getValue());
					//如果这里找到了相通的顶点，就接着执行while循环，不弹出栈顶元素,可以使用continue out，使用时在while前加上out:
					//continue out;
				}
			}
			//如果上面的for循环没找到与这个顶点相通的顶点，弹出栈顶元素
			stack.popData();
			//stack栈不为空时，修改当前位置为栈顶元素的位置
			if(stack.havaData()) {
			currentIndex=stack.topData();
			}
		}
	}
}
