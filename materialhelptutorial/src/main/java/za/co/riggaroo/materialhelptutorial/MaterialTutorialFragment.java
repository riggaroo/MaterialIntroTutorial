package za.co.riggaroo.materialhelptutorial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

        ImageView imageViewFront = (ImageView) v.findViewById(R.id.fragment_help_tutorial_imageview);
        ImageView imageViewBack = (ImageView) v.findViewById(R.id.fragment_help_tutorial_imageview_background);

        TextView textView = (TextView) v.findViewById(R.id.fragment_help_tutorial_text);
        textView.setText(tutorialItem.getTitleText());
        v.setTag(page);

        TextView textViewSubTitle = (TextView) v.findViewById(R.id.fragment_help_tutorial_subtitle_text);
        textViewSubTitle.setText(tutorialItem.getSubTitleText());
        Glide.with(this).load(tutorialItem.getBackgroundImageUrl()).into(imageViewBack);
        Glide.with(this).load(tutorialItem.getForegroundImageUrl()).into(imageViewFront);
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

