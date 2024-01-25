package com.example.cryptoapp_teste

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cryptoapp_teste.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar o layout da atividade usando View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Encontrar o NavController a partir do FragmentContainerView
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as? NavHostFragment

        // Verificar se o fragmento é do tipo NavHostFragment antes de obter o NavController
        val navController: NavController? = navHostFragment?.findNavController()

        // Se o NavController for nulo, você pode tratar isso conforme necessário
        if (navController != null) {
            // Encontrar a BottomNavigationView no layout
            val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomBar)

            // Configurar a BottomNavigationView com o NavController
            bottomNavigationView.setupWithNavController(navController)
        } else {
            // Trate o caso em que o NavController é nulo
            // Por exemplo, exibir uma mensagem de erro, registrar ou lidar de acordo com sua lógica de aplicativo.
        }
    }
}

