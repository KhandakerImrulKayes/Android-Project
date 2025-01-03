package com.example.mplcricket

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class ForgotPassword : AppCompatActivity() {
    private var mAuth:FirebaseAuth? = null
    lateinit var forgot_send_email_button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        forgot_send_email_button.setOnClickListener {
            var email=findViewById<EditText>(R.id.forgot_email).editableText.toString()
            Snackbar.make(findViewById(R.id.forgot_password_layout), "wait...", Snackbar.LENGTH_INDEFINITE).show()
            mAuth=FirebaseAuth.getInstance()

            if (email.length in 1..40){
                sendreseemail(email)
            }
            else{
                Snackbar.make(findViewById(R.id.forgot_password_layout), "email can't be empty", Snackbar.LENGTH_SHORT).show()
            }

        }
    }

    private fun sendreseemail(email: String) {
        mAuth?.sendPasswordResetEmail(email)?.addOnCompleteListener {
                task->
            if (task.isSuccessful){
                findViewById<Button>(R.id.forgot_send_email_button).visibility=View.INVISIBLE
                findViewById<TextView>(R.id.forgot_send_email_textview).visibility=View.VISIBLE
                Snackbar.make(findViewById(R.id.forgot_password_layout),"email is sand", Snackbar.LENGTH_SHORT).show()
            }
            else{
                Snackbar.make(findViewById(R.id.forgot_password_layout), task.exception.toString(), Snackbar.LENGTH_SHORT).show()
            }
        }

    }
}