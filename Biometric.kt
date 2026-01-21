// AuthTrampolineActivity.kt
private val deviceCredentialLauncher = registerForActivityResult(
    ActivityResultContracts.StartActivityForResult()
) { result ->
    if (result.resultCode == Activity.RESULT_OK) {
        sendBroadcast(Intent("com.example.security.AUTH_SUCCESS"))
    }
    finish()
}

// Inside Biometric Callback
override fun onAuthenticationFailed() {
    if (++failureCount >= 3) {
        val km = getSystemService(KEYGUARD_SERVICE) as KeyguardManager
        val intent = km.createConfirmDeviceCredentialIntent("Auth", "Enter PIN")
        deviceCredentialLauncher.launch(intent)
    }
}