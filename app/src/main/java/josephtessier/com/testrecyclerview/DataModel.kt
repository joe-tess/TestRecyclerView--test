package josephtessier.com.testrecyclerview

import android.support.v7.widget.RecyclerView
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView

/**
 * Created by Joseph Tessier on 28-11-2017.
 */
class DataModel(foods: String) {
    var foods:String = foods
}

class CostomAdapter(dataModel:ArrayList<DataModel>):RecyclerView.Adapter<CostomAdapter.CostomViewHolder>(){

    var mDataModel = dataModel
    var mCheckedIds = SparseBooleanArray()

    override fun onBindViewHolder(holder: CostomViewHolder?, position: Int) {
        var model = mDataModel[position]
        var foods = model.foods
        holder!!.food_name_tv.text = foods
        holder.check_box.isChecked = mCheckedIds.get(position)
        holder.check_box.setOnClickListener {
            checkCheckBox(position,!mCheckedIds.get(position))
        }
    }

    fun checkCheckBox(pos:Int,value:Boolean){
        if(value){
            mCheckedIds.put(pos,true)
        }else{
            mCheckedIds.delete(pos)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mDataModel.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CostomViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_row,parent,false)
        return (CostomViewHolder(view))
    }

    class CostomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var food_name_tv: TextView
        var check_box: CheckBox
        init {
            this.food_name_tv = itemView.findViewById(R.id.food_tv)
            this.check_box = itemView.findViewById(R.id.chk_box)
        }

    }

}