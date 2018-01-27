package com.theokanning.keyboarddemo


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.fragment_show_hide.*


/**
 * A Fragment that allows the user to manually show or hide the keyboard
 */
class ShowHideFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_show_hide, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hide.setOnClickListener { hideKeyboard(emailAddress) }
        show.setOnClickListener { showKeyboard(emailAddress) }
    }

    private fun showKeyboard(view : View) {
        val inputMethodManager = getInputMethodManager()
        view.requestFocus()
        inputMethodManager.showSoftInput(view, 0)
    }

    private fun hideKeyboard(view : View) {
        val inputMethodManager = getInputMethodManager()
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun getInputMethodManager() : InputMethodManager {
        return activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }
}
