package cycle_sequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 19.11.2014.
 */
public class Solution {
    private Set<CycleSequence> sequencesList = new HashSet<CycleSequence>();

    public static void main(String[] args) {


    }

    public static class CycleSequence{
        private ArrayList<Integer> list;

        public CycleSequence(int[] arr){
            list = new ArrayList<Integer>(arr.length);
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }

        }

        public ArrayList getList(){
            return list;
        }

        public boolean equals(CycleSequence cycle){
            if(list.size() != cycle.getList().size()) return false;

            for (int i = 0; i < list.size(); i++) {
                ArrayList<Integer> tempList = new ArrayList<Integer>();
                for (int j = 0; j < list.size(); j++) {
                    tempList.add(list.get((i + j)%list.size()));
                }
                if(tempList.equals(cycle.getList())) return true;
            }

            return false;
        }
    }

    public static void generateSequences(int r, int n, Set<CycleSequence> seqList){

    }


}
