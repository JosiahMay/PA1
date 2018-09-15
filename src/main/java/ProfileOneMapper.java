import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ProfileOneMapper extends Mapper < Object, Text, Text, NullWritable> {

  private final Text output = new Text();

  public void map( Object key, Text value, Context context) throws IOException, InterruptedException {
    if (!value.toString().isEmpty()) {
      StringTokenizer token = new StringTokenizer(value.toString().split("<====>")[2]);
      while (token.hasMoreTokens()) {
        String word = token.nextToken().replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        if(!word.isEmpty()){
          output.set(word);
          context.write(output, NullWritable.get());
        }

      }
    }
  }

  protected void cleanup(Context context)
      throws IOException, InterruptedException {

  }
}
