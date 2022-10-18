package admiral.group.tuneconsultingtask.ui

import admiral.group.tuneconsultingtask.R
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import admiral.group.tuneconsultingtask.databinding.ActivityMainBinding
import android.view.View
import androidx.navigation.NavController
import dagger.hilt.android.AndroidEntryPoint


/*
 * 1. SOLID - Dependency inversion
 * Framework - Dagger Hilt.
 *
 *  The @AndroidEntryPoint annotation helps to inject dependencies into Fragment and
 *  perform field injection using @Inject annotation.
 *
 */


/*
 * 2.  Dependency Injection is also Creational Pattern.
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun setVisible(){
        binding.navView.visibility=View.VISIBLE
    }

    fun setGone(){
        binding.navView.visibility=View.GONE
    }

}