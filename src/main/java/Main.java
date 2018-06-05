import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            AmazonEC2 ec2Client = AmazonEC2ClientBuilder.standard()
                    .build();
            DescribeInstancesResult result = ec2Client.describeInstances();
            for (Reservation r : result.getReservations()) {
                for (Instance e : r.getInstances()) {
                    System.out.println(e.getInstanceId() + " " + e.getInstanceType());
                }
            }
        } else if (args[0].equals("s3")) {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .build();
            for (Bucket e : s3Client.listBuckets()) {
                System.out.println(e);
            }
        }
    }
}
