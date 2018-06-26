package simw.learn.kotlin.star.widget.goodview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wx.goodview.GoodView
import kotlinx.android.synthetic.main.activity_gv.*
import simw.learn.kotlin.star.widget.R

class GVActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gv)
        val goodView = GoodView(this)
        var collect = false
        button.setOnClickListener {
            collect = if (!collect) {
                goodView.setText("收藏成功")
                goodView.show(it)
                it.setBackgroundResource(R.drawable.ic_star_black_24dp)
                !collect
            } else {
                goodView.setText("取消收藏")
                goodView.show(it)
                it.setBackgroundResource(R.drawable.ic_star_border_black_24dp)
                !collect
            }
        }
    }
}