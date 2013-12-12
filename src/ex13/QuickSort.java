package ex13;


public class QuickSort {
  private final int n = 50000;
  private int[] a = new int[n];

  public QuickSort(String filename) {
    // ここを作る
    // ファイル名を引数とする
    // ファイルを開いて全て読み込んで配列aに入れる
  }
  private int partition(int l, int r) {
    // ここを作る
    // クイックソートにおける分割を行う
	  return 0;
  }
  private void quicksort(int l, int r) {
    // ここを作る
    // クイックソートを実装する
    // 配列aの中身をソートする
  }
  public void sort() {
    quicksort(0, a.length -1);
  }
  public void output(String filename) {
    // ここを作る
    // ファイル名を引数とする
    // 配列arrayをファイルに出力する
    // 1行に1レコード
  }
  public static void main(String[] args) {
    String file1 = "sorted2.txt";
    String file2 = "rand2_result.txt";

    QuickSort qs = new QuickSort(file1);
    qs.sort();
    qs.output(file2);
  }
}
