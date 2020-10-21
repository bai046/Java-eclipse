package 算法;

/**
 * 请在此注释你的 姓名，班级，专业
 * 例如： 郭淑瑛  B190109 软件工程
 */
public class Solution {
    public static void main(String[] args) {
        //请在此测试你写的方法
        //测试第一题
        //test1();

        //测试第二题
        //test2();

        //测试第三题
        //test3();

        //测试第四题
        //test4();
    }

    /**
     * 第一题：一维数组的动态和
     */
    public static int[] runningSum(int[] nums) {
        //请在此补充代码
        //请删除下面一行代码
    	int i,j,temp=0;
        int[] rtnums=new int[nums.length];
        for(i=0;i<nums.length;i++){
            for(j=0;j<=i;j++){
                temp=temp+nums[j];
            }
            rtnums[i]=temp;
            temp=0;
        }
        return rtnums;
    }

    /**
     * 第二题：左旋转字符串
     */
    public static String reverseLeftWords(String s, int n) {
        //请在此补充代码
        //请删除下面一行代码
    // C语言
    	//char* reverseLeftWords(char* s, int n){
//  	int i = 0;
//  	int sz = strlen(s);
//  	for (i = 0; i < sz / 2; i++){
//  		char ret = *(s + i);
//  		*(s + i) = *(s + sz - 1 - i);
//  		*(s + sz - 1 - i) = ret;
//  	}
//  	for (i = 0; i < (sz - n) / 2; i++){
//  		char ret = *(s + i);
//  		*(s + i) = *(s + sz - 1 - n - i);
//  		*(s + sz - 1 - n - i) = ret;
//  	}
//  	for (i = 0; i < n / 2; i++){
//  		char ret = *(s + sz - n + i);
//  		*(s + sz - n + i) = *(s + sz - 1 - i);
//  		*(s + sz - 1 - i) = ret;
//  	}
//  	return s;
//  }    
//  int main(){
//  	char s[] = "lrloseumgh";
//  	int n = 0;
//  	scanf("%d", &n);
//  	reverseLeftWords(s,n);
//  	printf("%s\n", s);
//  	return 0;
//  }
    	return s;
    }

    /**
     * 第三题：存在重复3次的元素
     */
    public static boolean containsDuplicate(int[] nums) {
        //请在此补充代码
        //请删除下面一行代码
        return false;
    }

    /**
     * 第四题：反转字符串
     */
    public static char[] reverseString(char[] s) {
        //请在此补充代码
        //请删除下面一行代码
    	 int begin =0;
         int end =s.length-1;
         while(begin<end){
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin++;
            end--;
         }
         return s;
    }




    //以下的代码为测试代码，不用阅读，可以忽略
    //以下的代码为测试代码，不用阅读，可以忽略
    //以下的代码为测试代码，不用阅读，可以忽略
    public static void test1() {
        int[] nums = {1, 2, 3, 4};
        int[] result = runningSum(nums);
        System.out.println("你的第一题的输入为：[1, 2, 3, 4]");
        System.out.print("你的第一题输出为：");
        printIntElements(result);
    }

    public static void test2() {
        //第二题
        String s = "abcdefg";
        int k = 2;
        System.out.println("你的第二题输入为:s = \"abcdefg\", k = 2");
        System.out.println("你的第二题输出为：" + reverseLeftWords(s, k));
    }

    public static void test3() {
        int[] array1 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        int[] array2 = {1, 2, 3, 1};
        System.out.println("你的第三题输入1为：[1, 1, 1, 3, 3, 4, 3, 2, 4, 2]");
        System.out.println("你的第三题输出1为：" + containsDuplicate(array1));
        System.out.println("你的第三题输入2为：[1, 2, 3, 1]");
        System.out.println("你的第三题输出2为：" + containsDuplicate(array2));
    }

    public static void test4() {
        char[] charArray = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("你的第四题输入为：");
        printElements(charArray);
        char[] reverseResult = reverseString(charArray);
        System.out.println("你的第四题输出为：");
        printElements(reverseResult);
    }

    public static void printElements(char[] charArray) {
        System.out.print("[");
        for (int i = 0; i < charArray.length; i++) {
            if (i == charArray.length - 1) {
                System.out.print(charArray[i]);
            } else {
                System.out.print(charArray[i] + ",");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    public static void printIntElements(int[] charArray) {
        System.out.print("[");
        for (int i = 0; i < charArray.length; i++) {
            if (i == charArray.length - 1) {
                System.out.print(charArray[i]);
            } else {
                System.out.print(charArray[i] + ",");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}

