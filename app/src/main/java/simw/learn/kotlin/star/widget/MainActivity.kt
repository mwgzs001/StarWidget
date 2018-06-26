package simw.learn.kotlin.star.widget

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import simw.learn.kotlin.star.widget.gifloadingview.GLActivity
import simw.learn.kotlin.star.widget.goodview.GVActivity
import simw.learn.kotlin.star.widget.materialdrawer.MDActivity
import simw.learn.kotlin.star.widget.sidemenu.MSActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mdBtn.setOnClickListener { startActivity(Intent(this@MainActivity, MDActivity::class.java)) }
        msBtn.setOnClickListener { startActivity(Intent(this@MainActivity, MSActivity::class.java)) }
        gvBtn.setOnClickListener { startActivity(Intent(this@MainActivity, GVActivity::class.java)) }
        glBtn.setOnClickListener { startActivity(Intent(this@MainActivity, GLActivity::class.java)) }
    }
}
