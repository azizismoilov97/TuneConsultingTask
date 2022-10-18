package admiral.group.core2

import android.content.Context
import android.widget.Toast

class Utils
    fun showToast(context: Context, toastMsg:String){
        Toast.makeText(context, toastMsg, Toast.LENGTH_SHORT).show()
    }
