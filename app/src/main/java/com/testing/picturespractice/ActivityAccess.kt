package com.testing.picturespractice

import android.os.Bundle
import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper
import com.koushikdutta.ion.Ion

import kotlinx.android.synthetic.main.activity_access.*

class ActivityAccess : AppCompatActivity() {

    private var context:Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access)
        setSupportActionBar(toolbar)

        initializeComponents()
        initializeListeners()
        initialieData()
    }
    fun initializeComponents(){

    }
    fun initializeListeners(){
        btn_login.setOnClickListener {
            Log.i("Salida","Click de botón")
            println("Salida->Click botón")
            initialieData()

        }
    }
    fun initialieData(){
        var username:String = edit_username.text.toString()
        var password:String = edit_password.text.toString()

        if(!TextUtils.isEmpty(username)){
            if(!TextUtils.isEmpty(password)){
                login(username,password)
            }else{
                var toast:Toast =
                    Toast.makeText(context, context.resources.getString(R.string.empty_password),Toast.LENGTH_LONG)
                toast.show()
            }
        }else{
            var toast:Toast =
                Toast.makeText(context, context.resources.getString(R.string.empty_username),Toast.LENGTH_LONG)
            toast.show()
        }

    }
    fun login(username:String, password:String){
        /*https://jsonplaceholder.typicode.com/users*/
        Ion.with(context)
            .load("https://jsonplaceholder.typicode.com/users")
            .asJsonArray()
            .setCallback { error, result ->
                if(error==null){
                    Log.i("Salida",result.toString())
                    for(temp in result){
                        if(temp.asJsonObject.get("id").asInt == 7){
                            Log.i("Salida","Encontré el objeto 7")
                            if(temp.asJsonObject.get("username").asString.equals(username) ){
                                if(temp.asJsonObject.get("email").asString.equals(password)){
                                    var toast:Toast =
                                        Toast.makeText(context, "Usuario acceso correcto",Toast.LENGTH_LONG)
                                    toast.show()
                                }else{
                                    var toast:Toast =
                                        Toast.makeText(context, "Contraseña incorrecta",Toast.LENGTH_LONG)
                                    toast.show()
                                }
                            }else{
                                var toast:Toast =
                                    Toast.makeText(context, "Usuario incorrecto",Toast.LENGTH_LONG)
                                toast.show()
                            }
                            break
                        }else{
                            Log.i("Salida","No encontré el objeto 7")
                        }
                    }
                }
            }

    }

}
