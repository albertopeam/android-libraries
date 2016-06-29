package es.albertopeam.sample.presentation.timer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
    private TextView textTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_executor);
        setup();
    }

    private void setup() {
        textTV = (TextView) findViewById(R.id.tv);
        timerInteractor = new TimerInteractor(new ExecutorAdapter(new ExecutorImpl(), new MainThreadImpl()));
    }

    public void start(View view){
        textTV.setText("5");
        timerInteractor.temporizate(5, new TimerUseCase.TimerCallback() {
            @Override
            public void endTemporization(int seconds) {
                textTV.setText("end temporization");
            }
        });
    }

}
