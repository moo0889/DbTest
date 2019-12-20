package com.example.dbtest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dbtest.Database.Student
import kotlinx.android.synthetic.main.fragment_add_record.*
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class AddRecordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_record, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSave.setOnClickListener(){
            val S=Student(idValue.text.toString(),txtName.text.toString(),"RIT")

            try{
                MainActivity.appDB.studentDoa().insert(S)
                Toast.makeText(context,"Record Added",Toast.LENGTH_LONG).show()
            }catch (ex:Exception){
                Toast.makeText(context,ex.message,Toast.LENGTH_LONG).show()
            }

        }
    }
}