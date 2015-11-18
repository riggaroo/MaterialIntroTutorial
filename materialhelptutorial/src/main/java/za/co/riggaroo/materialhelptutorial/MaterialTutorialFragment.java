package za.co.riggaroo.materialhelptutorial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * @author rebeccafranks
 * @since 2015/10/15.
 */
public class MaterialTutorialFragment extends Fragment {
    private static final String ARG_TUTORIAL_ITEM = "arg_tut_item";
    private static final String TAG = "MaterialTutFragment";
    private static final String ARG_PAGE = "arg_page";

    public static MaterialTutorialFragment newInstance(TutorialItem tutorialItem, int page) {
        MaterialTutorialFragment helpTutorialImageFragment = new MaterialTutorialFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_TUTORIAL_ITEM, tutorialItem);
        args.putInt(ARG_PAGE, page);
        helpTutorialImageFragment.setArguments(args);
        return helpTutorialImageFragment;
    }

    private TutorialItem tutorialItem;
    int page;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        tutorialItem = b.getParcelable(ARG_TUTORIAL_ITEM);
        page = b.getInt(ARG_PAGE);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_help_tutorial_image, container, false);
        v.setTag(page);

        ImageView imageViewFront = (ImageView) v.findViewById(R.id.fragment_help_tutorial_imageview);
        ImageView imageViewBack = (ImageView) v.findViewById(R.id.fragment_help_tutorial_imageview_background);
        TextView textViewSubTitle = (TextView) v.findViewById(R.id.fragment_help_tutorial_subtitle_text);

        TextView textView = (TextView) v.findViewById(R.id.fragment_help_tutorial_text);
        if (!TextUtils.isEmpty(tutorialItem.getTitleText())) {
            textView.setText(tutorialItem.getTitleText());
        } else if (tutorialItem.getTitleTextRes() != -1) {
            textView.setText(tutorialItem.getTitleTextRes());
        }
        if (!TextUtils.isEmpty(tutorialItem.getSubTitleText())) {
            textViewSubTitle.setText(tutorialItem.getSubTitleText());
        } else if (tutorialItem.getSubTitleTextRes() != -1) {
            textViewSubTitle.setText(tutorialItem.getSubTitleTextRes());
        }
        if (tutorialItem.getBackgroundImageRes() != -1) {
            Glide.with(this).load(tutorialItem.getBackgroundImageRes()).into(imageViewBack);
        }
        if (tutorialItem.getForegroundImageRes() != -1) {
            Glide.with(this).load(tutorialItem.getForegroundImageRes()).into(imageViewFront);
        }
        return v;
    }

  /*  public void onTranform(int pageNumber, float transformation) {
        Log.d(TAG, "onTransform:" + transformation);
        if (!isAdded()) {
            return;
        }
        if (transformation == 0){
            imageViewBack.setTranslationX(0);
            return;
        }
        int pageWidth = getView().getWidth();
        Log.d(TAG, "onTransform Added page Width:" + pageWidth);

        imageViewBack.setTranslationX(-transformation * (pageWidth / 2)); //Half the normal speed

    }*/
}

