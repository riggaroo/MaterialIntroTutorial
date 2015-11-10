package za.co.riggaroo.materialhelptutorial;


import android.os.Parcel;
import android.os.Parcelable;

public class TutorialItem implements Parcelable {
    private String titleText;
    private String subTitleText;
    private int backgroundColor;
    private int foregroundImageUrl;
    private int backgroundImageUrl;

    public TutorialItem(String titleText, String subTitleText, int backgroundColor, int foregroundImageUrl, int backgroundImageUrl) {
        this.titleText = titleText;
        this.subTitleText = subTitleText;
        this.backgroundColor = backgroundColor;
        this.foregroundImageUrl = foregroundImageUrl;
        this.backgroundImageUrl = backgroundImageUrl;
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

    public int getForegroundImageUrl() {
        return foregroundImageUrl;
    }

    public int getBackgroundImageUrl() {
        return backgroundImageUrl;
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
        dest.writeInt(this.foregroundImageUrl);
        dest.writeInt(this.backgroundImageUrl);
    }

    protected TutorialItem(Parcel in) {
        this.titleText = in.readString();
        this.subTitleText = in.readString();
        this.backgroundColor = in.readInt();
        this.foregroundImageUrl = in.readInt();
        this.backgroundImageUrl = in.readInt();
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
