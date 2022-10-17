package admiral.group.tuneconsultingtask.customView


import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton

class CustomButton(
    context: Context,
    attrs: AttributeSet): LinearLayout(context, attrs) {

    init {
           inflate(context,
               admiral.group.tuneconsultingtask.R.layout.button_view, this)

           val button:AppCompatButton=findViewById(admiral.group.tuneconsultingtask.R.id.customButton)

        val attributes=context.obtainStyledAttributes(attrs,
            admiral.group.tuneconsultingtask.R.styleable.CustomButton
        )
        button.setTextColor(attributes.getColor(admiral.group.tuneconsultingtask.R.styleable.CustomButton_textColor, Color.BLACK))
        button.text=attributes.getText(admiral.group.tuneconsultingtask.R.styleable.CustomButton_text)
        button.background=attributes.getDrawable(admiral.group.tuneconsultingtask.R.styleable.CustomButton_background)

        attributes.recycle()
    }




}