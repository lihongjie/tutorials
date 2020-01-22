package com.jcg.mongodb.servlet;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MongoTest {

    private static String url = "mongodb://192.168.31.122:27017";

    private static String DATABASE = "fkdata";

    private static String COLLECTION_NAME = "report_log_201903";

    public static void main(String[] args) {

        MongoTest mongo = new MongoTest();
//        mongo.printAllDB();
//        mongo.printAllTables();
        mongo.findAll();
    }

    /**
     * 需要验证用户名、密码的连接方式
     *
     * @return mongoDatabase
     */
    public MongoDatabase getConnection() {
        try {
            //连接到MongoDB服务，如果是远程连接可以将localhost改为服务器所在的IP地址
            //ServerAddress（）参数分别为服务器地址、端口
            ServerAddress serverAddress = new ServerAddress("localhost", 27017);
            List<ServerAddress> serverAddressList = new ArrayList<ServerAddress>();
            serverAddressList.add(serverAddress);

            //createScramSha1Credential（）参数分别为用户名、数据库名称、密码
            MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("userName", "databaseName", "password".toCharArray());
            List<MongoCredential> mongoCredentialList = new ArrayList<MongoCredential>();
            mongoCredentialList.add(mongoCredential);

            //通过连接认证获取MongoDB连接
            MongoClient mongoClient = new MongoClient(serverAddressList, mongoCredentialList);

            //连接数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("databaseName");
            System.out.println("MongoDB连接成功");
            return mongoDatabase;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    /**
     * 不需要验证用户名、密码的连接方式
     *
     * @return mongoDatabase
     */
    public MongoDatabase getConnectionBasis() {
        try {
            //连接到MongoDB服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("users");
            System.out.println("MongoDB连接成功");
            return mongoDatabase;
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + "：" + e.getMessage());
        }
        return null;
    }

    private MongoDatabase getDatabase() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI(url));
        return mongoClient.getDatabase(DATABASE);
    }

    // 遍历所有库

    private void printAllDB() {
        MongoClient client = new MongoClient(new MongoClientURI(url));
        List<String> dbs = client.getDatabaseNames();// 获取到所有的数据库名
        for (String dbname : dbs) {
            System.out.println(dbname);
        }
    }

    //遍历数据库中所有的表名
    private void printAllTables() {
        MongoDatabase database = getDatabase();
        MongoIterable<String> tables = database.listCollectionNames();
        for (String coll : tables) {
            System.out.println(coll);
        }
    }

    private void addDocument() {

        MongoDatabase database = getDatabase();

        MongoCollection collection = database.getCollection("characters");

        Document mickeyMouse = new Document();
        Document charlieBrown = new Document();

        mickeyMouse.append("_id", 1)
                .append("characterName", "Mickey Mouse")
                .append("creator", new Document("firstName", "Walt").append("lastName", "Disney"))
                .append("pet", "Goofy");

        charlieBrown.append("_id", 2)
                .append("characterName", "Charlie Brown")
                .append("creator", new Document("firstName", "Charles").append("lastName", "Shultz"))
                .append("pet", "Snoopy");


        collection.insertOne(mickeyMouse);
        collection.insertOne(charlieBrown);
        System.out.println("Successfully inserted documents. \n");

    }

    private void multipleInsert() {

        MongoDatabase database = getDatabase();

        MongoCollection collection = database.getCollection("characters");
        // Delete the collection and start fresh - add before the initial inserts
        collection.drop();


        // Basic data on collection
        System.out.println("Collection size: " + collection.count() + " documents. \n");

        // Create and insert multiple documents
        List documents = new ArrayList();
        for (int i = 3; i < 51; i++) {
            documents.add(new Document("_id", i)
                    .append("characterName", "")
                    .append("creator", "")
                    .append("pet", "")
            );
        }
        collection.insertMany(documents);

        // Basic data on collection
        System.out.println("Collection size: " + collection.count() + " documents. \n");
    }

    private void updateDocument() {

        MongoDatabase database = getDatabase();

        MongoCollection collection = database.getCollection("characters");
        // Update a document
        // print the third document before update.
        Document third = (Document) collection.find(Filters.eq("_id", 3)).first();
        System.out.println(third.toJson());

        collection.updateOne(new Document("_id", 3),
                new Document("$set", new Document("characterName", "Dilbert")
                        .append("creator", new Document("firstName", "Scott").append("lastName", "Adams"))
                        .append("pet", "Dogbert"))
        );

        System.out.println("\nUpdated third document:");
        Document dilbert = (Document) collection.find(Filters.eq("_id", 3)).first();
        System.out.println(dilbert.toJson());
    }

    //查询所有documents
    public void findAll() {

        /**
         * 1. 获取迭代器FindIterable<Document>
         * 2. 获取游标MongoCursor<Document>
         * 3. 通过游标遍历检索出的文档集合
         * */
        MongoDatabase database = getDatabase();

        MongoCollection collection = database.getCollection(COLLECTION_NAME);
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            Document document = mongoCursor.next();
            System.out.println("MongoDB数据：" + document);
            System.out.println("插入时间：" + new SimpleDateFormat().format(document.getObjectId("_id").getDate()));
        }
    }

}
