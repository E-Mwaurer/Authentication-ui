package com.jnr.dread.auth_ui

import android.os.Bundle
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
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
            btnRegister.setOnClickListener(this@BaseLoginFragment)
            btnLogin.setOnClickListener(this@BaseLoginFragment)
            resetPasswordLink.apply {
                text = createStringFromHtml(resources.getString(R.string.reset_password_link_text))
                movementMethod = LinkMovementMethod.getInstance()
            }
        }
        return binding.root
    }

    abstract fun onLogin(loginPayload: LoginPayload)
    abstract fun onRegister()
    abstract fun onChangePassword()
    abstract fun onReset()

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_login -> {
                onLogin(loginPayload)
            }
            R.id.btn_register -> {
                onRegister()
            }
            else -> {
                onReset()
            }
        }
    }

    private fun createStringFromHtml(string: String): Spanned {
        return HtmlCompat.fromHtml(string, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}
