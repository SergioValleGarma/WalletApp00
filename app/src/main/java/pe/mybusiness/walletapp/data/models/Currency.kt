package pe.mybusiness.walletapp.data.models

import androidx.compose.ui.graphics.vector.ImageVector
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
