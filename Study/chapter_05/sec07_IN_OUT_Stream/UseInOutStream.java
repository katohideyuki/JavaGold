package sec07_IN_OUT_Stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import debug.Debug;

/** バイトストリームの使用例 */
public class UseInOutStream {
    // 読み込む画像ファイル
    static final String FILE_READ_IMAGE_PATH = "src/main/resource/chapter_05/sec07/me-moji.PNG";
    // 書き出し先のファイルパス
    static final String FILE_WRITE_PATH      = "src/main/resource/chapter_05/sec07/sec07_sample.txt";

    public static void main(String[] args) throws IOException {
        InOutImageFile();
    }

    /* 画像ファイルを読み込み、別のファイルへ書き込む */
    private static void InOutImageFile() throws IOException {
        Debug.log("InOutImageFile");

        // 読み込み用
        FileInputStream fis      = new FileInputStream(FILE_READ_IMAGE_PATH);
        BufferedInputStream bis  = new BufferedInputStream(fis);
        // 書き込み用
        FileOutputStream fos     = new FileOutputStream(FILE_WRITE_PATH);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        // 1024バイトずつ読み込み、書き出し先ファイルへ書き込む
        try (bis; bos) {
            byte[] data = null;
            while ((data = bis.readNBytes(1024)).length != 0)
                bos.write(data);
        }
        bos.flush();  // バッファとファイルを同期
        System.out.printf("Completed writing : %s%n", FILE_WRITE_PATH);
    }
}

/**
 * <pre>
 * FileInputStream
 *   - バイトストリームを読み込む
 *
 * BufferedInputStream(FileInputStream インスタンス)
 *   -  単体では動作せず、コンストラクタで受け取った InputStream を通じてファイルへアクセス
 *
 * InputStream.readNByte(バイト数)
 *   - 指定した任意のバイト数単位でデータを読み込む
 *   - 大きいバイト数の場合、メモリへの負担を減らすために使う
 *
 * FileOutputStream
 *   - バイトストリームを書き込む
 *
 * BufferedOutputStream(FileOutputStream インスタンス)
 *   - 単体では動作せず、コンストラクタで受け取った InputStream を通じてファイルへアクセス
 * </pre>
 */