import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class LIS {

    public void Longest_Increasing_Subsequence (List<Integer> seq) {

        int sz = seq.size();

        List<List<Integer>> seq_list;

        seq_list = new ArrayList<>(sz);
        for (int i=0; i<sz; i++) {
            seq_list.add(new ArrayList<Integer>(sz));
        }

        seq_list.get(0).add(seq.get(0));

        for (int b=1; b<sz; b++) {

            for (int a=0; a<b; a++) {

                if ( seq.get(b) > seq.get(a) && (seq_list.get(b).size() < seq_list.get(a).size()) ) {
                     seq_list.get(b).clear();
                     for (Integer i : seq_list.get(a)) {
                         seq_list.get(b).add(i);
                     }
                }
            }
           seq_list.get(b).add(seq.get(b));
        }

        System.out.println("Given sequence...");
        for(Integer i : seq)
            System.out.print(i + " ");

        int max_len = 0;

        System.out.println("\nLongest increasing subsequences generated at positions");

        for (int i=0; i<sz; i++) {
            System.out.print("[" + i + "]: ");
            max_len = Math.max(max_len, seq_list.get(i).size());
            for (Integer p : seq_list.get(i)) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
        System.out.println("Maximum length of increasing subsequence: " + max_len + "\n");
    }

    public static void main(String args[]) {

        LIS seq = new LIS();

        List<Integer> sequence1 = Arrays.asList(3, 2, 6, 4, 5, 1, 7);
        seq.Longest_Increasing_Subsequence (sequence1);

        List<Integer> sequence2 = Arrays.asList(2, 2, 3, 2, 2, 1, 2, 3);
        seq.Longest_Increasing_Subsequence (sequence2);
    }
}

