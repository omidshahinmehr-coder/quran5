package com.example.quranapp.data

import android.content.Context

data class AppSettings(
    val quranFontSize: Float = 22f,
    val quranUseCustomFont: Boolean = true,
    val translationFontSize: Float = 16f,
    val translationUseCustomFont: Boolean = true
)

class SettingsRepository(context: Context) {
    private val prefs = context.applicationContext
        .getSharedPreferences("quran_settings", Context.MODE_PRIVATE)

    fun load(): AppSettings = AppSettings(
        quranFontSize = prefs.getFloat(KEY_QURAN_SIZE, 22f),
        quranUseCustomFont = prefs.getBoolean(KEY_QURAN_FONT, true),
        translationFontSize = prefs.getFloat(KEY_TR_SIZE, 16f),
        translationUseCustomFont = prefs.getBoolean(KEY_TR_FONT, true)
    )

    fun save(settings: AppSettings) {
        prefs.edit()
            .putFloat(KEY_QURAN_SIZE, settings.quranFontSize)
            .putBoolean(KEY_QURAN_FONT, settings.quranUseCustomFont)
            .putFloat(KEY_TR_SIZE, settings.translationFontSize)
            .putBoolean(KEY_TR_FONT, settings.translationUseCustomFont)
            .apply()
    }

    companion object {
        private const val KEY_QURAN_SIZE = "quran_font_size"
        private const val KEY_QURAN_FONT = "quran_use_custom_font"
        private const val KEY_TR_SIZE = "translation_font_size"
        private const val KEY_TR_FONT = "translation_use_custom_font"
    }
}
