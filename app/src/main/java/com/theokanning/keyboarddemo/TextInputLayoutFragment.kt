package com.theokanning.keyboarddemo


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_text_input_layout.*


/**
 * A Fragment that show some of the available TextInputLayout features
 */
class TextInputLayoutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_text_input_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signIn.setOnClickListener { signIn() }
        password.setOnEditorActionListener(object :TextView.OnEditorActionListener{
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                signIn()
                return false // return false so that the keyboard is dismissed
            }
        })
    }

    private fun signIn() {
        if(password.text.toString() == "1234" ) {
            passwordWrapper.error = null
            Toast.makeText(context, "\uD83D\uDCAF", Toast.LENGTH_LONG).show()
        } else {
            passwordWrapper.error = "Wrong password"
        }
    }
}
