package com.jnr.dread.authui

import androidx.navigation.fragment.findNavController
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
        this.findNavController().navigate(R.id.sampleChangePassword)
    }

    override fun onReset() {
        TODO("Not yet implemented")
    }
}