package ch10;

import ch6.StringConcat;

public class PasswordException extends Exception {

    public PasswordException (String message) {
//        메시지에 대한 get 등 대부분이 상위 클래스에서 이루어질 수 있기 때문에 super
        super(message);
    }
}
