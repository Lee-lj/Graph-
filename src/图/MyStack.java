package 图;

public class MyStack {

	//栈的底层使用数组来存储数据,栈就是压子弹，先进后出，后进先出
		int[] elements;
		
		public MyStack() {
			elements = new int[0];
		}
		
		//向栈中压入元素
		public void pushData(int element) {
			int[] newarray=new int[elements.length+1];
			for(int i=0;i<elements.length;i++) {
				newarray[i]=elements[i];
			}
			newarray[elements.length]=element;
			elements=newarray;//类似于向数组中加入元素的方法，向最后位置插入数据element
		}

		//取出栈顶元素
		public int popData() {
			//取出栈顶元素:相当于数组的最后一个元素
			if(elements.length==0) {//因为后面length-1，所以如果长度为0，就直接抛出异常
				throw new RuntimeException("stack is empty");
			}
			int element=elements[elements.length-1];
			int[] array=new int[elements.length-1];
			for(int i=0;i<elements.length-1;i++) {
				array[i]=elements[i];
			}
	        elements=array;
	        return element;//返回取到的栈顶元素
		}
		
		//判断栈是否为空
		public boolean havaData() {
			/*if(elements.length>0) {
				return true;
			}else {
				return false;
			}*/
			return elements.length==0?false:true;
		}
		
		//查看栈顶元素
		public int topData() {
			return elements[elements.length-1];
		}
}
