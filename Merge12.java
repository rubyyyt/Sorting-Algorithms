/**
 * @author Rubaiat Tazim
 * PID: A12739293
 * Date: 5/18/2018
 */
 
import java.lang.Comparable;
import java.util.List;
import java.util.ArrayList;
public class Merge12 implements Sort12 {

 /**
     * Recursive merge method
     * @param list: List of T objects with Comparable implementation
     */
 public  <T extends Comparable<? super T>> void  sort(List<T> list) {
   
   ArrayList<T> inputList = new ArrayList<T>(list);
   ArrayList<T> temp = new ArrayList<T>(list); //copies list size to myList
   
   for (int i = 0; i < list.size(); i++) { 
     temp.add(null); //adds arbitrary elements to myList 
   } 
   internalMergeSort(inputList, temp, 0, list.size() - 1); //calls internalMergeSort
   
   list.clear(); 
   list.addAll(inputList); //copies elements from inputList back into list
 }
 
 
 /**
     * Divides list so that it can be sorted into smaller lists via recursion
     * @param inputArray: input ArrayList of T objects
     *        tempArray: ArrayList to manipulate T elements w/o affecting original array
     *        first: index of first element in array
     *        last: index of last element in array
     */
 private  <T extends Comparable<? super T>> void internalMergeSort(ArrayList<T> inputArray, 
                        ArrayList<T> tempArray, int first, int last) {
   
   if (first < last) {
     int mid = (first+last)/2;
     internalMergeSort(inputArray, null, first, mid); //recursive call on first half
     internalMergeSort(inputArray, null, mid + 1, last); //recursive call on last half
     merge(inputArray, new ArrayList<T>(), first, mid, last);   
  }
 }
 

 /** 
     * Combines two sorted lists into one sorted list
     * @param inputArray: input ArrayList of T objects
     *        tempArray: ArrayList to manipulate T elements w/o affecting original array
     *        first: index of first element in array
     *        mid: index of middle element in array
     *        last: index of last element in array
     */
 private  <T extends Comparable<? super T>> void merge(ArrayList<T> inputArray, 
                        ArrayList<T> tempArray, int first, int mid, int last) {
 
  int tempFirst = first;
  int tempMid = mid + 1;
  int nelems = last - first + 1; 
  
  while (tempFirst <= mid && tempMid <= last) { 
    
   //compares elements and puts smaller element at lower index
   if (inputArray.get(tempFirst).compareTo(inputArray.get(tempMid)) <= 0) { 
     tempArray.add(inputArray.get(tempFirst));
     tempFirst++;
   }
   
   else {   
    tempArray.add(inputArray.get(tempMid));
    tempMid++;
   }
  }
 
  //adds first half of inputArray to tempArray
  while (tempFirst <= mid) { 
   tempArray.add(inputArray.get(tempFirst));
   tempFirst++;
  }
  
  //adds last half of inputArray to tempArray
  while (tempMid <= last) {
   tempArray.add(inputArray.get(tempMid));
     tempMid++;
  }
    
  //copies elements back into inputArray
    for (int i = 0; i < nelems; i++) {
    inputArray.set(first+i, tempArray.get(i));
  } 
 }
}

// vim:ts=4:sw=4:sw=78
