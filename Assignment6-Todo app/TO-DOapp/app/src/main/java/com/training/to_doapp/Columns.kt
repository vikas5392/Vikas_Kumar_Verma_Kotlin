package com.training.to_doapp

import kotlin.properties.Delegates

class Columns() {
    var id:Int=0
    var entry:String?= null
    constructor (entry:String) : this() {
        this.entry=entry
    }


}