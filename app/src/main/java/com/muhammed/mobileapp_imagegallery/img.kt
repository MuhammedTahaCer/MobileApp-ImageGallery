package com.muhammed.mobileapp_imagegallery

class img {
    var id=0
    var head:String? = null
    var imgUrl:String? = null

    constructor(){

    }

    constructor(id: Int, head: String?, imgUrl: String?){
        this.id =id;
        this.head =head;
        this.imgUrl =imgUrl;
    }
}
