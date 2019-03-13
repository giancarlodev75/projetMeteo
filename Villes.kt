package com.example.projet

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.a01helloworld2.MainActivity
import kotlinx.android.synthetic.main.activity_villes.*

class Villes : AppCompatActivity() {

    val TAG="com.example.projet.villes.VILLES"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_villes)

        val ville1 = findViewById<Button>(R.id.boutonVille1)
        val ville2 = findViewById<Button>(R.id.boutonVille2)

        boutonVille1.setOnClickListener(View.OnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "2988507")
            startActivity(intent)
                    })

        boutonVille2.setOnClickListener(View.OnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG, "6539761")
            startActivity(intent)
        })

    }
}
