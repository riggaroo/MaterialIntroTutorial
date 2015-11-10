package za.co.riggaroo.materialhelptutorial;


import android.os.Parcel;
import android.os.Parcelable;

public class TutorialItem implements Parcelable {
    private String titleText;
    private String subTitleText;
    private int backgroundColor;
    private int foregroundImageRes;
    private int backgroundImageRes = -1;

    public TutorialItem(String titleText, String subTitleText, int backgroundColor, int foregroundImageRes, int backgroundImageRes) {
        this.titleText = titleText;
        this.subTitleText = subTitleText;
        this.backgroundColor = backgroundColor;
        this.foregroundImageRes = foregroundImageRes;
        this.backgroundImageRes = backgroundImageRes;
    }

    public TutorialItem(String titleText, String subTitleText, int backgroundColor, int foregroundImageRes) {
        this.titleText = titleText;
        this.subTitleText = subTitleText;
        this.backgroundColor = backgroundColor;
        this.foregroundImageRes = foregroundImageRes;
    }

    public String getTitleText() {
        return titleText;
    }

    public String getSubTitleText() {
        return subTitleText;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getForegroundImageRes() {
        return foregroundImageRes;
    }

    public int getBackgroundImageRes() {
        return backgroundImageRes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titleText);
        dest.writeString(this.subTitleText);
        dest.writeInt(this.backgroundColor);
        dest.writeInt(this.foregroundImageRes);
        dest.writeInt(this.backgroundImageRes);
    }

    protected TutorialItem(Parcel in) {
        this.titleText = in.readString();
        this.subTitleText = in.readString();
        this.backgroundColor = in.readInt();
        this.foregroundImageRes = in.readInt();
        this.backgroundImageRes = in.readInt();
    }

    public static final Parcelable.Creator<TutorialItem> CREATOR = new Parcelable.Creator<TutorialItem>() {
        public TutorialItem createFromParcel(Parcel source) {
            return new TutorialItem(source);
        }

        public TutorialItem[] newArray(int size) {
            return new TutorialItem[size];
        }
    };
}
