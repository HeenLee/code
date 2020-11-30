package com.base.数组;


/**
 * 向数组中插入一个元素。通过System的arraycopy()方法
 *  public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
 src:源数组； srcPos:源数组要复制的起始位置； dest:目的数组； destPos:目的数组放置的起始位置； length:复制的长度
 * 创建一个新数组，将老数组的元素赋值到新数组中。
 * 开始先复制一点，再在后面复制
 * @author lihe
 *
 */
public class Demo03ArrSortAndInsert {

	public static void main(String[] args) {
		//[ 1,3,4,5]  [1,0,3,4,5]
		int[] arr = {1,3,4,5};
		int[] newArr = insertElement(arr, 0, 1);
		for (int i : newArr) {
			System.out.print(i);
		}

	}
	public static int[] insertElement(int[] arr,int element,int index){
		int[] destArr = new int[arr.length + 1];
		//先把old数组的index长度复制到新数组
		System.arraycopy(arr, 0, destArr, 0, index);
		//将新的数组中赋值element
		destArr[index] = element;
		//再将老数组剩下的length - index 个元素复制到新数组
		System.arraycopy(arr, index, destArr, index + 1, arr.length - index);
		return destArr;
	}

}
