package id.itborneo.moca.changename

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import id.itborneo.moca.R


class ChangeNameActivity : AppCompatActivity() {

    companion object {
        const val SHARED_PREF_USER_NAME = "user name"

        fun getInstance(context: Context) {
            val intent = Intent(context, ChangeNameActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_name)

        editNameWithSecurity()
    }

    var masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    private fun editNameWithSecurity() {

        val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
            "secret_shared_prefs",
            masterKeyAlias,
            this,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )


        val getName = sharedPreferences.getString(SHARED_PREF_USER_NAME, "")
        Log.d("ChangeNameActivity", "$getName")

        with(sharedPreferences.edit()) {
            // Edit the user's shared preferences...
            this.putString(SHARED_PREF_USER_NAME, "IRPAN")
            apply()
        }


    }
}