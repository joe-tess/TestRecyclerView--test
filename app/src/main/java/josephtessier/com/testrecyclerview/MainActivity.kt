package josephtessier.com.testrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var costomAdapter:CostomAdapter?=null
    var dataModel:ArrayList<DataModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var food_list = arrayOf("apples","avocado","alfalfa","bacon","baked beans",
                "banana","bison","broccoli", "blah blah blah","bread","barley","Cabbage","carrot","crab","curry",
                "chips","catfish","dates","donuts","eggs","eggrolls","fish","franks","Noodles",
                "Pizza","Pancakes","Toast","Zucchini")

        for(i in 0..food_list.size-1) {
            dataModel.add(DataModel(food_list[i]))
        }

        costomAdapter = CostomAdapter(dataModel)
        var layoutManager = LinearLayoutManager(this@MainActivity)
        rec_view.layoutManager = layoutManager
        rec_view.adapter = costomAdapter
    }
}
