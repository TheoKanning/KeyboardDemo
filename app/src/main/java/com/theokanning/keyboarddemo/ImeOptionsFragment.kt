package com.theokanning.keyboarddemo


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_ime_options.*


/**
 * A Fragment that displays the available IME options
 */
class ImeOptionsFragment : Fragment() {

    private val listener = object : TextView.OnEditorActionListener {
        override fun onEditorAction(textView: TextView, actionId: Int, event: KeyEvent?): Boolean {
            when(actionId) {
                EditorInfo.IME_ACTION_SEARCH -> toast("Search Pressed")
                EditorInfo.IME_ACTION_DONE -> toast("Done Pressed")
            }
            return false // return true to consume event and prevent keyboard from disappearing
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_ime_options, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imeDone.setOnEditorActionListener(listener)
        imeSearch.setOnEditorActionListener(listener)
    }

    private fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
