package com.example.testapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.api.ApiInterface
import com.example.testapp.api.ApiUtilities
import com.example.testapp.databinding.ActivityHomeScreenBinding
import com.example.testapp.repository.Factrepo
import com.example.testapp.viewmodel.FviewModel
import com.example.testapp.viewmodel.FviewModelFactory
import kotlin.system.exitProcess


class HomeScreen : AppCompatActivity() {

    private lateinit var fviewmodel:FviewModel
    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val apiinterface=ApiUtilities.getInstance().create(ApiInterface::class.java)

        val facrepos=Factrepo(apiinterface)

        fviewmodel=ViewModelProvider(this,FviewModelFactory(facrepos)).get(FviewModel::class.java)
        fviewmodel.facts.observe(this) {

            Log.d("Facts", "onCreate:${it.toString()}")
            binding.facts.text=it.toString()
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val mBuilder = AlertDialog.Builder(this)
            .setTitle("Confirm")
            .setMessage("Are you sure you want to exit?")
            .setPositiveButton("Yes", null)
            .setNegativeButton("No", null)
            .show()
        val mPositiveButton = mBuilder.getButton(AlertDialog.BUTTON_POSITIVE)
        mPositiveButton.setOnClickListener {
            exitProcess(0)
        }
    }


}