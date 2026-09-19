import java.util.Properties

version = 487
android {
    buildFeatures {
        buildConfig = true
    }
    defaultConfig {
        val properties = Properties()
        val localPropsFile = project.rootProject.file("local.properties")
        if (localPropsFile.exists()) {
            localPropsFile.inputStream().use { properties.load(it) }
        }

        fun getProp(key: String): String {
            return properties.getProperty(key) ?: System.getenv(key) ?: ""
        }

        buildConfigField("String", "SIMKL_API", "\"${getProp("SIMKL_API")}\"")
        buildConfigField("String", "TMDB_KEY", "\"${getProp("TMDB_KEY")}\"")
        buildConfigField("String", "CASTLE_KEY", "\"${getProp("CASTLE_KEY")}\"")
        buildConfigField("String", "MOVIEBLAST_TOKEN", "\"${getProp("MOVIEBLAST_TOKEN")}\"")
        buildConfigField("String", "MOVIEBLAST_API", "\"${getProp("MOVIEBLAST_API")}\"")
        buildConfigField("String", "MOVIEBLAST_KEY", "\"${getProp("MOVIEBLAST_KEY")}\"")
    }
}

cloudstream {
    language = "en"
    description = "One stop solution for Movies, Series, Anime, AsianDrama and Torrents"
    authors = listOf("megix")
    status = 1
    tvTypes = listOf(
        "TvSeries",
        "Movie",
        "AsianDrama",
        "Anime",
        "Torrent"
    )

    iconUrl = "https://github.com/SaurabhKaperwan/CSX/raw/refs/heads/master/CineStream/icon.png"
}
