package com.example.a01helloworld2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Response


class MainActivity : AppCompatActivity() {

    var viewVille: TextView? = null
    var viewDegres: TextView? = null
    var viewMeteo: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewVille = findViewById(R.id.viewVille)
        viewDegres = findViewByd(R.id.viewDegres)
        viewMeteo = findViewById(R.id.viewMeteo)

        val ville = intent.getStringExtra("com.example.projet.villes.VILLES")

       /* val villeParis = Ville("ville de Paris", 15, "Nuageux")
       val villeRome = Ville("ville de Rome", 18, "Ensoleillé")

        if (ville == "villeParis") {
            viewVille?.text = villeParis.nom
            viewDegres?.text = villeParis.degres.toString()
            viewMeteo?.text = villeParis.meteo

        } else if (ville == "villeRome") {
            viewVille?.text = villeRome.nom
            viewDegres?.text = villeRome.degres.toString()
            viewMeteo?.text = villeRome.meteo
        } else {
            Toast.makeText(this, "Ville non répertoriée", Toast.LENGTH_SHORT).show()
        }
        */

        private fun requeteVolley(url: String) {

            val queue = Volley.newRequestQueue(this)

            val requete = StringRequest(Request.Method.GET, url, Response.Listener<String>
            {
                    response ->
                try {
                    Log.d("Test Volley OK", response)

                    val gson =Gson()
                    val ville = gson.fromJson(response, Ville::class.java)
                    Log.d("GSON", ville.nom)
                    viewVille?.text = ville.nom
                    viewDegres?.text = ville.temperature?.temp.toString()
                    viewMeteo?.text = ville.description?.get(0)?.description
                }
                catch (e: Exception) {

                }
            }, Response.ErrorListener {})

            queue.add(requete)
        }

        if (Reseau.reseauok(this)) {
            requeteVolley("api.openweathermap.org/data/2.5/weather?id="+ville+"&appid=b6907d289e10d714a6e88b30761fae22&units=metric")
        } else {
            Toast.makeText(this, "Pas de réseau", Toast.LENGTH_LONG).show()

        }
    }
}