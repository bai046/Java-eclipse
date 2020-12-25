package 二分查找;

import java.util.ArrayList;

//分块查找
public class BlockSearch {

  //用于存放临界点
  private int[] index;
  //用于存放各个区间容器的地址
  private ArrayList[] list;

  //有参构造方法
  public BlockSearch(int[] index) {
      if (null != index && index.length != 0) {
          this.index = index;
          this.list = new ArrayList[index.length + 1];
          for (int i = 0; i < list.length; i++) {
              list[i] = new ArrayList();//初始化容器
          }
      }
  }

  //插入索引
  public void insert(int value) {
      //通过二分查找快速定位到该数组的目标区间0,1,2,3
      int i = binarySearch(value);
      list[i].add(value);
  }

  //二分法查找
  private int binarySearch(int value) {
      //index数组起始角标为0
      int start = 0;
      //index数组终止角标为2
      int end = index.length - 1;
      int mid = -1;
      //目标值应该存放的区间
      int fenqushu = -1;
      while (start <= end) {
          mid = (start + end) / 2;
          if (index[mid] > value) {
              end = mid - 1;
              //当start==end，如果小于index[mid]，end = mid - 1;之后不符合条件
              fenqushu = start;
          } else {
              //如果相等，插入后面
              start = mid + 1;
              //当start==end，如果大于index[mid]，start = mid + 1;之后不符合条件
              fenqushu = start;
          }
      }
      return fenqushu;
  }

  //查找元素
  public boolean search(int data) {
      //确定该元素在哪个分区
      int i = binarySearch(data);
      //遍历该分区的元素进行查找
      for (int j = 0; j < list[i].size(); j++) {
          if (data == (int) list[i].get(j)) {
              System.out.println(String.format("查找元素为第: %d块  第%d个 元素", i, j));
              return true;
          }
      }
      return false;
  }

  //打印每块的元素
  public void printAll() {
      for (int i = 0; i < list.length; i++) {
          ArrayList l = list[i];
          System.out.print("ArrayList[" + i + "]:");

          for (int j = 0; j < l.size(); j++) {
              System.out.print(l.get(j) + "    ");
          }
          System.out.println("\n");
      }
  }

  //测试
  public static void main(String[] args) {
      //设置三个分界点，四个区间
      int[] index = {10, 20, 30};
      //利用构造方法创建各个组的区间，用于存放符合该区间的数据
      BlockSearch blocksearch = new BlockSearch(index);
      //插入数据，会根据数据的大小插入相对应的区间
      blocksearch.insert(1);
      blocksearch.insert(11);
      blocksearch.insert(21);
      blocksearch.insert(2);
      blocksearch.insert(12);
      blocksearch.insert(22);
      blocksearch.insert(5);
      blocksearch.insert(15);
      blocksearch.insert(25);
      blocksearch.insert(31);

      //输出各个区间中的值
      blocksearch.printAll();

      //查找值是否存在
      System.out.println("查找值15   结果" + blocksearch.search(15) + "\n");
      System.out.println("查找值29   结果" + blocksearch.search(29) + "\n");
  }
}
