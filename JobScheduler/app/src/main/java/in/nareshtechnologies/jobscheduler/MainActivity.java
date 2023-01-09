package in.nareshtechnologies.jobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //JobScheduler
    // JobService
    // JobInfo
    JobInfo jobInfo;
    JobScheduler scheduler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        JobInfo.Builder builder = new JobInfo.Builder(123,
                new ComponentName(getPackageName(), SampleService.class.getName()));

        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);

        jobInfo = builder.build();
    }

    public void scheduleJob(View view) {
        scheduler.schedule(jobInfo);
    }
}