package com.avengers.example;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.hadoop.io.BSONWritable;
import com.mongodb.hadoop.mapred.MongoOutputFormat;
import com.mongodb.hadoop.util.MongoConfigUtil;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import com.mongodb.hadoop.mapred.MongoInputFormat;
import org.apache.flink.api.java.hadoop.mapred.HadoopInputFormat;
import org.apache.flink.api.java.hadoop.mapred.HadoopOutputFormat;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.bson.BSONObject;

public class MongodbExample {

	public static void main(String[] args) throws Exception {

		final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

		HadoopInputFormat<BSONWritable, BSONWritable> hdIf = new HadoopInputFormat<BSONWritable, BSONWritable>(
				new MongoInputFormat(), BSONWritable.class, BSONWritable.class,	new JobConf());

		hdIf.getJobConf().set("mongo.input.uri", "mongodb://192.168.1.204:27017/test.users");

		DataSet<Tuple2<BSONWritable, BSONWritable>> input = env.createInput(hdIf);
		DataSet<Tuple2< Text, BSONWritable>> fin = input.map(
				new MapFunction<Tuple2<BSONWritable, BSONWritable>, Tuple2<Text,BSONWritable> >() {

					private static final long serialVersionUID = 1L;

					@Override
					public Tuple2<Text,BSONWritable> map(Tuple2<BSONWritable, BSONWritable> record) throws Exception {
						BSONWritable value = record.getField(1);
						BSONObject doc = value.getDoc();
						String id   =  String.valueOf(doc.get("_id"));
						String username   =  String.valueOf(doc.get("username"));
						DBObject builder = BasicDBObjectBuilder.start()
								.add("id", id)
								.add("username", username)
								.get();

						BSONWritable w = new BSONWritable(builder);
						return new Tuple2<Text,BSONWritable>(new Text(id), w);
					}
				});
		fin.print();
	}
}
