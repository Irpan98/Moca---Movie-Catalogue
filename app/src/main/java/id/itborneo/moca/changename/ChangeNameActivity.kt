package id.itborneo.moca.changename

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import id.itborneo.core.constant.SharedPrefConstant
import id.itborneo.core.utils.sharedpreferences.SecureSharedPreferences
import id.itborneo.moca.R
import id.itborneo.moca.databinding.ActivityChangeNameBinding

class ChangeNameActivity : AppCompatActivity() {

    companion object {
        fun getInstance(context: Context, launcher: ActivityResultLauncher<Intent>) {
            val intent = Intent(context, ChangeNameActivity::class.java)
            launcher.launch(intent)
        }
    }

    private lateinit var binding: ActivityChangeNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        initView()
    }

    private fun initBinding() {
        binding = ActivityChangeNameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun initView() {
        binding.edChangeNameUsername.requestFocus()
        binding.btnChangeNameSave.setOnClickListener {
            editNameWithSecurity(findViewById<EditText>(R.id.ed_change_name_username).text.toString())
        }
    }

    private fun editNameWithSecurity(name: String) {
        val sharedPreferences = SecureSharedPreferences.sharedPreferences(this)
        with(sharedPreferences.edit()) {
            // Edit the user's shared preferences...
            this.putString(SharedPrefConstant.SHARED_PREF_USER_NAME, name)
            apply()
            setResult(RESULT_OK)
            finish()
        }
    }
}