package admiral.group.tuneconsultingtask.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "projects")
data class ProjectEntity (

    @ColumnInfo(name = "nameProject")
    var nameProject:String,

    @ColumnInfo(name = "fullName")
    var fullName:String,

    @ColumnInfo(name = "phoneNumber")
    var phoneNumber:String,

    @ColumnInfo(name = "production")
    var production:String,

    @ColumnInfo(name = "interval")
    var interval:String,

    @ColumnInfo(name = "continious")
    var continious:String,

    @PrimaryKey(autoGenerate = true)
    var id:Int=1

)