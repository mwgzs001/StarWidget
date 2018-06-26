package simw.learn.kotlin.star.widget.materialdrawer

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.widget.Toast
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.*
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import kotlinx.android.synthetic.main.activity_md.*
import simw.learn.kotlin.star.widget.R
import simw.learn.kotlin.star.widget.R.id.toolbar

class MDActivity : AppCompatActivity() {
    lateinit var headerResult: AccountHeader
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_md)
        initHeader()
        initItem()
        initBar()
    }

    private fun initHeader() {
        headerResult = AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.colorPrimary)
                .addProfiles(ProfileDrawerItem()
                        .withName("Si Mingwen")
                        .withEmail("mwgzs001@163.com")
                        .withIcon(R.drawable.ic_account_circle_black_24dp))
                .withOnAccountHeaderListener { _, profile, _ ->
                    toast("${profile.name}")
                    false
                }
                .build()
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
        val item1: PrimaryDrawerItem = PrimaryDrawerItem()
                .withIdentifier(1)
                .withName("home")
                .withSelectable(false)
        val item2: SecondaryDrawerItem = SecondaryDrawerItem()
                .withIdentifier(2)
                .withName("settings")
        val result: Drawer = DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        item1,
                        DividerDrawerItem(),
                        item2,
                        SecondaryDrawerItem()
                                .withName("settings"),
                        ExpandableDrawerItem()
                                .withName("expandable")
                                .withSubItems(PrimaryDrawerItem()
                                        .withName("exp1"),
                                        PrimaryDrawerItem()
                                                .withName("exp2")),
                        MiniDrawerItem().withName("mini").withIdentifier(10)
                )
                .withOnDrawerItemClickListener { _, position, drawerItem ->
                    toast("$position,${drawerItem.identifier}")
                    false
                }
                .build()
        result.setSelection(2, false)
        result.addItem(DividerDrawerItem())
        result.addStickyFooterItem(PrimaryDrawerItem().withName("StickerFooterItem"))
        result.openDrawer()
    }

    private fun AppCompatActivity.toast(content: String) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_md, menu)
        return true
    }
}