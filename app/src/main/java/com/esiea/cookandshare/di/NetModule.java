package com.esiea.cookandshare.di;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import dagger.Module;
import dagger.Provides;
import io.reactivex.annotations.NonNull;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule
{
    private String url;

    public NetModule(String url)
    {
        this.url = url;
    }

    @Provides
    OkHttpClient provideHttpClient(Cache cache)
    {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .cache(cache);
        trustAllCertificates(client);
        return client.build();
    }

    @Provides
    Cache provideCache(Application application)
    {
        int cacheSize = 1024*1024*10;
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    Gson provideGson()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient client)
    {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();
    }

    private OkHttpClient trustAllCertificates(OkHttpClient.Builder client)
    {
        try
        {
            final TrustManager[] trustAllCerts = new TrustManager[]
            {
                    getNoOpTrustManager()
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            return client.sslSocketFactory(sslSocketFactory).hostnameVerifier(getNoOpHostnameVerifier()).build();
        }
        catch (NoSuchAlgorithmException | KeyManagementException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @NonNull
    private HostnameVerifier getNoOpHostnameVerifier()
    {
        return new HostnameVerifier()
        {
            @Override
            public boolean verify(String hostname, SSLSession session)
            {
                return true;
            }
        };
    }

    @NonNull
    private X509TrustManager getNoOpTrustManager()
    {
        return new X509TrustManager()
        {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException
            {
                //no-op
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException
            {
                //no-op
            }

            @Override
            public X509Certificate[] getAcceptedIssuers()
            {
                return new X509Certificate[]{};
            }
        };
    }

}
