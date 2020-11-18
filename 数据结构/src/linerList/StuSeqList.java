package linerList;

public class StuSeqList {
//数据集合存储，基本数组类型.以类名作为数据类型
	//任何一个变量没有初始化就没法用
private Student[] students;
private int maxlength;//最大长度
private int length;//当前长度

public StuSeqList(int maxlength,int length) {
    this.length=length;
    this.maxlength=maxlength;
    initate(maxlength);
}
private void initate(int maxlength)
{
  students =new Student[maxlength];
}
public int length()
{
  return length;
}
public int maxlength()
{
  return maxlength;
}

public boolean insert(int index,Student student)
{
	boolean suc=false;
	if(index<0||index>length)
	{
		System.out.print("插入位置有错");
		return suc;
	}
	if(length+1 >maxlength)
	{
		System.out.print("线性表已满");
		return suc;	
	}
	length++;
	for(;index<length;index++)
	{
		Student temp =students[index];
		students[index]=student;
		student=temp;
		suc=true;
		
		}
	return suc;
	
}

}
