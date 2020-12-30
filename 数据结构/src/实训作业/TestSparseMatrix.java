package 实训作业;

public class TestSparseMatrix {
	public static void main(String[] args) {
		int[][] chessArr1 = { 
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		CompressSparseMatrix csm = Compress(chessArr1);
		System.out.println("压缩后____________________");
		System.out.println("稀疏数组的行数：" + csm.rows);
		System.out.println("稀疏数组的列数：" + csm.cols);
		System.out.println("稀疏数组非零元数：" + csm.terms);
		for (Node node : csm.datas) {
			System.out.printf("%-3d%-3d%-3d\n", node.getI(), node.getJ(), node.getV());
		}
		System.out.println("还原稀疏数组____________________");
		int[][] chessArr2=upzipSparmatrix(csm);
		for(int[] row:chessArr2){
			for(int x:row){
				System.out.printf("%-3d",x);
			}
			System.out.println();
		}
				
	}

	// 将稀疏矩阵压缩存储
	public static CompressSparseMatrix Compress(int[][] sparseArr) {
		CompressSparseMatrix csm = new CompressSparseMatrix(getTerms(sparseArr));
		csm.rows = sparseArr.length;
		csm.cols = sparseArr[0].length;
		// 找出每个非零元，将其分布信息存储在datas
		int index = 0; // 数组初始顺序号为0
		for (int i = 0; i < csm.rows; i++) {
			for (int j = 0; j < csm.cols; j++) {
				if (sparseArr[i][j] != 0) {
					Node node = new Node(i, j, sparseArr[i][j]);
					csm.datas[index] = node;
					index++;
				}
				if (index >= csm.terms) // 提前结束
					break;
			}
		}
		return csm;
	}

	// 求稀疏数组的非零元的个数
	public static int getTerms(int[][] sparseArr) {
		int terms = 0; // 初始化非零元的个数为0
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < sparseArr[0].length; j++) {
				if (sparseArr[i][j] != 0) {
					terms++;
				}
			}
		}
		return terms;
	}

	// 将压缩的稀疏矩阵还原成二维数组
	public static int[][] upzipSparmatrix(CompressSparseMatrix csm) {
		int[][] arr = new int[csm.rows][csm.cols];
		for (Node node : csm.datas) {
			// 根据每个节点保存的非零元的行列号及值，将非零元值 恢复到二维数组对应的行列位置
			arr[node.getI()][node.getJ()] = node.getV();
		}
		return arr;

	}

}

