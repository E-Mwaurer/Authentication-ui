package com.jnr.dread.auth_ui

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_base_change_password.view.*

abstract class BaseChangePasswordFragment : Fragment() {

    open val layoutId: Int = R.layout.fragment_base_change_password
    open val appIcon: Int = R.drawable.ic_auth_icon

    private lateinit var userId: String
    private lateinit var oldPass: String
    private lateinit var newPass: String

    abstract fun doResetPassword(userId: String, oldPass: String, newPass: String)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(layoutId, container, false)
        initUiVariables(root)
        setBtnResetPasswordClickListener(root)
        setUpAppIcon(root)
        return root
    }

    private fun setUpAppIcon(view: View) {
        view.app_icon_id.setImageResource(appIcon)
    }

    private fun initUiVariables(view: View) {
        userId = view.userId.text.toString()
        oldPass = view.old_password.text.toString()
        newPass = view.new_password.text.toString()
    }

    private fun setBtnResetPasswordClickListener(view: View) {
        view.btn_reset_pass.setOnClickListener {
            doResetPassword(userId, oldPass, newPass)
        }
    }
/*
    fun ShowHidePass(view:View) {
        if (view.id === R.id.show_pass_btn)
        {
            if (edit_password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance()))
            {
                ((ImageView(view)).setImageResource(R.drawable.hide_password))
                //Show Password
                edit_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
            }
            else
            {
                ((view) as ImageView).setImageResource(R.drawable.show_password)
                //Hide Password
                edit_password.setTransformationMethod(PasswordTransformationMethod.getInstance())
            }
        }
    }*/
}
