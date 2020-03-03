package com.jnr.dread.auth_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.jnr.dread.auth_ui.databinding.FragmentBaseLoginBinding
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

abstract class BaseLoginFragment : Fragment(), View.OnClickListener {

    open val layoutId: Int = R.layout.fragment_base_login

    private val loginPayload: LoginPayload by inject { parametersOf("", "") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentBaseLoginBinding>(
            inflater,
            layoutId,
            container,
            false
        )

        binding.apply {
            lifecycleOwner = this@BaseLoginFragment
            payload = loginPayload
            btnReset.setOnClickListener(this@BaseLoginFragment)
            btnSubmit.setOnClickListener(this@BaseLoginFragment)
        }
        return binding.root
    }

    abstract fun onLogin(loginPayload: LoginPayload)
    abstract fun onRegister()
    abstract fun onChangePassword()
    abstract fun onReset()

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_submit) {
            onLogin(loginPayload)
        } else {
            onReset()
        }
    }
}
