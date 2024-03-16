package com.mtuci.vkpas.password

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mtuci.vkpas.R
import com.mtuci.vkpas.ui.theme.BlueBackgroundMedium
import com.mtuci.vkpas.ui.theme.GrayBackgroundMedium
import com.mtuci.vkpas.ui.theme.GrayTextDark

@Composable
fun PasswordContent(
    password: String,
    onPasswordChange: (String) -> Unit,
    onEnterClick: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 22.dp)
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Enter to VKPas",
            color = Color.Black,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        BasicTextField(
            value = password,
            onValueChange = onPasswordChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
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
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .padding(bottom = 22.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(35))
                .background(BlueBackgroundMedium)
                .clickable { onEnterClick() },
        ) {
            Text(
                text = stringResource(R.string.enter),
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 18.dp)
            )
        }
    }

}