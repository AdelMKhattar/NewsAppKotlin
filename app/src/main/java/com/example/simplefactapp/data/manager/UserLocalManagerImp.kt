package com.example.simplefactapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import com.example.simplefactapp.domain.manager.UserLocalManager
import kotlinx.coroutines.flow.Flow
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.simplefactapp.util.Constants
import com.example.simplefactapp.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.map


class UserLocalManagerImp(
    private val context: Context
) : UserLocalManager {
    override suspend fun saveAppEntry() {
       context.dataStore.edit { settings->
           settings[PreferencesKeys.APP_ENTRY]=true
       }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKeys.APP_ENTRY] ?: false
        }
    }

}

// Extension property on Context to provide a singleton DataStore<Preferences> instance
// using the "user_settings" file name. Delegated to preferencesDataStore for automatic creation.
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKeys {
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}

