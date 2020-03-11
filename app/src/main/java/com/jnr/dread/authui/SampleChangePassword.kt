package com.jnr.dread.authui

import android.widget.Toast
import com.jnr.dread.auth_ui.BaseChangePasswordFragment

class SampleChangePassword : BaseChangePasswordFragment() {

    override fun doResetPassword(userId: String, oldPass: String, newPass: String) {
        Toast.makeText(context, "Time To Change My password", Toast.LENGTH_SHORT).show()
    }
}