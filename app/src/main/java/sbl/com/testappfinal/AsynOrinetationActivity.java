package sbl.com.testappfinal;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.TextView;

import sbl.com.testappfinal.fragments.TaskFragment;

/**
 * Created by sandeep on 1/3/16.
 */
public class AsynOrinetationActivity extends Activity implements TaskFragment.TaskCallbacks {

    private static final String TAG_TASK_FRAGMENT = "task_fragment";
    public static final String PARAM_COUNT = "param_count";

    private TaskFragment mTaskFragment;

    private TextView tvCount = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_on_orientation);

        FragmentManager fm = getFragmentManager();
        mTaskFragment = (TaskFragment) fm.findFragmentByTag(TAG_TASK_FRAGMENT);

        tvCount = (TextView) this.findViewById(R.id.tvCount);

        // If the Fragment is non-null, then it is currently being
        // retained across a configuration change.
        if (mTaskFragment == null) {
            mTaskFragment = new TaskFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(PARAM_COUNT, 1);
            mTaskFragment.setArguments(bundle);
            fm.beginTransaction().add(mTaskFragment, TAG_TASK_FRAGMENT).commit();
        }

        // TODO: initialize views, restore saved state, etc.
    }

    // The four methods below are called by the TaskFragment when new
    // progress updates or results are available. The MainActivity
    // should respond by updating its UI to indicate the change.

    @Override
    public void onPreExecute() {  }

    @Override
    public void onProgressUpdate(int percent) {

        if( tvCount != null)  {
            tvCount.setText("" + percent);
        }
    }

    @Override
    public void onCancelled() {  }

    @Override
    public void onPostExecute() {  }
}