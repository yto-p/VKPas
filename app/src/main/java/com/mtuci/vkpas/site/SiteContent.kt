package com.mtuci.vkpas.site

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mtuci.vkpas.R
import com.mtuci.vkpas.ui.theme.BlueBackgroundMedium
import com.mtuci.vkpas.ui.theme.GrayBackgroundLight
import com.mtuci.vkpas.ui.theme.GrayBackgroundMedium
import com.mtuci.vkpas.ui.theme.GrayTextDark

@Composable
fun SiteContent(
    name: String,
    link: String,
    password: String,
    onNameChange: (String) -> Unit,
    onLinkChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onBackClick: () -> Unit,
    onSaveSiteClick: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayBackgroundLight)
            .safeDrawingPadding()
    ) {
        Image(
            painter = painterResource(R.drawable.ic_cancel),
            contentDescription = null,
            modifier = Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .clickable(onClick = onBackClick)
                .padding(11.dp)
                .size(14.dp)
        )
        Text(
            text = stringResource(R.string.site),
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
                BasicTextField(
                    value = name,
                    onValueChange = onNameChange,
                    singleLine = true,
                    decorationBox = { textField ->
                        Column(
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    brush = SolidColor(GrayBackgroundMedium),
                                    shape = RoundedCornerShape(18.dp)
                                )
                                .padding(
                                    horizontal = 14.dp,
                                    vertical = 10.dp
                                )
                        ) {
                            Text(
                                text = stringResource(id = R.string.name),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = GrayTextDark
                                )
                            Spacer(Modifier.height(8.dp))
                            textField()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp))
                )
                Spacer(modifier = Modifier.height(12.dp))
                BasicTextField(
                    value = link,
                    onValueChange = onLinkChange,
                    singleLine = true,
                    decorationBox = { textField ->
                        Column(
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    brush = SolidColor(GrayBackgroundMedium),
                                    shape = RoundedCornerShape(18.dp)
                                )
                                .padding(
                                    horizontal = 14.dp,
                                    vertical = 10.dp
                                )
                        ) {
                            Text(
                                text = stringResource(id = R.string.link),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = GrayTextDark
                            )
                            Spacer(Modifier.height(8.dp))
                            textField()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp))
                )
                Spacer(modifier = Modifier.height(12.dp))
                BasicTextField(
                    value = password,
                    onValueChange = onPasswordChange,
                    singleLine = true,
                    decorationBox = { textField ->
                        Column(
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    brush = SolidColor(GrayBackgroundMedium),
                                    shape = RoundedCornerShape(18.dp)
                                )
                                .padding(
                                    horizontal = 14.dp,
                                    vertical = 10.dp
                                )
                        ) {
                            Text(
                                text = stringResource(id = R.string.password),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = GrayTextDark
                            )
                            Spacer(Modifier.height(8.dp))
                            textField()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp))
                )

            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 22.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(35))
                    .background(BlueBackgroundMedium)
                    .clickable { onSaveSiteClick() },
            ) {
                Text(
                    text = stringResource(R.string.save_site),
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(vertical = 18.dp)
                )
            }
        }
    }
}