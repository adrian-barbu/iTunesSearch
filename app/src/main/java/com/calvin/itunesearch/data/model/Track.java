package com.calvin.itunesearch.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.calvin.itunesearch.di.module.GlideApp;

/**
 * @description     Model class to represent Track object
 *
 * @author          Adrian
 * @date            08/28/21
 */
@Entity(tableName = "tracks")
public class Track extends BaseObservable implements Parcelable {
    @PrimaryKey
    private Integer artistId;

    @SerializedName("wrapperType")
    private String wrapperType;

    @SerializedName("kind")
    private String kind;

    @SerializedName("collectionId")
    private Integer collectionId;

    @SerializedName("trackId")
    private Integer trackId;

    @SerializedName("artistName")
    private String artistName;

    @SerializedName("collectionName")
    private String collectionName;

    @SerializedName("trackName")
    private String trackName;
    @SerializedName("collectionCensoredName")
    private String collectionCensoredName;
    @SerializedName("trackCensoredName")
    private String trackCensoredName;
    @SerializedName("artistViewUrl")
    private String artistViewUrl;
    @SerializedName("collectionViewUrl")
    private String collectionViewUrl;
    @SerializedName("trackViewUrl")
    private String trackViewUrl;
    @SerializedName("previewUrl")
    private String previewUrl;
    @SerializedName("artworkUrl30")
    private String artworkUrl30;
    @SerializedName("artworkUrl60")
    private String artworkUrl60;
    @SerializedName("artworkUrl100")
    private String artworkUrl100;
    @SerializedName("collectionPrice")
    private Double collectionPrice;
    @SerializedName("trackPrice")
    private Double trackPrice;
    @SerializedName("releaseDate")
    private String releaseDate;
    @SerializedName("collectionExplicitness")
    private String collectionExplicitness;
    @SerializedName("trackExplicitness")
    private String trackExplicitness;
    @SerializedName("discCount")
    private Integer discCount;
    @SerializedName("discNumber")
    private Integer discNumber;
    @SerializedName("trackCount")
    private Integer trackCount;
    @SerializedName("trackNumber")
    private Integer trackNumber;
    @SerializedName("trackTimeMillis")
    private Integer trackTimeMillis;
    @SerializedName("country")
    private String country;
    @SerializedName("currency")
    private String currency;
    @SerializedName("primaryGenreName")
    private String primaryGenreName;
    @SerializedName("contentAdvisoryRating")
    private String contentAdvisoryRating;
    @SerializedName("description")
    private String description;
    @SerializedName("shortDescription")
    private String shortDescription;
    @SerializedName("longDescription")
    private String longDescription;
    @SerializedName("isStreamable")
    private Boolean isStreamable;

//    @SerializedName("additionalProperties")
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Track() {
    }

    /**
     * 
     * @param collectionExplicitness
     * @param trackCensoredName
     * @param artworkUrl60
     * @param collectionId
     * @param discCount
     * @param trackTimeMillis
     * @param collectionViewUrl
     * @param wrapperType
     * @param trackName
     * @param kind
     * @param currency
     * @param releaseDate
     * @param artistId
     * @param collectionCensoredName
     * @param collectionName
     * @param trackCount
     * @param trackId
     * @param artworkUrl30
     * @param primaryGenreName
     * @param trackNumber
     * @param discNumber
     * @param country
     * @param previewUrl
     * @param trackExplicitness
     * @param artistViewUrl
     * @param trackPrice
     * @param isStreamable
     * @param contentAdvisoryRating
     * @param description
     * @param shortDescription
     * @param longDescription
     * @param artistName
     * @param artworkUrl100
     * @param trackViewUrl
     * @param collectionPrice
     */
    public Track(String wrapperType, String kind, Integer artistId, Integer collectionId, Integer trackId, String artistName, String collectionName,
                 String trackName, String collectionCensoredName, String trackCensoredName, String artistViewUrl, String collectionViewUrl,
                 String trackViewUrl, String previewUrl, String artworkUrl30, String artworkUrl60, String artworkUrl100, Double collectionPrice,
                 Double trackPrice, String releaseDate, String collectionExplicitness, String trackExplicitness, Integer discCount, Integer discNumber,
                 Integer trackCount, Integer trackNumber, Integer trackTimeMillis, String country, String currency, String primaryGenreName,
                 String contentAdvisoryRating, String description, String shortDescription, String longDescription, Boolean isStreamable) {
        super();
        this.wrapperType = wrapperType;
        this.kind = kind;
        this.artistId = artistId;
        this.collectionId = collectionId;
        this.trackId = trackId;
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.trackName = trackName;
        this.collectionCensoredName = collectionCensoredName;
        this.trackCensoredName = trackCensoredName;
        this.artistViewUrl = artistViewUrl;
        this.collectionViewUrl = collectionViewUrl;
        this.trackViewUrl = trackViewUrl;
        this.previewUrl = previewUrl;
        this.artworkUrl30 = artworkUrl30;
        this.artworkUrl60 = artworkUrl60;
        this.artworkUrl100 = artworkUrl100;
        this.collectionPrice = collectionPrice;
        this.trackPrice = trackPrice;
        this.releaseDate = releaseDate;
        this.collectionExplicitness = collectionExplicitness;
        this.trackExplicitness = trackExplicitness;
        this.discCount = discCount;
        this.discNumber = discNumber;
        this.trackCount = trackCount;
        this.trackNumber = trackNumber;
        this.trackTimeMillis = trackTimeMillis;
        this.country = country;
        this.currency = currency;
        this.primaryGenreName = primaryGenreName;
        this.contentAdvisoryRating = contentAdvisoryRating;
        this.description = description;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.isStreamable = isStreamable;
    }

    protected Track(Parcel in) {
        if (in.readByte() == 0) {
            artistId = null;
        } else {
            artistId = in.readInt();
        }
        wrapperType = in.readString();
        kind = in.readString();
        if (in.readByte() == 0) {
            collectionId = null;
        } else {
            collectionId = in.readInt();
        }
        if (in.readByte() == 0) {
            trackId = null;
        } else {
            trackId = in.readInt();
        }
        artistName = in.readString();
        collectionName = in.readString();
        trackName = in.readString();
        collectionCensoredName = in.readString();
        trackCensoredName = in.readString();
        artistViewUrl = in.readString();
        collectionViewUrl = in.readString();
        trackViewUrl = in.readString();
        previewUrl = in.readString();
        artworkUrl30 = in.readString();
        artworkUrl60 = in.readString();
        artworkUrl100 = in.readString();
        if (in.readByte() == 0) {
            collectionPrice = null;
        } else {
            collectionPrice = in.readDouble();
        }
        if (in.readByte() == 0) {
            trackPrice = null;
        } else {
            trackPrice = in.readDouble();
        }
        releaseDate = in.readString();
        collectionExplicitness = in.readString();
        trackExplicitness = in.readString();
        if (in.readByte() == 0) {
            discCount = null;
        } else {
            discCount = in.readInt();
        }
        if (in.readByte() == 0) {
            discNumber = null;
        } else {
            discNumber = in.readInt();
        }
        if (in.readByte() == 0) {
            trackCount = null;
        } else {
            trackCount = in.readInt();
        }
        if (in.readByte() == 0) {
            trackNumber = null;
        } else {
            trackNumber = in.readInt();
        }
        if (in.readByte() == 0) {
            trackTimeMillis = null;
        } else {
            trackTimeMillis = in.readInt();
        }
        country = in.readString();
        currency = in.readString();
        primaryGenreName = in.readString();
        contentAdvisoryRating = in.readString();
        description = in.readString();
        shortDescription = in.readString();
        longDescription = in.readString();
        byte tmpIsStreamable = in.readByte();
        isStreamable = tmpIsStreamable == 0 ? null : tmpIsStreamable == 1;
    }

    public static final Creator<Track> CREATOR = new Creator<Track>() {
        @Override
        public Track createFromParcel(Parcel in) {
            return new Track(in);
        }

        @Override
        public Track[] newArray(int size) {
            return new Track[size];
        }
    };

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public Double getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(Double collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public Double getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(Double trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    public Integer getDiscCount() {
        return discCount;
    }

    public void setDiscCount(Integer discCount) {
        this.discCount = discCount;
    }

    public Integer getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Integer getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(Integer trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public Boolean getIsStreamable() {
        return isStreamable;
    }

    public void setIsStreamable(Boolean isStreamable) {
        this.isStreamable = isStreamable;
    }

//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

    /**
     * Bind the value of {@link Track} getArtworkUrl100 to this view
     * @param imageView The target {@link ImageView}
     * @param imageURL The value of {@link Track} getArtworkUrl100
     */
    @BindingAdapter({"artwork"})
    public static void loadImage(ImageView imageView, String imageURL) {
        GlideApp.with(imageView.getContext())
                .load(imageURL)
                .into(imageView);

    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (artistId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(artistId);
        }
        dest.writeString(wrapperType);
        dest.writeString(kind);
        if (collectionId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(collectionId);
        }
        if (trackId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(trackId);
        }
        dest.writeString(artistName);
        dest.writeString(collectionName);
        dest.writeString(trackName);
        dest.writeString(collectionCensoredName);
        dest.writeString(trackCensoredName);
        dest.writeString(artistViewUrl);
        dest.writeString(collectionViewUrl);
        dest.writeString(trackViewUrl);
        dest.writeString(previewUrl);
        dest.writeString(artworkUrl30);
        dest.writeString(artworkUrl60);
        dest.writeString(artworkUrl100);
        if (collectionPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(collectionPrice);
        }
        if (trackPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(trackPrice);
        }
        dest.writeString(releaseDate);
        dest.writeString(collectionExplicitness);
        dest.writeString(trackExplicitness);
        if (discCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(discCount);
        }
        if (discNumber == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(discNumber);
        }
        if (trackCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(trackCount);
        }
        if (trackNumber == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(trackNumber);
        }
        if (trackTimeMillis == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(trackTimeMillis);
        }
        dest.writeString(country);
        dest.writeString(currency);
        dest.writeString(primaryGenreName);
        dest.writeString(contentAdvisoryRating);
        dest.writeString(description);
        dest.writeString(shortDescription);
        dest.writeString(longDescription);
        dest.writeByte((byte) (isStreamable == null ? 0 : isStreamable ? 1 : 2));
    }
}
