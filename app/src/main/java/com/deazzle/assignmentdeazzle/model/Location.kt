package com.deazzle.assignmentdeazzle.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

data class Location (
                    @SerializedName("street")
                    @Embedded val street: Street,
                    @ColumnInfo(name = "city")
                    @SerializedName("city")
                     var city: String,
                    @SerializedName("state")
                     @ColumnInfo(name = "state")
                     var state: String,
                    @SerializedName("country")
                    @ColumnInfo(name = "country")
                    var country: String,
                    @NonNull
                    @SerializedName("postcode")
                    @ColumnInfo(name = "postcode")
                    var postalcode: String,
                    @SerializedName("coordinates")
                     @Embedded val coordinates: Coordinates,
                    @SerializedName("timezone")
                    @Embedded val timezone: TimeZone)
