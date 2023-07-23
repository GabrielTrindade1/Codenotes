import android.content.Context
import android.os.Build
import android.os.Parcelable
import androidx.annotation.RequiresApi
import kotlinx.parcelize.Parcelize
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.streams.toList

object CodigosCSV{
    @RequiresApi(Build.VERSION_CODES.N)
    fun main(context: Context): List<Product> {
        return BufferedReader(
            InputStreamReader(context.assets.open("codigos.csv"), Charsets.UTF_8)
        ).lines().map {
            val parameters = it.split(",")
            Product(parameters[0].toInt(), parameters[1])
        }.toList()
    }
}


@Parcelize
data class Product(val id: Int, val produto: String): Parcelable
