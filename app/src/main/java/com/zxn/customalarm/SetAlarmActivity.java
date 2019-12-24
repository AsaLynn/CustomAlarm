
package com.zxn.customalarm;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//com.zxn.customalarm
import com.zxn.customalarm.fragments.BaseSetAlarmFragment;
import com.zxn.customalarm.fragments.SetCountDownAlarmFragment;
import com.zxn.customalarm.fragments.SetDailyAlarmFragment;
import com.zxn.customalarm.fragments.SetInstantAlarmFragment;
import com.zxn.customalarm.fragments.SetMonthlyAlarmFragment;
import com.zxn.customalarm.fragments.SetWeeklyAlarmFragment;
import com.zxn.customalarm.fragments.SetYearlyAlarmFragment;

@SuppressLint("SimpleDateFormat")
public class SetAlarmActivity extends Activity {

    private ActionBar mActionBar;
    private BaseSetAlarmFragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);

        mActionBar = getActionBar();
        mActionBar.setDisplayShowHomeEnabled(true);
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setDisplayShowTitleEnabled(false);

        replaceFragment(new SetInstantAlarmFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.set_alarm, menu);
        return true;
    }

    public void done() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void replaceFragment(BaseSetAlarmFragment fragment) {
        currentFragment = fragment;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.alarm_set_window, currentFragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.save:
                currentFragment.saveAlarm();
                done();
                break;
            case R.id.daily_set:
                if (!(currentFragment instanceof SetDailyAlarmFragment)) {
                    replaceFragment(new SetDailyAlarmFragment());
                }
                break;
            case R.id.weekly_set:
                if (!(currentFragment instanceof SetWeeklyAlarmFragment)) {
                    replaceFragment(new SetWeeklyAlarmFragment());
                }
                break;
            case R.id.monthly_set:
                if (!(currentFragment instanceof SetMonthlyAlarmFragment)) {
                    replaceFragment(new SetMonthlyAlarmFragment());
                }
                break;
            case R.id.yearly_set:
                if (!(currentFragment instanceof SetYearlyAlarmFragment)) {
                    replaceFragment(new SetYearlyAlarmFragment());
                }
                break;
            case R.id.instant_set:
                if (!(currentFragment instanceof SetInstantAlarmFragment)) {
                    replaceFragment(new SetInstantAlarmFragment());
                }
                break;
            case R.id.count_down_set:
                if (!(currentFragment instanceof SetCountDownAlarmFragment)) {
                    replaceFragment(new SetCountDownAlarmFragment());
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
