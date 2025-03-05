package com.pedrobruno.planner.ui.components.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedrobruno.planner.R
import com.pedrobruno.planner.data.model.User
import com.pedrobruno.planner.data.model.mock.mockedUser

@Composable
fun TopDataUser(modifier: Modifier = Modifier, user: User) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(64.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "image_user"
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        Text(text = "Olá, ", style = MaterialTheme.typography.bodyMedium.copy(Color(0xFFE1E1E6)))
        Text(
            text = "${user.name}!", style = MaterialTheme.typography.bodyMedium.copy(
                color = Color(0xFFE1E1E6),
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Preview
@Composable
private fun TopDataUserPreview() {
    TopDataUser(
        user = mockedUser
    )
}