package br.example.braian_braga_continuada_2_app_yoshi

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PrimeiraTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primeira_tela)
    }

    fun consultarCachorro(view: View) {
        val apiCachorros = ConexaoApiCachorros.criar()
        val segundaTela = Intent(this,SegundaTela::class.java)

        val primeiroId:EditText = findViewById(R.id.et_primeiroId)
        val idUm = primeiroId.toString().toString()

        val segundoId:EditText = findViewById(R.id.et_segundoId)
        val idDois = segundoId.toString().toString()


        apiCachorros.get(idUm).enqueue(object : Callback<Cachorros>{
            override fun onResponse(call: Call<Cachorros>, response: Response<Cachorros>) {
                val tvResultado: TextView = findViewById(R.id.tv_Resultado)
                val tvImagem: ImageView = findViewById(R.id.iv_img_error)
                val cachorros = response.body()
                if (cachorros != null){
                    tvResultado.text = "Raça: ${cachorros.raca}"
                }else {
                    tvResultado.text = "Deu ruim... Nenhum cachorro encontrado com os ids ${idUm}"
                    tvImagem.setImageResource(R.drawable.cachorrotriste)
                }
            }

            override fun onFailure(call: Call<Cachorros>, t: Throwable) {
                Toast.makeText(baseContext, "Erro: ${t.message!!}", Toast.LENGTH_SHORT).show()
            }
        })


        apiCachorros.get(idDois).enqueue(object : Callback<Cachorros>{
            override fun onResponse(call: Call<Cachorros>, response: Response<Cachorros>) {
                val tvResultado: TextView = findViewById(R.id.tv_Resultado)
                val tvImagem: ImageView = findViewById(R.id.iv_img_error)
                val cachorros = response.body()
                if (cachorros != null){
                    tvResultado.text = "Raça: ${cachorros.raca}"
                }else {
                    tvResultado.text = "Deu ruim... Nenhum cachorro encontrado com os ids ${idUm}"
                    tvImagem.setImageResource(R.drawable.cachorrotriste)
                }
            }

            override fun onFailure(call: Call<Cachorros>, t: Throwable) {
                Toast.makeText(baseContext, "Erro: ${t.message!!}", Toast.LENGTH_SHORT).show()
            }
        })

    }
}