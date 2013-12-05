package ex12;


public class InsertionSort {
  private final int n = 50000;
  private int[] array = new int[n];

  public InsertionSort(String filename) {
    // ここを作る
    // ファイル名を引数とする
    // ファイルを開いて全て読み込んで配列arrayに入れる
  }
  public void sort() {
    // ここを作る
    // 挿入ソートを実装する
    // 配列arrayの中身をソートする
  }
  public void output(String filename) {
    // ここを作る
    // ファイル名を引数とする
    // 配列arrayをファイルに出力する
    // 1行に1レコード
  }

  public static void main(String[] args) {
    String file1 = "rand2.txt";
    String file2 = "rand2_result.txt";

    InsertionSort is = new InsertionSort(file1);
    is.sort();
    is.output(file2);
  }
}
