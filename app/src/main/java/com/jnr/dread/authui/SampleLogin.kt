package com.jnr.dread.authui

import android.widget.Toast
import com.jnr.dread.auth_ui.BaseLoginFragment
import com.jnr.dread.auth_ui.LoginPayload

class SampleLogin: BaseLoginFragment() {

    override fun onLogin(loginPayload: LoginPayload) {
        TODO("Not yet implemented")
    }

    override fun onRegister() {
        TODO("Not yet implemented")
    }

    override fun onChangePassword() {
        Toast.makeText(context,"I Wish Change My Password",Toast.LENGTH_SHORT).show()
    }

    override fun onReset() {
        TODO("Not yet implemented")
    }
}