package admiral.group.tuneconsultingtask.app

import android.app.Application
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp()
class MyApplication:MultiDexApplication()