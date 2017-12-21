package co.hackaton.marvelapp.presentation.view.activity;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by christianbarco on 19/12/17.
 */

public final class MarvelServiceTest {

    public static final String API_URL = "http://gateway.marvel.com";

    public static class Character {

        public final int id;
        public final String name;
        public final Thumbnail thumbnail;

        public Character(int id, String name, Thumbnail thumbnail) {
            this.id = id;
            this.name = name;
            this.thumbnail = thumbnail;
        }

        @Override
        public String toString() {
            return "Results{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public static class Thumbnail {
            public final String path;
            public final String extension;

            public Thumbnail(String path, String extension) {
                this.path = path;
                this.extension = extension;
            }

            @Override
            public String toString() {
                return "Thumblain{" +
                        "path='" + path + '\'' +
                        ", extension='" + extension + '\'' +
                        '}';
            }
        }
    }

    public static class Response {
        public final String copyright;
        public final String status;
        public final String code;
        public final Metadata data;

        public Response(String code, String copyright, String status, Metadata data) {
            this.copyright = copyright;
            this.status = status;
            this.code = code;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "copyright='" + copyright + '\'' +
                    ", status='" + status + '\'' +
                    ", code='" + code + '\'' +
                    ", data=" + data +
                    '}';
        }

        public static class Metadata {
            public final int offset;
            public final int limit;
            public final int total;
            public final int count;
            public final List<Character> results;

            public Metadata(int offset, int limit, int total, int count, List<Character> results) {
                this.offset = offset;
                this.limit = limit;
                this.total = total;
                this.count = count;
                this.results = results;
            }

            @Override
            public String toString() {
                return "Metadatos{" +
                        "offset=" + offset +
                        ", limit=" + limit +
                        ", total=" + total +
                        ", count=" + count +
                        '}';
            }
        }
    }

    public interface GitHub {
        @GET("/v1/public/characters/1011334?ts=1&hash=d3b2159883eef07a80c58659b0664556&apikey=93506d8f037a7ccdf2d9140a23472038")
        Call<Response> contributors();
    }

    public static void main(String... args) throws IOException {
        // Create a very simple REST adapter which points the GitHub API.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of our GitHub API interface.
        MarvelServiceTest.GitHub github = retrofit.create(MarvelServiceTest.GitHub.class);

        // Create a call instance for looking up Retrofit contributors.
        Call<Response> call = github.contributors();

        // Fetch and print a list of the contributors to the library.
        Response contributor = call.execute().body();
        System.out.println(contributor.toString());
        System.out.println(contributor.data.toString());
        //System.out.println("data" + contributor.data.results.toString());

        List<Character> characterList = contributor.data.results;
        for (Character character : characterList) {
            System.out.println("character: " + character.toString());
            System.out.println("thumblain: " + character.thumbnail.toString());
        }
    }
}
