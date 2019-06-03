package com.luist23.pdm_parcial_01

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.luist23.pdm_parcial_01.database.entities.Partido
import com.luist23.pdm_parcial_01.viewmodels.PartidoViewModel
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, FragmentList.ListenerTools {


    private lateinit var mainFrag : FragmentList
    //private lateinit var detFrag : FragmentDetail
    private lateinit var partidoViewModel:PartidoViewModel
    private var resource = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            val intent = Intent(this@MainActivity, NewPartidoActivity::class.java)
            startActivityForResult(intent,1)
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        partidoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        initMainFragment()
    }

    fun initMainFragment(){

        mainFrag = FragmentList()
        //detFrag = FragmentDetail()

        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            resource = R.id.main_fragment

            /*fab.setOnClickListener{
                val intent = Intent(this@MainActivity, NewBookActivity::class.java)
                startActivityForResult(intent, newBookActivityRequestCode)
            }*/
        }
        /*if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            resource = R.id.land_main_fragment
            changeFragment(R.id.land_main_cont_fragment, detFrag)
        }*/


        changeFragment(resource, mainFrag)
    }

    override fun portraitClick(partido: Partido) {
        /*val intent = Intent(this@MainActivity, BookInfoActivity::class.java)
        intent.putExtra("title", book.title)
        intent.putExtra("summary", book.summary)
        intent.putExtra("name", book.authors[0].author_name)
        intent.putExtra("last",book.authors[0].author_last_name)
        intent.putExtra("img", book.cover)
        Log.d("summary", book.toString())
        startActivity(intent)*/
    }

    override fun landscapeClick(partido: Partido) {
        /*detFrag = FragmentDetail.newInstance(partido)
        changeFragment(R.id.land_main_cont_fragment, detFrag)*/
    }

    private fun changeFragment(id: Int, fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(id,fragment).commit()
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
