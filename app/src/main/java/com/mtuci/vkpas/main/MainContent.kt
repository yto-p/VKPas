package com.mtuci.vkpas.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mtuci.vkpas.R
import com.mtuci.vkpas.model.SiteContent
import com.mtuci.vkpas.model.SiteData
import com.mtuci.vkpas.ui.theme.BlueBackgroundMedium
import com.mtuci.vkpas.ui.theme.GrayBackgroundLight

@Composable
fun MainContent(
    sites: List<SiteData>, addSite: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayBackgroundLight)
            .safeDrawingPadding()
    ) {
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.passwords),
            color = Color.Black,
            fontSize = 32.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 44.dp, topEnd = 44.dp))
                .background(Color.White)
                .padding(top = 22.dp)
                .padding(horizontal = 22.dp)
        ) {
            Column(Modifier.fillMaxSize()) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(sites){ site ->
                        SiteContent(site = site)
                    }
                }

            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 22.dp)
                    .size(72.dp)
                    .clip(RoundedCornerShape(35))
                    .background(BlueBackgroundMedium)
                    .clickable { addSite() },
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

    }
}