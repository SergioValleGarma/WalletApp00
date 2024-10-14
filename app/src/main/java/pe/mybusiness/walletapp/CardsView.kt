package pe.mybusiness.walletapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.mybusiness.walletapp.data.models.Card
import pe.mybusiness.walletapp.ui.theme.BlueEnd
import pe.mybusiness.walletapp.ui.theme.BlueStart
import pe.mybusiness.walletapp.ui.theme.GreenEnd
import pe.mybusiness.walletapp.ui.theme.GreenStart
import pe.mybusiness.walletapp.ui.theme.OrangeEnd
import pe.mybusiness.walletapp.ui.theme.OrangeStart
import pe.mybusiness.walletapp.ui.theme.PurpleEnd
import pe.mybusiness.walletapp.ui.theme.PurpleStart


@Preview(showBackground = true)
@Composable
fun CardsView(){
    LazyRow {
        items(cards.size){index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index:Int){
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cards.size-1){
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD"){
        image = painterResource(id = R.drawable.ic_mastercard)
    }
    Box(modifier = Modifier
        .padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(card.color)
            .width(250.dp)
            .height(160.dp)
            .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Image(painter = image,
                contentDescription = card.cardName,
                modifier = Modifier
                    .width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

fun getGradient(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "3456 8484 1233 3456",
        cardName = "Business",
        balance = 45.56,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "4443 1111 2222 3333",
        cardName = "Savings",
        balance = 2345.56,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "2460 0963 1111 3311",
        cardName = "School",
        balance = 456.73,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "MASTERCARD",
        cardNumber = "2999 3333 1122 7788",
        cardName = "Trips",
        balance = 12899.56,
        color = getGradient(GreenStart, GreenEnd)
    )
)











