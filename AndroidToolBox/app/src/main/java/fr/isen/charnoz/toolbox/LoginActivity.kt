package fr.isen.charnoz.toolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val goodIdentifier = "admin"
    val goodPassword = "admin"

    fun canLog(identifier: String, password:String): Boolean{
        return identifier == goodIdentifier && password == goodPassword
    }

    fun doLogin(){
        if(canLog(usernameEditText.text.toString(), inputPasswordEdit.text.toString())){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        validateButton.setOnClickListener {
            doLogin()
        }






    }
}
