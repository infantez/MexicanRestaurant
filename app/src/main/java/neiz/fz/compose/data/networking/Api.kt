package neiz.fz.compose.data.networking

import neiz.fz.compose.data.model.DishResponse
import neiz.fz.compose.data.model.LoginRequest
import neiz.fz.compose.data.model.LoginResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

object Api {

    // URL O ENDPOINT: http://betolix-001-site1.etempurl.com/api/securities/login
    // VERB: POST

    // URL BASE: http://betolix-001-site1.etempurl.com/
    // METHOD: api/securities/login
    // URL BASE + METHOD = ENDPOINT

   /* VIEW LOGS LOGCAT TO SERVER REQUEST
    val clientBuilder = OkHttpClient.Builder()
            val logginInterceptor = HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
                clientBuilder.addInterceptor(this)
            }
    */
    // 1. Configure retrofit
    private val builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl("http://betolix-001-site1.etempurl.com/")
        // .client(clientBuilder.build()) VIEW LOGS LOGCAT TO SERVER REQUEST
        .addConverterFactory(GsonConverterFactory.create())

    // 2. Create Methods
    interface HealthyMethods{
        @POST("api/securities/login")
        suspend fun logIn(@Body request:LoginRequest) : Response<LoginResponse>

        @GET("api/dish")
        suspend fun getDishes(@Header("Authorization") authorization:String) : Response<DishResponse>

    }

    // 3. Create function
    fun build(): HealthyMethods{
        return builder.build().create(HealthyMethods::class.java)
    }

}