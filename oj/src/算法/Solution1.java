package 算法;


//2019灞� B190109   閮窇鐟�
/**
* 閻犲洤鍢插﹢顏勵潰閵堝棙鏆堥梺鎻掞梗缂嶆﹢鎯冮敓锟� 濠殿喗鎸搁幃鏇㈡晬瀹�锟借ぐ顔剧棯瑜濈槐婵囩▔閹捐尙鐟�
* 濞撴艾顑呴々褔鏁嶉敓锟� 鐎殿喚濮崇粭锟�  B190101 閺夌儐鍨▎銏狀啅閵壯�鏌�
*/
public class Solution1 {
  public static void main(String[] args) {
      //閻犲洤鍢插﹢顏勵潰閵堝棛銈撮悹鍥ㄦ磻缂嶆﹢宕樺▎鎴炵暠闁哄倽顫夌涵锟�
      //婵炴潙顑堥惁顖滅箔椤戣法顏卞Λ甯嫹
      //test1();

      //婵炴潙顑堥惁顖滅箔椤戣法鐧屽Λ甯嫹
      //test2();

      //婵炴潙顑堥惁顖滅箔椤戣法鐟忓Λ甯嫹
      //test3();

      //婵炴潙顑堥惁顖滅箔椤掞拷濞叉挻锛愰敓锟�
      //test4();
  }

  /**
   * 缂佹鍏涚粩瀛橈紣濮楀牏绐楀☉鎿勬嫹缂備礁鐡ㄩ弳鐔虹磼閸曨厽鐣遍柛鏂诲妽閿熸垝绀侀幏锟�
   */
  public static int[] runningSum(int[] nums) {
      //閻犲洤鍢插﹢顏勵潰閵堝煻澶愬礂閸涱剙鏁╅柣顕嗘嫹
      //閻犲洤鍢查崹褰掓⒔閵堝嫮鐟撻梻鍫線缁斿鎮扮仦鐓庢暕闁活噯鎷�
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
   * 缂佹鍏涚花鈺傦紣濮楀牏绐楃�归潻闄勫Λ鍡樻姜椤掞拷閻⊙呯箔閿旇儻顩�
   */
//  //缁楊兛绨╂０妤ョ拠顓♀枅
//  char* reverseLeftWords(char* s, int n){
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

  /**
   * 缂佹鍏涚粭浣癸紣濮楀牏绐楅悗娑櫭﹢顏堟煂瀹ュ拋妲�3婵炲棴绱曞▓鎴﹀礂閸愵亞顦�
   */
  public static boolean containsDuplicate(int[] nums) {
      //閻犲洤鍢插﹢顏勵潰閵堝煻澶愬礂閸涱剙鏁╅柣顕嗘嫹
      //閻犲洤鍢查崹褰掓⒔閵堝嫮鐟撻梻鍫線缁斿鎮扮仦鐓庢暕闁活噯鎷�
      return false;
  }

  /**
   * 缂佹鍓欏ú鎾达紣濮楀牏绐楅柛娆忕Х濞村棛锟芥稒顨堥浣圭▔閿燂拷
   */
  public static char[] reverseString(char[] s) {
      //閻犲洤鍢插﹢顏勵潰閵堝煻澶愬礂閸涱剙鏁╅柣顕嗘嫹
      //閻犲洤鍢查崹褰掓⒔閵堝嫮鐟撻梻鍫線缁斿鎮扮仦鐓庢暕闁活噯鎷�
          int begin =0;
          int end =s.length-1;
          while(begin<end){
             char temp = s[begin];
             s[begin] = s[end];
             s[end] = temp;
             begin++;
             end--;
          }
          return;
  }




  //濞寸姰鍎扮粭鍛存儍閸曨亜鏁╅柣顔绘鐠愮喎霉鐎ｎ厾妲稿ù鐙呯悼閻栨粓鏁嶇仦鑲╃憹闁烩偓鍔戝Σ鍕嫚娴兼瑧绀夐柛娆樺灟娴滄帟绠涢悾灞炬
  //濞寸姰鍎扮粭鍛存儍閸曨亜鏁╅柣顔绘鐠愮喎霉鐎ｎ厾妲稿ù鐙呯悼閻栨粓鏁嶇仦鑲╃憹闁烩偓鍔戝Σ鍕嫚娴兼瑧绀夐柛娆樺灟娴滄帟绠涢悾灞炬
  //濞寸姰鍎扮粭鍛存儍閸曨亜鏁╅柣顔绘鐠愮喎霉鐎ｎ厾妲稿ù鐙呯悼閻栨粓鏁嶇仦鑲╃憹闁烩偓鍔戝Σ鍕嫚娴兼瑧绀夐柛娆樺灟娴滄帟绠涢悾灞炬
  public static void test1() {
      int[] nums = {1, 2, 3, 4};
      int[] result = runningSum(nums);
      System.out.println("濞达絿濮峰▓鎴犵箔椤戣法顏卞Λ鐗堫焽濞堟垶娼忛幘鍐插汲濞戞挾灏ㄧ槐鐧�1, 2, 3, 4]");
      System.out.print("濞达絿濮峰▓鎴犵箔椤戣法顏卞Λ鐗堫焾缁额參宕欐潪鎷岀闁挎冻鎷�");
      printIntElements(result);
  }

  public static void test2() {
      //缂佹鍏涚花鈺傦紣閿燂拷
      String s = "abcdefg";
      int k = 2;
      System.out.println("濞达絿濮峰▓鎴犵箔椤戣法鐧屽Λ鐗堫焾缁额參宕楅妷銈堢:s = \"abcdefg\", k = 2");
      System.out.println("濞达絿濮峰▓鎴犵箔椤戣法鐧屽Λ鐗堫焾缁额參宕欐潪鎷岀闁挎冻鎷�" + reverseLeftWords(s, k));
  }

  public static void test3() {
      int[] array1 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
      int[] array2 = {1, 2, 3, 1};
      System.out.println("濞达絿濮峰▓鎴犵箔椤戣法鐟忓Λ鐗堫焾缁额參宕楅敓锟�1濞戞挾灏ㄧ槐鐧�1, 1, 1, 3, 3, 4, 3, 2, 4, 2]");
      System.out.println("濞达絿濮峰▓鎴犵箔椤戣法鐟忓Λ鐗堫焾缁额參宕欓敓锟�1濞戞挾灏ㄧ槐锟�" + containsDuplicate(array1));
      System.out.println("濞达絿濮峰▓鎴犵箔椤戣法鐟忓Λ鐗堫焾缁额參宕楅敓锟�2濞戞挾灏ㄧ槐鐧�1, 2, 3, 1]");
      System.out.println("濞达絿濮峰▓鎴犵箔椤戣法鐟忓Λ鐗堫焾缁额參宕欓敓锟�2濞戞挾灏ㄧ槐锟�" + containsDuplicate(array2));
  }

  public static void test4() {
      char[] charArray = {'h', 'e', 'l', 'l', 'o'};
      System.out.println("濞达絿濮峰▓鎴犵箔椤掞拷濞叉挻锛愬Ο璺ㄧ炕闁稿繈鍎扮拹鐔兼晬閿燂拷");
      printElements(charArray);
      char[] reverseResult = reverseString(charArray);
      System.out.println("濞达絿濮峰▓鎴犵箔椤掞拷濞叉挻锛愬Ο璺ㄧ炕闁告垼妗ㄧ拹鐔兼晬閿燂拷");
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

