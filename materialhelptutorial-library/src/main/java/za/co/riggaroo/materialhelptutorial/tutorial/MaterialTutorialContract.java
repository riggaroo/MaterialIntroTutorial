package za.co.riggaroo.materialhelptutorial.tutorial;

import android.view.View;

import java.util.List;

import za.co.riggaroo.materialhelptutorial.MaterialTutorialFragment;
import za.co.riggaroo.materialhelptutorial.TutorialItem;

/**
 * @author rebeccafranks
 * @since 15/11/09.
 */
public interface MaterialTutorialContract {

    interface View {
        void showNextTutorial();
        void showEndTutorial();
        void setBackgroundColor(int color);
        void showDoneButton();
        void showSkipButton();
        void setViewPagerFragments(List<MaterialTutorialFragment> materialTutorialFragments);
    }

    interface UserActionsListener {
        void loadViewPagerFragments(List<TutorialItem> tutorialItems);
        void doneOrSkipClick();
        void nextClick();
        void onPageSelected(int pageNo);
        void transformPage(android.view.View page, float position);

        int getNumberOfTutorials();
    }

}
