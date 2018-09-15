import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ProfileOneDriver {

  public static void main(String[] args)
      throws IOException, ClassNotFoundException, InterruptedException {
    Path input = new Path(args[0]);
    Path output = new Path(args[1]);

    Configuration conf = new Configuration();

    Job job = Job.getInstance(conf, "Profile 1");
    job.setJarByClass(ProfileOneDriver.class);
    job.setMapperClass(ProfileOneMapper.class);
    job.setReducerClass(ProfileOneReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(NullWritable.class);
    FileInputFormat.addInputPath(job, input);


    FileSystem hdfs = FileSystem.get(conf);
    if (hdfs.exists(output)) {
      hdfs.delete(output, true);
    }

    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);

  }
}
