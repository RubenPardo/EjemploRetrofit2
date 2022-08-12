package com.example.rparcas.ejemploretrofit2.di

import com.example.rparcas.ejemploretrofit2.data.network.DogApiClient
/*import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent*/
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Singleton

/**
 * Cuando no se puede inyectar una clase (cuando es una libreria o clase con interfaz)
 * hay que proveerla para que se pueda "inyectar"
 * Esta clase nos va a proveer dependencias que no son tan faciles
 * de proveer como una clase nuestra propia. Por ejmplo dependencias
 * de librerias o depencias de clases que contienen interfaces
 * (CONTEXTO DEL DAGGER HILT)
 */
/*@Module // Los modulos en dagger son los que proveen dependencias
@InstallIn(SingletonComponent::class) // Alcance del proveedor, es decir creara n instancias mientras esa este viva,
// puede ser nivel de view model(ActivityRetainedScoped::class),
// activity (ActivityScope::class) o
// Application(SingletonComponent::class) normalmente
// en nuestro caso como es Retrofit(para realizar peticiones rest)
// nos conviene ponerlo a nivel de application
object NetworkModule {

    // De esta forma cuando nosotros inyectemos retrofit a una clase internamente
    // dagger va a saber proveerla (Con esto podemos obviar la clase RetrofitHelper)
    @Singleton // para evitar multiples instancias que en este caso no queremos, utilizando el patron singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            // endpoint a la API
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    // De esta forma podemos proveer la api client para en vez de poner
    // el retrofit pongamos el api client
    // Asi si inyectamos el api client nos dara la api client y el retrofit mezclados y listos para usar
    @Singleton
    @Provides
    fun provideDogApiClient(retrofit: Retrofit):DogApiClient{
        return retrofit.create(DogApiClient::class.java)
    }

}*/