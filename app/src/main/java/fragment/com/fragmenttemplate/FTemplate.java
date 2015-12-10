package fragment.com.fragmenttemplate;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

/**
 * Created by kakizaki_shoichi on 15/12/09.
 * ProjectName FragmentTemplate
 */

public class FTemplate extends Fragment {

    /*interfaceを設定してActivityで呼べるようにする*/
    public interface OnClickListener {
        void onFTemplateClick();
    }

    private WeakReference<FTemplate.OnClickListener> mOnClickListenerRef;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ;

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickListener onClickListener = mOnClickListenerRef.get();
                if (onClickListener != null) {
                    onClickListener.onFTemplateClick();
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = getActivity();

        if (!(activity instanceof FTemplate.OnClickListener)) {
            throw new ClassCastException("activity が ClickListener を実装していません.");
        }

        mOnClickListenerRef = new WeakReference<>((FTemplate.OnClickListener) activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOnClickListenerRef = null;
    }
}