package fr.isen.charnoz.toolbox

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_home.*

class LifeCycleActivity : AppCompatActivity() {

    private val tagname = "lifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        Log.d(tagname,"On create")
    }

    @Override fun OnPause(){
        super.onPause()
        Log.d(tagname,"On met en pause")
    }

    @SuppressLint("MissingSuperCall")
    override fun onResume(){
        super.onResume()
        Log.d(tagname,"On resume")
    }

    override fun onStart() {
        super.onStart()
        Log.d(tagname,"on start")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tagname,"on destroy")
    }
}
