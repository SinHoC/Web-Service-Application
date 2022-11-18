package com.TeamTemple.TTempleProject;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class TestDB {

    public static void main(String[] args) {


        ConnectionString connectionString = new ConnectionString("mongodb://teamtemple:nAFDs6Vm6Hurkg3@ac-aauxsnk-shard-00-00.hnszr88.mongodb.net:27017,ac-aauxsnk-shard-00-01.hnszr88.mongodb.net:27017,ac-aauxsnk-shard-00-02.hnszr88.mongodb.net:27017/?ssl=true&replicaSet=atlas-5b6m3r-shard-0&authSource=admin&retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("sample_mflix");
        MongoCollection<Document> collection = database.getCollection("comments");
        System.out.println(collection.getNamespace());


//        try {
//            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://teamtemple:nAFDs6Vm6Hurkg3@cluster0.hnszr88.mongodb.net/?w=majority"));
//            DB database = mongoClient.getDB("sample_mflix");
//            System.out.println(database.getStats());
////            DBCollection collection = database.getCollection("TheCollectionName");
//        } catch (UnknownHostException e) {
//            throw new RuntimeException(e);
//        }

    }
}
