package com.deazzle.assignmentdeazzle.model

import androidx.room.ColumnInfo

class Login(@ColumnInfo(name = "uuid")
            var uuid: String,
            @ColumnInfo(name = "username")
            var username: String,
            @ColumnInfo(name = "password")
            var password: String,
            @ColumnInfo(name = "salt")
            var salt: String,
            @ColumnInfo(name = "md5")
            var md5: String,
            @ColumnInfo(name = "sha1")
            var sha1: String,
            @ColumnInfo(name = "sha256")
            var sha256: String)