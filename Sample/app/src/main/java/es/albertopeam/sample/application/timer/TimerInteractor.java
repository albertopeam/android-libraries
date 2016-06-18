package es.albertopeam.sample.application.timer;


import es.albertopeam.sample.application.Executor;

/**
 * Created by alberto on 18/6/16.
 */
public class TimerInteractor implements TimerUseCase{


    private Executor executor;
    private TimerCallback timerCallback;


    public TimerInteractor(Executor executor) {
        this.executor = executor;
    }


    @Override
    public void temporizate(final int seconds, final TimerCallback timerCallback) {
        this.timerCallback = timerCallback;
        executor.runInBackgroundThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(seconds*1000);
                    executor.runInMainThread(new Runnable() {
                        @Override
                        public void run() {
                            timerCallback.endTemporization(seconds);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
