package admiral.group.tuneconsultingtask

import admiral.group.tuneconsultingtask.util.ItemClickListener
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
           inflate(context, R.layout.button_view, this)

           val button:AppCompatButton=findViewById(R.id.customButton)

        val attributes=context.obtainStyledAttributes(attrs, R.styleable.CustomButton)
        button.setTextColor(attributes.getColor(R.styleable.CustomButton_textColor, Color.BLACK))
        button.text=attributes.getText(R.styleable.CustomButton_text)
        button.background=attributes.getDrawable(R.styleable.CustomButton_background)

        attributes.recycle()
    }




}