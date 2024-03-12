package neiz.fz.compose.data.networking

import neiz.fz.compose.data.model.LoginRequest
import neiz.fz.compose.data.model.LoginResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.POST

object Api {

    // URL O ENPOINT: http://betolix-001-site1.etempurl.com/api/securities/login
    // VERBO: POST

    // URL BASE: http://betolix-001-site1.etempurl.com/
    // METHOD: api/securities/login
    // URL BASE + METHID = ENDPOINT

    // 1. Configure retrofit
    private val builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl("http://betolix-001-site1.etempurl.com/")
        .addConverterFactory(GsonConverterFactory.create())

    // 2. Create Methods
    interface HealthyMethods{
        @POST("api/securities/login")
        suspend fun logIn(@Body request:LoginRequest) : Response<LoginResponse>

    }

    // 3. Create function
    fun build(): HealthyMethods{
        return builder.build().create(HealthyMethods::class.java)
    }

}