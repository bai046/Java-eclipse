package com.bean.sortedbinarytreedemo;
import java.util.Iterator;
import java.util.NoSuchElementException;
 class TreeNode<E> {

    E element;  
    TreeNode<E> parent;  
    TreeNode<E> leftChild;  
    TreeNode<E> rightChild;  


    public TreeNode(E element, TreeNode<E> parent) {  
        this.element = element;  
        this.parent = parent;
    
    }  

    public TreeNode() {  
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public TreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }  


}

public class BinarySortTree<E> {
    // 根节点  
    private TreeNode<E> root = null;  
    // 树中元素个数  
    private int size = 0;  
    //空构造方法
    public BinarySortTree() {  

    }  
    //统计二叉树中的节点数
    public int countSize() {  
        return size;  
    }  
    //获得节点元素的值
    public E getRoot() {  
        return root == null ? null : root.element;  
    }  

    /** 
     * 递归实现: 查找指定元素element是否在树中存在，如果查找失败确认其添加的位置,查找成功直接返回 
     * @param t 表示从此节点开始往下查找 
     * @param f 保存t的父节点 
     * @param p 若查找成功p指向此数据元素节点，否则返回查找路径上的最后一个节点 
     */  
    private boolean searchBST(TreeNode<E> t, Object element, TreeNode<E> f, TreeNode<E> p) {  
        if (t == null) {  
            p = f;  
            return false;  
        }  
        Comparable<? super E> e = (Comparable<? super E>) element;  
        int cmp = e.compareTo(t.element);  
        if (cmp < 0) {  
            return searchBST(t.leftChild, element, t, p);  
        } else if (cmp > 0) {  
            return searchBST(t.rightChild, element, t, p);  
        } else {  
            p = t;  
            return true;  
        }  
    }  

    /** 
     * 非递归实现 
     */  
    private boolean searchBST(Object element, TreeNode<E>[] p) {  
        Comparable<? super E> e = (Comparable<? super E>) element;  
        TreeNode<E> parent = root;  
        TreeNode<E> pp = null;  
        // 保存parent父节点  
        while (parent != null) {  
            int cmp = e.compareTo(parent.element);  
            pp = parent;  
            if (cmp < 0) {  
                parent = parent.leftChild;  
            } else if (cmp > 0) {  
                parent = parent.rightChild;  
            } else {  
                p[0] = parent;  
                return true;  
            }  
        }  
        p[0] = pp;  
        return false;  
    }  

    /** 
     * 首先查找二叉排序树，如果找不到指定元素 则插入到二叉树中 
     */  
    public boolean add(E element) {  
        TreeNode<E> t = root;  
        if (t == null) {  
            // 如果根节点为空  
            root = new TreeNode<E>(element, null);  
            size = 1;  
            return false;  
        }  
        Comparable<? super E> e = (Comparable<? super E>) element;  
        TreeNode[] p = new TreeNode[1];  
        if (!searchBST(element, p)) {  
            // 查找失败，插入元素  
            TreeNode<E> s = new TreeNode<E>(element, p[0]);  
            int cmp = e.compareTo((E) p[0].element);  
            if (cmp < 0) {  
                p[0].leftChild = s;  
            }  
            if (cmp > 0) {  
                p[0].rightChild = s;  
            }  
            size++;  
            return true;  
        }  
        return false;  
    }  

    /** 
     * 移除节点，同时调整二叉树使之为二叉排序树 实现原理：  
     * 假设要删除的节点为p，其父节点为f，而p是f的左节点 分三种情况讨论: 
     * 1.若p为叶子节点，直接删除  
     * 2.若p有只有一个左孩子或者一个右孩子，则删除p，使PL或者PR为f的左子树 
     * 3.若p的左右子树均不为空，由二叉排序树的特点可知在删除p前，中序遍历此二叉树 
     * 可以得到一个有序序列，在删去p后为了保持其他元素的相对位置不变，可以这样做： 
     * 令p的直接前驱(或直接后继)替代p，然后删除其直接前驱或直接后继。其直接前驱可由 中序遍历的特点获得 
     */  
    public boolean remove(Object o) {  
        TreeNode<E>[] p = new TreeNode[1];  
        if (searchBST(o, p)) {  
            deleteTreeNode(p[0]); // 查找成功，删除元素  
            return true;  
        }  
        return false;  
    }  

    private void deleteTreeNode(TreeNode<E> p) {  
        size--;  
        if (p.leftChild != null && p.rightChild != null) { // 如果p左右子树都不为空，找到其直接后继，替换p  
            TreeNode<E> s = successor(p);  
            p.element = s.element;  
            p = s;  
        }  
        TreeNode<E> replacement = (p.leftChild != null ? p.leftChild : p.rightChild);  

        if (replacement != null) { // 如果其左右子树有其一不为空  
            replacement.parent = p.parent;  
            if (p.parent == null) // 如果p为root节点  
                root = replacement;  
            else if (p == p.parent.leftChild) // 如果p是左孩子  
                p.parent.leftChild = replacement;  
            else  
                p.parent.rightChild = replacement; // 如果p是右孩子  

            p.leftChild = p.rightChild = p.parent = null; // p的指针清空  

        } else if (p.parent == null) { // 如果全树只有一个节点  
            root = null;  
        } else { // 左右子树都为空,p为叶子节点  
            if (p.parent != null) {  
                if (p == p.parent.leftChild)  
                    p.parent.leftChild = null;  
                else if (p == p.parent.rightChild)  
                    p.parent.rightChild = null;  
                p.parent = null;  
            }  
        }  

    }  

    /** 
     * 返回以中序遍历方式遍历树时，t的直接后继 
     */  
    static <E> TreeNode<E> successor(TreeNode<E> t) {  
        if (t == null)  
            return null;  
        else if (t.rightChild != null) {  
            TreeNode<E> p = t.rightChild; // 往右，然后向左直到尽头  
            while (p.leftChild != null)  
                p = p.leftChild;  
            return p;  
        } else { // rightChild为空，如果t是p的左子树，则p为t的直接后继  
            TreeNode<E> p = t.parent;  
            TreeNode<E> ch = t;  
            while (p != null && ch == p.rightChild) {  
                ch = p; // 如果t是p的右子树，则继续向上搜索其直接后继  
                p = p.parent;  
            }  
            return p;  
        }  
    }  

    public Iterator<E> itrator() {  
        return new BinarySortIterator();  
    }  

    /** 
     * 返回中序遍历此树的迭代器 
     */  
    private class BinarySortIterator implements Iterator<E> {  
        TreeNode<E> next;  
        TreeNode<E> lastReturned;  

        public BinarySortIterator() {  
            TreeNode<E> s = root;  
            if (s != null) {  
                while (s.leftChild != null) {  
                    s = s.leftChild; // 找到中序遍历的第一个元素  
                }  
            }  
            next = s; // 赋给next  
        }  

        @Override  
        public boolean hasNext() {  
            return next != null;  
        }  

        @Override  
        public E next() {  
            TreeNode<E> e = next;  
            if (e == null)  
                throw new NoSuchElementException();  
            next = successor(e);  
            lastReturned = e;  
            return e.element;  
        }  

        @Override  
        public void remove() {  
            if (lastReturned == null)  
                throw new IllegalStateException();  
            if (lastReturned.leftChild != null && lastReturned.rightChild != null)  
                next = lastReturned;  
            deleteTreeNode(lastReturned);  
            lastReturned = null;  
        }  
    }  


    // 测试代码
    public static void main(String[] args) {  
        BinarySortTree<Integer> tree = new BinarySortTree<Integer>();  
       // tree.add(62);  
        //tree.add(15);  
       // tree.add(68);  
        //tree.add(12);  
        tree.add(13); 
        tree.add(2);  
        tree.add(18);
        tree.add(29);
        tree.add(4);  
        tree.add(6);  
        tree.add(79);   
    

        System.out.println("root=" + tree.getRoot());  
        System.out.println("二叉树的中序遍历：");
        Iterator<Integer> it = tree.itrator();  
        while (it.hasNext()) {  
            System.out.print(it.next()+"\t");  
        }  
        System.out.println();
        System.out.println(tree.countSize()); 
        System.out.println("插入一个节点 68");
        tree.add(68);
        System.out.println("root=" + tree.getRoot());  
        System.out.println("二叉树的中序遍历：");
        Iterator<Integer> it2 = tree.itrator();  
        while (it2.hasNext()) {  
            System.out.print(it2.next()+"\t");  
        }  
        System.out.println();
        System.out.println(tree.countSize());  
        System.out.println("删除18");
        tree.remove(18);
        System.out.println("root=" + tree.getRoot());  
        System.out.println("二叉树的中序遍历：");
        Iterator<Integer> it3 = tree.itrator();  
        while (it3.hasNext()) {  
            System.out.print(it3.next()+"\t");  
        }  
        System.out.println();
        System.out.println(tree.countSize()); 
//        tree.remove(18);
     //   tree.remove(65);
      //  tree.remove(68);
     //   tree.remove(79);
    //    System.out.println("root=" + tree.getRoot());  
     //   System.out.println("二叉树的中序遍历：");
     //   Iterator<Integer> it4 = tree.itrator();  
      //  while (it4.hasNext()) {  
        //    System.out.print(it4.next()+"\t");  
     //   }  
    //    System.out.println();
    //    System.out.println(tree.countSize()); 
    }  

}