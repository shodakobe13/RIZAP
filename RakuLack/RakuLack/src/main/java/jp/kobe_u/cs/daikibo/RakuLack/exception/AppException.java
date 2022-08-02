package jp.kobe_u.cs.daikibo.RakuLack.exception;

public class AppException extends RuntimeException {
    /* 本系エラーコード */
    public static final int BOOK_NOT_FOUND = 100;
    public static final int BOOK_ALREADY_EXIST = 101;

    public static final int ERROR = 900;

    private int code;   // この例外のコード

    public AppException(int code, String message) {
        super(message);
        this.code = code;
    }

    public AppException(int code, String message, Exception cause) {
        super(message, cause);
        this.code = code;
    }

}
