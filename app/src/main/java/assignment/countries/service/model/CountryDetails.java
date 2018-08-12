package assignment.countries.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by AmirG on 08/11/2018.
 */
public class CountryDetails {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("topLevelDomain")
    @Expose
    public List<String> topLevelDomain = null;
    @SerializedName("alpha2Code")
    @Expose
    public String alpha2Code;
    @SerializedName("alpha3Code")
    @Expose
    public String alpha3Code;
    @SerializedName("callingCodes")
    @Expose
    public List<String> callingCodes = null;
    @SerializedName("capital")
    @Expose
    public String capital;
    @SerializedName("altSpellings")
    @Expose
    public List<String> altSpellings = null;
    @SerializedName("region")
    @Expose
    public String region;
    @SerializedName("subregion")
    @Expose
    public String subregion;
    @SerializedName("population")
    @Expose
    public Integer population;
    @SerializedName("latlng")
    @Expose
    public List<Double> latlng = null;
    @SerializedName("demonym")
    @Expose
    public String demonym;
    @SerializedName("area")
    @Expose
    public Double area;
    @SerializedName("gini")
    @Expose
    public Double gini;
    @SerializedName("timezones")
    @Expose
    public List<String> timezones = null;
    @SerializedName("borders")
    @Expose
    public List<String> borders = null;
    @SerializedName("nativeName")
    @Expose
    public String nativeName;
    @SerializedName("numericCode")
    @Expose
    public String numericCode;
    @SerializedName("currencies")
    @Expose
    public List<Currency> currencies = null;
    @SerializedName("languages")
    @Expose
    public List<Language> languages = null;
    @SerializedName("translations")
    @Expose
    public Translations translations;
    @SerializedName("flag")
    @Expose
    public String flag;
    @SerializedName("regionalBlocs")
    @Expose
    public List<RegionalBloc> regionalBlocs = null;
    @SerializedName("cioc")
    @Expose
    public String cioc;

    public class Currency {

        @SerializedName("code")
        @Expose
        public String code;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("symbol")
        @Expose
        public String symbol;

    }

    public class Language {

        @SerializedName("iso639_1")
        @Expose
        public String iso6391;
        @SerializedName("iso639_2")
        @Expose
        public String iso6392;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("nativeName")
        @Expose
        public String nativeName;

    }

    public class RegionalBloc {

        @SerializedName("acronym")
        @Expose
        public String acronym;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("otherAcronyms")
        @Expose
        public List<Object> otherAcronyms = null;
        @SerializedName("otherNames")
        @Expose
        public List<Object> otherNames = null;

    }

    public class Translations {

        @SerializedName("de")
        @Expose
        public String de;
        @SerializedName("es")
        @Expose
        public String es;
        @SerializedName("fr")
        @Expose
        public String fr;
        @SerializedName("ja")
        @Expose
        public String ja;
        @SerializedName("it")
        @Expose
        public String it;
        @SerializedName("br")
        @Expose
        public String br;
        @SerializedName("pt")
        @Expose
        public String pt;
        @SerializedName("nl")
        @Expose
        public String nl;
        @SerializedName("hr")
        @Expose
        public String hr;
        @SerializedName("fa")
        @Expose
        public String fa;

    }
}
