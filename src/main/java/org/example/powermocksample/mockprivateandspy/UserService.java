package org.example.powermocksample.mockprivateandspy;

public class UserService {

    private void log() {
        System.out.println("log");
    }

    public void log(String str) {
        log();
    }

    private boolean check(String str) {
        throw new UnsupportedOperationException();
    }

    public boolean doCheck(String str) {
        return check(str);
    }
}
