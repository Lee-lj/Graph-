package 图;

/**
 * 顶点类
 * @author fugui
 *
 */
public class Vertex {
	
	private String value;//作为顶点，只需要存储数据
	public boolean visited;//判断这个顶点是否被访问过了，访问过了就不会再访问。默认为false

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Vertex [value=" + value + "]";
	}

	public Vertex(String value) {
		super();
		this.value = value;
	}
	
	

}
