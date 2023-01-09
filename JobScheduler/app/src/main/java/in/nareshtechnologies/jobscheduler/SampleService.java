package in.nareshtechnologies.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class SampleService extends JobService {


    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Toast.makeText(this, "Job Done!", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Toast.makeText(this, "Job Stopped!", Toast.LENGTH_SHORT).show();
        return false;
    }
}
