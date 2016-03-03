package sbl.com.testappfinal.tasks;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class AsynchronusTask extends AsyncTask<Void, Void, Void>
         {

    TextView tv;
    int count = 0;

    public void resetValues(TextView textView) {
        this.tv = textView;
    }

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}
	
	public AsynchronusTask(TextView tv) {
        this.tv = tv;


	}

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        tv.setText("" + count++);
    }

    @Override
	protected Void doInBackground(Void... params) {

        try {
            while (true) {
                Log.e("Async Task","Count:" + count);
                Thread.sleep(1000);
                publishProgress();
            }

        } catch ( Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
	}
}
