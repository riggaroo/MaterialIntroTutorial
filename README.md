# MaterialIntroTutorial
Android Library demonstrating a material intro tutorial much like the ones on Google Sheets

This library shows a help or introduction tutorial into your application. Its inspired by the one in the Google Sheets Android app. 
The help tutorial takes the background colour set for each page and when scrolling between the two pages, the two colours will fade into one another.


# Example Usage

Add the following into your build.gradle:

    compile "za.co.riggaroo.materialhelptutorial:material-tutorial:1.0.0"

In your activity, create a list of TutorialItems (set the title, subtitle, background colour and image drawable int). Pass them onto the MaterialTutorialActivity and start the activity for result.

    public void loadTutorial() {
        Intent mainAct = new Intent(this, MaterialTutorialActivity.class);
        mainAct.putParcelableArrayListExtra(MaterialTutorialActivity.MATERIAL_TUTORIAL_ARG_TUTORIAL_ITEMS, getTutorialItems(this));
        startActivityForResult(mainAct, REQUEST_CODE);

    }

    private ArrayList<TutorialItem> getTutorialItems(Context context) {
        TutorialItem tutorialItem1 = new TutorialItem(context.getString(R.string.slide_1_african_story_books), context.getString(R.string.slide_1_african_story_books_subtitle),
                R.color.slide_1, R.drawable.tut_page_1_front,  R.drawable.tut_page_1_background);

        ...

        ArrayList<TutorialItem> tutorialItems = new ArrayList<>();
        tutorialItems.add(tutorialItem1);
        ...

        return tutorialItems;
    }

You should see a tutorial like below:
![](example-usage.gif)

This library is using the following:
- CirclePageIndicator
- UniversalImageLoader
- Percent Support Library


