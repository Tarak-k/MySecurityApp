// SecurityAccessibilityService.kt
private val authReceiver = object : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "com.example.security.AUTH_SUCCESS") {
            removeOverlay()
        }
    }
}

override fun onServiceConnected() {
    val filter = IntentFilter("com.example.security.AUTH_SUCCESS")
    registerReceiver(authReceiver, filter)
}