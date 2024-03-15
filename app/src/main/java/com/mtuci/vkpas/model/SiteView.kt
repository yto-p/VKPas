package com.mtuci.vkpas.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mtuci.vkpas.R
import com.mtuci.vkpas.main.SitesEvent
import com.mtuci.vkpas.main.SitesState
import com.mtuci.vkpas.ui.theme.GrayBackgroundMedium
import com.mtuci.vkpas.ui.theme.GrayTextDark

@Composable
fun SiteContent(
    state: SitesState,
    index: Int,
    onEvent: (SitesEvent) -> Unit){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 12.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(percent = 35))
                .clickable { }
                .border(
                    width = 1.dp,
                    brush = SolidColor(GrayBackgroundMedium),
                    shape = RoundedCornerShape(percent = 35)
                )
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.default_icon),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.width(12.dp))
            Column {
                Text(
                    text = state.sites[index].name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    maxLines = 1
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = state.sites[index].link,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = GrayTextDark,
                    maxLines = 1
                )
            }
        }
        IconButton(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 10.dp),
            onClick = { onEvent(SitesEvent.DeleteSite(state.sites[index])) }) {
            Icon(
                imageVector = Icons.Outlined.Delete,
                contentDescription = "",
                tint = GrayTextDark
            )
        }
    }
}