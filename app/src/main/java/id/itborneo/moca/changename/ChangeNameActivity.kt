package id.itborneo.moca.changename

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import id.itborneo.core.constant.SharedPrefConstant
import id.itborneo.core.utils.sharedpreferences.SecureSharedPreferences
import id.itborneo.moca.R

class ChangeNameActivity : AppCompatActivity() {

    companion object {

        fun getInstance(context: Context) {
            val intent = Intent(context, ChangeNameActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_name)

//        editNameWithSecurity(findViewById<EditText>(R.id.ed_change_name_username).text.toString())

        findViewById<Button>(R.id.btn_change_name_save).setOnClickListener {
            editNameWithSecurity(findViewById<EditText>(R.id.ed_change_name_username).text.toString())
        }
    }


    private fun editNameWithSecurity(name: String) {
        val sharedPreferences = SecureSharedPreferences.sharedPreferences(this)
        with(sharedPreferences.edit()) {
            // Edit the user's shared preferences...
            this.putString(SharedPrefConstant.SHARED_PREF_USER_NAME, name)
            apply()
            finish()
        }
    }


}