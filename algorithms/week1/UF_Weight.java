/**
 * zhaoyou.xt@gmail.com (zhaoyou)
 */
public class UF_Weight {
  int [] id;
  int [] size;

  public UF_Weight(int n) {
    id = new int[n];
    size = new int[n];

    for (int i = 0; i < n; i++) {
      id[i] = i;
      size[i] = 1;
    }
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {

    int i = root(p);
    int j = root(q);

    if (i == j) return;

    if (size[i] < size[j]) {
      id[i] = j;
      size[j] += size[i];
    } else {
      id[j] = i;
      size[i] += size[j];
    }
  }

  public int root(int i) {
    while(i != id[i]) {
      //StdOut.println("i: " + id[i] + "id[id[i]]: " + id[id[i]]);
      id[i] = id[id[i]];
      i = id[i];
    }
    return i;
  }

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    int n = StdIn.readInt();
    UF_Weight uf = new UF_Weight(n);
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
    //StdOut.println("***************");
    //for (int i = 0; i < uf.size.length; i ++) {
    //  StdOut.println(uf.size[i]);
    //}
  }
}
