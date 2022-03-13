package chapter_09;

import java.util.Date;

/**
 * 可変オブジェクトクラス<br>
 * - コピーを使って出し入れする<br>
 * - 代入するときは、なるべくcloneメソッドを使わない<br>
 * --- cloneメソッドがオーバーライドされていて、意図しない実装で上書きされる可能性があるため<br>
 */
public class CopyObject {
  private Date date;

  public CopyObject(Date date) { /* 引数で受け取ったオブジェクトをコピーしてから代入 */
    this.date = new Date(date.getTime());
  }

  public CopyObject(CopyObject input) { /* コピーコンストラクタ */
    this.date = new Date(input.date.getTime());
  }

  public Date getDate() { /* コピーを作って戻す */
    return (Date) date.clone();
  }

  @Override
  public boolean equals(Object obj) { /* コピー元と比較する */
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CopyObject copy = (CopyObject) obj;
    if (date == null) {
      if (copy.date != null)
        return false;
    } else if (!date.equals(copy.date))
      return false;
    return true;
  }
}
