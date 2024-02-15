package com.example.androidsdktutorial.ui.account

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.androidsdktutorial.R
import java.util.UUID

class AccountFragment : Fragment() {

    private lateinit var baseView: LinearLayout
    private fun getRootView(): LinearLayout {
        return baseView.findViewById<LinearLayout>(R.id.fragment_account)
    }

    private val sharedPreference by lazy {
        context?.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        baseView = inflater.inflate(R.layout.fragment_account, container, false) as LinearLayout

        val userId = sharedPreference?.getString("userId", null)

        if (userId.isNullOrBlank()) {
            getRootView().addView(renderWithoutSession(inflater, container))
        } else {
            getRootView().addView(renderWithSession(inflater, container))
        }

        return baseView
    }

    private fun renderWithSession(inflater: LayoutInflater, container: ViewGroup?): View {
        val viewWithSession = inflater.inflate(R.layout.view_with_session, container, false)
        val userId = sharedPreference?.getString("userId", "")!!
        viewWithSession.findViewById<TextView>(R.id.userId).text = "userId: ${userId}"
        viewWithSession.findViewById<Button>(R.id.logout_button).setOnClickListener(this::onLogout)
        return viewWithSession
    }

    private fun renderWithoutSession(inflater: LayoutInflater, container: ViewGroup?): View {
        val viewWithoutSession = inflater.inflate(R.layout.view_without_session, container, false)
        viewWithoutSession.findViewById<Button>(R.id.login_button).setOnClickListener(this::onLogin)
        return viewWithoutSession
    }

    private fun onLogin(view: View) {
        Toast.makeText(context, "ログイン完了", Toast.LENGTH_SHORT).show()
        sharedPreference?.edit()?.putString("userId", UUID.randomUUID().toString())?.apply()
        getRootView().removeAllViews()
        getRootView().addView(renderWithSession(inflater,container))
    }

    private fun onLogout(view: View) {
        Toast.makeText(context, "ログアウト完了", Toast.LENGTH_SHORT).show()
        sharedPreference?.edit()?.remove("userId")?.apply()
        getRootView().removeAllViews()
        getRootView().addView(renderWithoutSession(inflater,container))
    }

}