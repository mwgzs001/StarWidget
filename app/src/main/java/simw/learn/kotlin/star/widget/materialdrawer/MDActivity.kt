package simw.learn.kotlin.star.widget.materialdrawer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import kotlinx.android.synthetic.main.activity_md.*
import simw.learn.kotlin.star.widget.R

class MDActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_md)
        initItem()
        initBar()
    }

    private fun initBar() {
        toolbar.title = "Material Drawer"
        toolbar.subtitle = "show"
        toolbar.setLogo(R.drawable.ic_subway_black_24dp)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        toolbar.setNavigationOnClickListener { finish() }
    }

    private fun initItem() {
        DrawerBuilder().withActivity(this).build()
        val item1: PrimaryDrawerItem = PrimaryDrawerItem().withIdentifier(1).withName("home")
        val item2: SecondaryDrawerItem = SecondaryDrawerItem().withIdentifier(2).withName("settings")
        val result: Drawer = DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        DividerDrawerItem(),
                        item2,
                        SecondaryDrawerItem().withName("settings")
                )
                .build()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_md, menu)
        return true
    }
}