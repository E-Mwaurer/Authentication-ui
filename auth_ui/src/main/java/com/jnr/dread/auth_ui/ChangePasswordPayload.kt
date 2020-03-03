package com.jnr.dread.auth_ui

data class ChangePasswordPayload(val email: String, val oldSecret: String, val newSecret: String)