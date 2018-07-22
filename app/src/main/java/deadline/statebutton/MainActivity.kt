package deadline.statebutton

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var text: StateButton

    lateinit var background: StateButton

    lateinit var radius: StateButton

    lateinit var stroke: StateButton

    lateinit var dash: StateButton

    lateinit var tvExtend: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //设置不同状态下文字变色
        text = findViewById<View>(R.id.text_test) as StateButton
        text.setOnClickListener { text.isEnabled = false }

        //最常用的设置不同背景
        background = findViewById<View>(R.id.background_test) as StateButton
        background.setOnClickListener { background.isEnabled = false }

        //设置四个角不同的圆角
        radius = findViewById<View>(R.id.different_radius_test) as StateButton
        radius.setRadius(floatArrayOf(0f, 0f, 20f, 20f, 40f, 40f, 60f, 60f))


        //设置不同状态下边框颜色，宽度
        stroke = findViewById<View>(R.id.stroke_test) as StateButton
        stroke.setOnClickListener { stroke.isEnabled = false }

        //设置间断
        dash = findViewById<View>(R.id.dash_test) as StateButton
        dash.setOnClickListener { dash.isEnabled = false }

        tvExtend = findViewById(R.id.tv_extend)
        tvExtend.setOnClickListener { Toast.makeText(this@MainActivity, "lal", Toast.LENGTH_SHORT).show() }

        tvExtend.setState(StateConfig.newBuilder()
                .setNormalBackgroundColor(Color.RED)
                .setPressedBackgroundColor(Color.GREEN)
                .setUnableBackgroundColor(Color.RED)
                .setNormalTextColor(Color.WHITE)
                .setPressedTextColor(Color.DKGRAY)
                .setDuration(300)
                .setRadius(30f)
                .build())
    }
}
