package admiral.group.tuneconsultingtask.util


//Single responsibility principle - SOLID

interface ItemClickListener{
    fun onItemClick(nameProject:String, fullname:String, phoneNumber:String,
    production:String, interval:String, continuous:String)
}