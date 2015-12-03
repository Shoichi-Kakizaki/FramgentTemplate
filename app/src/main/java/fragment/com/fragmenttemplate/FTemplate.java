package fragment.com.fragmenttemplate;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kakizaki_shoichi on 15/12/09.
 * ProjectName FragmentTemplate
 */

public class FTemplate extends Fragment {

    /*interfaceを設定してActivityで呼べるようにする*/
    public interface OnClickListener {
        public void backBrowserTransaction();
    }

    private View mV;
    private Activity mActivity;
    private OnClickListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mV = inflater.inflate(R.layout.fragment_main, container, false);
        return mV;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
        if (activity instanceof OnClickListener == false) {
            throw new ClassCastException("activity が ClickListener を実装していません.");
        }
        mListener = ((OnClickListener) activity);
    }

    @Override
    public void onStart() {
        super.onStart();
         if (mListener != null) {
             mListener.backBrowserTransaction();
         }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}