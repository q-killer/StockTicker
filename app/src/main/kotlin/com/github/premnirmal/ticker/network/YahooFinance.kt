package com.github.premnirmal.ticker.network

import com.github.premnirmal.ticker.network.data.AssetDetailsResponse
import com.github.premnirmal.ticker.network.data.YahooResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface YahooFinance {

  /**
   * Retrieves a list of stock quotes.
   *
   * @param query comma separated list of symbols.
   *
   * @return A List of quotes.
   */
  @GET(
      "quote?format=json"
  )
  suspend fun getStocks(@Query(value = "symbols") query: String): YahooResponse
}

interface YahooQuoteDetails {
  @GET("quoteSummary/{symbol}?modules=financialData,assetProfile")
  suspend fun getAssetDetails(@Path(value = "symbol") symbol: String): AssetDetailsResponse
}