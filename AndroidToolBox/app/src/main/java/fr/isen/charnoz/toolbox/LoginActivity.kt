package fr.isen.charnoz.toolbox

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val goodIdentifier = "admin"
    val goodPassword = "123"

    var userPreference: SharedPreferences? = null

    fun canLog(identifier: String, password:String): Boolean{
        return identifier == goodIdentifier && password == goodPassword
    }

    fun doLogin(){
        if(canLog(usernameEditText.text.toString(), inputPasswordEdit.text.toString())){
            saveUser(usernameEditText.text.toString(), inputPasswordEdit.text.toString())
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    fun checkPreferences() {
        val identifier = userPreference?.getString(Constants.identifier, null) ?: ""
        val password = userPreference?.getString(Constants.password, null) ?: ""
        usernameEditText.setText(identifier)
        inputPasswordEdit.setText(password)
        doLogin()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        userPreference = getSharedPreferences(Constants.userPrefName, Context.MODE_PRIVATE)
        checkPreferences()
        validateButton.setOnClickListener {
            doLogin()
        }

    }
    fun saveUser(identifier: String, password: String) {
        val editor = userPreference?.edit()
        editor?.putString(Constants.identifier, identifier)
        editor?.putString(Constants.password, password)
        editor?.apply()
    }

}
