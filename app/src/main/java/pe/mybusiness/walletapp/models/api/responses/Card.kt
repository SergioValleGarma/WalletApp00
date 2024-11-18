package pe.mybusiness.walletapp.models.api.responses

data class Card(
    val cardType:String,
    val cardNumber:String,
    val cardName:String,
    val balance:Double,
    //val color:Brush
    val startColor: String,
    val endColor: String
)