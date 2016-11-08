package deadline.statebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    StateButton text;

    StateButton stroke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (StateButton) findViewById(R.id.text_test);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text.isEnabled()) {
                    text.setEnabled(false);
                }
            }
        });

        stroke = (StateButton) findViewById(R.id.stroke_test);
        stroke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(stroke.isEnabled()) {
                    stroke.setEnabled(false);
                }
            }
        });
    }
}
