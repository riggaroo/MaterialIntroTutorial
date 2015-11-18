package za.co.riggaroo.materialhelptutorial;


import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

public class TutorialItem implements Parcelable {
    private String titleText;
    private String subTitleText;
    private int backgroundColor;
    private int foregroundImageRes = -1;
    private int backgroundImageRes = -1;
    private int titleTextRes = -1;
    private int subTitleTextRes = -1;

    public TutorialItem(@NonNull String titleText, @Nullable String subTitleText, @ColorRes int backgroundColor, @DrawableRes int foregroundImageRes, @DrawableRes int backgroundImageRes) {
        this.titleText = titleText;
        this.subTitleText = subTitleText;
        this.backgroundColor = backgroundColor;
        this.foregroundImageRes = foregroundImageRes;
        this.backgroundImageRes = backgroundImageRes;
    }

    public TutorialItem(@NonNull String titleText, @Nullable String subTitleText, @ColorRes int backgroundColor, @DrawableRes int foregroundImageRes) {
        this.titleText = titleText;
        this.subTitleText = subTitleText;
        this.backgroundColor = backgroundColor;
        this.foregroundImageRes = foregroundImageRes;
    }

    public TutorialItem(@StringRes int titleTextRes, @StringRes int subTitleTextRes, @ColorRes int backgroundColor, @DrawableRes int foregroundImageRes, @DrawableRes int backgroundImageRes) {
        this.titleTextRes = titleTextRes;
        this.subTitleTextRes = subTitleTextRes;
        this.backgroundColor = backgroundColor;
        this.foregroundImageRes = foregroundImageRes;
        this.backgroundImageRes = backgroundImageRes;
    }

    public TutorialItem(@StringRes int titleTextRes, @StringRes int subTitleTextRes, @ColorRes int backgroundColor, @DrawableRes int foregroundImageRes) {
        this.subTitleTextRes = titleTextRes;
        this.subTitleTextRes = subTitleTextRes;
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

    public int getTitleTextRes() {
        return titleTextRes;
    }

    public int getSubTitleTextRes() {
        return subTitleTextRes;
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
        dest.writeInt(this.titleTextRes);
        dest.writeInt(this.subTitleTextRes);
    }

    protected TutorialItem(Parcel in) {
        this.titleText = in.readString();
        this.subTitleText = in.readString();
        this.backgroundColor = in.readInt();
        this.foregroundImageRes = in.readInt();
        this.backgroundImageRes = in.readInt();
        this.titleTextRes = in.readInt();
        this.subTitleTextRes = in.readInt();
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
