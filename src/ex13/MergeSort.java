package ex13;


public class MergeSort {
  private final int n = 50000;
  private int[] a = new int[n];

  public MergeSort(String filename) {
    // ここを作る
    // ファイル名を引数とする
    // ファイルを開いて全て読み込んで配列aに入れる
  }
  private void mergesort(int low, int high) {
    // ここを作る
    // マージソートを実装する
    // 配列aの中身をソートする
  }
  public void sort() {
    mergesort(0, a.length -1);
  }
  public void output(String filename) {
    // ここを作る
    // ファイル名を引数とする
    // 配列aをファイルに出力する
    // 1行に1レコード
  }
  public static void main(String[] args) {
    String file1 = "rand2.txt";
    String file2 = "rand2_result.txt";

    MergeSort ms = new MergeSort(file1);
    ms.sort();
    ms.output(file2);
  }
}
