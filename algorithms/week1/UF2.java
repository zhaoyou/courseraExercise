/**
 * zhaoyou.xt@gmail.com (zhaoyou)
 */
public class UF2 {
  int [] id;

  public UF2(int n) {
    id = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    //int pid = id[p];
    //int qid = id[q];

    //for (int i = 0; i < id.length; i++) {
    //  if (id[i] == pid) {
    //    id[i] = qid;
    //  }
    //}
    int i = root(p);
    int j = root(q);

    id[i] = j;
  }

  public int root(int p) {
    while(p != id[p]) {
      p = id[p];
    }
    return p;
  }

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    int n = StdIn.readInt();
    UF2 uf = new UF2(n);
    while(!StdIn.isEmpty()) {
      int p =  StdIn.readInt();
      int q =  StdIn.readInt();
      if (!uf.connected(p, q)) {
        uf.union(p, q);
        StdOut.println(p + ":" + q);
      }
    }
    long end = System.currentTimeMillis();
    StdOut.println("cost time:" + (end -  start));

    for (int i = 0; i < uf.id.length; i ++) {
      StdOut.println(uf.id[i]);
    }
  }
}
