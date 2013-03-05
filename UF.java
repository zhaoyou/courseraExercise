
import java.util.List;
import java.util.ArrayList;

/**
 *  zhaoyou.xt@gmail.com (zhaoyou)
 */
public class UF {

  int[] N ;
  List<List<Integer>> compentList = null;



  public UF(int n) {
    N = new int[n];
    compentList = new ArrayList<List<Integer>>();
    for(int i = 0; i < n; i++) {
      N[i] = i;
    }
  }

  public boolean connected(int p, int q) {
    // TODO
    for(List<Integer> compent: compentList) {
      if (compent.contains(p) && compent.contains(q)) {
        return true;
      }
    }
    return false;
  }

  public void union(int p, int q) {
    List<Integer> newCompent = new ArrayList<Integer>();
    newCompent.add(p);
    newCompent.add(q);
    List<Integer> mergeIndexs = new ArrayList<Integer>();
    for(List<Integer> compent: compentList) {
      if (compent.contains(p) || compent.contains(q)) {
        newCompent.addAll(compent);
        mergeIndexs.add(compentList.indexOf(compent));
      }
    }

    // merge to newCompent already.
    for(Integer i: mergeIndexs) {
      compentList.remove(i);
    }

    compentList.add(newCompent);
  }

  int find(int p) {
    for(List<Integer> compent: compentList) {
      if (compent.contains(p)) {
        return compentList.indexOf(compent);
      }
    }
    return -1;
  }

  int cout() {
    return compentList.size();
  }

  public static void main(String[] args) {

    long start = System.currentTimeMillis();
    int n = StdIn.readInt();
    UF uf = new UF(n);
    while(!StdIn.isEmpty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      if (!uf.connected(p, q)) {
        uf.union(p, q);
        System.out.println(p + ":" + q);
      }
    }
    long end = System.currentTimeMillis();
    StdOut.println("cost time:" + (end -  start));
  }
}
