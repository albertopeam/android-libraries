package es.albertopeam.sample.presentation.timer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import es.albertopeam.infrastructure.concurrent.ExecutorImpl;
import es.albertopeam.infrastructure.concurrent.MainThreadImpl;
import es.albertopeam.sample.R;
import es.albertopeam.sample.application.timer.TimerInteractor;
import es.albertopeam.sample.application.timer.TimerUseCase;
import es.albertopeam.sample.infrastructure.ExecutorAdapter;

/**
 * Created by alberto on 18/6/16.
 */
public class TimerActivity extends AppCompatActivity {

    private TimerInteractor timerInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_executor);
        setup();
    }

    private void setup() {
        //TODO: DI
        //TODO: constraint layout, button and result,,,,
        //TODO: make a domain model,,,,
        //TODO: make a boundary to not use the domain model. Make a x viewModel..
        //TODO: mantain clean...
        timerInteractor = new TimerInteractor(new ExecutorAdapter(new ExecutorImpl(), new MainThreadImpl()));
        timerInteractor.temporizate(5, new TimerUseCase.TimerCallback() {
            @Override
            public void endTemporization(int seconds) {

            }
        });
    }

}
