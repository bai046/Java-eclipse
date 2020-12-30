package 实训作业;

//压缩稀疏矩阵，保存原始矩阵的行，列，非零元个数，及非零元的分布
public class CompressSparseMatrix {
	int rows;	//原始矩阵的行数
	int cols;	//原始矩阵的列数
	int terms;	//原始矩阵中非零元个数
	Node[] datas;	//非零元数组，三元组表
	public CompressSparseMatrix(int terms) {
		super();
		this.terms = terms;
		datas= new Node[terms];
	}
}
//存储每个非零元的分布信息，行，列，值 
class Node{
	private int i;		//存储非零元的行号
	private int j;		//存储非零元的列号
	private int v;		//存储非零元的值
	public Node(int i, int j, int v) {
		super();
		this.i = i;
		this.j = j;
		this.v = v;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	
}

