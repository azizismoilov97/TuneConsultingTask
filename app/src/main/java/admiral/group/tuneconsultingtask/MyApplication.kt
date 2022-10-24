package admiral.group.tuneconsultingtask

import android.app.Application
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

/*
   SOLID - Dependenvy inversion

   - Annotating our application class with
     the @HiltAndroidApp is help to trigger Hilt’s code generation
     .
 */

@HiltAndroidApp()
class MyApplication:MultiDexApplication()

//task 2

