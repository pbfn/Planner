package com.pedrobruno.planner.ui.components.inputs

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedrobruno.planner.R
import com.pedrobruno.planner.ui.theme.Lime300
import com.pedrobruno.planner.ui.theme.Zinc100
import com.pedrobruno.planner.ui.theme.Zinc400
import com.pedrobruno.planner.ui.theme.Zinc800
import com.pedrobruno.planner.ui.theme.Zinc950

@Composable
fun PlannerInput(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    @DrawableRes leadingIcon: Int,
    isPassword: Boolean,
    showPassword: Boolean = false,
    singleLine: Boolean = true,
    readOnly: Boolean = false,
    onClickShowPassword: () -> Unit = {},
    onValueChange: (String) -> Unit,
) {
    val iconPassword = if (showPassword)
        R.drawable.eye
    else
        R.drawable.eye_off

    OutlinedTextField(
        modifier = modifier.heightIn(56.dp),
        value = value,
        onValueChange = { newValue ->
            onValueChange(newValue)
        },
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.bodyMedium.copy(color = Zinc400),
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(leadingIcon), contentDescription = "leading_icon",
                modifier = Modifier.size(20.dp),
                tint = Zinc400
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            disabledContainerColor = Zinc950,
            focusedContainerColor = Zinc950,
            unfocusedContainerColor = Zinc950,
            unfocusedBorderColor = Zinc800,
            focusedBorderColor = Lime300,
            focusedTextColor = Zinc100,
            unfocusedTextColor = Zinc100
        ),
        singleLine = singleLine,
        readOnly = readOnly,
        trailingIcon = {
            if (isPassword)
                IconButton(
                    modifier = Modifier.size(20.dp),
                    onClick = {
                        onClickShowPassword()
                    }) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(iconPassword),
                        contentDescription = "icon_password"
                    )
                }
        },
        visualTransformation = if (showPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}

@Preview(name = "empty / default")
@Composable
private fun PlannerInputPreview0() {
    PlannerInput(
        value = "",
        placeholder = "Placeholder",
        isPassword = false,
        onValueChange = {},
        leadingIcon = R.drawable.ic_launcher_foreground,
        onClickShowPassword = {}
    )
}


@Preview(name = "filled / default")
@Composable
private fun PlannerInputPreview2() {
    PlannerInput(
        value = "Text",
        placeholder = "Placeholder",
        isPassword = false,
        onValueChange = {},
        leadingIcon = R.drawable.ic_launcher_foreground,
        onClickShowPassword = {}
    )
}

@Preview(name = "password / empty")
@Composable
private fun PlannerInputPreview3() {
    PlannerInput(
        value = "",
        placeholder = "Password",
        isPassword = true,
        showPassword = false,
        onValueChange = {},
        leadingIcon = R.drawable.ic_launcher_foreground,
        onClickShowPassword = {}
    )
}

@Preview(name = "password / default / false")
@Composable
private fun PlannerInputPreview4() {
    PlannerInput(
        value = "1234",
        placeholder = "Password",
        isPassword = true,
        showPassword = false,
        onValueChange = {},
        leadingIcon = R.drawable.ic_launcher_foreground,
        onClickShowPassword = {}
    )
}

@Preview(name = "password / default / true")
@Composable
private fun PlannerInputPreview5() {
    PlannerInput(
        value = "1234",
        placeholder = "Password",
        isPassword = true,
        showPassword = true,
        onValueChange = {},
        leadingIcon = R.drawable.ic_launcher_foreground,
        onClickShowPassword = {}
    )
}


