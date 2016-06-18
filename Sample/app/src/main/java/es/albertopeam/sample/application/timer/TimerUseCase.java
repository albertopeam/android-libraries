package es.albertopeam.sample.application.timer;

/**
 * Created by alberto on 18/6/16.
 */
public interface TimerUseCase {
    void temporizate(int seconds, TimerCallback timerCallback);

    interface TimerCallback{
        void endTemporization(int seconds);
    }
}
