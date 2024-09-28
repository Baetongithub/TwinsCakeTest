package kg.twnscake.twinscaketest.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kg.twnscake.twinscaketest.R
import kg.twnscake.twinscaketest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var vb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

    }
}