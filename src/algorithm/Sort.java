package algorithm;

import org.omg.PortableInterceptor.INACTIVE;

import java.text.SimpleDateFormat;
import java.util.*;

public class Sort {
    /**
     * 冒泡排序
     * @param list
     * @return
     */
    public List<Integer> BubbleSort(List<Integer> list){
        List<Integer> result = new ArrayList<>(list);
        for(int i = 0; i< result.size();i++){
            for(int j = 0 ; j< result.size()-1;j++){
                if(result.get(j)> result.get(j+1)){
                    int temp = result.get(j);
                    result.set(j, result.get(j+1));
                    result.set(j+1, temp);
                }
            }
        }
        return result;
    }

    /**
     * 选择排序
     * @param list
     * @return
     */
    public List<Integer> SelectSort(List<Integer> list){
        List<Integer> result = new ArrayList<>(list);
        for(int i = 0; i< result.size();i++){
            int id = i , min = result.get(i);
            for(int j = i;j<result.size();j++){
                if(min > result.get(j)){
                    min = result.get(j);
                    id = j;
                }
            }
            int temp = result.get(i);
            result.set(i, min);
            result.set(id, temp);
        }
        return result;
    }

    /**
     * 插入排序
     * @param list
     * @return
     */
    public List<Integer> InsertSort(List<Integer> list){
        List<Integer> result = new ArrayList<>(list);
        for(int i = 1;i<result.size();i++){
            for(int j = 0;j<i;j++){
                if(result.get(i) < result.get(j)){
                    int temp = result.get(i);
                    for(int id = i; id>j;id--){
                        result.set(id, result.get(id-1));
                    }
                    result.set(j, temp);
                }
            }
        }
        return result;
    }

    /**
     * 快速排序
     * @param list
     * @return
     */
    public List<Integer> FastSort(List<Integer> list){
        List<Integer> result = new ArrayList<>(list);
        if(result.size() <= 1){
            return result;
        }
        int i = 1, j = result.size()-1, base = 0;
        while(i != j){
            if(result.get(j) < result.get(0)){
                if(result.get(i) > result.get(0)){
                    int temp = result.get(j);
                    result.set(j, result.get(i));
                    result.set(i, temp);

                }else{
                    i ++;
                }
            }else{
                j--;
            }
        }
        if(result.get(i) <= result.get(base)) {
            int temp = result.get(i);
            result.set(i, result.get(base));
            result.set(base, temp);
            base = i;
        }
//        System.out.println(list.toString() + ":" + result.toString());
        List<Integer> r = new ArrayList<>();
        r.addAll(FastSort(result.subList(0, base)));
        r.add(result.get(base));
        r.addAll(FastSort(result.subList(base+1,result.size())));

        return r;
    }

    public List<Integer> HeapSort(List<Integer> list){
        List<Integer> result = new ArrayList<>(list);
        String temp_result_str = result.toString();
        if(result.size() <= 1)
            return result;
        for(int i = result.size()-1;i>=0;i--)
           adjHeap(result, i);
        System.out.println(temp_result_str + " : " + result.toString());
        //result为大顶堆
        int temp  = result.get(result.size()-1);
        result.set(result.size()-1, result.get(0));
        result.set(0, temp);

        List<Integer> r = new ArrayList<>();
        r.addAll(HeapSort(result.subList(0, result.size()-1)));
        r.add(result.get(result.size()-1));
        return r;
    }
    private void adjHeap(List<Integer> list, int id){
        int i = id;
        while(i<list.size()){
            int lid = i * 2 + 1;
            int rid = i * 2 + 2;
            if(lid < list.size() && rid < list.size()) {
                if(list.get(id) < list.get(lid) || list.get(id) < list.get(rid)){
                    if(list.get(lid) > list.get(rid)){
                        swap(list, id, lid);
                        id = lid;
                    }else{
                        swap(list, id, rid);
                        id = rid;
                    }
                }else
                    break;
            }else if(lid < list.size()){
                if(list.get(id) < list.get(lid)){
                    swap(list, id, lid);
                    id = lid;
                }else{
                    break;
                }
            }else
                break;
        }
    }

    private void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args){
        Sort s = new Sort();
        List<Integer> list = new ArrayList<>();
        list.add(5);list.add(3);list.add(8);list.add(6);list.add(4);list.add(1);list.add(2);
        System.out.println(s.BubbleSort(list));
        System.out.println(s.SelectSort(list));
        System.out.println(s.InsertSort(list));
        System.out.println(s.FastSort(list));
        System.out.println(s.HeapSort(list));
        System.out.println(list);
    }
}
