import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.data.ProductToSave

class CartListAdapter( val codes: List<ProductToSave>, val onDeleteItem: (ProductToSave)-> Unit) : RecyclerView.Adapter<CartListAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_task, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val code = codes[position]
        holder.bind(code)
    }

    override fun getItemCount(): Int {
        return codes.size
    }

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val codeTextView: TextView = itemView.findViewById(R.id.tv_produto)
        private val delButton: ImageButton = itemView.findViewById(R.id.del_button)
        private val quantityTextView : TextView = itemView.findViewById(R.id.tv_quantidade)

        fun bind(code: ProductToSave) {
            codeTextView.text = code.productName
            quantityTextView.text = quantityTextView.text.toString()+" ${code.quantity}"
            delButton.setOnClickListener {
                onDeleteItem(code)
            }
        }
    }
}
