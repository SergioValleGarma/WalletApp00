package pe.mybusiness.walletapp.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currencies")
data class Currency(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val name:String,
    val buy:Float,
    val sell:Float
    ///val icon:ImageVector
)
