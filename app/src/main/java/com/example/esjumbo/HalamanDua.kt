package com.example.esjumbo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.esjumbo.data.FormState
import com.example.esjumbo.data.OrderUIState
import com.example.esjumbo.ui.theme.komponen.DataPemesan
import com.example.esjumbo.ui.theme.komponen.FormatLabelHarga

@Composable
fun HalamanDua (
    formState: FormState,
    orderUiState: OrderUIState,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        Pair(stringResource(R.string.quantity), orderUiState.jumlah),
        Pair(stringResource(R.string.flavor), orderUiState.rasa)
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier =
            Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement =
            Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            DataPemesan(
                namaPemesan = formState.nama,
                alamatPemesan = formState.alamat,
                telpPemesan = formState.hp
            )
            Spacer(modifier = Modifier.padding(8.dp))
            items.forEach { items ->
                Column {
                    Text(items.first.uppercase())
                    Text(text = items.second.toString(), fontWeight = FontWeight.Bold)
                }
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            FormatLabelHarga(
                subtotal = orderUiState.harga,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Row(
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {}
                ) {
                    Text(stringResource(R.string.send))
                }
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicked
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun show2() {
    HalamanDua(
        orderUiState = OrderUIState(),
        formState = FormState(),
        onCancelButtonClicked = { /*TODO*/ })
}