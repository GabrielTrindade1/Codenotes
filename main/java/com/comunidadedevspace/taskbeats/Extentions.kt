package com.comunidadedevspace.taskbeats

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri
import java.text.Normalizer

fun CharSequence.removeAccents(): String {
    val temp = Normalizer.normalize(this, Normalizer.Form.NFD)
    return Regex("\\p{InCombiningDiacriticalMarks}+").replace(temp, "")
}

fun Context.startWhatsAppIntent(
    WhatsAppNumber: String = "+5515996224553",
    TextToSend: String = ""
) {
    try {
        Intent(
            Intent.ACTION_VIEW,
            Constants.WHATS_APP_URL.addPhone(WhatsAppNumber).addMessage(TextToSend).toUri()
        ).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    } catch (exception: Exception) {
        startWhatsAppInPlayStoreIntent()
    }
}

fun Context.startWhatsAppInPlayStoreIntent() {
    Intent(Intent.ACTION_VIEW, Constants.WHATS_APP_PLAY_STORE_URL.toUri()).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(this)
    }
}

fun String.addPhone(phoneNumber: String) = this+"phone=$phoneNumber&"
fun String.addMessage(message: String) = this+"text=$message&"