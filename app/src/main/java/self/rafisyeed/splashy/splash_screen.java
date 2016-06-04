package self.rafisyeed.splashy;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                TextView view = (TextView) findViewById(R.id.splashtext);
                view.setText("Wait");
            }
        };

        setContentView(R.layout.activity_splash_screen);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    try {

                        Message msg = handler.obtainMessage();
                        msg.obj = ".";
                        handler.sendMessage(msg);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Intent intent = new Intent(splash_screen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }).start();
    }
}
