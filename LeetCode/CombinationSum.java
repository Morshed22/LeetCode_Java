import javax.swing.*;
import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        System.out.println(sum.combinationSum2(new int[]{2,5,2,1,2}, 5));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        return combinationList(list, new ArrayList<Integer>(), candidates, target, 0);
    }

    private List<List<Integer>> combinationList(List<List<Integer>> list, List<Integer> midList, int[] candidates, int target, int index) {

        if (target == 0) {
            list.add(new ArrayList<>(midList));
            return list;
        }
        for (int i = index; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            System.out.println(candidates[i]);
            if (newTarget >= 0) {
                midList.add(candidates[i]);
                combinationList(list, midList, candidates, newTarget, i);
                //now have to remove the last item and it will generate new combination with rest ones
                midList.remove(midList.size() - 1);
            } else {
                //it will stop the loop for making combination it its (>) than target.
                break;
            }
        }
        return list;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        return combinationList2(list, new ArrayList<Integer>(), candidates, target, 0);
    }

    private List<List<Integer>> combinationList2(List<List<Integer>> list, List<Integer> midList, int[] candidates, int target, int index) {
        if (target == 0) {
            list.add(new ArrayList<>(midList));
            return list;
        }
        for (int i = index; i < candidates.length; i++) {

            int newTarget = target - candidates[i];
            if (newTarget >= 0){
                midList.add(candidates[i]);
                combinationList2(list, midList, candidates, newTarget, i + 1);
                 midList.remove(midList.size()-1);
            }else {
                break;
            }
            while (i < candidates.length-1 && candidates[i] == candidates[i+1]){
                i = i+1;
            }
        }
        return list;
    }
}
