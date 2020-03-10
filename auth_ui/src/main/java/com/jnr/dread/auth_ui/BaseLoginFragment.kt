package com.jnr.dread.auth_ui

import android.os.Bundle
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.jnr.dread.auth_ui.databinding.FragmentBaseLoginBinding
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

abstract class BaseLoginFragment : Fragment(), View.OnClickListener {

    open val layoutId: Int = R.layout.fragment_base_login
    open val copyrightsTextMarkup: Int = R.string.copyrights_markup
    open val appIcon: Int = R.drawable.ic_auth_icon
    private val loginPayload: LoginPayload by inject { parametersOf("", "") }

    abstract fun onLogin(loginPayload: LoginPayload)
    abstract fun onRegister()
    abstract fun onChangePassword()
    abstract fun onReset()

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
            setBtnRegisterClickListener()
            setBtnLoginClickListener()
            setUpResetPassword()
            setUpCustomIcon()
            setUpCustomCopyrightsMarkup()
        }

        return binding.root
    }

    private fun FragmentBaseLoginBinding.setUpCustomIcon() {
        Glide.with(this@BaseLoginFragment).load(appIcon).into(appIconId)
    }

    private fun FragmentBaseLoginBinding.setUpCustomCopyrightsMarkup() {
        copyrightText.text = context!!.resources.getString(copyrightsTextMarkup)
    }

    private fun FragmentBaseLoginBinding.setUpResetPassword() {
        resetPasswordLink.apply {
            text = createSpannedString(resources.getString(R.string.reset_password_link_text))
            setOnClickListener(this@BaseLoginFragment)
        }
    }

    private fun FragmentBaseLoginBinding.setBtnLoginClickListener() {
        btnLogin.setOnClickListener(this@BaseLoginFragment)
    }

    private fun FragmentBaseLoginBinding.setBtnRegisterClickListener() {
        btnRegister.setOnClickListener(this@BaseLoginFragment)
    }

    private fun createSpannedString(text: String): Spanned {
        return HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_login -> {
                onLogin(loginPayload)
            }
            R.id.btn_register -> {
                onRegister()
            }
            R.id.reset_password_link -> {
                onChangePassword()
            }
            else -> {
                onReset()
            }
        }
    }

}
