package com.example.swifty_companion.data

//import net.openid.appauth.ResponseTypeValues

object AuthConfig {
    const val TOKEN_URI = "https://api.intra.42.fr/oauth/token"
    const val CLIENT_ID = "eea1e114bc1550f2d37494bed3de284886bf3c45b4dc7eed1b4e4ce51c3e3454"
    const val REDIRECT_URI = "https://profile.intra.42.fr/"
    const val SCOPE = "public"
    const val STATE = ""
    const val RESPONSE_TYPE = "code"
    const val CLIENT_SECRET = "ebc8b5ccb9f3b4d2a7c88d0385f27aeca4cfdf15b35b8e444ac20a61660fc118"
    var TOKEN = ""

}