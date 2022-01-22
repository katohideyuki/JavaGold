package chapter_02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinPoolについて<br>
 *
 *
 */
public class SampleFrokJoinPool {
  public static void main(String[] a) {
    executeParallel();
  }

  /**
   * スレッド実行<br>
   */
  private static void executeParallel() {
    ForkJoinPool thread = new ForkJoinPool(4); // スレッド生成
    CreateFrokJoinPool createFrokJoinPool = new CreateFrokJoinPool(128);
    long result = thread.invoke(createFrokJoinPool);
    System.out.println("result : " + result);
  }

  /**
   * インナークラス<br>
   * {@link RecursiveAction}のTaskを定義<br>
   */
  @SuppressWarnings("serial") // 課題と関係がないので、警告無視
  private static class CreateFrokJoinPool extends RecursiveTask<Long>/* 戻り値がある場合 */ {
    private long workload = 0; // 作業負荷

    /**
     * コンストラクタ<br>
     */
    public CreateFrokJoinPool(long workload) {
      this.workload = workload;
    }

    /**
     * タスクの処理内容<br>
     * - タスクが実行されると呼び出される<br>
     */
    @Override
    protected Long compute() {
      String threadName = Thread.currentThread().getName();// スレッド名を取得

      // Taskが閾値16を超えていた場合、子Taskに分割
      if (workload > 16) {
        System.out.println("[" + LocalDate.now() + "]" + "[" + threadName + "（分割)] : " + this.workload);

        sleep(1000);
        List<CreateFrokJoinPool> subTasks = new ArrayList<>(); // 子タスクのリスト
        subTasks.addAll(createSubTasks()); // 子タスクオブジェクト生成
        for (CreateFrokJoinPool subTaskAction : subTasks) {
          subTaskAction.fork(); // タスクを分割して、他のスレッドで処理させる
        }

        long result = 0;
        for (CreateFrokJoinPool subTask : subTasks) {
          result += subTask.join();// 子タスクの処理が完了するまで待ち、結果を自分と合わせて、より上位の親へ返す
          System.out.println("[" + LocalDate.now() + "]" + "[" + threadName + "]" + "子タスクの結果 : " + result);
        }
        return result; // 分割されたタスクの結果

        // Taskが閾値16を超えていない場合、そのままスレッド情報を出力
      } else {
        sleep(1000);
        System.out.println("[" + LocalDate.now() + "]" + "[" + threadName + "(処理)] : " + this.workload);
        return workload * 3;
      }
    }

    /**
     * スレッドスリープ<br>
     *
     * @param time
     */
    private void sleep(int time) {
      try {
        Thread.sleep(time);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    /**
     * 子タスクオブジェクトを生成<br>
     * - 現在の親タスクから作業負荷50%を受け持つ<br>
     *
     * @return 子タスクオブジェクトのリスト
     */
    private List<CreateFrokJoinPool> createSubTasks() {
      List<CreateFrokJoinPool> subTasks = new ArrayList<>();
      CreateFrokJoinPool task_01 = new CreateFrokJoinPool(this.workload / 2); // 親タスクから、作業負荷50%を受け持った子タスク
      CreateFrokJoinPool task_02 = new CreateFrokJoinPool(this.workload / 2); // 〃

      subTasks.add(task_01);
      subTasks.add(task_02);

      return subTasks;
    }
  }
}
