package com.paawk4.presentation.ui.items

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.paawk4.presentation.ui.theme.AppBgColor
import com.paawk4.presentation.ui.theme.ErrorColor
import com.paawk4.presentation.ui.utils.TextFieldTypes

private const val PHONE_MASK = "+7 (000) 000 - 00 - 00"

@Composable
fun AppTextField(
    text: String,
    label: String,
    type: TextFieldTypes,
    isError: Boolean,
    onValueChanged: (String) -> Unit
) {
    TextField(
        value = text,
        onValueChange = {
            when (type) {
                TextFieldTypes.PHONE_TYPE -> onValueChanged(it.take(PHONE_MASK.count { it == '0' }))
                TextFieldTypes.EMAIL_TYPE -> onValueChanged(it)
                TextFieldTypes.NUMBER_TYPE -> onValueChanged(it)
                TextFieldTypes.TEXT_TYPE -> onValueChanged(it)
            }
        },
        label = {
            Text(text = label)
        },
        keyboardOptions = when (type) {
            TextFieldTypes.PHONE_TYPE -> KeyboardOptions(keyboardType = KeyboardType.Phone)
            TextFieldTypes.EMAIL_TYPE -> KeyboardOptions(keyboardType = KeyboardType.Email)
            TextFieldTypes.NUMBER_TYPE -> KeyboardOptions(keyboardType = KeyboardType.Number)
            TextFieldTypes.TEXT_TYPE -> KeyboardOptions(keyboardType = KeyboardType.Text)
        },
        visualTransformation = when (type) {
            TextFieldTypes.PHONE_TYPE -> PhoneVisualTransformation(PHONE_MASK, '0')
            TextFieldTypes.EMAIL_TYPE -> VisualTransformation.None
            TextFieldTypes.NUMBER_TYPE -> VisualTransformation.None
            TextFieldTypes.TEXT_TYPE -> VisualTransformation.None
        },
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = AppBgColor,
            focusedContainerColor = AppBgColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            errorContainerColor = ErrorColor
        ),
        modifier = Modifier.fillMaxWidth(),
        isError = isError
    )
}

class PhoneVisualTransformation(val mask: String, val maskNumber: Char) : VisualTransformation {

    private val maxLength = mask.count { it == maskNumber }

    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.length > maxLength) text.take(maxLength) else text

        val annotatedString = buildAnnotatedString {
            if (trimmed.isEmpty()) return@buildAnnotatedString

            var maskIndex = 0
            var textIndex = 0
            while (textIndex < trimmed.length && maskIndex < mask.length) {
                if (mask[maskIndex] != maskNumber) {
                    val nextDigitIndex = mask.indexOf(maskNumber, maskIndex)
                    append(mask.substring(maskIndex, nextDigitIndex))
                    maskIndex = nextDigitIndex
                }
                append(trimmed[textIndex++])
                maskIndex++
            }
        }

        return TransformedText(annotatedString, PhoneOffsetMapper(mask, maskNumber))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PhoneVisualTransformation) return false
        if (mask != other.mask) return false
        if (maskNumber != other.maskNumber) return false
        return true
    }

    override fun hashCode(): Int {
        return mask.hashCode()
    }
}

private class PhoneOffsetMapper(val mask: String, val numberChar: Char) : OffsetMapping {

    override fun originalToTransformed(offset: Int): Int {
        var noneDigitCount = 0
        var i = 0
        while (i < offset + noneDigitCount) {
            if (mask[i++] != numberChar) noneDigitCount++
        }
        return offset + noneDigitCount
    }

    override fun transformedToOriginal(offset: Int): Int =
        offset - mask.take(offset).count { it != numberChar }
}