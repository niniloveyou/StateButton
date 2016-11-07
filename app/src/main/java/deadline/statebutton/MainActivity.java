package deadline.statebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    StateButton mStateButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStateButton1 = (StateButton) findViewById(R.id.state_button_1);
        mStateButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mStateButton1.isEnabled()) {
                    mStateButton1.setEnabled(false);
                }
            }
        });
    }
}
