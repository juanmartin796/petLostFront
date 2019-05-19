package otros.martin.com.petlost.utils;

class MyApplication {
    private static final MyApplication ourInstance = new MyApplication();

    static MyApplication getInstance() {
        return ourInstance;
    }

    private MyApplication() {
    }
}
