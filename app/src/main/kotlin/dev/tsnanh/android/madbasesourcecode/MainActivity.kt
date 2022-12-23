package dev.tsnanh.android.madbasesourcecode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.tsnanh.android.core.ui.utils.viewBinding
import dev.tsnanh.android.madbasesourcecode.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navController = (supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment).navController
        binding.bottomNav.setupWithNavController(navController)
    }
}
