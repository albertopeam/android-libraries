package java.infrastructure.concurrent.main;

import android.os.Handler;
import android.os.Looper;

/**
 * MainThread represents ability to change the execution flow between background thread to UI thread
 */
public class MainThreadImpl implements MainThread {


    private Handler handler;


    public MainThreadImpl() {
        this.handler = new Handler(Looper.getMainLooper());
    }


    /**
     * Run the passed runnable in the UI thread
     * @param runnable
     */
    @Override
    public void run(Runnable runnable) {
        handler.post(runnable);
    }


    /**
     * Run the passed block in the UI thread
     * @param block
     */
    @Override
    public void run(MainThreadBlock block) {
        handler.post(block);
    }
}
