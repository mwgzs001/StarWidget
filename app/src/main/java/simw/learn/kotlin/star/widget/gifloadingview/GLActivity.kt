package simw.learn.kotlin.star.widget.gifloadingview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.roger.gifloadinglibrary.GifLoadingView
import simw.learn.kotlin.star.widget.R

class GLActivity : AppCompatActivity() {
    lateinit var mGifLoadingView: GifLoadingView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gl)
        mGifLoadingView = GifLoadingView()
        mGifLoadingView.setImageResource(R.drawable.num2)
        mGifLoadingView.show(fragmentManager, "")
    }
}